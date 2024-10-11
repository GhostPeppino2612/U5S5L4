package giuseppeacquaviva.U5S5L4.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Pizza extends Elemento {

    private String nome;
    @ManyToMany
    @JoinTable(name = "toppings_pizzas", joinColumns = @JoinColumn(name = "pizzas"), inverseJoinColumns = @JoinColumn(name = "toppings"))
    private List<Topping> listaToppings;
    private boolean isXl = false;

    public Pizza(String nome, List<Topping> listaToppings, boolean isXl) {
        super(5.00, 1000);
        this.nome = nome;
        this.listaToppings = listaToppings;
        this.isXl = isXl;
        this.calorie = setCalories(listaToppings, isXl);
        this.prezzo = setPrezzo(listaToppings, isXl);

    }

    public int setCalories(List<Topping> toppings, boolean isXl) {
        int tot = 1000;
        if (toppings != null) {
            for (int i = 0; i < toppings.size(); i++) {
                tot += toppings.get(i).getCalorie();
            }
        }
        if (isXl) return tot += (tot * (5 / 100));
        else return tot;
    }

    public double setPrezzo(List<Topping> toppings, boolean isXl) {
        double tot = 5.00;
        if (toppings != null) {
            for (int i = 0; i < toppings.size(); i++) {
                tot += toppings.get(i).getPrezzo();
            }
        }
        if (isXl) return tot += (tot * (5 / 100));
        else return tot;
    }
}
