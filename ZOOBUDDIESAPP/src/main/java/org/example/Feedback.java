package org.example;


public class Feedback {

    private String visitorName;

    private String description;



    public Feedback(String visitorName, String content) {

        this.visitorName = visitorName;

        this.description = content;

    }



    public String getVisitorName() {

        return visitorName;

    }

    public void setVisitorName(String visitorName) {

        this.visitorName = visitorName;

    }



    public String getContent() {

        return description;

    }

    public void setContent(String description) {

        this.description = description;

    }

}