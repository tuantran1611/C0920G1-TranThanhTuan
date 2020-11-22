package case_study_module_2.models;

public class Ticket {
    private String nameCus;
    private String nameFilm;
    private String timeFilm;
    private String numberSeat;

    public Ticket() {
    }

    public Ticket(String nameCus, String nameFilm, String timeFilm, String numberSeat) {
        this.nameCus = nameCus;
        this.nameFilm = nameFilm;
        this.timeFilm = timeFilm;
        this.numberSeat = numberSeat;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public String getTimeFilm() {
        return timeFilm;
    }

    public void setTimeFilm(String timeFilm) {
        this.timeFilm = timeFilm;
    }

    public String getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(String numberSeat) {
        this.numberSeat = numberSeat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "Name ='" + nameCus + '\'' +
                ", Name Film='" + nameFilm + '\'' +
                ", Time ='" + timeFilm + '\'' +
                ", Seat ='" + numberSeat + '\'' +
                '}';
    }
}
