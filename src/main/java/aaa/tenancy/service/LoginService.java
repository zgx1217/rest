package aaa.tenancy.service;



import aaa.tenancy.common.BaseService;
import aaa.tenancy.entity.Module;
import aaa.tenancy.entity.Users;

import java.util.List;


public interface LoginService extends BaseService<Users> {

    public Users login(Users user);

    public Users findByUsername(String username);

    public List<Module> getModuleByUser(Users user);

    public List<String>  queryPermitUrls(List<Module> moules);

    public List<String> queryPermits(Users user);
}
