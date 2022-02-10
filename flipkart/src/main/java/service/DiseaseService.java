package service;

import models.Disease;
import models.DiseaseType;
import models.InfectionType;
import models.TransmissionType;

public interface DiseaseService {

    public void registerDisease(Disease disease);
    public void registerDisease(String name, DiseaseType diseaseType, InfectionType infectionType, TransmissionType transmissionType);


}
