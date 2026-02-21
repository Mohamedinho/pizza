package com.example.myrecipeapp.model;

public class Pizza {
    private static long AUTO_ID = 1;

    private long id;
    private String name;
    private double price;
    private int imageRes;
    private String duration;
    private String ingredients;
    private String description;
    private String steps;

    public Pizza() {
        this.id = AUTO_ID++;
    }

    public Pizza(String name, double price, int imageRes, String duration,
                   String ingredients, String description, String steps) {
        this.id = AUTO_ID++;
        this.name = name;
        this.price = price;
        this.imageRes = imageRes;
        this.duration = duration;
        this.ingredients = ingredients;
        this.description = description;
        this.steps = steps;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getImageRes() { return imageRes; }
    public void setImageRes(int imageRes) { this.imageRes = imageRes; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSteps() { return steps; }
    public void setSteps(String steps) { this.steps = steps; }

    @Override
    public String toString() {
        return name + " - " + price + " €";
    }
}
