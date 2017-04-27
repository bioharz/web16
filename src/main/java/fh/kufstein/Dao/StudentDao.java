package fh.kufstein.Dao;

import fh.kufstein.Entity.Student;
import fh.kufstein.Utility.DBConnector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by 1510653032 on 27.04.2017.
 */
public class StudentDao {

    private SessionFactory factory = new DBConnector().getSessionFactory();

    public Student addStudent(String pkz, String firstName, String surName, Date birthday) {

        Session session = factory.openSession();
        Transaction tx = null;
        Student student = null;

        try {
            tx = session.beginTransaction();
            student = new Student(pkz, firstName, surName, birthday);
            session.save(student);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


        return student;
    }

}
