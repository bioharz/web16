package fh.kufstein.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bioharz on 11/04/17.
 */
public class University {

    private String description;
    private int studentCounter;
    //private int Studiengaenge;
    private List<Student> studentList = new ArrayList<>();
    private String city;

    public University(String description, int studiengaenge, String city) {
        this.description = description;
        //Studiengaenge = studiengaenge;
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public int getStudentCounter() {
        return studentCounter;
    }

    /*
    public int getStudiengaenge() {
        return Studiengaenge;
    }
    */

    public List<Student> getStudentList() {
        return studentList;
    }

    public String getCity() {
        return city;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*
    public void setStudiengaenge(int studiengaenge) {
        Studiengaenge = studiengaenge;
    }
    */

    public void setCity(String city) {
        this.city = city;
    }

    public void neuerStudent(Student student) {

        this.studentList.add(student);
        studentCounter++;
    }

    public void pintInfo() {
        System.out.println("University{" +
                "becheinung='" + description + '\'' +
                ", studentCounter=" + studentCounter +
    //            ", Studiengaenge=" + Studiengaenge +
                ", studentList=" + studentList +
                ", city='" + city + '\'' +
                '}');
    }
}


