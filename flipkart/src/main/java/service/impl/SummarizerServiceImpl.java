package service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import models.Country;
import models.Person;
import models.Summary;
import service.StorageService;
import service.SummarizerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class SummarizerServiceImpl implements SummarizerService {

    private StorageService storageService;

    public void showWorldSummary() {
        Map<String, List<Person>> allActive = storageService.getAllActive();
        Map<String, List<Person>> allCured = storageService.getAllCured();
        Map<String, List<Person>> allFatal = storageService.getAllFatal();

        Summary summary = new Summary();
        long activeCount = findSize(allActive);
        long curedCount = findSize(allCured);
        long fatalCount = findSize(allFatal);
        summary.setTotal(activeCount + curedCount + fatalCount);
        summary.setActive(activeCount);
        summary.setCured(curedCount);
        summary.setFatality(fatalCount);
        System.out.println(summary);
    }

    public void showWorldSummaryDiseaseBreakup() {
        Map<String, List<Person>> allActive = storageService.getAllActive();
        Map<String, List<Person>> allCured = storageService.getAllCured();
        Map<String, List<Person>> allFatal = storageService.getAllFatal();


        Map<String, Summary> result = new HashMap<String, Summary>();
        for (Map.Entry<String, List<Person>> entry: allActive.entrySet()) {
            Summary summary = new Summary();
            String diseaseName = entry.getKey();
            summary.setActive(entry.getValue().size());
            result.put(diseaseName, summary);
        }

        for (Map.Entry<String, List<Person>> entry: allCured.entrySet()) {
            String diseaseName = entry.getKey();
            Summary summary = result.get(diseaseName);
            summary.setCured(entry.getValue().size());
            result.put(diseaseName, summary);
        }

        for (Map.Entry<String, List<Person>> entry: allFatal.entrySet()) {
            String diseaseName = entry.getKey();
            Summary summary = result.get(diseaseName);
            summary.setFatality(entry.getValue().size());
            result.put(diseaseName, summary);
        }

        System.out.println(result);
    }

    public void showCountryBreakup() {

    }

    public void curedCountByCountry() {
        Map<String, List<Person>> allCured = storageService.getAllCured();

        Map<Country, Long> result = new HashMap<>();

        for (Map.Entry<String, List<Person>> entry: allCured.entrySet()) {
            List<Person> personList = entry.getValue();
            for (Person person: personList) {
                Country country = person.getAffectedLocation().getCountry();
                if (result.containsKey(country)) {
                    result.put(country, result.getOrDefault(country, 0l) + 1);
                }
            }
        }

        System.out.println(result);
    }

    private Long findSize(Map<String, List<Person>> map) {
        long activeCount = 0;
        for (String disease: map.keySet()) {
            activeCount += map.get(disease).size();
        }
        return activeCount;
    }
}
