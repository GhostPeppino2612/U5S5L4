package giuseppeacquaviva.U5S5L4.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Drink extends Elemento {

    private String nome;

    public Drink(String nome ,double prezzo, int calorie) {
        super(prezzo, calorie);
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Drink{" +
                "name='" + nome + '\'' +
                ", calories=" + calorie +
                ", price=" + prezzo +
                '}';
    }
}
