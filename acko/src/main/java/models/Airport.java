package models;

import lombok.Data;

import java.util.List;

@Data
public class Airport {

    private List<Flight> flights;
}
