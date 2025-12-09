//package mk.ukim.finki.wp.lab.repository.inmemory;
//
//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
//import mk.ukim.finki.wp.lab.model.Dish;
//import mk.ukim.finki.wp.lab.repository.DishRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class InMemoryDishRepository implements DishRepository {
//    @Override
//    public List<Dish> findAll() {
//        return DataHolder.dishes;
//    }
//
//    @Override
//    public Optional<Dish> findById(Long id) {
//        return DataHolder.dishes.stream().filter(item -> item.getId() == id).findFirst();
//    }
//
//    @Override
//    public Dish save(Dish dish) {
//        DataHolder.dishes.removeIf(item -> item.getId() == dish.getId());
//        DataHolder.dishes.add(dish);
//        return dish;
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        DataHolder.dishes.removeIf(item -> item.getId() == id);
//        DataHolder.chefs.forEach(chef -> chef.removeDish(id));
//    }
//}
