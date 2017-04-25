package fh.kufstein.Dao;

import fh.kufstein.Entity.Student;
import fh.kufstein.Utility.DBConnector;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by 1510653032 on 25.04.2017.
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
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return student;

    }

    public Student getStudentByPKZ(String pkz){
        Session session = factory.openSession();
        Transaction tx = null;

        Student result = null;

        try {
            tx = session.beginTransaction();

            String hql = "FROM Student s WHERE s.pkz = :student_pkz";
            Query query = session.createQuery(hql);
            query.setParameter("student_pkz", pkz);
            result = (Student) query.getSingleResult();
            tx.commit();
        } catch (Exception e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }
        return result;
    }


    public List<Student> getAllStudents() {

        Session session = factory.openSession();
        Transaction tx = null;

        List<Student> result = null;

        try {
            tx = session.beginTransaction();

            String hql = "FROM Student";
            Query query = session.createQuery(hql);
            result = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

}
