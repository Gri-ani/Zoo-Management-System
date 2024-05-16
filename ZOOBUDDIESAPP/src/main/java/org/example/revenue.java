package org.example;

public class revenue {
    double revenue;
    revenue(double revenue) {
        this.revenue = revenue;

    }
    public void addamt(double amt) {
        revenue=revenue+(amt);



    }

    public void subtractamt(double amt) {
        revenue=revenue-(amt);



    }



    public double getrevenue() {

        return revenue;

    }

}