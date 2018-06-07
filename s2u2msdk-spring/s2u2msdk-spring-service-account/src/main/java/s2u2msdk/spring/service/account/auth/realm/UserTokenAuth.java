package s2u2msdk.spring.service.account.auth.realm;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationToken;
import s2u2msdk.spring.service.account.entity.UserEntity;

/**
 * class AdminTokenAuth
 *
 * @author xiayy860612
 * @date 2018/5/4
 */
public class UserTokenAuth implements AuthenticationToken {

    @Getter
    private String token;
    public UserTokenAuth(String token) {
        this.token = token;
    }

    @Getter
    @Setter
    private UserEntity userEntity;

    @Override
    public Object getPrincipal() {
        return this.token;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }
}
