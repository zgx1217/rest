package aaa.tenancy.realm;


import aaa.tenancy.entity.Users;
import aaa.tenancy.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义的realm 用来获取认证和授权的数据
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户对象
        Users user = (Users)principalCollection.getPrimaryPrincipal();
        //查询用户能操作的权限的信息
        List<String> permits = loginService.queryPermits(user);

        //如果是管理员获取到的信息是user rold mod ckd rkd
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permits);
        return info;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户传递过来的用户名
        String username = token.getPrincipal().toString();
        //根据用户传递过来的用户名，查询用户的对象
        Users user = loginService.findByUsername(username);
        //获取用户的盐值信息
        String salt = user.getSalt();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),ByteSource.Util.bytes(salt),"authRealm");
        return info;
    }
}
