import models.Departure;
import models.Flight;
import models.Location;
import service.AirportService;
import service.impl.AirportServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    private void init() {

    }

    public static void main(String[] args) {
        // init
        AirportService airportService = new AirportServiceImpl();
        Location mumbai = new Location(1, "Mumbai");
        Location delhi = new Location(2, "Delhi");
        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime nowOneHour = LocalDateTime.now().plusHours(1);
        LocalDateTime nowTwoHours = LocalDateTime.now().plusHours(2);
        LocalDateTime nowThreeHour = LocalDateTime.now().plusHours(3);

        LocalDateTime nowMinusOneHour = LocalDateTime.now().minusHours(1);

        Departure mumbaiDepartureNow = new Departure(nowTime, mumbai);
        Departure delhiDepartureOnehour = new Departure(nowOneHour, delhi);
        Departure delhiDepartureThreeHour = new Departure(nowThreeHour, delhi);

        // LocalDateTime localDateTime = new LocalDateTime(new LocalDate(2022, 1, 28), new )
        // Departure abs3pm = new Departure(, delhi);

        // testing apis
        airportService.addFlight(new Flight("123", mumbaiDepartureNow));
        airportService.addFlight(new Flight("234", delhiDepartureOnehour));
        airportService.addFlight(new Flight("456", delhiDepartureThreeHour));

        // airportService.addFlight(new Flight("hello", ))

        System.out.println("Find closest flight for Mumbai at current Time");
        airportService.getClosestFlight(nowTime, mumbai);

        System.out.println("Find closest flight for Mumbai at current + 2");
        airportService.getClosestFlight(nowTwoHours, mumbai);

        System.out.println("Find closest flight for Delhi at current + 1");
        airportService.getClosestFlight(nowOneHour, delhi);

        System.out.println("Find closest flight for Delhi at current + 2");
        airportService.getClosestFlight(nowTwoHours, delhi);

        System.out.println("Removing flight no 234");
        airportService.removeFlight("234");

        System.out.println("Find closest flight for Delhi at current + 1");
        airportService.getClosestFlight(nowOneHour, delhi);

        System.out.println("Find closest flight for Delhi at current");
        airportService.getClosestFlight(nowTime, delhi);
    }
}
