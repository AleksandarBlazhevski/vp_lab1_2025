package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String bio;
    @OneToMany(mappedBy = "chef")
    Set<Dish> dishes;

    public Chef(Long id, String firstName, String lastName, String bio, Set<Dish> dishes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.dishes = dishes;
    }

    public Chef(String firstName, String lastName, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.dishes = new HashSet<>();
    }

    public Chef() {
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void removeDish(Long id) {
        dishes.removeIf(item -> item.getId().equals(id));
    }

    public String getFormatedName(){
        return firstName + " " + lastName + ", Bio: " + bio;
    }
}
