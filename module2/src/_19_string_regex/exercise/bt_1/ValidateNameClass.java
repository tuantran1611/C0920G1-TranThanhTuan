package _19_string_regex.exercise.bt_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNameClass {

    private static final String NAME_REGEX = "[CAP]\\d{4}[GHIKLM]";

    public ValidateNameClass() {
    }

    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
