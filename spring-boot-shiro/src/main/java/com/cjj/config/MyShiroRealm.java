package com.cjj.config;

import com.cjj.model.SysPermission;
import com.cjj.model.SysRole;
import com.cjj.model.UserInfo;
import com.cjj.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/23 14:09
 */

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserInfoService userInfoService;

    /**
     * Shiro 的权限授权是通过继承AuthorizingRealm抽象类，重载doGetAuthorizationInfo();
     * 当访问到页面的时候，链接配置了相应的权限或者 Shiro 标签才会执行此方法否则不会执行，
     * 所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回 null 即可。
     * 在这个方法中主要是使用类：SimpleAuthorizationInfo进行角色的添加和权限的添加。
     *
     * 就是说如果在shiro配置文件中添加了filterChainDefinitionMap.put(“/add”, “perms[权限添加]”);
     * 就说明访问/add这个链接必须要有“权限添加”这个权限才可以访问，
     * 如果在shiro配置文件中添加了filterChainDefinitionMap.put(“/add”, “roles[100002]，perms[权限添加]”);
     * 就说明访问/add这个链接必须要有“权限添加”这个权限和具有“100002”这个角色才可以访问。
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
        for (SysRole role :
                userInfo.getRoleList()) {
            simpleAuthorizationInfo.addRole(role.getRole());
            for (SysPermission p :
                    role.getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 在认证、授权内部实现机制中都有提到，最终处理都将交给Real进行处理。
     * 因为在 Shiro 中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     * 通常情况下，在 Realm 中会直接从我们的数据源中获取 Shiro 需要的验证信息。
     * 可以说，Realm 是专用于安全框架的 DAO. Shiro 的认证过程最终会交由 Realm 执行，
     * 这时会调用 Realm 的getAuthenticationInfo(token)方法。
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("身份认证-->MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户输入的账号
        String username = (String) token.getPrincipal();
        System.out.println("Credentials:"+token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，返回一个封装了用户信息的AuthenticationInfo实例
        // 没找到,则返回null
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("----->>userInfo="+userInfo);
        if (null == userInfo) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户信息
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        String credentials = (String) simpleAuthenticationInfo.getCredentials();
        System.out.println(credentials);
        return simpleAuthenticationInfo;
    }
}
