package giuseppeacquaviva.U5S5L4.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Topping extends Elemento {

    private String name;

    public Topping(double prezzo, int calorie, String name) {
        super(prezzo, calorie);
        this.name = name;
    }
}
