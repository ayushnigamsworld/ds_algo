/*
package hackerrank;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class sS {

    public static void main(String[] args) {
        String dateString = "20200301";
        char a = 'z';
        char A = 'A';
        System.out.println((int)a);
        System.out.println((int)A);
        Map<Integer, Integer> aa = new HashMap<>();
        Set<Integer> ss= new HashSet<>();
        Field d = null;
        Class s = null;
        Method sss = null;
        class Inner {
            Inner() {

            }
        }

// BASIC_ISO_DATE is "YYYYMMDD"
// See below link to docs for details
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.BASIC_ISO_DATE);

// get date for previous day
        LocalDate previousDate = date.minusDays(1);

        String f= previousDate.toString();

        // System.out.println(previousDate.format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}
*/
