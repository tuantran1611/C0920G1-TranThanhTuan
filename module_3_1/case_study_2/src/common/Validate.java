package common;

public class Validate {
    public static String validateCustomerName(String name) {
        String message = null;
        String regex = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$";
        if (!name.matches(regex)) {
            message = "Not OK. Customer name invalid";
        }
        return message;
    }
}
