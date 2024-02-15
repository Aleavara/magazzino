package GestioneMagazzino;

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
        this.listaProdotti = new ArrayList<>();
    }
    
    
    //METODI
    
    /**
     * Aggiunge un nuovo prodotto alla lista del magazzino.
     * @param nuovoProdotto Il prodotto da aggiungere al magazzino.
     */
    public void aggiungiProdotto(Prodotto nuovoProdotto) {
        listaProdotti.add(nuovoProdotto);
    }

    /**
     * Visualizza tutti i prodotti presenti nel magazzino.
     */
    public void visualizzaProdotti() {
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
        for(Prodotto prodotto: listaProdotti){
            if(prodotto.getSeriale().equals(seriale))
                return prodotto;
        }
        return null;
    }
}