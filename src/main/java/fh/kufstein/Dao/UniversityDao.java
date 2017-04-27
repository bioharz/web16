package fh.kufstein.Dao;

import fh.kufstein.Entity.Student;
import fh.kufstein.Entity.University;
import fh.kufstein.Utility.DBConnector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by 1510653032 on 27.04.2017.
 */
public class UniversityDao {

    private SessionFactory factory = new DBConnector().getSessionFactory();

    public University addUniversity(String description, int studentCounter, String city) {

        Session session = factory.openSession();
        Transaction tx = null;
        University university = null;

        try {
            tx = session.beginTransaction();
            university = new University();
            session.save(student);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return student;
    }

}
