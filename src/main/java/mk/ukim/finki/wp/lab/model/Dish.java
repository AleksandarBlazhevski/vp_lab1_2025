package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.wp.lab.model.enumerations.Cuisine;

@Data
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    @Enumerated(EnumType.STRING)
    Cuisine cuisine;
    int preparationTime;
    @ManyToOne
    Chef chef;

    public Dish(Long id, String name, Cuisine cuisine, int preparationTime) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
    }

    public Dish(String name, Cuisine cuisine, int preparationTime, Chef chef) {
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
        this.chef = chef;
    }

    public Dish(String name, Cuisine cuisine, int preparationTime){
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
    }

    public Dish(){}

    public String getFormatedDish(){
        return String.format("%d, %s, %s, %d", id, name, cuisine, preparationTime);
    }

    public String toString(){
        return String.format("%s (%s, %d)", name,  cuisine, preparationTime);
    }
}
