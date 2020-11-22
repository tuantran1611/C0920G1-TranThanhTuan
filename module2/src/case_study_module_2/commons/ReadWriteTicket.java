package case_study_module_2.commons;

import case_study_module_2.models.Ticket;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class ReadWriteTicket {
    private static String TICKET_PATH = "src/case_study_module_2/data/Ticket.csv";

    public static void writeTicket(Ticket ticket) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(TICKET_PATH), true));
            bw.write(ticket.getNameCus() + "," + ticket.getNameFilm() + "," + ticket.getTimeFilm() + "," +
                    ticket.getNumberSeat());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Queue<Ticket> readTicket() {
        Queue<Ticket> ticketQueue = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(TICKET_PATH)));
            String[] strArr;
            String line;
            Ticket ticket;
            while ((line = br.readLine()) != null) {
                strArr = line.split(",");
                ticket = new Ticket(strArr[0], strArr[1], strArr[2], strArr[3]);
                ticketQueue.add(ticket);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ticketQueue;
    }

}
