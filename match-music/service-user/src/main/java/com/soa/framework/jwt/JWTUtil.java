package com.soa.framework.jwt;

import com.soa.entity.User;
import com.soa.framework.exception.MyException;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * jwt工具类
 * https://www.cnblogs.com/Jason-Xiang/p/9808596.html
 */
public class JWTUtil {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setUser_name("asd");

        System.out.println(sign(user));

    }

    public static  String token = "token";
    /**
     * 生成token的秘钥，过期时间（一天）
     * soa_final为签名密码
     */
    public static String jwt_SECRET = "soa_final";
    public static long jwt_expr = 3600*24*1000;

    public static String sign(User user){
        //签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成时的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //创建payload
        Map<String,Object> claims = new HashMap<>(5);
        claims.put("id",user.getId());
        claims.put("user_name",user.getUser_name());

        String subject = user.getUser_name();

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm,jwt_SECRET);

        //设置过期时间
        Date exprDate = new Date(nowMillis + jwt_expr);
        builder.setExpiration(exprDate);
        return builder.compact();

    }

    /**
     * @param token 传入前端token并进行身份验证
     * @return 返回验证结果
     */
    public static boolean verify(String token){
        try {
            if(token.isEmpty()){
                return false;
            }
            Jwts.parser().setSigningKey(jwt_SECRET).parseClaimsJws(token).getBody();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User getUser(String token){
        try {
            if(token.isEmpty()){
                throw new MyException("token不能为空");
            }
            if(verify(token)){
                Claims claims = Jwts.parser().setSigningKey(jwt_SECRET).parseClaimsJws(token).getBody();
                User user = new User();
                user.setId( Integer.parseInt(claims.get("id")+""));
                user.setUser_name( claims.get("user_name")+"");

                return user;

            }
            else {
                throw new MyException("超时或不合法token");
            }
        } catch (Exception e) {
            throw new MyException("超时或不合法token");
        }
    }



}
