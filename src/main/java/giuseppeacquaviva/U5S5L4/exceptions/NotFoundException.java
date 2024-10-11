package giuseppeacquaviva.U5S5L4.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Elemento con id " + id + "non trovato");
    }
}
