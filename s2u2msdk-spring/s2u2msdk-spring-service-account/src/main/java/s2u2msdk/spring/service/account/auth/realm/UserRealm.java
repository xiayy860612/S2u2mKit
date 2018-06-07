package s2u2msdk.spring.service.account.auth.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import s2u2msdk.spring.service.account.entity.UserEntity;
import s2u2msdk.spring.service.account.service.UserService;

/**
 * class UserRealm, check
 *
 * @author xiayy860612
 * @date 2018/6/7
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UserTokenAuth;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UserTokenAuth auth = (UserTokenAuth)authenticationToken;
        UserEntity entity = userService.get(auth.getToken());
        if (entity == null) {
            throw new UnknownAccountException();
        }

        auth.setUserEntity(entity);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                entity, auth.getCredentials(), getName());
        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }


}
