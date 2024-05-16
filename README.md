

# Zoo Management System

This project is a Zoo Management System implemented in Java, utilizing various object-oriented concepts and design patterns.

## Compilation Steps

1. `mvn clean`
2. `mvn compile`
3. `mvn package`
4. For `<name of the functionality>`: `java -jar <assignment2.jar> <class-name> <args>`

## Assumptions

1. Two animals, lion and deer, are hardcoded, utilizing polymorphism.
2. In the `SpecialDeal` function, the deal is assumed to be applicable only for the exact number of attractions specified.
3. To access as an admin, the username is "admin" and the password is "admin123".
4. While adding an attraction, the basic ticket price is required. To change this price later, it's done through Schedule Events.
5. The category name is used as the discount code.
6. Visitors can't remove an animal if there are less than two of that type in the zoo.
7. Visitors can visit animals for free.
8. Visitors with premium membership cannot buy tickets.
9. The ID of the attraction is used to uniquely identify attractions.
10. Visitor count is based on the registered number of visitors.

## Class Descriptions

- **Zoo Class**: Manages attractions, animals, visitors, discounts, special deals, and feedback.
- **Admin Class**: Represents an administrator managing attractions, feedback, and other functionalities.
- **Visitor Class**: Represents a visitor with attributes like name, age, and methods for actions like purchasing memberships, buying tickets, and leaving feedback.
- **Ticket Class**: Represents a ticket purchased by a visitor.
- **SpecialDeal Class**: Represents a special deal offered by the zoo.
- **Revenue Class**: Calculates the revenue.
- **Feedback Class**: Manages visitor feedback.
- **Discount Class**: Manages discounts.
- **Attraction Class**: Represents an attraction at the zoo.
- **Animal Class**: Represents an animal at the zoo.
- **TypeMammal, TypeAmphibian, TypeReptile Classes**: Concrete implementations of Animal class representing different types of animals.
- **Main Class**: Implements various functionalities for both admins and visitors.

The implementation incorporates interfaces, abstract classes, polymorphism, and object-oriented concepts.
