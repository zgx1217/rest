package aaa.tenancy.service.impl;


import aaa.tenancy.common.BaseDao;
import aaa.tenancy.common.BaseServiceImpl;
import aaa.tenancy.dao.LoginDao;
import aaa.tenancy.entity.Module;
import aaa.tenancy.entity.Users;
import aaa.tenancy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl extends BaseServiceImpl<Users> implements LoginService {
    @Autowired
    private LoginDao loginDao;
    public Users login(Users user) {
       return loginDao.login(user);
    }

    public Users findByUsername(String username) {
        return loginDao.findByUsername(username);
    }

    public List<Module> getModuleByUser(Users user) {
        List<Module> firstModules = loginDao.getFirstModule(user);
        for (Module firstModule :firstModules
             ) {
            List<Module> secondModule = loginDao.getSecondModule(user, firstModule);
            firstModule.setChildren(secondModule);
        }
        return firstModules;
    }

    /**
     * 查询用户能操作的所有二级模块的命名空间
     * @param moules
     * @return
     */
    public List<String>  queryPermitUrls (List<Module> moules){
        List<String> strs = new ArrayList<String>();
        for(Module oneModule : moules){
            List<Module> twoModules = oneModule.getChildren();
            for(Module twoModule : twoModules){
                String url = twoModule.getUrl();
                strs.add(url.substring(0,url.indexOf("/")));
            }
        }
        return strs;
    }

    public BaseDao<Users> getDao() {
        return loginDao;
    }

    public List<String> queryPermits(Users user){
        return loginDao.queryPermits(user);
    }
}
