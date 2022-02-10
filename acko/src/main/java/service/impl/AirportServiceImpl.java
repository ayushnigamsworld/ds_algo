package service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import models.Flight;
import models.Location;
import service.AirportService;

import java.time.LocalDateTime;

public class AirportServiceImpl implements AirportService {

    private StorageService storageService;

    public AirportServiceImpl() {
        storageService = new StorageService();
    }

    @Override
    public Flight addFlight(@NonNull Flight flight) {
        // basic checks of validations done here.
        storageService.addFlight(flight);
        storageService.addLocationWiseFlight(flight);
        // modify flight obj.
        return flight;
    }

    @Override
    public void removeFlight(String flightNo) {
        if (storageService.containsFlight(flightNo)) {
            storageService.removeFromHeap(flightNo);
            storageService.removeFlight(flightNo);
        }else {
            System.out.println("Flight not found");
        }
    }

    @Override
    public Flight getClosestFlight(LocalDateTime departureTime, Location destination) {
        Flight closestFlight = storageService.getMin(destination, departureTime);
        if (closestFlight == null) {
            System.out.println("No flight");
        } else {
            System.out.println(closestFlight.getFlightNo());
        }
        return closestFlight;
    }
}
