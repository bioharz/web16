package fh.kufstein;


import fh.kufstein.Entity.Student;
import fh.kufstein.Entity.University;

import fh.kufstein.Utility.DBConnector;
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

        //DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");



        //System.exit(0);


        //private SessionFactory factory = new DBConnector().getSessionFactory();

        SessionFactory factory = new DBConnector().getSessionFactory();

        System.exit(0);


    }
}
