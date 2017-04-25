package fh.kufstein;

import fh.kufstein.Dao.StudentDao;
import fh.kufstein.Entity.Student;
import fh.kufstein.Entity.University;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by bioharz on 11/04/17.
 */
public class Main {

    private static SessionFactory factory;

    public static void main(String[] args) throws Exception {

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        //University fhKufstein = new University("FH-Kufstein", 3, "Kufstein");

        StudentDao studentDao = new StudentDao();

      /* Add few students records in database */

        Student stud1 = studentDao.addStudent("1510653032", "Reza", "Shokri",  formatter.parse("21.02.1991"));
        Student stud2 = studentDao.addStudent("1510653033", "Reza2", "Shokri2",  formatter.parse("21.02.1992"));
        Student stud3 = studentDao.addStudent("1510653034", "Reza3", "Shokri3",  formatter.parse("21.02.1993"));

        //System.out.println(stud1.toString());

      /* List down all the students */
        studentDao.listStudents();

        System.out.println(studentDao.getStudentByPKZ("1510653032"));

      /* Update student's records */
        //ME.updatestudent(empID1, 5000);

      /* Delete an student from the database */
        //ME.deletestudent(empID2);

      /* List down new list of the students */
        //ME.liststudents();

        System.exit(0);

    }
}
