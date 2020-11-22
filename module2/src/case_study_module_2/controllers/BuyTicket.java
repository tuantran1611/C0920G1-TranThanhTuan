package case_study_module_2.controllers;

import case_study_module_2.commons.NameException;
import case_study_module_2.commons.ReadWriteTicket;
import case_study_module_2.commons.ValidateData;
import case_study_module_2.models.Ticket;

import java.util.Scanner;

public class BuyTicket {
    public static void buyTicket(){
        Scanner scanner = new Scanner(System.in);
        Ticket ticket = new Ticket();
        boolean check = false;
        do {
            try{
                System.out.println("Nhập tên khách: ");
                String nameCus = scanner.nextLine();
                if (ValidateData.validateNameCustomer(nameCus)){
                    ticket.setNameCus(nameCus);
                    check = true;
                } else {
                    throw new NameException("Tên phải ghi hoa chữ đầu, không có 2 khoảng trống trở lên");
                }
            } catch (NameException e){
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try{
                System.out.println("Nhập tên film");
                String filmName = scanner.nextLine();
                if (ValidateData.validateNameCustomer(filmName)){
                    ticket.setNameFilm(filmName);
                    check = true;
                } else {
                    throw new NameException("Viết hoa chữ đầu");
                }
            } catch (NameException e){
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;
        do {
            try{
                System.out.println("Nhập thời gian chiếu");
                String timeFilm = scanner.nextLine();
                if (ValidateData.validateTimeFilm(timeFilm)){
                    ticket.setTimeFilm(timeFilm);
                    check = true;
                } else {
                    throw new NameException("Nhập đúng định dạng 12:12 AM");
                }
            } catch (NameException e){
                System.err.println(e.getMessage());
            }
        } while (!check);
        check = false;

        do {
            try{
                System.out.println("Nhập ghế ngồi");
                String numSeat = scanner.nextLine();
                if (ValidateData.validateNumSeat(numSeat)){
                    ticket.setNumberSeat(numSeat);
                    check = true;
                } else {
                    throw new NameException("Nhập đúng định dạng [C19]");
                }
            } catch (NameException e){
                System.err.println(e.getMessage());
            }
        } while (!check);
        System.out.println("Nhập thành công");
        ReadWriteTicket.writeTicket(ticket);
    }

    public static void showTicket(){
        System.out.println(ReadWriteTicket.readTicket().poll());
    }
}
