package aaa.tenancy.dao;



import aaa.tenancy.common.BaseDao;
import aaa.tenancy.entity.Module;
import aaa.tenancy.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LoginDao extends BaseDao<Users> {

    public Users login(Users user);

    public  Users findByUsername(String username);

    public List<Module> getFirstModule(Users user);

    public List<Module> getSecondModule(@Param("user") Users user, @Param("parent") Module parent);

    public List<String> queryPermits(Users user);
}
