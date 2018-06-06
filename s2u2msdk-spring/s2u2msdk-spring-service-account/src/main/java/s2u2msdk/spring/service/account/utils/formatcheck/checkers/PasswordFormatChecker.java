package s2u2msdk.spring.service.account.utils.formatcheck.checkers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import s2u2msdk.spring.service.account.utils.formatcheck.IStringFormatChecker;
import s2u2msdk.spring.service.account.utils.formatcheck.property.PasswordFormatCheckProperty;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class PasswordFormatChecker
 *
 * @author xiayy860612
 * @date 2018/5/7
 */
@Component
public class PasswordFormatChecker implements IStringFormatChecker {

    private static final Pattern pattern;

    static {
        String specialChars = "!@#$%^&*()-+=";
        String reg = String.format("^[a-zA-Z][\\w%s]+$", specialChars);
        pattern = Pattern.compile(reg);
    }

    @Autowired
    private PasswordFormatCheckProperty property;

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
