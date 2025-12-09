package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class Dish {

    private Long id;
    String name;
    String cuisine;
    int preparationTime;

    public Dish(Long id, String name, String cuisine, int preparationTime) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
    }

    public Dish(String name, String cuisine, int preparationTime){
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
