package s2u2msdk.spring.service.account.auth.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import s2u2msdk.spring.service.account.entity.UserEntity;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * class AdminFilter
 *
 * @author xiayy860612
 * @date 2018/5/3
 */
public class UserTokenFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(
            ServletRequest servletRequest, ServletResponse servletResponse,
            Object o) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String token = request.getHeader("token");
        UserTokenAuth auth = new UserTokenAuth(token);
        Subject subject = getSubject(servletRequest, servletResponse);
        try {
            subject.login(auth);
        } catch (AuthenticationException ex) {
            return false;
        }

        // transfer UserEntity
        request.setAttribute(UserEntity.class.getName(), auth.getUserEntity());
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.sendRedirect("/unauth");
        return false;
    }
}
