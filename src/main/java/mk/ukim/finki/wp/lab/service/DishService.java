package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DishService {
    List<Dish> listDishes();
    Dish findById(Long id);
    Dish create(String name, String cuisine, int preparationTime, Long chefId);
    Dish update(Long id, String name, String cuisine, int preparationTime);
    Dish update(Dish dish);
    Dish update(Long id, String name, String cuisine, int preparationTime, Long chefId);
    void delete(Long id);
}
