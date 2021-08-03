package glider;

import java.util.*;
import java.text.SimpleDateFormat;

public class CarRental {
    public static Boolean canScheduleAll(List<RentalTime> rentalTimes) {
        Collections.sort(rentalTimes, new SortByStart());
        for (int i=1; i<rentalTimes.size(); i++) {
            if (rentalTimes.get(i).end.compareTo(rentalTimes.get(i-1).start) <= 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<RentalTime> rentalTimes = new ArrayList<RentalTime>();
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 20:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:10"), sdf.parse("03/05/2020 22:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/05/2020 22:00")));

        System.out.println(CarRental.canScheduleAll(rentalTimes));
    }
}

class SortByStart implements Comparator<RentalTime>
{
    public int compare(RentalTime  a, RentalTime b) {
        return a.start.compareTo(b.start);
    }
}

class RentalTime {
    public Date start, end;

    public RentalTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}
