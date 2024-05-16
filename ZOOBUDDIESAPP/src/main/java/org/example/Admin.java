package org.example;

// import org.w3c.dom.events.Event;

import java.util.ArrayList;
import java.util.List;

public class Admin implements useractions{
    private final String username;
    private final String password;
    // private static List<Feedback> feedbackList = new ArrayList<>();

    public Admin(String username, String adminPassword) {
        this.username = username;
        this.password = adminPassword;
    }


    public String getUsername() {
        return this.username;
    }


    public String getPassword() {
        return this.password;
    }

    public void addAttraction(attraction attraction, zoo zoo) {
        zoo.getAttractions().add(attraction);
    }

    public void removeAttraction(attraction attraction, zoo zoo) {
        zoo.getAttractions().remove(attraction);
    }


    //method to open a attraction (used to schedule events)
    public void openAttraction(attraction attraction) {

        attraction.setOpen(true);

    }


    //method to close a attraction (used to schedule events)
    public void closeAttraction(attraction attraction) {
        attraction.setOpen(false);
    }

    public void setTicketPrice(attraction attraction, double price) {
        attraction.setTicketPrice(price);
    }
    @Override
    public void Feedback(zoo zoo) {
        // System.out.println(feedback);
        zoo.viewFeedback();



    }


    @Override
    public void viewattractions(zoo zoo) {
        zoo.viewAttractions();
    }
}

