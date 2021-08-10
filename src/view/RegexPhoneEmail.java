
package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPhoneEmail {
    private static final String phoneNumber = "^[0]\\d{9}$";
    private static final String email = "^[A-Za-z0-9]+[A-Za-z0-9]*(@gmail.com)$";

    public RegexPhoneEmail() {
    }

    public static boolean validate(String regex2) {
        Pattern pattern = Pattern.compile("^[0]\\d{9}$");
        Matcher matcher = pattern.matcher(regex2);
        return matcher.matches();
    }
    public static boolean valida1(String regex1) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*(@gmail.com)$");
        Matcher matcher = pattern.matcher(regex1);
        return matcher.matches();
    }
}