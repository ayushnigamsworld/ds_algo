package upstox.util;

import upstox.model.StoryClass;

import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    // Haven't implemented this ofcourse, just a CSV util. NO brainer.
    public List<StoryClass> readCSV(String filepath) {
        List<StoryClass> storyClassList = new ArrayList<>();
        // Use  Apache Commons CSV to read the file
        // and then set the pojo i.e. StoryClass

        /*try (Reader reader = Files.newBufferedReader(Paths.get("file.csv"));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withFirstRecordAsHeader()
             ) {
            for (CSVRecord csvRecord : csvParser) {
                     StoryClass storyClass = new StoryClass();
                     String name = csvRecord.get("Name");
                     storyClass.setName(name);
                     String manager = csvRecord.get("manager");
                     storyClass.setManager(manager);
                     .. similarly rest of setters
                     storyClassList.add(storyClass);
                     ... etc
                     // (..)
                 }*/
        return storyClassList;
    }
}
