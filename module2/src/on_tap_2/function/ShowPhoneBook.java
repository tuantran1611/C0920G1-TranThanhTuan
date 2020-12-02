package on_tap_2.function;

import on_tap_2.models.PhoneBook;

import java.util.List;

public class ShowPhoneBook {

    public static void showPhoneBook(){
        List<PhoneBook> phoneBookList = AddNewPhoneBook.getPhoneBookList();
        if (phoneBookList.isEmpty()){
            System.out.println("Danh sách trống");
        } else {
            for (PhoneBook phoneBook : phoneBookList) {
                System.out.println(phoneBook.toString());
            }
        }
    }
}
