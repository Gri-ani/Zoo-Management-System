package org.example;

interface Details {

    String getType();
    void setType(String type);
    String getDescription();
    void setDescription(String description);
}
//
//abstract class Animalclass implements Details{
//    String name;
//    String type;
//    String description;
//    String sound;
//
//    abstract public  String getName();
//    abstract public String setName(String name);
//    abstract public void getSound();
//    abstract public void setSound(String sound);
//    abstract public String toString();
//
//
//
//
//}






public class Animal implements Details {
    private String name;        // Name of the animal
    private String type;        // Type of the animal (e.g., Mammal, Amphibian, Reptile)
    private String description; // Details about the animal
    private String sound;       // Sound the animal makes

    public Animal(String name, String type, String description, String sound) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.sound = sound;
    }

    // Getters and setters for the fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", sound='" + sound + '\'' +
                '}';
    }
}