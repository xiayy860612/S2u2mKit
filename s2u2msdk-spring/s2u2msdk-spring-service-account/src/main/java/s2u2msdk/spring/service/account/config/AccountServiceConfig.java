package s2u2msdk.spring.service.account.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import s2u2msdk.spring.core.config.AbS2u2mServiceConfig;
import s2u2msdk.spring.service.account.auth.argresolver.UserEntityMethodArgResolver;

import java.util.List;

/**
 * class AccountServiceConfig
 *
 * @author xiayy860612
 * @date 2018/6/7
 */
@Configuration
public class AccountServiceConfig extends AbS2u2mServiceConfig {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new UserEntityMethodArgResolver());
    }
}
