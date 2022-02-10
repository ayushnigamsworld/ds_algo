package service;

import models.City;
import models.Country;
import models.Person;
import models.State;

public interface ReportService {

    public void report(String diseaseName, String name, Country country, State state, City city);
    public void cured(String diseaseName, Person name);
    public void registerFatality(String diseaseName, Person name);
}
