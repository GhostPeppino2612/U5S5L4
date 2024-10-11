package giuseppeacquaviva.U5S5L4.repositories;

import giuseppeacquaviva.U5S5L4.entities.Drink;
import giuseppeacquaviva.U5S5L4.entities.Elemento;
import giuseppeacquaviva.U5S5L4.entities.Pizza;
import giuseppeacquaviva.U5S5L4.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementoRepository extends JpaRepository<Elemento, Long> {


    @Query("SELECT p FROM Pizza p")
    List<Pizza> findPizzas();

    @Query("SELECT d FROM Drink d")
    List<Drink> findDrinks();

    @Query("SELECT t FROM Topping t")
    List<Topping> findToppings();
}
