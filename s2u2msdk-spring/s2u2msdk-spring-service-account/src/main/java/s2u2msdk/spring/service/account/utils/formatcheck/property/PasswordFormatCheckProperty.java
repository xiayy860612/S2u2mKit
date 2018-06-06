package s2u2msdk.spring.service.account.utils.formatcheck.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * class UserNameFormatCheckProperty
 *
 * @author xiayy860612
 * @date 2018/5/20
 */
@Configuration
@PropertySource("classpath:config/formatcheck.properties")
@ConfigurationProperties(prefix = "formatcheck.password")
@Getter
@Setter
public class PasswordFormatCheckProperty {
    private int minLength;
    private int maxLength;
}
