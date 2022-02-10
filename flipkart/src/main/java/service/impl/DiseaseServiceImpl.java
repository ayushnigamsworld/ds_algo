package service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import models.Disease;
import models.DiseaseType;
import models.InfectionType;
import models.TransmissionType;
import service.DiseaseService;
import service.StorageService;

@AllArgsConstructor
@NoArgsConstructor
public class DiseaseServiceImpl implements DiseaseService {

    private StorageService storageService;

    public void registerDisease(Disease disease) {
        // validations here existing etc
        storageService.storeDisease(disease);
    }

    public void registerDisease(String name, DiseaseType diseaseType, InfectionType infectionType, TransmissionType transmissionType) {
        // existing disease
        storageService.storeDisease(new Disease(name, diseaseType, infectionType, transmissionType));
    }
}
