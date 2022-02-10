package service.impl;

import lombok.Data;
import models.Disease;
import models.Location;
import models.Person;
import service.StorageService;

import java.util.*;

// Singleton
@Data
public class StorageServiceImpl implements StorageService {

    // personStorage
    private Map<String, Disease> diseaseMap;
    private Map<String, List<Person>> activeDiseaseOnPersonStorage;
    private Map<String, List<Person>> curedDiseaseOnPersonStorage;
    private Map<String, List<Person>> fatalDiseaseOnPersonStorage;


    public StorageServiceImpl() {
        diseaseMap = new HashMap<String, Disease>();
        activeDiseaseOnPersonStorage = new HashMap<String, List<Person>>();
        curedDiseaseOnPersonStorage = new HashMap<String, List<Person>>();
        fatalDiseaseOnPersonStorage = new HashMap<String, List<Person>>();
    }

    public void storeDisease(Disease disease) {
        this.diseaseMap.put(disease.getName(), disease);
    }

    public void registerActive(Disease disease, Person person) {
        List<Person> existingPerson = null;
        // club to single function...
        if (activeDiseaseOnPersonStorage.containsKey(disease.getName())) {
            existingPerson = activeDiseaseOnPersonStorage.get(disease.getName());
            existingPerson.add(person);
        } else {
            existingPerson = new ArrayList<Person>();
            existingPerson.add(person);
        }
        activeDiseaseOnPersonStorage.put(disease.getName(), existingPerson);
    }

    public void registerCured(Disease disease, Person person) {
        removeFromCategory(activeDiseaseOnPersonStorage, person);
        List<Person> existingPerson = null;
        if (curedDiseaseOnPersonStorage.containsKey(disease.getName())) {
            existingPerson = curedDiseaseOnPersonStorage.get(disease.getName());
            existingPerson.add(person);
        } else {
            existingPerson = new ArrayList<Person>();
            existingPerson.add(person);
        }
        curedDiseaseOnPersonStorage.put(disease.getName(), existingPerson);
    }

    public void registerFatality(Disease disease, Person person) {
        removeFromCategory(activeDiseaseOnPersonStorage, person);
        List<Person> existingPerson = null;
        if (fatalDiseaseOnPersonStorage.containsKey(disease.getName())) {
            existingPerson = fatalDiseaseOnPersonStorage.get(disease.getName());
            existingPerson.add(person);
        } else {
            existingPerson = new ArrayList<Person>();
            existingPerson.add(person);
        }
        fatalDiseaseOnPersonStorage.put(disease.getName(), existingPerson);
    }

    public Disease getDisease(String name) {
        return diseaseMap.get(name);
    }

    public Map<String, List<Person>> getAllActive() {
        return this.activeDiseaseOnPersonStorage;
    }

    public Map<String, List<Person>> getAllCured() {
        return this.curedDiseaseOnPersonStorage;
    }

    public Map<String, List<Person>> getAllFatal() {
        return this.fatalDiseaseOnPersonStorage;
    }

    private void removeFromCategory(Map<String, List<Person>> storage, Person person) {
        for (Map.Entry<String, List<Person>> personEntry: storage.entrySet()) {
            List<Person> personList = personEntry.getValue();
            // fix for concurrentmodification
            for (Person person1 : personList) {
                if (person1.getId().equalsIgnoreCase(person.getId())) {
                    personList.remove(person1);
                }
            }
        }
    }
}
