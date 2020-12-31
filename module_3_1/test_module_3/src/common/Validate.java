package common;

import models.*;

public class Validate {

    private static final String ID_SERVICE_VILLA_REGEX = "^(SVVL)-\\d{4}$";
    private static final String ID_SERVICE_HOUSE_REGEX = "^(SVHO)-\\d{4}$";
    private static final String ID_SERVICE_ROOM_REGEX = "^(SVRO)-\\d{4}$";
    private static final String NAME_SERVICE_REGEX = "^[A-Z][a-z0-9_]*$";
    private static final String POOL_AREA_REGEX = "^(([3-9])([0-9])|([1-9]\\d{2,}))(|\\.[0-9]+)$";
    private static final String AMOUNT_MAX_REGEX = "^((0*[1-9])|1([1-9]))$";
    private static final String PRICE_RENT_REGEX = "^(\\d+)(|\\.[0-9]+)$";
    private static final String NAME_CUSTOMER_REGEX= "^(([A-Z][a-z]+)(| ))+$";
    private static final String ID_CUSTOMER_REGEX = "^((KH)-|)\\d{4}$";
    private static final String EMAIL_CUSTOMER_REGEX = "^[a-z0-9_]+[a-z0-9]@([a-z0-9]+\\.)[a-z]+(|\\.[a-z]+)$";
    private static final String CMND_CUSTOMER_REGEX = "^([0-9]{3}\\s){2}[0-9]{3}$";
    private static final String GENDER_CUSTOMER_REGEX = "^[nN][aA][mM]|[nN][uU]|[uU][nN][kK][nN][oO][wW]$";
    private static final String PHONE_NUMBER_REGEX = "^0([0-9]{9})$";
    private static final String BIRTHDAY_REGEX = "(^(((0[1-9]|1[0-9]|2[0-8])[/](0[1-9]|1[012]))|((29|30|31)[/]" +
            "(0[13578]|1[02]))|((29|30)[/](0[4,6,9]|11)))[/](19\\d\\d|200[0-1])$)|(^29[/]02[/]((19)" +
            "(04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)|2000)$)";
    private static final String TIME_FILM_REGEX = "^((0*\\d)|1[012])\\:[0-5][0-9] (AM|PM)$";
    private static final String NUMBER_SEAT_REGEX = "^\\[[A-Z][0-9][1-9]\\]$";

    public static String validateUserName(String name) {
        String message = null;
        String regex = "^([a-z]+(|[0-9]+))_[a-z0-9]+$";
        if (!name.matches(regex)) {
            message = "Not OK. Username like abc123_abc123";
        }
        return message;
    }


    public static String validateEmployeeId(String id) {
        String message = null;
        String regex = "^\\d+$";
        if (id.equals("")) {
        } else if (!id.matches(regex)){
            message = "Not OK. Please input a number or no input in this row!!!";
        }
        return message;
    }

    public static String validateServiceName(String name) {
        String message = null;
        if (name.equals("")) {
            message = "Not OK. Please input name of service";
        }
        return message;
    }

    public static String validateServiceArea(String area) {
        String message = null;
        String regex = "^(\\d+)(|\\.[0-9]+)$";
        if (!area.matches(regex)) {
            message = "Not OK. The number is a Positive number";
        }
        return message;
    }

    public static String validateServiceTypeCost(String cost) {
        String message = null;
        String regex = "^(\\d+)(|\\.[0-9]+)$";
        if (!cost.matches(regex)) {
            message = "Not OK. The number is a Positive number";
        }
        return message;
    }

    public static String validateCustomerId(String id) {
        String message = null;
        String regex = "^((KH)-|)\\d{4}$";
        if (!id.matches(regex)) {
            message = "Not OK. Customer id invalid. Please input KH-XXXX . With XXXX is 4 numbers";
        }
        return message;
    }

    public static String validateServiceId(String id) {
        String message = null;
        String regex = "^((DV)-|)\\d{4}$";
        if (!id.matches(regex)) {
            message = "Not OK. Service id invalid. Please input DV-XXXX . With XXXX is 4 numbers";
        }
        return message;
    }


    public static String validateCustomerName(String name) {
        String message = null;
        String regex = "^(([A-Z][a-z]+)(| ))+$";
        if (!name.matches(regex)) {
            message = "Not OK. Customer name invalid";
        }
        return message;
    }

}
