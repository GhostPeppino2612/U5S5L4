package giuseppeacquaviva.U5S5L4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected int calorie;
    protected double prezzo;

    public Elemento(double prezzo, int calorie) {
        this.prezzo = prezzo;
        this.calorie = calorie;
    }
}
