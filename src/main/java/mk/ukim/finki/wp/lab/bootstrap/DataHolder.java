//package mk.ukim.finki.wp.lab.bootstrap;
//
//import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.wp.lab.model.Chef;
//import mk.ukim.finki.wp.lab.model.Dish;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DataHolder {
//
//    public static List<Chef> chefs = new ArrayList<>();
//    public static List<Dish> dishes = new ArrayList<>();
//    public static Long dishLastId = 0L;
//
//    @PostConstruct
//    void init(){
//        List<Dish> allDishes = new ArrayList<>();
//        allDishes.add(new Dish(++dishLastId, "Cake", "Mediterranean", 180));
//        allDishes.add(new Dish(++dishLastId, "Pizza", "Italian Cuisine", 30));
//        allDishes.add(new Dish(++dishLastId, "Sushi", "Japanese", 60));
//        allDishes.add(new Dish(++dishLastId, "Noodles", "Thai", 100));
//        allDishes.add(new Dish(++dishLastId, "Gyro", "Greek", 15));
//        dishes.addAll(allDishes);
//
//        List<Dish> chef2Dishes = new ArrayList<>();
//        chef2Dishes.add(allDishes.get(0));
//        chef2Dishes.add(allDishes.get(1));
//        chef2Dishes.add(allDishes.get(2));
//        chef2Dishes.add(allDishes.get(3));
//
//        List<Dish> chef3Dishes = new ArrayList<>();
//        chef3Dishes.add(allDishes.get(0));
//        chef3Dishes.add(allDishes.get(1));
//        chef3Dishes.add(allDishes.get(2));
//
//        List<Dish> chef4Dishes = new ArrayList<>();
//        chef4Dishes.add(allDishes.get(0));
//        chef4Dishes.add(allDishes.get(1));
//
//        chefs.add(new Chef(1L, "Aleksandar", "Blazhevski", "Bio for 1", allDishes));
//        chefs.add(new Chef(2L, "Marko", "Shilevski", "Bio for 2", chef2Dishes));
//        chefs.add(new Chef(3L, "Martina", "Beshlieva", "Bio for 3", chef3Dishes));
//        chefs.add(new Chef(4L, "Sofija", "Lazarevska", "Bio for 4", chef4Dishes));
//        chefs.add(new Chef(5L, "Kristijan", "Blazhevski", "Bio for 5", new ArrayList<>()));
//    }
//
//}
