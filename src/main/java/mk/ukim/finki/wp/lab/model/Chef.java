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
        dishes.removeIf(item -> item.getId() == dish.getId());
        dishes.add(dish);
    }

    public void removeDish(Long id) {
        dishes.removeIf(item -> item.getId().equals(id));
    }

    public String getFormatedName(){
        return firstName + " " + lastName + ", Bio: " + bio;
    }
}
