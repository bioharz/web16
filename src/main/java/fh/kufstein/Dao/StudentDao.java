package fh.kufstein.Dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import fh.kufstein.Entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Created by 1510653032 on 24.04.2017.
 */
public class StudentDao {


    private static SessionFactory factory;
    public static void main(String[] args) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");




        try{
            //Configuration  configuration = new Configuration().configure("hibernate.cfg.xml");
            //return  configuration.buildSessionFactory();

            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        StudentDao ME = new StudentDao();

      /* Add few employee records in database */
        /*
        Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
        Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
        Integer empID3 = ME.addEmployee("John", "Paul", 10000);
        */

        //Student stud1 = ME.addStudent("1510653032", "Reza", "Shokri",  formatter.parse("21.02.1991"));
        //Student stud2 = ME.addStudent("1510653033", "Reza2", "Shokri2",  formatter.parse("21.02.1992"));
        //Student stud3 = ME.addStudent("1510653034", "Reza3", "Shokri3",  formatter.parse("21.02.1993"));


        //System.out.println(stud1.toString());

      /* List down all the employees */
        //ME.listEmployees();

        System.out.println(ME.getStudentByPKZ("1510653032"));

      /* Update employee's records */
        //ME.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
        //ME.deleteEmployee(empID2);

      /* List down new list of the employees */
        //ME.listEmployees();

        System.exit(0);
    }
    /* Method to CREATE an employee in the database */


    public Student addStudent(String pkz, String firstName, String lastName, Date birthday){
        Session session = factory.openSession();
        Transaction tx = null;
        //String pkzID = null;

        Student student = null;

        try{
            tx = session.beginTransaction();
            student = new Student(pkz, firstName, lastName, birthday);
            //pkzID = (String) session.save(student);
            //employeeID = (Integer) session.save(employee);
            pkz = (String) session.save(student);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        //return pkzID;
        return student;
    }
    /* Method to  READ all the employees */


    public void listStudents( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List students = session.createQuery("FROM Student").list();
            for (Iterator iterator =
                 students.iterator(); iterator.hasNext();){
                Student student = (Student) iterator.next();
                System.out.println(student);
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public Student getStudentByPKZ(String pkz){
        Session session = factory.openSession();
        Transaction tx = null;

        Student result = null;

        try{
            tx = session.beginTransaction();

            //Student student = session.createQuery("FROM Student where pkz = :pkz ").getParameter(pkz);

            String hql = "FROM Student s WHERE s.pkz = :student_pkz";
            Query query = session.createQuery(hql);
            query.setParameter("student_pkz",pkz);
            result = (Student) query.getSingleResult();
            /*

            List students = session.createQuery("FROM Student").list();
            for (Iterator iterator =
                 students.iterator(); iterator.hasNext();){
                Student student = (Student) iterator.next();
                System.out.println(student);
            }*/
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return result;
    }



    /* Method to UPDATE salary for an employee */


/*
    public void updateEmployee(String pkz, String firstname, String lastname, Date date){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Employee employee =
                    (Employee)session.get(Employee.class, EmployeeID);
            employee.setSalary( salary );
            session.update(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
*/

    /* Method to DELETE an employee from the records */

    /*

    public void deleteEmployee(Integer EmployeeID){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Employee employee =
                    (Employee)session.get(Employee.class, EmployeeID);
            session.delete(employee);
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
