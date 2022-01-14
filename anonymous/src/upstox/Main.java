package upstox;

import upstox.model.Result;
import upstox.model.StoryClass;
import upstox.points.DevPoints;
import upstox.points.QAPoints;
import upstox.util.CSVUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Upstox Round 1:: Ayush Nigam
 */
public class Main {

    public static void main(String[] args) {
        CSVUtil csvUtil = new CSVUtil();
        List<StoryClass> inp = csvUtil.readCSV("//something"); // Dummy CSV method.
        Main main = new Main();
        // Pass a valid list to this method to test.
        Result result = main.bestEmployees(inp);
        System.out.println(result);
    }

    // To test simply pass the list
    public Result bestEmployees(List<StoryClass> inp) {
        String bestQA = null;
        String bestDev = null;
        String bestManager = null;
        Integer maxQA = Integer.MIN_VALUE;
        Integer maxDev = Integer.MIN_VALUE;
        Integer maxManager = Integer.MIN_VALUE;
        Map<String, Integer> manager = new HashMap<>();
        for (StoryClass storyClass: inp) {
            Integer localOverall = 0;
            if (manager.containsKey(storyClass.getManager())) {
                localOverall = manager.get(storyClass.getManager());
            }

            if (storyClass.getRole().equalsIgnoreCase("QA")) {
                Integer localQA = findQAPoints(storyClass); // this is stored in variable jst in case u want to retrieve it.
                localOverall += localQA;
                if (localQA > maxQA) {
                    bestQA = storyClass.getName();
                }
            }
            else if (storyClass.getRole().equalsIgnoreCase("DEV")) {
                Integer localDev = findDevPoints(storyClass);
                localOverall += localDev;
                if (localDev > maxDev) {
                    bestDev = storyClass.getName();
                }
            }
            manager.put(storyClass.getManager(), localOverall);
        }
        for (Map.Entry<String, Integer> mp: manager.entrySet()) {
            if (mp.getValue() > maxManager ) {
                maxManager = mp.getValue();
                bestManager = mp.getKey();
            }
        }
        return new Result(bestDev, bestQA, bestManager);
    }

    private Integer findDevPoints(StoryClass storyClass) {
        return storyClass.getFeatureStory() * DevPoints.feature + storyClass.getUatBug() * DevPoints.uat
                + storyClass.getProdBug() * DevPoints.prod;
    }

    private Integer findQAPoints(StoryClass storyClass) {
        return storyClass.getFeatureStory() * QAPoints.feature + storyClass.getUatBug() * QAPoints.uat
                + storyClass.getProdBug() * QAPoints.prod;
    }
}

