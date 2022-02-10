package service;

import models.Flight;
import models.Location;

import java.time.LocalDateTime;

public interface AirportService {

    public Flight addFlight(Flight flight);

    public void removeFlight(String flightNo);

    public Flight getClosestFlight(LocalDateTime departureTime, Location destination);
}
