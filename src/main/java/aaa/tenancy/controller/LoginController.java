package aaa.tenancy.controller;

import aaa.tenancy.common.DefaultMsg;
import aaa.tenancy.entity.Module;
import aaa.tenancy.entity.Users;
import aaa.tenancy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/tologin")
    public String toLogin(){
        return "/back/login";
    }
    @RequestMapping("/login")
    @ResponseBody
    public DefaultMsg login(Users users, HttpSession session){
        DefaultMsg msg=new DefaultMsg();
        Users login = loginService.login(users);
        if (login==null){
            msg.setSuccess(0);
            msg.setError("用户名或密码错误");
        }else {
            session.setAttribute("user",users);
        }
        return msg;
    }
    @RequestMapping("/index")
    public String toIndex(){
        return "/back/index";
    }
    @RequestMapping("/getMenu")
    @ResponseBody
    public List<Module> getMenu(HttpSession session){
        Users user =(Users) session.getAttribute("user");
        List<Module> moduleByUser = loginService.getModuleByUser(user);
        return moduleByUser;
    }
}
