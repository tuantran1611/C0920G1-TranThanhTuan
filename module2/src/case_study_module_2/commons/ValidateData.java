package case_study_module_2.commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateData {

    private static final String ID_SERVICE_VILLA_REGEX = "^(SVVL)-\\d{4}$";
    private static final String ID_SERVICE_HOUSE_REGEX = "^(SVHO)-\\d{4}$";
    private static final String ID_SERVICE_ROOM_REGEX = "^(SVRO)-\\d{4}$";
    private static final String NAME_SERVICE_REGEX = "^[A-Z][a-z0-9]*$";
    private static final String POOL_AREA_REGEX = "^(([3-9])([0-9])|([1-9]\\d{2,}))(|\\.[0-9]+)$";
    private static final String AMOUNT_MAX_REGEX = "^((0*[1-9])|1([1-9]))$";
    private static final String PRICE_RENT_REGEX = "^(\\d+)(|\\.[0-9]+)$";
    private static final String NAME_CUSTOMER_REGEX= "^([A-Z][a-z]+\\s)+(|[A-Z][a-z]+)$";
    private static final String EMAIL_CUSTOMER_REGEX = "^[a-z0-9_]+[a-z0-9]@([a-z0-9]+\\.)[a-z]+(|\\.[a-z]+)$";
    private static final String CMND_CUSTOMER_REGEX = "^([0-9]{3}\\s){2}[0-9]{3}$";
    private static final String GENDER_CUSTOMER_REGEX = "^[mM][aA][lL][eE]|[fF][eE][mM][aA][lL][eE]|[uU][nN][kK][nN][oO][wW]$";
    private static final String PHONE_NUMBER_REGEX = "^0([0-9]{9})$";
    private static final String BIRTHDAY_REGEX = "^((0[1-9])|([1-2][0-9])|(3[01]))\\/((0[0-9])|1[0-2])\\/((19[0-9]{2}))$";
    public ValidateData() {
    }

    public static boolean validateIdServiceVilla(String regex){
        Pattern pattern = Pattern.compile(ID_SERVICE_VILLA_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateIdServiceHouse(String regex){
        Pattern pattern = Pattern.compile(ID_SERVICE_HOUSE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateIdServiceRoom(String regex){
        Pattern pattern = Pattern.compile(ID_SERVICE_ROOM_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateNameService(String regex){
        Pattern pattern = Pattern.compile(NAME_SERVICE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validatePoolArea(String regex){
        Pattern pattern = Pattern.compile(POOL_AREA_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateAmountMax(String regex){
        Pattern pattern = Pattern.compile(AMOUNT_MAX_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validatePriceRent(String regex){
        Pattern pattern = Pattern.compile(PRICE_RENT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateNameCustomer(String regex){
        Pattern pattern = Pattern.compile(NAME_CUSTOMER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateEmailCustomer(String regex){
        Pattern pattern = Pattern.compile(EMAIL_CUSTOMER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateCmndCustomer(String regex){
        Pattern pattern = Pattern.compile(CMND_CUSTOMER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateGenderCustomer(String regex){
        Pattern pattern = Pattern.compile(GENDER_CUSTOMER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validatePhoneCustomer(String regex){
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}