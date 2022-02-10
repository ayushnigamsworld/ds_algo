package models;

import lombok.Data;

import java.util.Set;

@Data
public class Person {

    private String id;
    private String usernameAlias;
    private PersonDetails personDetails;

    private Boolean isAffected = false;
    private Boolean isCured = false;
    private Boolean isFatal = false;

    private Location affectedLocation;
    private Set<Disease> diseaseSet;
    private Disease fatalByDisease;
}
