//package com.music_zuul.filter;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Component
//@EnableConfigurationProperties(FilterProperties.class)
//public class AuthFilter extends ZuulFilter {
//
//    @Autowired
//    private FilterProperties filterProperties;
//
//    @Override
//    public String filterType() {
//        return  "pre";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        // 获取上下文
//        RequestContext ctx = RequestContext.getCurrentContext();
//        // 获取request
//        HttpServletRequest req = ctx.getRequest();
//        // 获取路径
//        String requestURI = req.getRequestURI();
//        // 判断白名单
//        return !isAllowPath(requestURI);
//    }
//
//    private boolean isAllowPath(String requestURI) {
//        // 定义一个标记
//        boolean flag = false;
//        // 遍历允许访问的路径
//        for (String path : this.filterProperties.getAllowPaths()) {
//            // 然后判断是否是符合
//            if(requestURI.startsWith(path)){
//                flag = true;
//                break;
//            }
//        }
//        return flag;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//
//        RequestContext context = RequestContext.getCurrentContext();
//        HttpServletRequest request = context.getRequest();
//        String token = request.getParameter("token");
//        if(token == null){
//            context.setSendZuulResponse(false);
//            context.setResponseStatusCode(401);
//            context.addZuulResponseHeader("content-type","text/html;charset=utf-8");
//            context.setResponseBody("非法访问");
//        }
//
//        return null;
//    }
//}
