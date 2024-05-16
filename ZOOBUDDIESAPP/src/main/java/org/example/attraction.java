package org.example;

import java.util.List;

interface Details2 {

    String getType();
    void setType(String type);
    String getDescription();
    void setDescription(String description);
}

public  class attraction implements Details2 {
    private int id;             // Unique ID for the attraction

    private String type;        // Attractions can be any cultural exhibit, such as a safari experience, a botanical garden, a dinosaur show, etc.
    private boolean isOpen;     // Indicates whether the attraction is open or not
    private String description;  // Description of the attraction
    private double ticketPrice;  // Ticket price for the attraction
    private int countOfVisitors; // Count of ticketed visitors

    public attraction(int id, String type, String description, double ticketPrice) {
        this.id = id;
        // this.name = name;
        this.type = type;
        this.description = description;
        this.ticketPrice = ticketPrice;
        this.isOpen = false; // Initially, set to closed
        this.countOfVisitors = 0;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isOpen() {
        return isOpen;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    // public void setName(String name) {
    //     this.name = name;
    // }


    // public String getName() {
    //     return name;
    // }


    public void setType(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double tp) {
        this.ticketPrice=tp;
    }

    public int getCountOfVisitors() {
        return countOfVisitors;
    }

    public  void setCountOfVisitors(int count) {
        countOfVisitors = count;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "id=" + id +
                ", type/name='" + type + '\'' +
                ", isOpen=" + isOpen +
                ", description='" + description + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", countOfVisitors=" + countOfVisitors +
                '}';
    }
}
