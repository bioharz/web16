package aufgabe3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bioharz on 11/04/17.
 */
public class Aufruf {

    public static void main(String[] args) throws Exception{

        DateFormat formatter = new SimpleDateFormat( "dd.MM.yyyy" );

        Hochschule fhKufstein = new Hochschule("FH-Kufstein", 3, "Kufstein");



        for (int i = 0; i <3; i++) {
            fhKufstein.neuerStudent(new Student("151065303"+i, "Reza"+i, "Shokri"+i, formatter.parse("21.02.199"+i)));
            fhKufstein.pintInfo();
        }

    }
}
