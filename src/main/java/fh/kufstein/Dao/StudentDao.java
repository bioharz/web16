package fh.kufstein.Dao;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import fh.kufstein.Entity.Student;
import fh.kufstein.Utility.DBConnector;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * Created by 1510653032 on 24.04.2017.
 */
public class StudentDao {

    private SessionFactory factory = new DBConnector().getSessionFactory();

    public Student addStudent(String pkz, String firstName, String lastName, Date birthday) {
        Session session = factory.openSession();
        Transaction tx = null;
        Student student = null;

        try {
            tx = session.beginTransaction();
            student = new Student(pkz, firstName, lastName, birthday);
            session.save(student); //OPTINAL: give back the student...
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return student;
    }

    public void listStudents() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List students = session.createQuery("FROM Student").list();
            for (Iterator iterator =
                 students.iterator(); iterator.hasNext(); ) {
                Student student = (Student) iterator.next();
                System.out.println(student);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Student getStudentByPKZ(String pkz) {
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

    /* Method to UPDATE salary for an student */

/*
    public void updatestudent(String pkz, String firstname, String lastname, Date date){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            student student =
                    (student)session.get(student.class, studentID);
            student.setSalary( salary );
            session.update(student);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
*/

    /* Method to DELETE an student from the records */

    /*

    public void deletestudent(Integer studentID){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            student student =
                    (student)session.get(student.class, studentID);
            session.delete(student);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    */
}
