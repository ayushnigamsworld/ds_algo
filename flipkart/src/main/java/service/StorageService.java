package service;

import models.Disease;
import models.Person;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StorageService {

    public void storeDisease(Disease disease);
    public void registerActive(Disease disease, Person person);
    public void registerCured(Disease disease, Person person);
    public void registerFatality(Disease disease, Person person);

    public Disease getDisease(String name);

    public Map<String, List<Person>> getAllActive();
    public Map<String, List<Person>> getAllCured();
    public Map<String, List<Person>> getAllFatal();
}
