package aufgabe2;

import org.omg.CORBA.UnknownUserException;

import javax.security.auth.login.CredentialException;
import javax.swing.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * Created by bioharz on 10/04/17.
 */
public class Aufruf {

    //FUR 2.8.2
    private static final Logger logger = LogManager.getLogger(Aufruf.class);

    //FUER 1.2
    //static Logger logger = Logger.getLogger(Aufruf.class);

    //CREATE SOME TEST USER
    static private User[] users = new User[3];


    public static void main(String[] args) {

        //CREATE SOME TEST USER
        users[0] = new User("andrea.mair", "123test");
        users[1] = new User("michael.sommer", "winter!");
        users[2] = new User("stefan.geist", "password");


        JTextField username = new JTextField();
        JTextField password = new JTextField();
        Object[] message = {"Username", username,
                "Password", password};

        JOptionPane pane = new JOptionPane(message,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION);
        pane.createDialog(null, "Login-Page").setVisible(true);


        try {
            checkLogin(username.getText(), password.getText());
        } catch (Exception e) {
            logger.error(e);
            //LOG ME
            //e.printStackTrace();
        }


        //System.out.println("Username: " + username.getText() + "\nPassword: " + password.getText());
        System.exit(0);

    }

    private static void checkLogin(String username, String password) throws UnknownUserException, PasswordWrongException {

        boolean goodUserName = false;

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("CORRECT USERNAME");
                goodUserName = true;
                if (user.getPassword().equals(password)) {
                    System.out.println("CORRECT PASSWORD");
                    break;
                } else {
                    throw new PasswordWrongException("PASSWORD WRONG");
                }
            }
        }

        //NO USER FOUND
        if (!goodUserName) {
            throw new UnknownUserException();
        }
    }
}
