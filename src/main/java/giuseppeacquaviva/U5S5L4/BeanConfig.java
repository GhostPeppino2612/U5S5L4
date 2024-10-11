package giuseppeacquaviva.U5S5L4;

import giuseppeacquaviva.U5S5L4.entities.Drink;
import giuseppeacquaviva.U5S5L4.entities.Pizza;
import giuseppeacquaviva.U5S5L4.entities.Topping;
import giuseppeacquaviva.U5S5L4.entities.StatoTavolo;
import giuseppeacquaviva.U5S5L4.entities.Table;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class BeanConfig {
    @Bean(name = "tomato_topping")
    @Scope()
    public Topping tomatoTopping() {
        return new Topping(0.10, 10, "Tomato");
    }
    @Bean(name = "cheese_topping")
    public Topping cheeseTopping() {
        return new Topping(1,22, "Cheese");
    }
    @Bean(name = "ham_topping")
    public Topping hamTopping() {
        return new Topping(2,12,"Ham");
    }
    @Bean(name = "pineapple_topping")
    public Topping pineappleTopping() {
        return new Topping(1.2, 23, "Pineapple");
    }
    @Bean(name = "salami_toppings")
    public Topping salamiTopping() {
        return new Topping(2, 8, "Salami");
    }

    @Bean(name = "pizza_margherita")
    public Pizza pizzaMargherita() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(tomatoTopping());
        toppings.add(cheeseTopping());
        return new Pizza("Pizza Margherita", toppings, false);
    }

    @Bean(name = "hawaiian_pizza")
    public Pizza pizzaHawaiian() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(tomatoTopping());
        toppings.add(cheeseTopping());
        toppings.add(hamTopping());
        toppings.add(pineappleTopping());
        return new Pizza("Hawaiian Pizza", toppings, false);
    }

    @Bean(name = "salami_pizza")
    public Pizza pizzaSalami() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(tomatoTopping());
        toppings.add(cheeseTopping());
        toppings.add(salamiTopping());
        return new Pizza("Salami Pizza", toppings, false);
    }

    @Bean(name = "salami_pizza_xl")
    public Pizza pizzaSalamiXl() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(tomatoTopping());
        toppings.add(cheeseTopping());
        toppings.add(salamiTopping());
        return new Pizza("Salami Pizza XL", toppings, true);
    }

    @Bean(name = "lemonade")
    public Drink lemonade() {
        return new Drink("Lemonade", 2,200);
    }

    @Bean(name = "water")
    public Drink water() {
        return new Drink("Water", 1, 10);
    }

    @Bean(name = "wine")
    public Drink wine() {
        return new Drink("Wine", 10, 70);
    }

    @Bean("pizzas")
    public List<Pizza> pizzaList() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(pizzaMargherita());
        pizzas.add(pizzaHawaiian());
        pizzas.add(pizzaSalami());
        pizzas.add(pizzaSalamiXl());
        return pizzas;
    }

    @Bean("drinks")
    public List<Drink> drinksList() {
        List<Drink> drinks = new ArrayList<>();
        drinks.add(lemonade());
        drinks.add(water());
        drinks.add(wine());
        return drinks;
    }

    @Bean("toppings")
    public List<Topping> toppingsList() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(tomatoTopping());
        toppings.add(cheeseTopping());
        toppings.add(salamiTopping());
        toppings.add(hamTopping());
        toppings.add(pineappleTopping());
        return toppings;
    }

    @Bean("Tavolo1")
    Table getTable1(@Value("${table.price}") double tablePrice) {
        return new Table(1, 3, StatoTavolo.LIBERO, tablePrice);
    }
    @Bean("Tavolo2")
    Table getTable2(@Value("${seat.price}") double seatPrice) {
        return new Table(2, 4, StatoTavolo.LIBERO, seatPrice);
    }

    @Bean("Tavolo3")
    Table getTable3(@Value("${seat.price}") double seatPrice) {
        return new Table(3, 8, StatoTavolo.LIBERO, seatPrice);
    }

}
