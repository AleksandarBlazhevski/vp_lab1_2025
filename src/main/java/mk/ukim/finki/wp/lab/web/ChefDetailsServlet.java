package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "ChefDetailsServlet", urlPatterns = "/chefDetails")
public class ChefDetailsServlet extends HttpServlet {

    private final ChefService chefService;
    private final SpringTemplateEngine templateEngine;
    private final DishService dishService;

    public ChefDetailsServlet(ChefService chefService, SpringTemplateEngine templateEngine, DishService dishService) {
        this.chefService = chefService;
        this.templateEngine = templateEngine;
        this.dishService = dishService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        try {
            String chefId = req.getParameter("chefId");
            String dishId = req.getParameter("dishId");

            Chef chef = chefService.findById(Long.parseLong(chefId));
            Dish dish = dishService.findById(Long.parseLong(dishId));

            Chef updatedChef = chefService.addDishToChef(Long.parseLong(chefId), Long.parseLong(dishId));

            Set<Dish> dishes = updatedChef.getDishes();

            context.setVariable("chef", chef);
            context.setVariable("dishes", dishes);

            templateEngine.process("chefDetails.html", context, resp.getWriter());
        }catch (Exception e){
            System.out.printf(e.getMessage());
        }


    }
}
