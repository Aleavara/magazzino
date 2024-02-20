package gestione.gestioneProdotti;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import gestione.salvataggio.SalvaFile;

public class InterfacciaUtente {

	public static void main(String[] args) {
		Magazzino magazzino = new Magazzino();

		// Caricamento dei prodotti dal file se già presenti
		try {
			magazzino.deserializzaMagazzino("prodotti.csv");
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Nessun prodotto trovato nel file.");
		}		

		Scanner scanner = new Scanner(System.in);

		boolean continua = true;
		while (continua) {

			System.out.println("Menu: ");
			System.out.println("1. Aggiungi prodotto");
			System.out.println("2. Visualizza prodotto: ");
			System.out.println("3. Rimuovi prodotto");
			System.out.println("4. Visualizza tutti i prodotti del tuo magazzino");
			System.out.println("5. Esci (e salva)");
			System.out.print("Scelta: ");
			
			int scelta = scanner.nextInt();
			scanner.nextLine(); 

			switch (scelta) {
			
			case 1:
				try {
					// Richiesta della prima stringa
					System.out.println("Inserisci la marca del prodotto");
					String marca = scanner.nextLine();

					System.out.println("Inserisci il modello del prodotto");
					String modello = scanner.nextLine();

					System.out.println("Inserisci il seriale");
					int seriale = scanner.nextInt();

					System.out.println("Inserisci la quantita");
					int quantita = scanner.nextInt();

					System.out.println("Inserisci il prezzo");
					float prezzo = scanner.nextFloat();

					System.out.println("Inserisci la disponibilità");
					int disponibilita = scanner.nextInt();

					System.out.println("Inserisci l'eta minima di utilizzo");
					int etaMinima = scanner.nextInt();

					System.out.println("Inserisci i mesi di garanzia");
					int mesiGaranzia = scanner.nextInt();

					System.out.println("Inserisci la data di produzione:");
					String data = scanner.nextLine();

					System.out.println("Inserisci la data di scadenza");
					String dataScadenza = scanner.nextLine();

					Prodotto prodotto = new Prodotto(marca, modello, seriale, quantita, prezzo, disponibilita,
							etaMinima, mesiGaranzia, data, dataScadenza);
					magazzino.aggiungiProdotto(prodotto);
				} catch (InputMismatchException e) {
					System.out.println("Input non valido");
				}

				break;
			case 2:
				System.out.println("forniscimi il seriale:");
				int serial = scanner.nextInt();
				if (magazzino.ricercaProdotto(serial) == null)
					System.out.println("prodotto non trovato");
				else
					System.out.println(
							"prodotto trovato!\n ecco i dettagli: " + magazzino.ricercaProdotto(serial).toString());
				break;
			case 3:
				System.out.println("vuoi eliminare tutti i prodotti di un tipo o solo una quantità? digita 1 o 0");
				int sceltaEliminazione = scanner.nextInt();
				if (sceltaEliminazione == 1) {
					System.out.println("digita il seriale del prodotto per eliminare tutte le disponibilità: ");
					int serialeElim = scanner.nextInt();
					if (magazzino.ricercaProdotto(serialeElim) == null)
						System.out.println("prodotto non trovato");
					else {
						magazzino.eliminaProdotto(magazzino.ricercaProdotto(serialeElim));
						System.out.println("prodotto eliminato con successo!");

					}
				} else if (sceltaEliminazione == 0) {
					System.out.println("digita il seriale del prodotto per eliminarne una quantità: ");
					int serialeEl = scanner.nextInt();
					if (magazzino.ricercaProdotto(serialeEl) == null)
						System.out.println("prodotto non trovato");
					else {
						System.out.println("quanti vuoi eliminarne? ");
						int quantitaDaEliminare = scanner.nextInt();
						try {
							magazzino.ricercaProdotto(serialeEl).aggiornaDisponibilita(quantitaDaEliminare);

						} catch (ProdottoException e) {
							System.out.println("quantità da eliminare superiore alla disponibilità!!");
						}
					}
				}
				break;
				
			case 4:
				System.out.println(magazzino.getListaProdotti());
				break;
			case 5:
				continua = false;
				System.out.println("troverai in magazzino.txt tutti i prodotti aggiornati del magazzino, Arrivederci! ");
				break; 
			default:
				System.out.println("Scelta non valida.");
			}
		}

		scanner.close();

		try {
			SalvaFile.salvaProdotti(magazzino, "magazzino.txt");
		} catch (IOException e) {
			System.out.println("Errore durante il salvataggio dei prodotti su file: " + e.getMessage());

		}
		// Salvataggio dei prodotti su file prima di uscire
		try {
			magazzino.serializzaMagazzino("prodotti.csv");
			System.out.println("Prodotti salvati su file.");
		} catch (IOException e) {
			System.out.println("Errore durante il salvataggio dei prodotti su file: " + e.getMessage());
		}
	}
}