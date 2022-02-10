import models.*;
import service.DiseaseService;
import service.ReportService;
import service.StorageService;
import service.SummarizerService;
import service.impl.DiseaseServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.StorageServiceImpl;
import service.impl.SummarizerServiceImpl;

public class Main {

    public static void main(String[] args) {

        StorageService storageService = new StorageServiceImpl();
        DiseaseService diseaseService = new DiseaseServiceImpl(storageService);
        ReportService reportService = new ReportServiceImpl(storageService);
        SummarizerService summarizerService = new SummarizerServiceImpl(storageService);


        diseaseService.registerDisease("COVID19", DiseaseType.VIRAL, InfectionType.TRANSMISSIBLE, TransmissionType.AIR);
        diseaseService.registerDisease("FLU", DiseaseType.VIRAL, InfectionType.TRANSMISSIBLE, TransmissionType.AIR);

        reportService.report("COVID19", "P1", new Country("India"), new State("U.P."), new City("Lucknow"));

        reportService.report("COVID19", "P2", new Country("India"), new State("U.P."), new City("Kanpur"));

        reportService.report("COVID19", "P3", new Country("India"), new State("Maharastra"), new City("Mumbai"));

        Person person1 = new Person();
        person1.setId("P1");

        reportService.report("FLU", "P1", new Country("America"), new State("U.P."), new City("Lucknow"));

        Person person2 = new Person();
        person2.setId("P2");
        Person person3 = new Person();
        person2.setId("P3");
        reportService.cured("COVID19", person2);
        reportService.registerFatality("COVID19", person3);

        System.out.println("World Summary");
        summarizerService.showWorldSummary();
        System.out.println("Disease Summary");
        summarizerService.showWorldSummaryDiseaseBreakup();
    }
}
