package upstox.model;

public class Result {
    private String bestDev;
    private String bestQA;
    private String bestManager;

    public Result(String bestDev, String bestQA, String bestManager) {
        this.bestDev = bestDev;
        this.bestQA = bestQA;
        this.bestManager = bestManager;
    }

    public String getBestDev() {
        return bestDev;
    }

    public void setBestDev(String bestDev) {
        this.bestDev = bestDev;
    }

    public String getBestQA() {
        return bestQA;
    }

    public void setBestQA(String bestQA) {
        this.bestQA = bestQA;
    }

    public String getBestManager() {
        return bestManager;
    }

    public void setBestManager(String bestManager) {
        this.bestManager = bestManager;
    }

    @Override
    public String toString() {
        return "Result{" +
                "bestDev='" + bestDev + '\'' +
                ", bestQA='" + bestQA + '\'' +
                ", bestManager='" + bestManager + '\'' +
                '}';
    }
}
