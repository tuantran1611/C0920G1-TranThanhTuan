//package on_tap_1.commons;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class RegexData {
//
//    private static final String PRODUCT_CODE = "^(SP)\\d{5}$";
//    private static final String PRODUCT_NAME = "^[A-Z][a-z]* ?[A-Za-z0-9]*$";
//    private static final String PRODUCT_PRICE = "^[1-9][0-9]*$";
//
//
//    public static boolean regexProductCode(String regex){
//        Pattern pattern = Pattern.compile(PRODUCT_CODE);
//        Matcher matcher = pattern.matcher(regex);
//        return matcher.matches();
//    }
//
//    public static boolean regexProductName(String regex){
//        Pattern pattern = Pattern.compile(PRODUCT_NAME);
//        Matcher matcher = pattern.matcher(regex);
//        return matcher.matches();
//    }
//
//    public static boolean regexPrice(String regex){
//        Pattern pattern = Pattern.compile(PRODUCT_PRICE);
//        Matcher matcher = pattern.matcher(regex);
//        return matcher.matches();
//    }
//}
