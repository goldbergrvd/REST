package haha.bean;

public class ProgramLanguage {
    private String name;
    private int communityIndex;
    private double rating;
    private String type;
    private boolean interpret;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCommunityIndex() {
        return communityIndex;
    }

    public void setCommunityIndex(int communityIndex) {
        this.communityIndex = communityIndex;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isInterpret() {
        return interpret;
    }

    public void setInterpret(boolean interpret) {
        this.interpret = interpret;
    }

}
