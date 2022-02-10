package models;

public enum InfectionType {

    TRANSMISSIBLE("TRANSMISSIBLE"),
    NONTRANSMISSIBLE("NON-TRANSMISSIBLE");

    private String name;

    InfectionType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
