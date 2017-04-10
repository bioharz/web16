package aufgabe4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by bioharz on 11/04/17.
 */
public class Aufruf {

    public static void main(String[] args) throws Exception {

        boolean pwIsSecure = false;


        do {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a secure pw: ");
            String input = br.readLine();

            pwIsSecure = isPasswordSecure(input);

        }
        while (!pwIsSecure);

    }

    static boolean isPasswordSecure(String password){
        if (    password.length() >= 6 &&
                (       password.contains("!") ||
                        password.contains("?") ||
                        password.contains("&")
                ) &&
                password.matches(".*\\d+.*")
            ) {
            System.out.println("good passwd, the last 3 chart of the pw: "+password.substring(password.length()-3,password.length()));
            return true;
        }
        else {
             System.err.println("BAD PASSWORD!!!!");
            return false;
        }
    };
}
