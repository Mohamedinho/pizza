package com.example.pizzaapp.model;

public class MarrakeshItem {
    private static long serialGenerator = 1000;

    private long uniqueId;
    private String label;
    private double unitPrice;
    private int visualResource;
    private String prepTime;
    private String components;
    private String briefInfo;
    private float userRating;

    public MarrakeshItem(String label, double unitPrice, int visualResource, String prepTime,
                        String components, String briefInfo, float userRating) {
        this.uniqueId = serialGenerator++;
        this.label = label;
        this.unitPrice = unitPrice;
        this.visualResource = visualResource;
        this.prepTime = prepTime;
        this.components = components;
        this.briefInfo = briefInfo;
        this.userRating = userRating;
    }

    public long getUniqueId() { return uniqueId; }
    public String getLabel() { return label; }
    public double getUnitPrice() { return unitPrice; }
    public int getVisualResource() { return visualResource; }
    public String getPrepTime() { return prepTime; }
    public String getComponents() { return components; }
    public String getBriefInfo() { return briefInfo; }
    public float getUserRating() { return userRating; }
}
