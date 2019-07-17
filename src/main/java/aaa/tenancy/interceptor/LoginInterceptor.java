package aaa.tenancy.interceptor;


import aaa.tenancy.common.Constants;
import aaa.tenancy.entity.Users;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 登录校验拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private List<String> allowUrls;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //获取当前请求的路径
        String path = request.getServletPath();
        //判断当前请求路径是否在allowUrls中，如果在直接返回true
        if(allowUrls.contains(path)){
            return true;
        }

        //获取Session
        HttpSession session = request.getSession();
        //获取Session的用户对象
        Users user = (Users)session.getAttribute(Constants.SESSION_USER);
        //判断用户对象是否为空，如果为空跳转到登录界面
        if(user==null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;

        }else
        {
            return true;
        }

    }

    public List<String> getAllowUrls() {
        return allowUrls;
    }

    public void setAllowUrls(List<String> allowUrls) {
        this.allowUrls = allowUrls;
    }
}
