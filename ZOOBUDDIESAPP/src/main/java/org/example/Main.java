package org.example;


import java.util.Scanner;
import java.util.List;
import java.util.Random;

interface useractions {
    void Feedback(zoo zoo);

    void viewattractions(zoo zoo);

}

class TypeMammal extends Animal{
    public TypeMammal(String name,String description, String sound) {
        super(name, "Mammal", description, sound);
    }

}

class TypeAmphibian extends Animal{
    public TypeAmphibian(String name,String description, String sound) {
        super(name, "Amphibian", description, sound);
    }


}

class TypeReptile extends Animal{
    public TypeReptile(String name,String description, String sound) {
        super(name, "Reptile", description, sound);
    }


}




public class Main {
    // double revenue=0.0;

    public static void main(String[] args) {
        revenue revenue=new revenue(0.0);
        Scanner scanner = new Scanner(System.in);
        zoo zoo = new zoo();

        Animal animal=new TypeMammal("lion","carnivore majestic animal","roar");//polymorphism


        zoo.getAnimals().add(animal);

        Animal animal2=new TypeMammal("deer","herbivore animal","bellowing");//polymorphism

        // void addAnimal(animal("lion","","",""));
        zoo.getAnimals().add(animal2);


        // Create an instance of the Zoo class
        // double revenue=0.0;

        while (true) {
            System.out.println("Welcome to ZOOtopia!");
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as Visitor");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Admin admin = new Admin(); // Create an instance of the Admin class
                    adminActions(zoo, revenue);
                    break;
                case "2":
                    visitorActions(zoo, scanner, revenue);
                    break;
                case "3":
                    System.out.println("Exiting the application.");
                    scanner.close(); // Close the Scanner before exiting
                    return;
                // default:
                //     System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void manageAnimals(zoo zoo, Scanner scanner) {
        while (true) {
            System.out.println("Manage Animals:");
            System.out.println("1. Add Animal");
            System.out.println("2. Update Animal Details");
            System.out.println("3. Remove Animal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String adminAnimalChoice = scanner.nextLine();

            switch (adminAnimalChoice) {
                case "1":
                    // zoo.viewAnimals();
                    // Add Animal
                    System.out.print("Enter Animal Name to add  : ");
                    String animalName = scanner.nextLine();

                    System.out.print("Enter Animal Type (Mammal, Amphibian, or Reptile): ");
                    String animalType = scanner.nextLine();

                    System.out.println("Enter Animal details:");
                    String animalDetails = scanner.nextLine();

                    System.out.println("Enter Animal sound:");
                    String animalSound = scanner.nextLine();

                    addAnimal(animalType,zoo ,animalName,animalDetails,animalSound);

                    // if (isValidAnimalType(animalType)) {
                    //     // Ensure that there are at least 2 kinds of animals for each type
                    //     if (zoo.countAnimalsByType(animalType) < 2) {
                    //         System.out.println(
                    //                 "There are less than 2 animals of the type " + animalType + " in the zoo.");
                    //                 System.out.println("Adding animal to the zoo.");
                    //                 Animal newAnimal = new Animal(animalName, animalType, animalDetails, animalSound);
                    //                 zoo.addAnimal(newAnimal);
                    //                 System.out.println("Animal added to the zoo.");

                    //     } else {
                    //         Animal newAnimal = new Animal(animalName, animalType, animalDetails, animalSound);
                    //         zoo.addAnimal(newAnimal);
                    //         System.out.println("Animal added to the zoo.");
                    //     }
                    // } else {
                    //     System.out.println("Invalid animal type. Please choose from Mammal, Amphibian, or Reptile.");
                    // }
                    break;

                case "2":
                    // Update Animal Details
                    System.out.print("Enter the name of the animal you want to update: ");
                    String animalToUpdate = scanner.nextLine();
                    // zoo.viewAnimals();

                    for (Animal existingAnimal : zoo.getAnimals()) {
                        if (existingAnimal.getName().equals(animalToUpdate)) {
                            System.out.print("Do you want to update animal detscription (yes/no)? ");
                            String updateDetailsChoice = scanner.nextLine().toLowerCase();

                            if (updateDetailsChoice.equals("yes")) {
                                // Update the animal's description
                                System.out.print("Enter the new description of the animal: ");
                                String newAnimalDescription = scanner.nextLine();
                                existingAnimal.setDescription(newAnimalDescription);

                                System.out.print("Do you want to update the animal's sound (yes/no)? ");
                                String updateSoundChoice = scanner.nextLine().toLowerCase();

                                if (updateSoundChoice.equals("yes")) {
                                    // Update the animal's sound
                                    System.out.print("Enter the new sound of the animal: ");
                                    String newAnimalSound = scanner.nextLine();
                                    existingAnimal.setSound(newAnimalSound);

                                    System.out.println("Animal description and sound updated successfully.");
                                } else {
                                    System.out.println(
                                            "Animal description updated successfully, but sound remains unchanged.");
                                }
                            } else {
                                System.out.println("Animal details were  not updated.");
                            }
                        }
                    }
                    break;

                case "3":
                    System.out.println("these are the animals-");
                    zoo.viewAnimals();
                    // Remove Animal
                    System.out.print("Enter the name of the animal to remove: ");
                    String animalToRemove = scanner.nextLine();
                    boolean found = false;

                    for (Animal animal : zoo.getAnimals()) {
                        if (animal.getName().equals(animalToRemove)) {


                            if (zoo.countAnimalsByType(animal.getType()) > 2) {
                                zoo.removeAnimal(animal);
                                System.out.println("Animal removed from the zoo.");
                            } else {
                                System.out.println(
                                        "Animal cannot be removed since then animals of this type will be less than the required amount.");
                            }
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Animal not found in the zoo.");
                    }
                    break;

                case "4":
                    return; // Exit the "Manage Animals" menu
            }
        }
    }


    public static void addAnimal(String animalType,zoo zoo,String animalName,String animalDetails,String animalSound){
        if (animalType.equalsIgnoreCase("Mammal") || animalType.equalsIgnoreCase("Amphibian") || animalType.equalsIgnoreCase("Reptile")){


            if (zoo.countAnimalsByType(animalType) < 2) {
                System.out.println("There are less than 2 animals of the type " + animalType + " in the zoo.");
                System.out.println("Adding the animal to the zoo.");
                if (animalType.equalsIgnoreCase("mammal")){
                    Animal newAnimal = new TypeMammal(animalName, animalDetails, animalSound);//POLYMORPHISM
                    zoo.addAnimal(newAnimal);
                    System.out.println("Animal has been added to the zoo.\n");

                } else if (animalType.equals("amphibian")) {
                    Animal newAnimal = new TypeAmphibian(animalName, animalDetails, animalSound);
                    zoo.addAnimal(newAnimal);
                    System.out.println("Animal has been added to the zoo.\n");
                } else if (animalType.equals("reptile")) {

                    Animal newAnimal = new TypeReptile(animalName, animalDetails, animalSound);
                    zoo.addAnimal(newAnimal);
                    System.out.println("Animal has been added to the zoo.\n");
                }


            } else {
                Animal newAnimal = new Animal(animalName, animalType, animalDetails, animalSound);
                zoo.addAnimal(newAnimal);
                System.out.println("Animal has been added to the zoo.\n");
            }
        } else {
            System.out.println("Invalid animal type.choose from Mammal, Amphibian, or Reptile.\n");
        }
    }





    public static void setSpecialDeals(zoo zoo, Scanner scanner) {
        while (true) {
            System.out.println("Set Special Deals Menu:");
            System.out.println("1. Add Special Deal");
            System.out.println("2. Remove Special Deal");
            System.out.println("3. View Special Deals");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String dealChoice = scanner.nextLine();

            switch (dealChoice) {
                //special deal to be applies for this exact no. of attractions )
                case "1":
                    System.out.print("Enter the number of attractions for the special deal: ");
                    int noOfAttractions = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the discount percentage for eg( 20 for 20%): ");
                    int discountPercentage = scanner.nextInt();
                    scanner.nextLine();//
                    SpecialDeal specialDeal = new SpecialDeal(noOfAttractions, discountPercentage);
                    zoo.addDeal(specialDeal);
                    System.out.println("Special Deal has been added successfully.");
                    break;

                case "2":
                    zoo.viewSpecialDeals();
                    System.out.print("Enter the number of attractions to remove: ");
                    int attractionsToRemove = scanner.nextInt();
                    SpecialDeal deal = zoo.findDealByNoOfAttractions(attractionsToRemove);
                    if (deal != null) {
                        zoo.removeDeal(deal);
                        System.out.println("Special Deal has been  removed successfully.");
                    } else {
                        System.out.println("No such special deal with the given number of attractions.");
                    }
                    break;

                case "3":
                    zoo.viewSpecialDeals();
                    break;

                case "4":
                    return;


                default:
                    System.out.println("enter a valid choice");

            }
        }
    }



    public static boolean isValidAnimalType(String animalType) {
        // Check if the provided animal type is valid (Mammal, Amphibian, or Reptile)
        return animalType.equalsIgnoreCase("Mammal") || animalType.equalsIgnoreCase("Amphibian") || animalType.equalsIgnoreCase("Reptile");



    }

    public static void manageAttractions(Admin admin, zoo zoo, Scanner scanner) {
        while (true) {
            System.out.println("Manage Attractions:");
            System.out.println("1. Add Attraction");
            System.out.println("2. View Attractions");
            System.out.println("3. Modify Attraction");
            System.out.println("4. Remove Attraction");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // ADD ATTRACTION
                    Random rand = new Random();
                    int id = rand.nextInt(1000);

                    System.out.print("Enter attraction type/name: ");
                    String type = scanner.nextLine();

                    System.out.println("Enter attraction description: ");
                    String description = scanner.nextLine();

                    System.out.println("Enter ticket price for basic members");
                    double ticketBasicPrice = scanner.nextDouble();
                    scanner.nextLine();// to Consume the newline character

                    attraction newAttraction = new attraction(id, type, description, ticketBasicPrice);

                    admin.addAttraction(newAttraction, zoo);

                    System.out.println("New attraction added!");
                    break;

                case "2":
                    // VIEW ATTRACTIONS
                    System.out.println("Attractions:\n");
                    zoo.viewAttractions();
                    break;

                case "3":
                    // MODIFY ATTRACTION
                    zoo.viewAttractions();
                    System.out.print("Enter the 'ID' of the attraction to be modified: ");
                    int id3 = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    attraction foundAttraction = null;

                    for (attraction attraction : zoo.getAttractions()) {
                        if (attraction.getId() == id3) {
                            foundAttraction = attraction;
                            break;
                        }
                    }

                    if (foundAttraction != null) {
                        System.out.println("Enter the new name for the attraction: ");
                        String newName = scanner.nextLine();

                        System.out.println("Enter the new description for the attraction: ");
                        String newDescription = scanner.nextLine();

                        System.out.println("Enter the new ticket basic price for the attraction: ");
                        double newTicketBasicPrice = scanner.nextDouble();

                        // Modify the foundAttraction with the new values
                        foundAttraction.setType(newName);
                        foundAttraction.setDescription(newDescription);
                        foundAttraction.setTicketPrice(newTicketBasicPrice);

                        System.out.println("Attraction has been modified successfully.");
                    } else {
                        System.out.println("Attraction with ID " + id3 + " was  not found.");
                    }
                    break;

                case "4":
                    zoo.viewAttractions();
                    System.out.println("Enter id of attraction to be removed");
                    int id2 = scanner.nextInt();

                    // Try to remove the attraction with the given ID
                    boolean attractionRemoved = zoo.getAttractions().removeIf(attraction -> attraction.getId() == id2);

                    if (attractionRemoved) {
                        System.out.println("Attraction removed successfully");
                    } else {
                        System.out.println("Wrong ID. No attraction with the specified ID found.");
                    }
                    break;


                case "5":
                    System.out.println("Exiting the attraction management.");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void scheduleEvents(zoo zoo) {
        while (true) {
            System.out.println("----Schedule Events:-----");
            System.out.println("1. Set Open/Close Status for Attractions");
            System.out.println("2. Set Ticket Price for Attractions");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // SET OPEN/CLOSE STATUS FOR ATTRACTIONS
                    zoo.viewAttractions();

                    System.out.print("Choose attraction 'ID' to open or close: ");
                    int Id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    attraction selectedAttraction = null;

                    for (attraction attraction : zoo.getAttractions()) {
                        if (attraction.getId() ==Id) {
                            selectedAttraction = attraction;
                            break;
                        }
                    }

                    if (selectedAttraction != null) {
                        System.out.print("Set the open/close status (true/false): ");
                        boolean setOpen = scanner.nextBoolean();
                        selectedAttraction.setOpen(setOpen);
                        System.out.println("Attraction set to " + setOpen);
                    } else {
                        System.out.println("Wrong attraction ID.");
                    }
                    break;

                case "2":
                    // SET TICKET PRICE FOR ATTRACTIONS
                    zoo.viewAttractions();

                    System.out.print("Choose attraction ID to set the ticket price: ");
                    int attractionId2 = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    attraction selectedAttraction2 = null;

                    for (attraction attraction : zoo.getAttractions()) {
                        if (attraction.getId() == attractionId2) {
                            selectedAttraction2 = attraction;
                            break;
                        }
                    }

                    if (selectedAttraction2 != null) {
                        System.out.print("Enter the new ticket price for the attraction: ");
                        double newTicketPrice = scanner.nextDouble();
                        selectedAttraction2.setTicketPrice(newTicketPrice);
                        System.out.println("Attraction " + selectedAttraction2.getType() + " ticket price is set to " + newTicketPrice);
                    } else {
                        System.out.println("Wrong attraction ID.");
                    }
                    break;

                case "3":
                    System.out.println("Exiting event scheduling.");
                    // scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void setTicketPrice(attraction selectedAttraction) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the new ticket price for the attraction: ");
        double newTicketPrice = scanner.nextDouble();
        selectedAttraction.setTicketPrice(newTicketPrice);
        System.out.println("Attraction " + selectedAttraction.getType() + " ticket price is set to " + newTicketPrice);
    }






    public static void adminActions(zoo zoo,revenue revenue) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Admin Username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String adminPassword = scanner.nextLine();

        Admin admin = new Admin(adminUsername, adminPassword); // Create an instance of the Admin class

        // Check if the provided username and password match the predefined admin credentials
        if (adminUsername.equals("admin") && adminPassword.equals("admin123")) {
            while (true) {
                System.out.println("Admin Menu:");
                System.out.println("1. Manage Attractions/Events");
                System.out.println("2. Manage Animals");
                System.out.println("3. Schedule Events");
                System.out.println("4. Set Discounts");
                System.out.println("5. Set Special Deals");
                System.out.println("6. View Visitor Stats");
                System.out.println("7. View Feedback");
                System.out.println("8. Back");
                System.out.print("Enter your choice: ");

                String adminChoice = scanner.nextLine();

                switch (adminChoice) {
                    case "1":
                        manageAttractions( admin,zoo,scanner);
                        break;



                    case "2":
                        manageAnimals(zoo, scanner);
                        break;

                    case "3":
                        scheduleEvents(zoo);
                        break;


                    case "4":
                        setDiscounts(zoo, scanner);
                        break;

                    case "5":
                        setSpecialDeals(zoo, scanner);

                        break;

                    case "6":
                        calculateVisitorStatistics(zoo, revenue);


                        break;

                    case "7":
                        admin.Feedback(zoo);
                        break;

                    case "8":

                        return; // Going  back to the main menu
                }
            }
        }
    }



    public static void calculateVisitorStatistics(zoo zoo,revenue revenue) {
        // Total Visitors
        int totalVisitors = zoo.getVisitors().size();
        System.out.println("Total Visitors: " + totalVisitors);



        System.out.println("total revenue (rss): " + revenue.revenue);


        int maxVisitor = 0;
        attraction mostPopularAttraction = null;
        for (attraction attraction : zoo.getAttractions()) {
            if (attraction.getCountOfVisitors() > maxVisitor) {
                maxVisitor = attraction.getCountOfVisitors();
                mostPopularAttraction = attraction;
            }
        }

        if (mostPopularAttraction != null) {
            System.out.println("Most Popular Attraction: " + mostPopularAttraction.getType()+"\n");
        } else {
            System.out.println("No attraction has been visited yet.\n");
        }
    }




    public static void setDiscounts(zoo zoo, Scanner scanner) {
        while (true) {
            System.out.println("Set Discounts Menu:");
            System.out.println("1. Add Discount");
            System.out.println("2. Modify Discount");
            System.out.println("3. Remove Discount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String discountChoice = scanner.nextLine();

            switch (discountChoice) {
                case "1":
                    System.out.print("Enter Discount Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                    double percentage = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    zoo.addDiscount(new Discount(category, percentage));
                    System.out.println("Discount added successfully.");
                    break;

                case "2":
                    System.out.print("Enter Discount Category to modify: ");
                    String categoryToModify = scanner.nextLine();
                    System.out.print("Enter New Discount Percentage: ");
                    double newDiscountPercentage = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    zoo.modifyDiscount(categoryToModify, newDiscountPercentage);
                    break;

                case "3":
                    zoo.viewDiscounts();
                    System.out.print("Enter Discount Category to remove: ");
                    String categoryToRemove = scanner.nextLine();
                    Discount d = zoo.findDiscountByCategory(categoryToRemove);
                    if (d != null) {
                        zoo.removeDiscount(d);
                        System.out.println("Discount removed successfully.");
                    } else {
                        System.out.println("No such discount category.");
                    }
                    break;

                case "4":
                    // scanner.close();
                    return;
            }
        }
    }

    public static Visitor registerVisitor(zoo zoo) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter your balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Create a password: ");
        String password = scanner.nextLine();

        Visitor visitor = new Visitor(name, age, phoneNumber, balance, email, password);
        zoo.addVisitor(visitor);

        System.out.println("Visitor registration successful!");
        return visitor;
    }



    public static Visitor loginVisitor(zoo zoo, Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Visitor visitor = null;  // Initialize the visitor to null

        for (Visitor vis : zoo.getVisitors()) {
            if (vis.getEmail().equals(email) && vis.getPassword().equals(password)) {
                visitor = vis;  // Assign the visitor when found
                break;  // Break the loop after finding the correct visitor
            }
        }

        if (visitor != null) {
            System.out.println("Login was  successful!");
            return visitor;
        } else {
            System.out.println("Login failed. Invalid email or password.");
            return null;
        }
    }

    public static void exploreZoo(zoo zoo, Scanner scanner) {
        // boolean exploring = true;

        while (true) {
            System.out.println("Explore the Zoo:");
            System.out.println("1. View Attractions");
            System.out.println("2. View Animals");
            System.out.println("3. Exit");

            System.out.print("Enter your choice:(1,2, or 3) ");
            String choice = scanner.nextLine();
//            scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("attractions to view: ");
                    zoo.viewAttractions();
                    for(int i=0; i< zoo.getAttractions().size(); i++) {
                        System.out.println(i+1 + ".  " + zoo.getAttractions().get(i).getType());


                    }

                    System.out.println("enter your choice no.to view (eg 1,2,3)");

                    int choice2 = scanner.nextInt();

                    if(choice2==zoo.getAttractions().size()+1) {

                        return;

                    }
                    else if (choice2 < 1 || choice2 > zoo.getAttractions().size()) {
                        System.out.println("Invalid choice. Please select a valid attraction.");
                        return;
                    }

                    else if (choice2 > 0 && choice2 <= zoo.getAttractions().size()) {
                        // View the selected attraction's description
                        attraction selectedAttraction = zoo.getAttractions().get(choice2 - 1);
                        System.out.println("Description of " + selectedAttraction.getType() + ":");
                        System.out.println(selectedAttraction.getDescription());
                    }

                    else if(choice2==zoo.getAttractions().size()+1) {

                        return;

                    }
                    break;


                case "2":
                    System.out.println("Exploring the animals:");

                    zoo.viewAnimals();
                    break;

                case "3":
                    System.out.println("Exiting the exploration.");

                    return;


                default:
                    System.out.println("invalid input");
                    // break;

            }
        }
    }




    public static void buyMembership(zoo zoo, Scanner scanner, Visitor visitor,revenue revenue) {
        System.out.println("Select the type of membership you would like to purchase:");
        System.out.println("1. Basic Membership (Rs 20.00)");
        System.out.println("2. Premium Membership (Rs 50.00)");

        System.out.print("Enter your choice(ie 1 or 2): ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                if (visitor.getBalance() < 20.00) {
                    System.out.println("Insufficient balance, cannot buy membership.");
                    break;
                }
                boolean applyMoreDiscount = true;
                visitor.purchaseMembership("Basic");
                System.out.println("your purchase was successful.");
                visitor.setBalance(visitor.getBalance() - 20.00);
                revenue.addamt(20.00);

                while (applyMoreDiscount) {

                    //  revenue.addamt(20.00);

                    //what we can do is that we first automatically reduce the amount by 20 and then keep on adding the discounted amount to it until it is a no and set balance each time and in the end return the balance
                    System.out.println("Apply discount code (enter your category or 'no' to stop): ");
                    String category = scanner.nextLine();

                    if (category.equalsIgnoreCase("no")) {

                        System.out.println(" Your balance is now " + visitor.getBalance());
                        applyMoreDiscount=false;
                        break;
                    }

                    Discount discount = zoo.findDiscountByCategory(category);

                    if (discount != null) {
                        double discountPercentage = discount.getPercentage() / 100.0;
                        double discountAmount = 20.00 * discountPercentage;
                        // revenue-=discountAmount;
                        revenue.subtractamt(discountAmount);
                        visitor.setBalance(visitor.getBalance() + discountAmount);
                        System.out.println("  Discount applied: Your balance is now " + visitor.getBalance());
                    } else {
                        System.out.println("Invalid discount code. ");

                        // System.out.println("");
                    }
                }
                break;
            // visitor.setBalance(visitor.getBalance() - 20.00);
            // System.out.println("Membership purchase successful. Your balance is now " + (visitor.getBalance()));
            // break;

            case "2":
                if (visitor.getBalance() < 50.00) {
                    System.out.println("Insufficient balance, cannot buy premium membership.");
                    break;
                }

                visitor.purchaseMembership("Premium");
                boolean applyDiscount = true;
                // visitor.purchaseMembership("Basic");
                System.out.println("your purchase was successful.");

                while (applyDiscount) {
                    visitor.setBalance(visitor.getBalance() - 50.00);
                    revenue.addamt(50.00);

                    //what we can do is that we first automatically reduce the amount by 20 and then keep on adding the discounted amount to it until it is a no and set balance each time and in the end return the balance
                    System.out.println("Apply discount code (enter your category or 'no' to stop): ");
                    String category = scanner.nextLine();

                    if (category.equalsIgnoreCase("no")) {

                        System.out.println(" Your balance is now " + visitor.getBalance());
                        applyDiscount=false;
                        break;
                    }

                    Discount discount = zoo.findDiscountByCategory(category);

                    if (discount != null) {
                        double discountPercentage = discount.getPercentage() / 100.0;
                        double discountAmount = 50.00 * discountPercentage;
                        // revenue-=discountAmount;
                        revenue.subtractamt(discountAmount);
                        visitor.setBalance(visitor.getBalance() + discountAmount);
                        System.out.println("  Discount applied: Your balance is now " + visitor.getBalance());
                    } else {
                        System.out.println("Invalid discount code. ");

                        // System.out.println("");
                    }
                }
                break;




        }
    }





    public static void buyTickets(Visitor visitor, zoo zoo, Scanner scanner,revenue revenue) {
        if (visitor.getMembership().equalsIgnoreCase("premium")){
            System.out.println("you are a premium member no need to buy tickets.\n");
            return;

        }

        System.out.println("Buy Tickets:");


        System.out.println("Enter the no. of tickets:");
        int nooftickets=scanner.nextInt();


        System.out.println("Select an Attraction to Buy a Ticket for :");
        List<attraction> attractions = zoo.getAttractions();

        for (int i = 0; i < attractions.size(); i++) {
            attraction attraction = attractions.get(i);
            System.out.println((i + 1) + ". " + attraction.getType() + "  Rs" + attraction.getTicketPrice() );
        }

        System.out.print("Enter your choice:(for eg 1,2...) ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        double price = 0;
        String attractionName = null;

        if (choice >= 1 && choice <= attractions.size()) {
            attraction selectedAttraction = attractions.get(choice - 1);
            price = selectedAttraction.getTicketPrice()*nooftickets;
            double discount=0.0;

            double d=zoo.getSpecialDealDiscountPercentage(nooftickets);

            for(SpecialDeal sd: zoo.getSpecialDeals()){
                if (sd.noOfattractions==nooftickets) {
                    discount=sd.getDiscount();
                    price=price-price*discount/100;
                    break;
                }

            }




            attractionName = selectedAttraction.getType();
        } else {
            System.out.println("Invalid choice. Please select a valid attraction.");
            return;
        }

        if (visitor.getBalance() < price) {
            System.out.println("Insufficient balance, cannot buy the ticket.");
        } else {
            // Deduct the ticket price from the visitor's balance
            double newBalance=visitor.getBalance() - price;
            visitor.setBalance(newBalance);


            //adding to the revenue
            revenue.addamt(price);






            // Increase the count of visitors for the selected attraction
            attraction selectedAttraction = attractions.get(choice - 1);
            selectedAttraction.setCountOfVisitors(selectedAttraction.getCountOfVisitors() + 1);

            // Store the purchased ticket in the visitor's list of tickets
            Ticket ticket=new Ticket(nooftickets,attractionName, price);
            ticket.setNooftickets(nooftickets);
            visitor.addTicket(ticket);

            System.out.println("The ticket for the  " + attractionName + " attraction has been  purchased successfully \n. Your balance is now Rs" + visitor.getBalance());
        }
    }


    public static void VisitAnimal(zoo zoo,Scanner scanner){

        while (true) {
            System.out.println("-----Visit Animals:------");
            System.out.println("Select an Animal to Visit:");
            System.out.println("or write 'exit' to exit form the visitanimal function\n");
            // System.out.println("2.exit");
            for (Animal animal : zoo.getAnimals()) {
                System.out.println(animal.getName());
            }

            System.out.print("Enter your choice : (name of the animal to visit eg deer,lion etc) or (exit)\n");
            String animaltosearch=scanner.nextLine();
            if (animaltosearch.equalsIgnoreCase("exit")) {
                return; // Exiting the visit animals menu
            }

            boolean found=false;



            for (Animal animal : zoo.getAnimals()) {
                if (animal.getName().equalsIgnoreCase(animaltosearch)) {
                    found = true;
                    System.out.println("Animal found!");
                    System.out.println("You selected the animal:" + animal.getName() + ".");
                    System.out.println("What would you like to do?");
                    System.out.println("1. Feed the animal: " + animal.getName());
                    System.out.println("2. Read about the animal:" + animal.getName());
                    System.out.println("enter your choic:(1 or 2)");
                    int choice = scanner.nextInt();
                    if (choice ==1){
                        System.out.println("you are feeding the " + animal.getName());
                        System.out.println("makes sound"+animal.getSound());
                    }
                    else if(choice ==2){
                        System.out.println("you are reading about the animal : " + animal.getName());
                        System.out.println("information about the animal : " + animal.getDescription());

                    }


                    else{
                        System.out.println("invalid choice");
                    }


                }
                if (found == false){
                    System.out.println("Animal not found");
                }
            }
        }


    }




    public static void visitAttractions(Visitor visitor, zoo zoo, Scanner scanner) {
        while (true) {
            System.out.println("------Visit Attractions:-------");
            System.out.println("Select an Attraction to Visit:");

            // List<Attraction> attractions = zoo.getAttractions();
            for (int i = 0; i < zoo.getAttractions().size(); i++) {
                attraction attraction = zoo.getAttractions().get(i);
                System.out.println((i + 1) + ". " + attraction.getType());
            }

            System.out.println(zoo.getAttractions().size() + 1 + ". Exit");
            System.out.print("Enter your choice(eg 1,2...): ");
            int choice = scanner.nextInt();

            if (choice == zoo.getAttractions().size() + 1) {
                // Exit the attraction visit menu and go back to the visitor menu
                return;
            } else if (choice < 1 || choice > zoo.getAttractions().size()) {
                System.out.println("Invalid choice. Please select a valid attraction.");
                continue;
            }

            attraction selectedAttraction = zoo.getAttractions().get(choice - 1);

            // Check if the visitor's membership is "premium" or if they have a ticket for
            // the attraction
            // if (visitor.getMembership().equalsIgnoreCase("premium")){
            //     System.out.println("You are a premium member. You can visit this attraction.");
            //     System.out.println("thank you for visiting this attraction."+selectedAttraction.getType()+"hope you enjoyed the attraction.");
            //     attraction.setCountOfVisitors(attraction.getCountOfVisitors()+1);
            // }
            // visitAttractionPremium(selectedAttraction,visitor);

            if (visitor.getMembership().equals("")) {
                System.out.println("purchase membership first");

            }
            if (visitor.getMembership().equalsIgnoreCase("premium")) {
                visitAttractionPremium(selectedAttraction,visitor);
            }

            if (visitor.getMembership().equalsIgnoreCase("basic")) {
                visitAttractionBasic(selectedAttraction, visitor);

            }




        }
    }

    public static void visitAttractionBasic(attraction attraction,Visitor visitor) {
        if (visitor.hasTicketForAttraction(attraction.getType())) {
            // Deduct one ticket from the visitor's ticket list if not "premium"
            visitor.removeTicket(attraction.getType());
            attraction.setCountOfVisitors(attraction.getCountOfVisitors() + 1);
            System.out.println("1 Ticket Used.");
            System.out.println("Thank you for visiting " + attraction.getType()
                    + ". Hope you enjoyed the attraction.");

        } else {
            System.out.println("You are a basic member and you do not have a ticket for this attraction.");
        }
    }


    public static void visitAttractionPremium(attraction attraction,Visitor visitor) {

        System.out.println("You are a premium member. You can visit this attraction.");
        System.out.println("Thank you for visiting this attraction: " + attraction.getType() + ". Hope you enjoyed the attraction.");
        attraction.setCountOfVisitors(attraction.getCountOfVisitors() + 1);

    }







    public static void visitorActions(zoo zoo, Scanner scanner,revenue revenue) {
        Visitor visitor = new Visitor();

        while(true) {
            System.out.println("1. Register");
            System.out.println("2. Log In");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                visitor = registerVisitor(zoo);
                // break;
            } else if (choice.equals("2")) {
                visitor = loginVisitor(zoo, scanner);
                if (visitor != null) {
                    break;
                } else {
                    System.out.println("Invalid choice");
//                break;
                }
            }
        }
        while (true) {
            System.out.println("Visitor Actions:");
            System.out.println("1. Explore the Zoo");
            System.out.println("2. Buy Membership");
            System.out.println("3. Buy Tickets");
            System.out.println("4. View Discounts");
            System.out.println("5. View Special Deals");
            System.out.println("6. Visit Animal");
            System.out.println("7. Visit Attractions/Events");
            System.out.println("8. Provide Feedback");
            System.out.println("9.log out\n");
            System.out.print("Enter your choice: ");

            String visitorChoice = scanner.nextLine();

            switch (visitorChoice) {
                case "1":
                    exploreZoo(zoo, scanner);

                    break;
                case "2":
                    buyMembership(zoo, scanner, visitor, revenue);

                    break;
                case "3":
                    buyTickets(visitor, zoo, scanner,revenue);

                    break;
                case "4":
                    zoo.viewDiscounts();

                    break;
                case "5":
                    zoo.viewSpecialDeals();

                    break;
                case "6":
                    VisitAnimal(zoo, scanner);

                    break;
                case "7":
                    visitAttractions(visitor, zoo, scanner);

                    break;
                case "8":
                    zoo.provideFeedback();
                    break;


                case "9":
                    System.out.println("logged out\n");
                    return;



            }
        }
    }
}







