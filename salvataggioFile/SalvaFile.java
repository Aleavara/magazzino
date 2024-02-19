package salvataggio;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import GestioneMagazzino.Magazzino;
import GestioneMagazzino.Prodotto;

public class SalvaFile {

    /**
     * Salva su file tutti i prodotti del magazzino con gli attributi principali.
     *
     * @param magazzino Il magazzino da cui estrarre i prodotti da salvare su file.
     * @param fileName  Il nome del file in cui salvare i prodotti.
     * @throws IOException Se si verifica un errore di I/O durante il salvataggio su file.
     */
    public static void salvaProdotti(Magazzino magazzino, String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Prodotto prodotto : magazzino.getListaProdotti()) {
                writer.println(prodotto.toFileString());
            }
        }
    }
}