package s2u2msdk.spring.service.account.auth;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import s2u2msdk.spring.service.account.auth.realm.UserRealm;
import s2u2msdk.spring.service.account.auth.realm.UserTokenFilter;

import javax.servlet.Filter;
import java.util.*;

/**
 * @author Amos Xia
 * @date 2018/4/28
 */
@Configuration
public class ShiroConfig {

    @Autowired
    private UserRealm userRealm;

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager sm = new DefaultWebSecurityManager();

        // set realms
        List<Realm> realms = new ArrayList<>();
        realms.add(userRealm);

        sm.setRealms(realms);
        return sm;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager sm) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(sm);

        // filter
        Map<String, Filter> filters = new HashMap<>();
        filters.put(UserTokenFilter.class.getName(), new UserTokenFilter());

        factoryBean.setFilters(filters);

        // filter chain
        Map<String, String> chainMap = new LinkedHashMap<>();
        chainMap.put("/unauth", "anon");

        // swagger
        chainMap.put("/v2/api-docs", "anon");

        // druid
        chainMap.put("/druid/**", "anon");

        // user filters
        chainMap.put("/account/**/login", "anon");
        chainMap.put("/account/**/reg", "anon");
        chainMap.put("/**", UserTokenFilter.class.getName());

        // chainMap.put("/**", "anon");

        factoryBean.setFilterChainDefinitionMap(chainMap);
        // factoryBean.setUnauthorizedUrl("/unauth");

        return factoryBean;
    }

    // make shiro aop enable
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
