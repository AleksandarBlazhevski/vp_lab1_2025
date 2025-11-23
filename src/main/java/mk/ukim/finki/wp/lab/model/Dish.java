package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class Dish {

    private Long id;
    String dishId;
    String name;
    String cuisine;
    int preparationTime;

    public Dish(Long id, String dishId, String name, String cuisine, int preparationTime) {
        this.id = id;
        this.dishId = dishId;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
    }

    public Dish(){}

    public String getFormatedDish(){
        return String.format("%s, %s, %s, %d", dishId, name, cuisine, preparationTime);
    }

    public String toString(){
        return String.format("%s (%s, %d)", name,  cuisine, preparationTime);
    }
}
