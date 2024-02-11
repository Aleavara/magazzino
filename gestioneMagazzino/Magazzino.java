package gestione.prodotti;

import java.util.ArrayList;
import java.util.List;

public class Magazzino {
    
	//ATTRIBUTI
	private List<Prodotto> listaProdotti; //Lista di prodotti
	
	
	//COSTRUTTORE
    public Magazzino() {
        this.listaProdotti = new ArrayList<>();
    }
    
    
    //METODI
    public void aggiungiProdotto(Prodotto nuovoProdotto) {
          listaProdotti.add(nuovoProdotto);
    }

    public void visualizzaProdotti() {
        for (Prodotto prodotto : listaProdotti) {
            System.out.println(prodotto.toString());
        }
    }
    public Prodotto ricercaProdotto(String seriale){
        for(prodotto: listaprodotti){
            if(prodotto.getSeriale().equals(seriale))
            return prodotto;}
            return null;
        }
    }

