package giuseppeacquaviva.U5S5L4.entities;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    private int numeroOrdine;
    private int numeroCoperti;
    private Stato stato;
    private LocalTime oraOrdine;
    private List<Elemento> elementiOrdinati;
    private Table tavolo;

    public Order(int numeroCoperti, Table tavolo) {
        Random rndm = new Random();
        this.numeroOrdine = rndm.nextInt(10000, 100000);
        this.stato = Stato.IN_CORSO;
        this.numeroCoperti = numeroCoperti;
        this.oraOrdine = LocalTime.now();
        this.elementiOrdinati = new ArrayList<>();
        this.tavolo = tavolo;
    }

    public void addElemento(Elemento elemento) {
        this.elementiOrdinati.add(elemento);
    }

    public double getTotal() {
        return this.elementiOrdinati.stream().mapToDouble(Elemento::getPrezzo).sum() + (this.tavolo.getCostoCoperto() * this.numeroCoperti);
    }

    public void print() {
        System.out.println("Id dell'ordine:" + this.numeroOrdine);
        System.out.println("Stato: " + this.stato);
        System.out.println("Numero Coperti: " + this.numeroCoperti);
        System.out.println("Ora ordinazione: " + this.oraOrdine);
        System.out.println("Numero del tavolo: " + this.tavolo.getNumTable());
        System.out.println("Lista: ");
        this.elementiOrdinati.forEach(System.out::println);
        System.out.println("totale: " + this.getTotal());

    }
}
