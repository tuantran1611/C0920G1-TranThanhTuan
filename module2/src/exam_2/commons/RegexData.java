package exam_2.commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexData {
    private static final String MA_SO_SO = "^(STK)\\-\\d{4}$";
    private static final String NGAY_MO_SO= "(^(((0[1-9]|1[0-9]|2[0-8])[/](0[1-9]|1[012]))|((29|30|31)[/]" +
            "(0[13578]|1[02]))|((29|30)[/](0[4,6,9]|11)))[/](19\\d\\d|200[0-1])$)|(^29[/]02[/]((19)" +
            "(04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)|2000)$)";
    private static final String SO_TIEN_GUI = "^[1-9][0-9]{6,}$";

    private static final String KY_HAN_GUI_NGAN_HAN = "^3|6$";
    private static final String KY_HAN_GUI = "^1|3|5|10$";
    private static final String LAI_SUAT = "^[1-9][0-9]*$";


    public static boolean regexMaSoSo(String regex){
        Pattern pattern = Pattern.compile(MA_SO_SO);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean regexNgayMoSo(String regex){
        Pattern pattern = Pattern.compile(NGAY_MO_SO);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean regexKyHanGui(String regex){
        Pattern pattern = Pattern.compile(KY_HAN_GUI);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean regexKyHanGuiNganHan(String regex){
        Pattern pattern = Pattern.compile(KY_HAN_GUI_NGAN_HAN);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean regexSoTienGui(String regex){
        Pattern pattern = Pattern.compile(SO_TIEN_GUI);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean regexPrice(String regex){
        Pattern pattern = Pattern.compile(LAI_SUAT);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
