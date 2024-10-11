package giuseppeacquaviva.U5S5L4.services;

import giuseppeacquaviva.U5S5L4.entities.Drink;
import giuseppeacquaviva.U5S5L4.entities.Elemento;
import giuseppeacquaviva.U5S5L4.entities.Pizza;
import giuseppeacquaviva.U5S5L4.entities.Topping;
import giuseppeacquaviva.U5S5L4.exceptions.NotFoundException;
import giuseppeacquaviva.U5S5L4.repositories.ElementoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementoService {
    @Autowired
    private ElementoRepository elementoRepository;

    public List<Elemento> getAllElementi() {
        return elementoRepository.findAll();
    }

    public List<Pizza> getPizzas() {
        return elementoRepository.findPizzas();
    }

    public List<Drink> getDrinks() {
        return elementoRepository.findDrinks();
    }

    public List<Topping> getToppings() {
        return elementoRepository.findToppings();
    }

    public Elemento findById(long id) {
        return elementoRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void save(Elemento item) {
        elementoRepository.save(item);
    }

    public void findByIdAndDelete(long id) {
        Elemento order = this.findById(id);
        elementoRepository.delete(order);
    }
}
