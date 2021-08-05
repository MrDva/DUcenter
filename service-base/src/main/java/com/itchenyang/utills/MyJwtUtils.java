package com.itchenyang.utills;

import com.itchenyang.exception.BusinessException;
import com.itchenyang.result.ResponseEnum;
import com.ithujiaze.entity.Role;
import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class MyJwtUtils {
    private static long tokenExpiration = 24*60*60*1000;
    private static String tokenSignKey = "A1t2g3uigu123456";

    private static Key getKeyInstance(){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] bytes = DatatypeConverter.parseBase64Binary(tokenSignKey);
        return new SecretKeySpec(bytes,signatureAlgorithm.getJcaName());
    }

    public static String createToken(String phone, String Username, int Role_Id,String affiliation,int User_Id) {
        String token = Jwts.builder()
                .setSubject("SRB-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("phone", phone)
                .claim("Username", Username)
                .claim("role_id",Role_Id)
                .claim("affiliation",affiliation)
                .claim("User_Id", User_Id)
                .signWith(SignatureAlgorithm.HS512, getKeyInstance())
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    public static String createToken(String requestPhone,String responsePhone,String requestName,String responseName,Integer status) {
        String token = Jwts.builder()
                .setSubject("SRB-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("requestPhone",requestPhone)
                .claim("responsePhone",responsePhone)
                .claim("requestName",requestName)
                .claim("responseName",responseName)
                .claim("status",status)
                .signWith(SignatureAlgorithm.HS512, getKeyInstance())
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }


    /**
     * 判断token是否有效
     * @param token
     * @return
     */
    public static boolean checkToken(String token) {
        if(StringUtils.isEmpty(token)) {
            return false;
        }
        try {
            Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static String getRequestPhone(String token) {
        Claims claims = getClaims(token);
        return (String)claims.get("requestPhone");
    }
    public static String getResponsePhone(String token) {
        Claims claims = getClaims(token);
        return (String)claims.get("responsePhone");
    }
    public static String getRequestName(String token) {
        Claims claims = getClaims(token);
        return (String)claims.get("requestName");
    }
    public static String getResponseName(String token) {
        Claims claims = getClaims(token);
        return (String)claims.get("responseName");
    }
    public static Integer getStatus(String token) {
        Claims claims = getClaims(token);
        return (Integer)claims.get("status");
    }
    public static String getAffiliation(String token) {
        Claims claims = getClaims(token);
        return (String)claims.get("affiliation");
    }

    public static Integer getUser_Id(String token) {
        Claims claims = getClaims(token);
        return (Integer) claims.get("User_Id");
    }

    public static Integer getRole(String token) {
        Claims claims = getClaims(token);
        return (Integer) claims.get("role_id");
    }

    public static String getUserName(String token) {
        Claims claims = getClaims(token);
        return (String)claims.get("Username");
    }

    public static String getPhone(String token) {
        Claims claims = getClaims(token);
        return (String)claims.get("phone");
    }

    public static void removeToken(String token) {
        //jwttoken无需删除，客户端扔掉即可。
    }

    /**
     * 校验token并返回Claims
     * @param token
     * @return
     */
    private static Claims getClaims(String token) {
        if(StringUtils.isEmpty(token)) {
            // LOGIN_AUTH_ERROR(-211, "未登录"),
            throw new BusinessException(ResponseEnum.LOGIN_AUTH_ERROR);
        }
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            return claims;
        } catch (Exception e) {
            throw new BusinessException(ResponseEnum.LOGIN_AUTH_ERROR);
        }
    }
}
