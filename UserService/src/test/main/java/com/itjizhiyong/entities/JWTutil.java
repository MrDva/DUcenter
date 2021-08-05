package com.itjizhiyong.entities;

import com.itchenyang.exception.BusinessException;
import com.itchenyang.result.ResponseEnum;
import com.itchenyang.utills.JwtUtils;
import com.ithujiaze.entity.Role;
import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.List;

class JWTutils  {
    private static long tokenExpiration = 24*60*60*1000;
    private static String tokenSignKey = "A1t2g3uigu123456";

    private static Key getKeyInstance(){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] bytes = DatatypeConverter.parseBase64Binary(tokenSignKey);
        return new SecretKeySpec(bytes,signatureAlgorithm.getJcaName());
    }

    public static String createToken(String username, String phone, Role role) {
        String token = Jwts.builder()
                .setSubject("SRB-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("username", username)
                .claim("phone",phone)
                .claim("role",role)
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


    public static String getUsername(String token) {
        Claims claims = getClaims(token);
        return (String) claims.get("username");
    }

    public static String getPhone(String token) {
        Claims claims = getClaims(token);
        return (String)claims.get("phone");
    }
    public static Role getRole(String token){
        Claims claims = getClaims(token);
        Role role = (Role)claims.get("role");
        return role;
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
