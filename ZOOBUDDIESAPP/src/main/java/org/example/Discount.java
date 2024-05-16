package org.example;

public class Discount {
    private String category;  // Category of the discount (e.g., "Minor", "Senior Citizen")
    private double percentage; // Percentage of the discount (e.g., 10% or 20%)

    public Discount(String category, double percentage) {
        this.category = category;
        this.percentage = percentage;
    }

    public String getCategory() {
        return category;
    }

    public double getPercentage() {
        return percentage;
    }

    // public double getPercentage() {
    //     return percentage;
    // }

    // Setter for percentage
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
