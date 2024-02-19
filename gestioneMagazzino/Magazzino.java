package GestioneMagazzino;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe rappresenta un magazzino che contiene una lista di prodotti.
 * @author avara
 * @version 1.0
 */
public class Magazzino {
    
    //ATTRIBUTI
    private List<Prodotto> listaProdotti; //Lista di prodotti
    
    
    //COSTRUTTORE
    
    /**
     * Costruttore della classe Magazzino.
     * Crea un nuovo magazzino con una lista di prodotti vuota.
     */
    public Magazzino() {
        // Inizializzazione della lista dei prodotti
        this.listaProdotti = new ArrayList<>();
    }
    
    
    //METODI
    
    /**
     * Aggiunge un nuovo prodotto alla lista del magazzino.
     * @param nuovoProdotto Il prodotto da aggiungere al magazzino.
     */
    public void aggiungiProdotto(Prodotto nuovoProdotto) {
        // Aggiunge un prodotto alla lista
        listaProdotti.add(nuovoProdotto);
    }

    /**
     * Visualizza tutti i prodotti presenti nel magazzino.
     */
    public void visualizzaProdotti() {
        // Visualizza i dettagli di ogni prodotto nella lista
        for (Prodotto prodotto : listaProdotti) {
            System.out.println(prodotto.toString());
        }
    }
   
    /**
     * Elimina un prodotto specifico dalla lista del magazzino.
     * @param p Il prodotto da eliminare.
     * @return true se il prodotto è stato eliminato con successo, false altrimenti.
     */
    public boolean eliminaProdotto(Prodotto p) {
        // Cerca il prodotto nella lista e lo elimina se trovato
        for (Prodotto prodotto : listaProdotti) {
            if(p == prodotto) {
                listaProdotti.remove(prodotto);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Ricerca un prodotto per numero seriale nella lista del magazzino.
     * @param seriale Il numero seriale del prodotto da cercare.
     * @return Il prodotto corrispondente al numero seriale specificato, null se non trovato.
     */
    public Prodotto ricercaProdotto(String seriale){
        // Cerca il prodotto nella lista per numero seriale
        for(Prodotto prodotto: listaProdotti){
            if(prodotto.getSeriale().equals(seriale))
                return prodotto;
        }
        return null;
    }
    
    /**
     * Metodo per ottenere la quantità totale di prodotti presenti nel magazzino.
     * @return La quantità totale di prodotti nel magazzino.
     */
    public int getQuantitaTotale() {
        // Calcola la quantità totale di prodotti
        int quantitaTotale = 0;
        for (Prodotto prodotto : listaProdotti) {
            quantitaTotale += prodotto.getQuantita();
        }
        return quantitaTotale;
    }
    
    /**
     * Metodo per filtrare i prodotti per marca nel magazzino.
     * @param marca La marca dei prodotti da filtrare.
     * @return Una lista di prodotti filtrati per la marca specificata.
     */
    public List<Prodotto> filtraProdottiPerMarca(String marca) {
        // Filtra i prodotti per la marca specificata
        List<Prodotto> prodottiFiltrati = new ArrayList<>();
        for (Prodotto prodotto : listaProdotti) {
            if (prodotto.getMarca().equalsIgnoreCase(marca)) {
                prodottiFiltrati.add(prodotto);
            }
        }
        return prodottiFiltrati;
    }

    /**
     * Metodo per ottenere la lista di tutti i prodotti nel magazzino.
     * @return La lista di tutti i prodotti nel magazzino.
     */
    public List<Prodotto> getListaProdotti() {
        // Restituisce la lista di prodotti
        return this.listaProdotti;
    }
	
	 /**
     * Metodo per serializzare tutti i prodotti presenti nel magazzino.
     *
     * @param fileName  Il nome del file in cui salvare la serializzazione.
     * @throws IOException Se si verifica un errore di I/O durante la serializzazione.
     */
    public void serializzaMagazzino(String fileName) throws IOException {
        // Serializza la lista dei prodotti in un file
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(this.getListaProdotti());
        }
    }

    /**
     * Metodo per deserializzare i prodotti da un file e aggiungerli al magazzino.
     *
     * @param fileName  Il nome del file da cui caricare la deserializzazione.
     * @throws IOException            Se si verifica un errore di I/O durante la deserializzazione.
     * @throws ClassNotFoundException Se la classe del file serializzato non viene trovata.
     */
    public  void deserializzaMagazzino(String fileName) throws IOException, ClassNotFoundException {
        // Deserializza i prodotti da un file e li aggiunge al magazzino
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Prodotto> prodotti = (List<Prodotto>) inputStream.readObject();
            this.getListaProdotti().addAll(prodotti);
        }
    }
}