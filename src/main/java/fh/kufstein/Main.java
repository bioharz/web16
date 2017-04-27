package fh.kufstein;

import fh.kufstein.Dao.StudentDao;
import fh.kufstein.Entity.Student;
import fh.kufstein.Entity.University;
import fh.kufstein.Utility.DBConnector;
import org.hibernate.SessionFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by bioharz on 11/04/17.
 */
public class Main {


    public static void main(String[] args) throws Exception {

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        StudentDao studentDao = new StudentDao();

        Student student1 = studentDao.addStudent("1510653032", "Reza", "Shokri", formatter.parse("21.02.1991"));

        System.exit(0);

    }
}
