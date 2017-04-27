package fh.kufstein.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bioharz on 11/04/17.
 */
@Entity
@Table(name = "university")
public class University {

    @Id
    @Column(name = "description")
    private String description;
    @Column(name = "studentcounter")
    private int studentCounter;
    //private int Studiengaenge;
    //private List<Student> studentList = new ArrayList<>();
    @Column(name = "city")
    private String city;

    public University(String description, int studentCounter, String city) {
        this.description = description;
        this.studentCounter = studentCounter;
        //Studiengaenge = studiengaenge;
        this.city = city;
    }

    public University() {
    }

    public void setStudentCounter(int studentCounter) {
        this.studentCounter = studentCounter;
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

    /*
    public List<Student> getStudentList() {
        return studentList;
    }
    */

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

        //this.studentList.add(student);
        studentCounter++;
    }

    public void pintInfo() {
        System.out.println("University{" +
                "becheinung='" + description + '\'' +
                ", studentCounter=" + studentCounter +
                //            ", Studiengaenge=" + Studiengaenge +
                ", studentList=" +
                ", city='" + city + '\'' +
                '}');
    }
}


