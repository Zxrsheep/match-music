package com.soa.framework.mvc;

import com.soa.entity.User;
import com.soa.framework.exception.MyException;
import com.soa.framework.jwt.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token拦截器
 */
public class TokenIntercetor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader(JWTUtil.token);
        User user = JWTUtil.getUser(token);
        if(user == null){
            throw new MyException("超时或不合法token1111");
        }
        //token续期
        String newToken = JWTUtil.sign(user);
        response.setHeader(JWTUtil.token,newToken);
        request.setAttribute("user",user);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
