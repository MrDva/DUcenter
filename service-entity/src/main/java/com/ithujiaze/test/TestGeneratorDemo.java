package com.ithujiaze.test;


import com.ithujiaze.dao.*;
import com.ithujiaze.entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class TestGeneratorDemo {

    public static void main(String[] args) throws IOException {
        String resource = "src/main/resources/conf.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory
                = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();

//        UserTableMapper mapper = session.getMapper(UserTableMapper.class);
//       User user = mapper.GetUserByUserId(1) ;

//        RoleTableMapper mapper = session.getMapper(RoleTableMapper.class);
//        Role user = mapper.GetRoleById(1) ;

//        AuthorityTableMapper mapper = session.getMapper(AuthorityTableMapper.class);
//        Authority user = mapper.GetAuthorityById(1) ;
//        Login_DataTableMapper mapper = session.getMapper(Login_DataTableMapper.class);
////        Login_Data user = mapper.GetLogin_DataById(1) ;
//        Login_Data login_data=new Login_Data();
//         <!--private int access_id;-->
//    <!--private User user;//账号本人-->
//    <!--private String mac;-->
//    <!--private String address;-->
//    <!--private String point_X;-->
//    <!--private String point_Y;-->
//    <!--private Date datetime;-->
//        User user=new User();
//        user.setPhone(1);
//        java.util.Date date=new java.util.Date();
//        Timestamp sqlDate = new Timestamp(date.getTime());
//        login_data.setUser(user);
//        login_data.setMac("mac2");
//        login_data.setAddress("shanghai");
//        login_data.setPoint_X("101.0");
//        login_data.setPoint_Y("200");
//        login_data.setDatetime(sqlDate);
//        mapper.insert(login_data);
//        System.out.println(login_data);
//        session.commit();
//        System.out.println(user);
        Three_DataTableMapper mapper = session.getMapper(Three_DataTableMapper.class);
       Three_Data user = mapper.GetThree_DataById(1) ;
        System.out.println(user);
        session.close();

    }
}
