package aufgabe3;

import java.util.Date;

/**
 * Created by bioharz on 11/04/17.
 */
public class Student {

    private String pkz;
    private String vorname;
    private String nachname;
    private Date gbDate;

    public Student(String pkz, String vorname, String nachname, Date gbDate) {
        this.pkz = pkz;
        this.vorname = vorname;
        this.nachname = nachname;
        this.gbDate = gbDate;
    }

    public String getPkz() {
        return pkz;
    }

    public void setPkz(String pkz) {
        this.pkz = pkz;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Date getGbDate() {
        return gbDate;
    }

    public void setDate(Date gbDate) {
        this.gbDate = gbDate;
    }


    @Override
    public String toString() {
        return "Student{" +
                "pkz='" + pkz + '\'' +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", date=" + gbDate +
                '}';
    }
}
