package _19_string_regex.exercise.bt_2;

public class ValidatePhoneNumberTest {
    public static void main(String[] args) {
        String str = "(+84)-(0987575064)";
        System.out.println(new ValidatePhoneNumber().validate(str));
    }
}
