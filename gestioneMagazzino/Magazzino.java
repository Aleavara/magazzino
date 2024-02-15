package GestioneMagazzino;

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
   
    public boolean eliminaProdotto(Prodotto p) {
    	
    	for (Prodotto prodotto : listaProdotti) {
    		if(p==prodotto) {
    			
    			listaProdotti.remove(prodotto);
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public Prodotto ricercaProdotto(String seriale){
        for(Prodotto prodotto: listaProdotti){
            if(prodotto.getSeriale().equals(seriale))
            return prodotto;}
            return null;
        }
    
   
}

