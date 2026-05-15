package com.lemon_legacy.models;

public class Area {

    private String name;
    private String description;
    private int recommendedLevel;

    public Area(String name, String description, int recommendedLevel) {
        this.name = name;
        this.description = description;
        this.recommendedLevel = recommendedLevel;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRecommendedLevel() {
        return recommendedLevel;
    }

    public void showDetails() {
        System.out.println("Area: " + name);
        System.out.println(description);
        System.out.println("Recommended level: " + recommendedLevel);
    }
}