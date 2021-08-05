package com.itjizhiyong.service;

import com.itchenyang.utills.MyJwtUtils;
import com.ithujiaze.entity.Login_Data;
import com.ithujiaze.entity.Point;
import com.itjizhiyong.entities.FeignArg;
import com.itjizhiyong.entities.LoginNum;
import com.itjizhiyong.entities.MyR;
import com.itjizhiyong.mapper.LoginMapper;
import com.itjizhiyong.utils.FaceId;
import com.itjizhiyong.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final int FAILCOUNT = 5;
    private final int LOCKHOURS = 2;
    private final int FAILTIME = 180;
    @Autowired
    private LoginMapper loginmapper;


//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private RedisUtils redisUtil;
    @Autowired
    FeignClient feignClient;
    /**
     * 用户登陆
     * @param Phone 账号
     * @param Password  密码
     * @return
     */
    @Override
    public MyR login(String Phone, String Password, String mac, String ip){

        Map<String,String> loginMap = new HashMap<>();
        loginMap.put("Phone",Phone);
        loginMap.put("Password",Password);
        FeignArg feignArg = new FeignArg(mac,ip,Phone);

        List<LoginNum> loginRes = loginmapper.GetUser(loginMap);

//        System.out.println(loginRes);
        HashMap<String,String> map = new HashMap<>();
        //查询用户是否被锁定，返回剩余时间


        if(redisUtil.hasKey(Phone)){
            long lockTime = this.getUserLoginTimeLock(Phone);
//            String key = "Phone:" + Phone + ":failCount";
            if(lockTime > 0){//判断用户是否已经被锁定
                map.put(Phone,"该账号已经被锁定请在" + lockTime + "秒之后尝试");

            }
        }

//        System.out.println("111111");
        if(!loginRes.isEmpty()){//检验用户输入的账号密码是否正确
            //检验是否异常登录
            Point point = feignClient.isAbnormal(feignArg);
            Login_Data login_data = new Login_Data();


            System.out.println(point.toString());
            if(point.isFlag()){
                return MyR.error().playCode(252).playMessage("用户出现异常登录，是否进行活体检测");
            }
            System.out.println(loginRes.toString());
            String token = MyJwtUtils.createToken(loginRes.get(0).getPhone(),loginRes.get(0).getUsername(),loginRes.get(0).getRole().getRole_Id(),
                    loginRes.get(0).getAffiliation(),loginRes.get(0).getUser_Id());

            return MyR.ok().playCode(200).playMessage("success").playData("token",token).playAffiliation(loginRes.get(0).getAffiliation());
        }else{
            //设置用户登陆失败次数
            this.setFailCount(Phone);
            int count =(Integer)redisUtil.get(Phone);
            System.out.println(count);
            if(count == FAILCOUNT){//判断是否已经达到了最大失败次数
//                String lockkey = "user:" + Phone + ":lockTime";
                System.out.println("FAILCOUNT");
                redisUtil.set(Phone,"1",LOCKHOURS * 60 * 60);//设置锁定时间为2小时
                redisUtil.del(Phone);
                map.put(Phone,"错误次数已达上线，请两小时后重新能录");
                return  MyR.error().playCode(251).playMessage(map.get(Phone));
            }
            //没有达到5次，返回剩余登陆次数
            int Count = FAILCOUNT - count;
            map.put(Phone,"登陆失败，您还剩" + Count +"次登陆机会");
        }
        return  MyR.error().playCode(249).playMessage(map.get(Phone));
    }



    @Override
    public MyR face(String phone,String password,String mac,String ip,String face) {

        Map<String,String> loginMap = new HashMap<>();
        String  path="G:\\java\\DUcenter\\UserService\\src\\main\\resources\\face_demo\\"+ phone +".jpeg";
        String path_2="G:\\java\\DUcenter\\UserService\\src\\main\\resources\\face_base\\"+phone+".jpeg";
        FaceId faceId=new FaceId();

        face=face.substring(face.indexOf(",")+1,face.length()-face.indexOf(",")-1);
        faceId.GenerateImage(face,path);
       boolean flag= faceId.faceMatch(path,path_2);
        loginMap.put("Phone",phone);
        loginMap.put("Password",password);
        System.out.println(loginMap);
        List<LoginNum> loginRes = loginmapper.GetUser(loginMap);
        System.out.println("人脸识别"+flag);
        System.out.println( "loginRes"+loginRes.toString());
        if(flag){
            System.out.println(loginRes);
            String token = MyJwtUtils.createToken(loginRes.get(0).getPhone(),loginRes.get(0).getUsername(),loginRes.get(0).getRole().getRole_Id(),
                    loginRes.get(0).getAffiliation(),loginRes.get(0).getUser_Id());
            return MyR.ok().playCode(200).playMessage("验证成功").playData("token", token).playAffiliation(loginRes.get(0).getAffiliation());
//            return R.ok().playMessage("验证成功").playData("url","要跳转的url,系统页");
        }else {
            return MyR.ok().playCode(253).playMessage("人脸识别验证失败,请重新验证");
        }
    }


    /**
     * 检查用户是否已经被锁定，如果是，返回剩余锁定时间，如果否，返回-1
     * @param Phone  username
     * @return  时间
     */
    private int getUserLoginTimeLock(String Phone) {
//        String key = "user:" + username + ":lockTime";
        int lockTime = (int)redisUtil.getExpireSeconds(Phone);
        System.out.println(lockTime);
        if(lockTime > 0){//查询用户是否已经被锁定，如果是，返回剩余锁定时间，如果否，返回-1
            return lockTime;
        }else{
            return -1;
        }
    }

    /**
     * 设置失败次数
     * @param Phone  username
     */
    private void setFailCount(String Phone){
        long count = this.getUserFailCount(Phone);

        if(count < 0){//判断redis中是否有该用户的失败登陆次数，如果没有，设置为1，过期时间为2分钟，如果有，则次数+1
            redisUtil.set(Phone,1,FAILTIME);
            System.out.println("count2:"+redisUtil.get(Phone));
        }else{
            redisUtil.incr(Phone,new Double(1));
            System.out.println("count3:"+redisUtil.get(Phone));
        }
    }

    /**
     * 获取当前用户已失败次数
     * @param key  username
     * @return  已失败次数
     */
    private int getUserFailCount(String key){
//        String key = "user:" + username + ":failCount";
        //从redis中获取当前用户已失败次数
        Object object = redisUtil.get(key);
//        System.out.println(object.toString());
        if(object != null){
            return (int)object;
        }else{
            return -1;
        }
    }
}





