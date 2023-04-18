package com.siafweb.common.intercept;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("==========================================================");
        log.info("BEGIN");

        ////////////////////////////////////////////////////////////////////////////////////////////////
        // 사용자 세션 체크 로직...
        ////////////////////////////////////////////////////////////////////////////////////////////////
        HttpSession session = request.getSession();
        UserVO loginVO = (UserVO) session.getAttribute("loginUser");

        if(ObjectUtils.isEmpty(loginVO)){
            // session에 로그인 객체가 없을경우 response.sendRedirect 로 로그인화면으로 이동.
            response.sendRedirect("/moveLogin.go");
            return false;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////
        // 사용자 세션 체크 로직...
        ////////////////////////////////////////////////////////////////////////////////////////////////

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("PROCESS END...");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("END");
        log.info("==========================================================");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
