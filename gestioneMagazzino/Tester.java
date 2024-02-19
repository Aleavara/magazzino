package GestioneMagazzino;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import salvataggio.SalvaFile;

public class Tester {

	public static void main(String[] args) {
	  
	     // Creazione di un oggetto Prodotto
        Prodotto prodotto = new Prodotto("Marca", "Modello", 1234, 10, 99.99f, 5
                                        );
        
        // Salvataggio dell'oggetto su file
        String filePath = "prodotto.ser";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(prodotto);
            System.out.println("Prodotto serializzato correttamente e salvato su file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Lettura dell'oggetto serializzato da file
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Prodotto prodottoDeserializzato = (Prodotto) inputStream.readObject();
            System.out.println("Prodotto deserializzato correttamente:");
            System.out.println(prodottoDeserializzato);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
        // Creazione di un magazzino
        Magazzino magazzino = new Magazzino();

        // Aggiunta di alcuni prodotti al magazzino
        Prodotto prodotto1 = new Prodotto("Marca1", "Modello1", 1, 10, 100.0f, 10);
        Prodotto prodotto2 = new Prodotto("Marca2", "Modello2", 2, 20, 200.0f, 20);

        magazzino.aggiungiProdotto(prodotto1);
        magazzino.aggiungiProdotto(prodotto2);

        // Salvataggio dei prodotti serializzati in un file
        String fileName = "magazzino.csv";
        try {
            magazzino.serializzaMagazzino( fileName);
            System.out.println("Magazzino serializzato con successo.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante la serializzazione del magazzino: " + e.getMessage());
        }

        // Deserializzazione dei prodotti dal file e aggiunta al magazzino
        try {
            Magazzino magazzinoDeserializzato = new Magazzino();
            magazzinoDeserializzato.deserializzaMagazzino( fileName);
            System.out.println("Magazzino deserializzato con successo.");
            System.out.println("Prodotti nel magazzino deserializzato:");
            magazzinoDeserializzato.visualizzaProdotti();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Si è verificato un errore durante la deserializzazione del magazzino: " + e.getMessage());
        }
        
        // Creazione di un magazzino e aggiunta di alcuni prodotti
        Magazzino magazzino2 = new Magazzino();
        magazzino2.aggiungiProdotto(new Prodotto("Marca1", "Modello1", 123, 10, 20.5f, 5));
        magazzino2.aggiungiProdotto(new Prodotto("Marca2", "Modello2", 456, 20, 15.75f, 10));
        magazzino2.aggiungiProdotto(new Prodotto("Marca3", "Modello3", 789, 30, 30.0f, 25));

        // Definizione del nome del file in cui salvare i prodotti
        String fileName2 = "prodotti.txt";
        SalvaFile x= new SalvaFile();

        try {
            // Chiamata al metodo per salvare i prodotti sul file
            x.salvaProdotti(magazzino, fileName2);
            System.out.println("Prodotti salvati con successo nel file: " + fileName);
        } catch (IOException e) {
            System.err.println("Si è verificato un errore durante il salvataggio dei prodotti: " + e.getMessage());
        } 
        
	}
}
 