package aaa.tenancy.interceptor;


import aaa.tenancy.common.Constants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 权限校验拦截器
 */
public class PermitInterceptor extends HandlerInterceptorAdapter {

    private List<String> allowUrls;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //获取当前请求的路径   /user/edit.do
        String path = request.getServletPath();
        //判断当前请求路径是否在allowUrls中，如果在直接返回true
        if(allowUrls.contains(path)){
            return true;
        }
        //获取Session
        HttpSession session = request.getSession();
        //获取当前用户能操作的命名空间的集合
       List<String> namespaces = (List<String>) session.getAttribute(Constants.SESSION_NAMESPACES);
       //获取用户当前请求路径的命名空间
        String namespace = path.substring(1,path.lastIndexOf("/"));
        //判断当前请求路径的命名空间在不在用户可操作的命名空间之内
        if(namespaces.contains(namespace)){
            return true;
        }else{
            //跳转到权限不足的界面
            response.sendRedirect(request.getContextPath()+"/error.html");
            return false;
        }


    }

    public List<String> getAllowUrls() {
        return allowUrls;
    }

    public void setAllowUrls(List<String> allowUrls) {
        this.allowUrls = allowUrls;
    }
}
