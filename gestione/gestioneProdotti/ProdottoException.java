package gestione.gestioneProdotti;

/**
 * Eccezione personalizzata per gestire gli errori relativi ai prodotti.
 * @author avara
 * @version 1.0
 */
public class ProdottoException extends Throwable {
    
    /**
     * Costruttore della classe ProdottoException.
     * @param message Il messaggio di errore associato all'eccezione.
     */
    public ProdottoException(String message) {
        super(message);
    }
}