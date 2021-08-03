package farzi;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Just {

    public static void main(String[] args) {
        Float d = new Float("3.0");
        int s  = d.intValue();
        byte a = d.byteValue();
        double q = d.doubleValue();
        // System.out.println(s + a + q);

        Instant aa= Instant.parse("2015-06-25T16:43:30.00z");
        aa.plus(10, ChronoUnit.HOURS);
        System.out.println(aa);
    }
}
