package pl.sda.springdemo.flights;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public class FlightResponse {

    private final List<Flight> flights;

    @JsonCreator
    public FlightResponse(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
