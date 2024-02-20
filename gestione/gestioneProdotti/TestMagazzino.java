package gestione.gestioneProdotti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class TestMagazzino {

    private Magazzino magazzino;
    private Prodotto prodotto1;
    private Prodotto prodotto2;

    @Before
    public void setUp() throws Exception {
        magazzino = new Magazzino();
        prodotto1 = new Prodotto("Marca1", "Modello1", 1234, 10, 100.0f, 5);
        prodotto2 = new Prodotto("Marca2", "Modello2", 5678, 5, 50.0f, 2);
        magazzino.aggiungiProdotto(prodotto1);
        magazzino.aggiungiProdotto(prodotto2);
    }

    @Test
    public void testAggiungiProdotto() {
        Prodotto prodotto3 = new Prodotto("Marca3", "Modello3", 9876, 8, 80.0f, 3);
        magazzino.aggiungiProdotto(prodotto3);
        assertEquals(3, magazzino.getListaProdotti().size());
    }

    @Test
    public void testVisualizzaProdotti() {  
        assertNotNull(magazzino.getListaProdotti());
        assertFalse(magazzino.getListaProdotti().isEmpty());
    }

    @Test
    public void testEliminaProdotto() {
        assertTrue(magazzino.eliminaProdotto(prodotto1));
        assertEquals(1, magazzino.getListaProdotti().size());
        assertFalse(magazzino.eliminaProdotto(new Prodotto("Marca1", "Modello1", 1234, 10, 100.0f, 5)));
        assertEquals(1, magazzino.getListaProdotti().size());
    }

    @Test
    public void testSetQuantita() {
        try {
            prodotto1.setQuantita(15);
            assertEquals(15, prodotto1.getQuantita());
        } catch (ProdottoException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = ProdottoException.class)
    public void testSetQuantitaNegativa() throws ProdottoException {
        prodotto1.setQuantita(-5);
    }

    @Test
    public void testSetPrezzo() {
        try {
            prodotto1.setPrezzo(120.0f);
            assertEquals(120.0f, prodotto1.getPrezzo(), 0.0f);
        } catch (ProdottoException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = ProdottoException.class)
    public void testSetPrezzoNegativo() throws ProdottoException {
        prodotto1.setPrezzo(-50.0f);
    }
}
