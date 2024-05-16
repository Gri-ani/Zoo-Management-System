package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Objects;



// interface for managing attractions
interface AttractionManager {
    void addAttraction(attraction attraction);
    void viewAttractions();
    void removeAttraction(attraction attraction);
}

//interface for managing animals
interface AnimalManager {
    void addAnimal(Animal animal);

    void removeAnimal(Animal animal);

}

//abstract class remove
abstract class remove{
    abstract void removeAttraction(attraction attraction);
    abstract void removeAnimal(Animal animal);

    abstract void removeDeal(SpecialDeal specialdeal);
    abstract void removeDiscount(Discount discount);
    // void remove
}
//abstract class view which extends abstract class remove
abstract class view extends remove{
    abstract void viewAnimals();
    abstract void viewAttractions();
    abstract void viewDiscounts();
    abstract void viewFeedback();
    abstract void viewSpecialDeals();

}

// abstract class remo


//  THIS IS THE ZOO CLASS IT CONTAINS A LIST OF ANIMALS, ATTRACTIONS,VISITORS,DISCOUNTS,SPECIALDEALS AND FEEDBACK AND CONTAINS METHODS TO MODIFY,ADD,REMOVE ELEMENTS IN THESE.
public class zoo  extends view implements AttractionManager,AnimalManager{
    private List<Animal> animals;
    private List<attraction> attractions;
    private List<Visitor> visitors;
    private List<Discount> discounts;
    private List<SpecialDeal> specialDeals;
    private static List<Feedback> feedbackList = new ArrayList<>();
    // private static List<Visitor> visitors = new ArrayList<>();


    public zoo() {
        animals = new ArrayList<>();
        attractions = new ArrayList<>();
        visitors = new ArrayList<>();
        discounts = new ArrayList<>();
        specialDeals = new ArrayList<>();
    }


    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addAnimalMammal(TypeMammal animal){
        animals.add(animal);//polymorphism
    }

    public void addAnimalReptile(TypeReptile animal){
        animals.add(animal);//polymorphism
    }

    public void addAnimalAmphibian(TypeAmphibian animal){
        animals.add(animal);//polymorphism
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public  void viewAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals to display.");
        } else {
            System.out.println(" Animals:");
            for (Animal animal : animals) {
                System.out.println(animal); // Automatically calls toString method
                System.out.println();
            }
        }
    }


    public void modifyDescription(Animal animal, String details) {
        animal.setDescription(details);
    }

    public List<attraction> getAttractions() {
        return attractions;
    }

    public void viewAttractions() {
        for (attraction attraction : getAttractions()) {
            System.out.println("Name of attraction: " + attraction.getType());
            System.out.println("ID: " + attraction.getId() );
            System.out.println("Attraction description: " +attraction.getDescription()+"\n");
        }
    }


    public void exploreAttractions() {
        for (attraction attraction : attractions) {
            System.out.println("Exploring Attraction:");
            System.out.println(attraction);
            System.out.println(); // Add a newline for separation
        }
    }

    // public void removeAttraction(attraction attraction) {
    //     attractions.remove(attraction);
    // }

    public void setAttractions(List<attraction> attractions) {
        this.attractions = attractions;
    }

    public void addAttraction(attraction attraction) {
        attractions.add(attraction);
    }

    public void modifyAttraction(attraction attraction) {
        // Code to modify existing attraction
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public int countAnimalsByType(String type) {
        int count = 0;
        for (Animal animal : animals) {
            if (animal.getType().equalsIgnoreCase(type)) {
                count++;
            }
        }
        return count;
    }

    public Discount findDiscountByCategory(String category) {
        for (Discount discount : discounts) {
            if (discount.getCategory().equalsIgnoreCase(category)) {
                return discount;
            }
        }
        return null;
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    @Override
    public void removeDiscount(Discount discount) {
        discounts.remove(discount);
    }


    public void modifyDiscount(String category, double newDiscountPercentage) {
        for (Discount discount : discounts) {
            if (discount.getCategory().equalsIgnoreCase(category)) {
                discount.setPercentage(newDiscountPercentage);
                System.out.println("discount modified successfully");
                break;
            }
        }
        System.out.println("discount not found");
    }

    public void viewDiscounts() {
        for (Discount discount : discounts) {
            System.out.println( "Category is "+discount.getCategory()+" and percentage is "+discount.getPercentage()+"-"+discount.getCategory());
        }
    }

    public double getDiscountpercentage(String category) {
        for (Discount discount : discounts) {
            if (discount.getCategory().equalsIgnoreCase(category)) {
                return discount.getPercentage();
            }
        }
        return 0.0; // Return 0 if discount not found
    }

    public List<Discount> getdiscounts(){
        return discounts;
    }

    //method to find deal by no. of attractions
    public SpecialDeal findDealByNoOfAttractions(int noOfattractions) {
        for (SpecialDeal sd : specialDeals) {
            if (sd.getNoOfattractions() == noOfattractions) {
                return sd;
            }
        }
        return null;
    }


    public void addDeal(SpecialDeal sd) {
        specialDeals.add(sd);
    }
    @Override
    public void removeDeal(SpecialDeal deal) {
        specialDeals.remove(deal);
    }
    //method to get discount percentage if noof attractions is given
    public double getSpecialDealDiscountPercentage(int noOfAttractions) {
        SpecialDeal sd = findDealByNoOfAttractions(noOfAttractions);
        if (sd != null) {
            return sd.getDiscount();
        }
        return 0.0;
    }

    public List<SpecialDeal> getSpecialDeals() {
        return specialDeals;
    }

    public void viewSpecialDeals() {
        for (SpecialDeal sd : specialDeals) {
            System.out.println("Number of Attractions: " + sd.getNoOfattractions() + " - Discount Percentage: " + sd.getDiscount() + "%");
        }
    }



    public void provideFeedback(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter your name:");
        String name=scanner.next();
        System.out.println("Enter your feedback");
        String feedback = scanner.next();
        Feedback feedback1 = new Feedback(name,feedback);
        feedbackList.add(feedback1);
        System.out.println("thankyou for ur feedback\n");

    }

    public void viewFeedback() {
        System.out.println("Visitor Feedback:");
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback is available.\n");
        } else {
            for (Feedback feedback : feedbackList) {
                System.out.println("Visitor name : " + feedback.getVisitorName());
                System.out.println("Feedback: " + feedback.getContent());
                System.out.println();
            }
        }
    }
    @Override
    public void removeAttraction(attraction attraction) {
        attractions.remove(attraction);
    }





}


