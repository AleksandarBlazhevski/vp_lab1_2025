package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class DishController {

    private final DishService dishService;
    private final ChefService chefService;

    public DishController(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }

    @GetMapping(path = "/dishes")
    public String getDishesPage(@RequestParam(required = false) String error, Model model){
        List<Dish> dishes = dishService.listDishes();
        model.addAttribute("dishes", dishes);
        model.addAttribute("error", error);
        return "listDishes";
    }

    @PostMapping(path = "/dishes/add")
    public String saveDish(@RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime, @RequestParam Long chefId){
        String error = "";
        try{
            dishService.create( name, cuisine, preparationTime, chefId);
        }catch (Exception e){
            error = e.getMessage();
        }
        return error.isBlank() ? "redirect:/dishes" : "redirect:/dishes?error=" + error;
    }

    @PostMapping(path = "/dishes/edit/{id}")
    public String editDish(@PathVariable Long id, @RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime, @RequestParam Long chefId){
        String error = "";
        try {
            dishService.update(id, name, cuisine, preparationTime, chefId);
        }catch (Exception e){
            error = e.getMessage();
        }
        return error.isBlank() ? "redirect:/dishes" : "redirect:/dishes?error=" + error;
    }

    @PostMapping(path = "/dishes/delete/{id}")
    public String deleteDish(@PathVariable Long id){
        dishService.delete(id);
        return "redirect:/dishes";
    }

    @GetMapping(path = "/dishes/dish-form/{id}")
    public String getEditDishForm(@PathVariable(required = false) Long id, Model model){
        try {
            List<Chef> chefs = chefService.listChefs();
            Dish dish = dishService.findById(id);
            model.addAttribute("dish", dish);
            model.addAttribute("url", "/dishes/edit/" + id);
            model.addAttribute("chefs", chefs);
            return "dish-form";
        }catch (Exception e){
            return "redirect:/dishes?error=DishNotFound";
        }
    }

    @GetMapping(path = "/dishes/dish-form")
    public String getAddDishPage(Model model){

        List<Chef> chefs = chefService.listChefs();
        model.addAttribute("url", "/dishes/add");
        model.addAttribute("chefs", chefs);
        return "dish-form";
    }
}
