package giuseppeacquaviva.U5S5L4;

import giuseppeacquaviva.U5S5L4.entities.*;
import giuseppeacquaviva.U5S5L4.entities.Drink;
import giuseppeacquaviva.U5S5L4.entities.Order;
import giuseppeacquaviva.U5S5L4.entities.Pizza;
import giuseppeacquaviva.U5S5L4.entities.Table;
import giuseppeacquaviva.U5S5L4.services.ElementoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private ElementoService elementoService;


    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5S5L4Application.class);
        try {

            Table tavolo1 = (Table) ctx.getBean("Tavolo1");

            List<Pizza> pizzas = (List<Pizza>) ctx.getBean("pizzas");
            List<Drink> drinks = (List<Drink>) ctx.getBean("drinks");
            List<Topping> toppings = (List<Topping>) ctx.getBean("toppings");

             for (Pizza pizza : pizzas) {
                elementoService.save(pizza);
            }

            for (Drink drink : drinks) {
                elementoService.save(drink);
            }

            for (Topping topping : toppings) {
                elementoService.save(topping);
            }

            System.out.println("Tutte le pizze:");
            elementoService.getPizzas().forEach(pizza -> System.out.println(pizza.getNome()));

            System.out.println("Tutte le bevande:");
            elementoService.getDrinks().forEach(drink -> System.out.println(drink.getNome()));

            System.out.println("Tutti i topping:");
            elementoService.getToppings().forEach(topping -> System.out.println(topping.getName()));

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            ctx.close();
        }
    }
}
