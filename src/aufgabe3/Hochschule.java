package aufgabe3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bioharz on 11/04/17.
 */
public class Hochschule {

    private String bezeichnung;
    private int anzahlStudenten;
    private int Studiengaenge;
    private List<Student> studentenliste = new ArrayList<>();
    private String ort;

    public Hochschule(String becheinung, int studiengaenge, String ort) {
        this.bezeichnung = becheinung;
        Studiengaenge = studiengaenge;
        this.ort = ort;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getAnzahlStudenten() {
        return anzahlStudenten;
    }

    public int getStudiengaenge() {
        return Studiengaenge;
    }

    public List<Student> getStudentenliste() {
        return studentenliste;
    }

    public String getOrt() {
        return ort;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setStudiengaenge(int studiengaenge) {
        Studiengaenge = studiengaenge;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void neuerStudent(Student student) {

        this.studentenliste.add(student);
        anzahlStudenten++;
    }

    public void pintInfo() {
        System.out.println("Hochschule{" +
                "becheinung='" + bezeichnung + '\'' +
                ", anzahlStudenten=" + anzahlStudenten +
                ", Studiengaenge=" + Studiengaenge +
                ", studentenliste=" + studentenliste +
                ", ort='" + ort + '\'' +
                '}');
    }
}


