package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disease {

    private String name;
    private DiseaseType type;
    private InfectionType infectionType;
    private TransmissionType transmissionType;
}
