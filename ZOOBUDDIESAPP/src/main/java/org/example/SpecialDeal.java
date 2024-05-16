package org.example;

public class SpecialDeal {
    int noOfattractions;
    double discount;



    public SpecialDeal(int noOfattractions, int discount){
        this.noOfattractions = noOfattractions;
        this.discount = discount;
    }

    public int getNoOfattractions() {
        return noOfattractions;
    }

    public double getDiscount() {
        return discount;
    }

    public void setNoOfattractions(int noOfattractions) {
        this.noOfattractions = noOfattractions;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }



}