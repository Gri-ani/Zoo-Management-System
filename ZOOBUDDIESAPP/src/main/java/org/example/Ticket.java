package org.example;


//this class is used while buyingtickets by the visitor and has 3 parameters
public class Ticket {
    private int nooftickets;
    private String attractionname;
    private double price;

    public String getAttractionname() {
        return this.attractionname;
    }

    public void setAttractionname(String attractionname) {
        this.attractionname = attractionname;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNooftickets() {
        return this.nooftickets;
    }

    public void setNooftickets(int nooftickets) {
        this.nooftickets = nooftickets;
    }

    public Ticket(int nooftickts,String attractionname, double price) {
        this.nooftickets=nooftickets;
        this.attractionname = attractionname;
        this.price = price;

    }


}
