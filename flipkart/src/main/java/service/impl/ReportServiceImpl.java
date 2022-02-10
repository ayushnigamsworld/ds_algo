package service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import models.*;
import service.ReportService;
import service.StorageService;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class ReportServiceImpl implements ReportService {

    private StorageService storageService;

    public void report(String diseaseName, String person, Country country, State state, City city) {
        //
        Disease disease = storageService.getDisease(diseaseName);
        //
        Location location = new Location(country, state, city);
        Person person1 = new Person();
        person1.setId(person);
        person1.setIsAffected(true);
        person1.setAffectedLocation(location);
        Set<Disease> diseaseSet = person1.getDiseaseSet();
        if (diseaseSet != null && diseaseSet.isEmpty()) {
            diseaseSet.add(disease);
        } else {
            diseaseSet = new HashSet<Disease>();
            diseaseSet.add(disease);
        }
        person1.setDiseaseSet(diseaseSet);
        storageService.registerActive(disease, person1);
    }

    public void cured(String diseaseName, Person person) {
        // do validations here
        Disease disease = storageService.getDisease(diseaseName);
        person.setIsCured(true);
        /*Set<Disease> diseaseSet = person.getDiseaseSet();
        // do validations here
        diseaseSet.remove(disease);
        person.setDiseaseSet(diseaseSet);*/
        storageService.registerCured(disease, person);
    }

    public void registerFatality(String diseaseName, Person person) {
        // do validations here
        Disease disease = storageService.getDisease(diseaseName);
        person.setIsFatal(true);
        person.setFatalByDisease(disease);
        storageService.registerFatality(disease, person);
    }
}
