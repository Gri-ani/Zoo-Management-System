package org.example;

import java.util.Scanner;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Visitor implements useractions {
    private String name;
    private     int age;
    private     String phone;
    private     double balance;
    private     String email;
    private     String password;


    private    String membership="";
    private   List<Ticket> ticketList = new ArrayList<>();
    // private attractiontype

    // public Visitor(String name, int age, String phone, double balance, String email, String password) {

    public Visitor(String name, int age, String phone, double balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.balance = balance;
        this.email = email;
        this.password = password;

    }

    public void addTicket(Ticket ticket) {
        ticketList.add(ticket);
    }

    public String getMembership() {
        return this.membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }
    // this.class = class;



    public Visitor() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Visitor name(String name) {
        setName(name);
        return this;
    }

    public Visitor age(int age) {
        setAge(age);
        return this;
    }

    public Visitor phone(String phone) {
        setPhone(phone);
        return this;
    }

    public Visitor balance(double balance) {
        setBalance(balance);
        return this;
    }

    public Visitor email(String email) {
        setEmail(email);
        return this;
    }

    public Visitor password(String password) {
        setPassword(password);
        return this;
    }

    public List<Ticket> getTicketList() {
        return this.ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public void purchaseMembership(String membershipType) {
        // Check the membership type and take appropriate action
        if ("Basic".equalsIgnoreCase(membershipType)) {
            membership = "Basic";
            System.out.println("Basic Membership purchase was successfull.");
        } else if ("Premium".equalsIgnoreCase(membershipType)) {
            membership= "Premium";
            System.out.println("Premium  Membership purchase was successfull.");

        } else {
            System.out.println("Invalid membership type.Please enter a valid membership type \n");
        }
    }

    public  boolean hasTicketForAttraction(String attractionName) {
        for (Ticket ticket : getTicketList()) {
            if (ticket.getAttractionname().equalsIgnoreCase(attractionName) && ticket.getNooftickets()>0) {
                return true; // Visitor has a ticket for the attraction
            }
        }
        return false; // Visitor does not have a ticket for the attraction
    }

    public void removeTicket(String attractionName) {
        for (Ticket ticket : ticketList) {
            if (ticket.getAttractionname().equalsIgnoreCase(attractionName)) {
                ticket.setNooftickets(ticket.getNooftickets()-1);
                break; // Remove only the first occurrence
            }
        }
    }




    //USE OF OBJECT CLASS

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                ", phone='" + getPhone() + "'" +
                ", balance='" + getBalance() + "'" +
                ", email='" + getEmail() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }



    @Override
    public void Feedback(zoo zoo) {
        zoo.provideFeedback();
    }





    @Override
    public void viewattractions(zoo zoo) {
        zoo.viewAttractions();
    }






}
