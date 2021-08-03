import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Vector;

public class DateChallenge {

    public static void main(String[] args) {

        System.out.println(Integer.parseInt("01"));
        LocalDate ld = LocalDate.parse("2019-01-31");
        YearMonth yearMonthObject = YearMonth.of(1999, 2);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        System.out.println(ld.getMonthValue());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
        String inputString1 = "23 01 1997";
        String inputString2 = "27 04 1997";



        try {
            LocalDate date1 = LocalDate.parse(inputString1, dtf);
            LocalDate date2 = LocalDate.parse(inputString2, dtf);
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MM dd yyyy");
            System.out.println(DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(date1));
            System.out.println(" ,,--"+ date1.compareTo(date2));
            long daysBetween = ChronoUnit.DAYS.between(date1, date2);
            System.out.println ("Days: " + daysBetween);
        } catch (Exception e){
            throw e;
        }
    }
}

interface HH {
    public abstract Object aa();
}

interface H2 {
    public Object ab();
}

abstract class AA implements HH, H2 {

}
