package fh.kufstein.Dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fh.kufstein.Entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        String stud1 = ME.addStudent("1510653032", "Reza", "Shokri",  formatter.parse("21.02.1991"));

      /* List down all the employees */
        //ME.listEmployees();

      /* Update employee's records */
        //ME.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
        //ME.deleteEmployee(empID2);

      /* List down new list of the employees */
        //ME.listEmployees();
    }
    /* Method to CREATE an employee in the database */
    public String addStudent(String pkz, String firstName, String lastName, Date birthday){
        Session session = factory.openSession();
        Transaction tx = null;
        //String pkzID = null;
        try{
            tx = session.beginTransaction();
            Student student = new Student(pkz, firstName, lastName, birthday);
            //pkzID = (String) session.save(student);
            //employeeID = (Integer) session.save(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        //return pkzID;
        return pkz;
    }
    /* Method to  READ all the employees */

    /*
    public void listEmployees( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator =
                 employees.iterator(); iterator.hasNext();){
                Employee employee = (Employee) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    */

    /* Method to UPDATE salary for an employee */

    /*

    public void updateEmployee(Integer EmployeeID, int salary ){
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
