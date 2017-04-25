package fh.kufstein;


import fh.kufstein.Dao.StudentDao;
import fh.kufstein.Entity.Student;
import fh.kufstein.Entity.University;

import fh.kufstein.Utility.DBConnector;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by bioharz on 11/04/17.
 */
public class Main {

    private static SessionFactory factory;

    public static void main(String[] args) throws Exception {

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        //Student student1 = new StudentDao().addStudent("1510653032", "Reza", "Shokri", formatter.parse("21.01.1991"));
        //Student student2 = new StudentDao().addStudent("1510653033", "Reza2", "Shokri2", formatter.parse("21.01.1992"));
        //Student student3 = new StudentDao().addStudent("1510653034", "Reza3", "Shokri3", formatter.parse("21.01.1993"));

        //Student student1 = new StudentDao().getStudentByPKZ("1510653032");


        //System.out.println(student1);

        List<Student> studentList = new StudentDao().getAllStudents();

        for (Student student: studentList
             ) {
            System.out.println(student);
        }

        System.exit(0);


    }
}
