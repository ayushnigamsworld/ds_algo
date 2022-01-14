package upstox.model;

public class StoryClass {
    private String role;
    private String name;
    private String manager;
    private Integer featureStory;
    private Integer uatBug;
    private Integer prodBug;

    public StoryClass() {
    }

    public StoryClass(String role, String name, String manager, Integer featureStory, Integer uatBug, Integer prodBug) {
        this.role = role;
        this.name = name;
        this.manager = manager;
        this.featureStory = featureStory;
        this.uatBug = uatBug;
        this.prodBug = prodBug;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Integer getFeatureStory() {
        return featureStory;
    }

    public void setFeatureStory(Integer featureStory) {
        this.featureStory = featureStory;
    }

    public Integer getUatBug() {
        return uatBug;
    }

    public void setUatBug(Integer uatBug) {
        this.uatBug = uatBug;
    }

    public Integer getProdBug() {
        return prodBug;
    }

    public void setProdBug(Integer prodBug) {
        this.prodBug = prodBug;
    }
}
