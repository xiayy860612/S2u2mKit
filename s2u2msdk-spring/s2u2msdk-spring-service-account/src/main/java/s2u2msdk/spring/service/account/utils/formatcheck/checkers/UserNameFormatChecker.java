package s2u2msdk.spring.service.account.utils.formatcheck.checkers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import s2u2msdk.spring.service.account.utils.formatcheck.property.UserNameFormatCheckProperty;
import s2u2msdk.spring.service.account.utils.formatcheck.IStringFormatChecker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class UserNameFormatChecker
 *
 * @author xiayy860612
 * @date 2018/5/7
 */
@Component
public final class UserNameFormatChecker implements IStringFormatChecker {
    private static final Pattern pattern;

    static {
//        String specialChars = "!@#$%^&*()-+=";
        String reg = "^[a-zA-Z]\\w+$";
        pattern = Pattern.compile(reg);
    }

    @Autowired
    private UserNameFormatCheckProperty property;

    @Override
    public boolean check(String data) {
        if (data.length() < property.getMinLength()
                || data.length() > property.getMaxLength()) {
            return false;
        }

        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
}
