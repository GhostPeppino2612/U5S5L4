package giuseppeacquaviva.U5S5L4.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Table {
    private int numTable;
    private int numMaxCoperti;
    private StatoTavolo stato;
    private double costoCoperto;

    public void print() {
        System.out.println("Numero tavolo--> " + numTable);
        System.out.println("Numero massimo coperti--> " + numMaxCoperti);
        System.out.println("Occupato/Libero--> " + this.stato);
        System.out.println("Occupato/Libero--> " + this.stato);
    }

}