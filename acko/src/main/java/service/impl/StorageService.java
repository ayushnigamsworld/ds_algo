package service.impl;

import lombok.AllArgsConstructor;
import models.Flight;
import models.Location;

import java.time.LocalDateTime;
import java.util.*;

public class StorageService {

    private Map<String, Flight> flightStorage;
    private Map<Location, PriorityQueue<Flight>> locationWiseFlights;

    StorageService() {
        flightStorage = new HashMap<>();
        locationWiseFlights = new HashMap<>();
    }

    public void addFlight(Flight flight) {
        flightStorage.put(flight.getFlightNo(), flight);
    }

    public boolean containsFlight(String flightNumber) {
        return flightStorage.containsKey(flightNumber);
    }

    public void removeFlight(String flightNumber) {
        if (flightStorage.containsKey(flightNumber)) {
            flightStorage.remove(flightNumber);
        }
    }

    public void removeFromHeap(String flightNumber) {
        Flight existingFlight = flightStorage.get(flightNumber);
        Location location = existingFlight.getDeparture().getDestination();
        PriorityQueue<Flight> heap = locationWiseFlights.get(location);
        heap.remove(existingFlight);
        locationWiseFlights.put(location, heap);
    }

    public void addLocationWiseFlight(Flight flight) {
        Location location = flight.getDeparture().getDestination();
        if (locationWiseFlights.containsKey(location)) {
            PriorityQueue<Flight> existing = locationWiseFlights.get(location);
            existing.offer(flight);
            locationWiseFlights.put(location, existing);
        } else {
            PriorityQueue<Flight> newQueue = new PriorityQueue<>(Comparator.comparing(a -> a.getDeparture().getTime()));
            newQueue.offer(flight);
            locationWiseFlights.put(location, newQueue);
        }
    }

    public void removeLocationWiseFlight(Location destination, Flight flight) {
        // can be done easily.
    }

    public Flight getMin(Location location, LocalDateTime dateTime) {
        PriorityQueue<Flight> flightsAtLocation = locationWiseFlights.get(location);
        for (Flight flight: flightsAtLocation) {
            if (flight.getDeparture().getTime().compareTo(dateTime) >= 0) {
                return flight;
            }
        }
        return null;
    }
}
