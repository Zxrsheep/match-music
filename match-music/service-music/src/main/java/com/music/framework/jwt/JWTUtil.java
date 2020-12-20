package com.music.framework.jwt;

import com.music.framework.exception.MyException;
import io.jsonwebtoken.*;

/**
 * jwt工具类
 * https://www.cnblogs.com/Jason-Xiang/p/9808596.html
 */
public class JWTUtil {

    public static  String token = "token";
    //生成token的秘钥，过期时间（一天）
    public static String jwt_SECRET = "soa_final";
    public static long jwt_expr = 3600*24*1000;

    //验证
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

    public static Boolean getToken(String token){
        try {
            if(token.isEmpty()){
                throw new MyException("token不能为空");
            }
            if(verify(token)){
                Claims claims = Jwts.parser().setSigningKey(jwt_SECRET).parseClaimsJws(token).getBody();

                return true;

            }
            else {
                throw new MyException("超时或不合法token");
            }
        } catch (Exception e) {
            throw new MyException("超时或不合法token");
        }
    }



}
