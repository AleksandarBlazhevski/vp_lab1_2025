package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.List;

@Data
public class Chef {
    Long id;
    String firstName;
    String lastName;
    String bio;
    List<Dish> dishes;

    public Chef(Long id, String firstName, String lastName, String bio, List<Dish> dishes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.dishes = dishes;
    }

    public Chef() {
    }

    public void addDish(Dish dish) {
        dishes.removeIf(item -> item.getDishId().equals(dish.getDishId()));
        dishes.add(dish);
    }

    public String getFormatedName(){
        return firstName + " " + lastName + ", Bio: " + bio;
    }
}
