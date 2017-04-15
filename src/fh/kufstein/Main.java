package fh.kufstein;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by bioharz on 11/04/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        University fhKufstein = new University("FH-Kufstein", 3, "Kufstein");

/*
        for (int i = 0; i < 3; i++) {
            fhKufstein.neuerStudent(new Student("151065303" + i, "Reza" + i, "Shokri" + i, formatter.parse("21.02.199" + i)));
            fhKufstein.pintInfo();
        }
*/
    }
}
