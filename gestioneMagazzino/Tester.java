package GestioneMagazzino;

public class Tester {

	public static void main(String[] args) {
		Prodotto a= new Prodotto("Asus","MXJE",39492,50,499,2000);
		Magazzino m= new Magazzino();
		m.aggiungiProdotto(a);
		m.visualizzaProdotti();
	}

}
