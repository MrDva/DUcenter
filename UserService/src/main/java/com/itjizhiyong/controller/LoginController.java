package com.itjizhiyong.controller;


import com.ithujiaze.entity.Point;
import com.ithujiaze.service.Login_DataService;
import com.itjizhiyong.entities.LoginVO;
import com.itjizhiyong.entities.MyR;
import com.itjizhiyong.entities.Face;


import com.alibaba.fastjson.JSONObject;
//import com.itjizhiyong.service.OrderFeignService;
import com.itjizhiyong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/User")
public class LoginController {


    public final static String UPLOAD_PATH_PREFIX = "src/main/resources/face_base/";

    Point point=new Point();
    List<String> Authority_names = new ArrayList<>();

    @Autowired
    private UserService userLogin;

    private Login_DataService login_dataService;



    String mac;
    String phone;
    String ip;
    String password;

    @PostMapping("/face")
    @CrossOrigin(origins = "*")
    public MyR face(@RequestBody Face face, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        System.out.println(face.toString());
        return userLogin.face(face.getPhone(),
                face.getPassword(),face.getMac(),face.getIp(),face.getFace());
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public MyR login(@RequestBody LoginVO loginVO, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        System.out.println(UPLOAD_PATH_PREFIX);
        phone = loginVO.getPhone();
        password = loginVO.getPassword();
        mac = loginVO.getMac();
        ip = loginVO.getIp();

//        System.out.println(password);

//        List<LoginNum> loginRes = loginServ.login(phone, password);
//        System.out.println(loginRes);
//        String token = MyJwtUtils.createToken(loginRes.get(0).getAffiliation(),loginRes.get(0).getPhone(),loginRes.get(0).getRole(),loginRes.get(0).getUsername(),loginRes.get(0).getUser_Id());
//        if (loginRes == null) {
//

//            return R.error().playMessage("error,用户不存在或密码错误").playCode(1);
//        }
//        else {
//            return R.ok().playCode(200).playMessage("success").playData("token", token);
//        }

        MyR res = userLogin.login(phone, password, mac, ip);
        return res;

    }


    public Point toHuPoint(@RequestBody String JsonFeignArg){
        JSONObject jsonFeignArg= JSONObject.parseObject(JsonFeignArg);
         mac = jsonFeignArg.getString("mac");
         String phone = jsonFeignArg.getString("Phone");
         ip = jsonFeignArg.getString("ip");

        Point point = login_dataService.login(mac, ip, phone);
        return this.point;
    }



}
