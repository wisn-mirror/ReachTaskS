package com.wisn.interceptor;

import com.wisn.http.HttpResponse;
import com.wisn.protocol.session.TokenManager;
import com.wisn.tools.JacksonUtil;
import com.wisn.tools.TextUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        System.out.println("Authorization:"+authorization);
        if(TextUtils.isEmpty(authorization)) {
            response.setStatus(400);
            return false;
        }
        boolean online = TokenManager.isOnline(authorization);
        if(!online){
            response.setStatus(401);
            response.setHeader("content-type", "application/json;charset=UTF-8");
            response.getWriter().print(JacksonUtil.toJSon(new HttpResponse<String>(401, "no auth")));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
