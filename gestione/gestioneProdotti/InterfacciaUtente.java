package gestione.gestioneProdotti;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import gestione.salvataggio.SalvaFile;

public class InterfacciaUtente {

	public static void main(String[] args) {

		Magazzino magazzino = new Magazzino();

		try {
			magazzino.deserializzaMagazzino("prodotti.csv");

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Nessun prodotto trovato nel file, il magazzino è vuoto");
		}

		Scanner scanner = new Scanner(System.in);

		boolean continua = true;
		while (continua) {
			try {
			System.out.println("Menu: ");
			System.out.println("1. Aggiungi prodotto");
			System.out.println("2. Visualizza prodotto: ");
			System.out.println("3. Modifica prodotto");
			System.out.println("4. verifica prodotti in scadenza nel magazzino");
			System.out.println("5. Rimuovi tutti i prodotti dal magazzino");
			System.out.println("6. Rimuovi prodotto");
			System.out.println("7. Visualizza tutti i prodotti del tuo magazzino");
			System.out.println("8. Visualizza tutti i nuovi arrivi");
			System.out.println("9. Filtra i prodotti per marca");
			System.out.println("10. Esci (e salva)");
			System.out.print("Scelta: ");
			
			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta) {

			case 1:
				try {
					
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

					int disponibilita;
					do {
						System.out.println("Inserisci la disponibilità (giacenza disponibile al momento");
						disponibilita = scanner.nextInt();
					} while (disponibilita > quantita);

					System.out.println("Inserisci l'eta minima di utilizzo");
					int etaMinima = scanner.nextInt();

					System.out.println("Inserisci i mesi di garanzia");
					int mesiGaranzia = scanner.nextInt();

					System.out.println(
							"Inserisci la data di produzione (assicurati che sia in formato anno-mese-giorno):");
					scanner.nextLine();
					String data = scanner.nextLine();

					System.out.println("Inserisci la data di scadenza (in formato anno-mese-giorno):");
					String dataScadenza = scanner.nextLine();

					Prodotto prodotto = new Prodotto(marca, modello, seriale, quantita, prezzo, disponibilita,
							etaMinima, mesiGaranzia, data, dataScadenza);
					try {
						magazzino.aggiungiProdotto(prodotto);
					} catch (Exception e) {
						System.out.println("prodotto con stesso seriale già esistente. operazione annullata");
					}
				} catch (InputMismatchException e) {
					System.out.println("Input non valido");
				}

				break;
			case 2:
				System.out.println("forniscimi il seriale:");
				int serial = scanner.nextInt();
				if (magazzino.ricercaProdotto(serial) == null)
					System.out.println("prodotto non trovato");
				else {
					System.out.println(
							"prodotto trovato!\n ecco i dettagli: " + magazzino.ricercaProdotto(serial).toString());
					if (magazzino.ricercaProdotto(serial).isGaranziaValida())
						System.out.println("il prodotto ha ancora la garanzia valida");
					else
						System.out.println(
								"la garanzia sul prodotto è scaduta, se hai notato problemi di conformità è troppo tardi per fare il reso al produttore.");
				}
				break;

			case 3:
				System.out.println("ora digitami il seriale del prodotto desiderato: ");
				int serialeModifica = scanner.nextInt();
				if (magazzino.ricercaProdotto(serialeModifica) == null)
					System.out.println("prodotto non trovato");
				else {
					System.out.println("cosa vuoi modificare del prodotto?");
					System.out.println("1. quantità:");
					System.out.println("2. prezzo: ");
					System.out.println("3. disponibilità");
					System.out.println("4. Nulla, esci");

					int sceltaModifica = scanner.nextInt();
					switch (sceltaModifica) {
					case 1:
						System.out.println("Digita la nuova quantità: ");
						int nuovaQuantita = scanner.nextInt();
						try {
							magazzino.ricercaProdotto(serialeModifica).setQuantita(nuovaQuantita);
						} catch (ProdottoException e) {
							e.printStackTrace();
						}
						break;
					case 2:
						System.out.println("Digita il prezzo aggiornato: ");
						float prezzoAggiornato = scanner.nextFloat();
						try {
							magazzino.ricercaProdotto(serialeModifica).setPrezzo(prezzoAggiornato);
						} catch (ProdottoException e) {
							e.printStackTrace();
						}

						break;

					case 3:
						System.out.println(
								"Dimmi quanti prodotti hai venduto e ti aggiorno in automatico la disponibilità: ");
						int prodottiVenduti = scanner.nextInt();
						try {
							magazzino.ricercaProdotto(serialeModifica).aggiornaDisponibilita(prodottiVenduti);
							System.out.println("perfetto! ti sono rimasti "
									+ magazzino.ricercaProdotto(serialeModifica).getDisponibilita()
									+ " pezzi di questo prodotto ;)");

						} catch (ProdottoException e) {
							e.printStackTrace();
						}
						break;

					}

				}

				break;

			case 4:
				magazzino.visualizzaProdottiInScadenza();
				break;

			case 5:
				magazzino.rimuoviTuttiProdotti();
				System.out.println("tutti i prodotti sono stati rimossi con successo");
				break;

			case 6:
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

			case 7:
				System.out.println(magazzino.getListaProdotti());
				break;

			case 9:
				System.out.println("Digita il marchio da ricercare: ");
				String marchioRicerca = scanner.nextLine();
				System.out.println(magazzino.filtraProdotti(marchioRicerca));
				break;
			case 10:
				continua = false;
				System.out
						.println("troverai in magazzino.txt tutti i prodotti aggiornati del magazzino, Arrivederci! ");
				break;
			default:
				System.out.println("Scelta non valida.");
			}
			}
		catch (InputMismatchException e) {
            System.out.println("Input non valido. Assicurati di inserire un numero intero.");
            scanner.nextLine(); // Consuma l'input non valido per evitare un loop infinito
        }}
		
		
		scanner.close();
		try {
			SalvaFile.salvaProdotti(magazzino, "magazzino.txt");
		} catch (IOException e) {
			System.out.println("Errore durante il salvataggio dei prodotti su file: " + e.getMessage());

		}

		try {
			magazzino.serializzaMagazzino("prodotti.csv");
			System.out.println("Prodotti salvati su file.");
		} catch (IOException e) {
			System.out.println("Errore durante il salvataggio dei prodotti su file: " + e.getMessage());
		}
	
}}