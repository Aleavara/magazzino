package GestioneMagazzino;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Questa classe rappresenta un prodotto nel magazzino.
 * @author avara
 * @version 1.0
 */
public class Prodotto implements Serializable,Comparable<Prodotto>{
    
    //ATTRIBUTI
    private String marca;
    private String modello;
    private Integer seriale;
    private int quantita; //quanti può contenerli
    private float prezzo;
    private int disponibilita; //quanti ce ne sono ora
    private int etaMinimaUtilizzo;
    private int mesiGaranzia;
    private String dataProduzione;
    private String dataScadenza;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /**
     * Costruttore della classe Prodotto.
     * @param marca La marca del prodotto.
     * @param modello Il modello del prodotto.
     * @param seriale Il numero seriale del prodotto.
     * @param quantita La quantità di prodotti.
     * @param prezzo Il prezzo del prodotto.
     * @param disponibilita La disponibilità attuale del prodotto.
     */
    public Prodotto(String marca, String modello, int seriale, int quantita, float prezzo, int disponibilita) {
        
        this.marca = marca;
        this.modello = modello;
        this.seriale = seriale;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.disponibilita = disponibilita;
    }
    
    /**
     * Costruttore della classe Prodotto.
     * @param marca La marca del prodotto.
     * @param modello Il modello del prodotto.
     * @param seriale Il numero seriale del prodotto.
     * @param quantita La quantità di prodotti.
     * @param prezzo Il prezzo del prodotto.
     * @param disponibilita La disponibilità attuale del prodotto.
     * @param etaMinimaUtilizzo L'età minima di utilizzo del prodotto.
     * @param mesiGaranzia I mesi di garanzia del prodotto.
     * @param dataProduzione La data di produzione del prodotto.
     * @param dataScadenza La data di scadenza del prodotto.
     */
    public Prodotto(String marca, String modello, int seriale, int quantita, float prezzo, int disponibilita,
                    int etaMinimaUtilizzo, int mesiGaranzia, String dataProduzione, String dataScadenza) {
        this.marca = marca;
        this.modello = modello;
        this.seriale = seriale;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.disponibilita = disponibilita;
        this.etaMinimaUtilizzo = etaMinimaUtilizzo;
        this.mesiGaranzia = mesiGaranzia;
        this.dataProduzione = dataProduzione;
        this.dataScadenza = dataScadenza;
    }
    
    /**
     * Metodo per ottenere una rappresentazione testuale del prodotto.
     * @return Una stringa che rappresenta il prodotto.
     */
    @Override
    public String toString() {
        return "Prodotto{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", seriale=" + seriale +
                ", quantita=" + quantita +
                ", prezzo=" + prezzo +
                ", disponibilita=" + disponibilita +
                '}';
    }
    
    public String toFileString() {
        return marca + "," +
               modello + "," +
               seriale + "," +
               quantita + "," +
               prezzo + "," +
               disponibilita;
    }
    
    
    //METODI GETTER E SETTER
    
    /**
     * Metodo per ottenere la marca del prodotto.
     * @return La marca del prodotto.
     */
    public String getMarca() {
        return marca;
    }
    
    /**
     * Metodo per impostare la marca del prodotto.
     * @param marca La nuova marca del prodotto.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * Metodo per ottenere il modello del prodotto.
     * @return Il modello del prodotto.
     */
    public String getModello() {
        return modello;
    }
    
    /**
     * Metodo per impostare il modello del prodotto.
     * @param modello Il nuovo modello del prodotto.
     */
    public void setModello(String modello) {
        this.modello = modello;
    }
    
    /**
     * Metodo per ottenere il numero seriale del prodotto.
     * @return Il numero seriale del prodotto.
     */
    public Integer getSeriale() {
        return seriale;
    }
    
    /**
     * Metodo per impostare il numero seriale del prodotto.
     * @param seriale Il nuovo numero seriale del prodotto.
     */
    public void setSeriale(int seriale) {
        this.seriale = seriale;
    }
    
    /**
     * Metodo per ottenere la quantità del prodotto.
     * @return La quantità del prodotto.
     */
    public int getQuantita() {
        return quantita;
    }
    
    /**
     * Metodo per impostare la quantità del prodotto.
     * @param quantita La nuova quantità del prodotto.
     * @throws ProdottoException Se la quantità è negativa.
     */
    public void setQuantita(int quantita) throws ProdottoException {
        if (quantita < 0) {
            throw new ProdottoException("quantità inammissibile");
        }
        this.quantita = quantita;
    }
    
    /**
     * Metodo per ottenere il prezzo del prodotto.
     * @return Il prezzo del prodotto.
     */
    public float getPrezzo() {
        return prezzo;
    }
    
    /**
     * Metodo per impostare il prezzo del prodotto.
     * @param prezzo Il nuovo prezzo del prodotto.
     * @throws ProdottoException Se il prezzo è negativo o zero.
     */
    public void setPrezzo(float prezzo) throws ProdottoException {
        if (prezzo <= 0) {
            throw new ProdottoException("Il prezzo non può essere negativo o zero");
        }
        this.prezzo = prezzo;
    }
    
    /**
     * Metodo per ottenere la disponibilità del prodotto.
     * @return La disponibilità del prodotto.
     */
    public int getDisponibilita() {
        return disponibilita;
    }
    
    /**
     * Metodo per impostare la disponibilità del prodotto.
     * @param disponibilita La nuova disponibilità del prodotto.
     * @throws Exception Se la disponibilità è maggiore della quantità.
     */
    public void setDisponibilita(int disponibilita) throws ProdottoException {
        if(disponibilita<quantita)
            this.disponibilita = disponibilita;
        else
            throw new ProdottoException("parametro errato");
    }
    
    /**
     * Metodo per impostare l'età minima di utilizzo del prodotto.
     * @param eta L'età minima di utilizzo del prodotto.
     * @throws ProdottoException Se l'età è negativa o zero.
     */
    public void setEtaMinimaUtilizzo(int eta) throws ProdottoException  {
        if (eta <= 0) {
            throw new ProdottoException("età inammissibile");
        }     
        this.etaMinimaUtilizzo=eta;
    }
    
    /**
     * Metodo per impostare i mesi di garanzia del prodotto.
     * @param mesi I mesi di garanzia del prodotto.
     * @throws ProdottoException Se i mesi sono negativi o zero.
     */
    public void setMesiGaranzia(int mesi) throws ProdottoException {
        if (mesi <= 0) {
            throw new ProdottoException("valore errato");
        }
        this.mesiGaranzia=mesi;
    }
    
    /**
     * Metodo per ottenere l'età minima di utilizzo del prodotto.
     * @return L'età minima di utilizzo del prodotto.
     */
    public int getEtaminimaUtilizzo() {
        return this.etaMinimaUtilizzo;
    }
    
    /**
     * Metodo per ottenere i mesi di garanzia del prodotto.
     * @return I mesi di garanzia del prodotto.
     */
    public int getMesiGaranzia() {
        return this.mesiGaranzia;
    }

	public String getDataProduzione() {
		return dataProduzione;
	}

	public void setDataProduzione(String dataProduzione) {
		this.dataProduzione = dataProduzione;
	}

	public String getDataScadenza() {
		return dataScadenza;
	}

	 public void setDataScadenza(String dataScadenza) {
	        try {
	            LocalDate.parse(dataScadenza, FORMATTER);
	            this.dataScadenza = dataScadenza;
	        } catch (Exception e) {
	            throw new IllegalArgumentException("Formato data di scadenza non valido. ho bisogno del formato yyyy-MM-dd !!");
	        }
	    }
	
	public boolean isProdottoInScadenza() {
	    // Confronta la data di scadenza con la data attuale
	    LocalDate oggi = LocalDate.now();
	    LocalDate dataScadenzaProdotto = LocalDate.parse(this.dataScadenza); // Assicurati che la dataScadenza sia nel formato corretto (es. "yyyy-MM-dd")
	    
	    // Se la data di scadenza è entro i prossimi 30 giorni dalla data attuale, ritorna true
	    return oggi.plusDays(30).isAfter(dataScadenzaProdotto) && oggi.isBefore(dataScadenzaProdotto);
	}
	
	public float calcolaValoreTotale() {
	    return quantita * prezzo;
	}
	
	public void aggiornaDisponibilita(int quantitaVenduta) throws ProdottoException {
	    if (quantitaVenduta < 0) {
	        throw new ProdottoException("Quantità venduta non valida");
	    }
	    if (quantitaVenduta > quantita) {
	        throw new ProdottoException("Quantità venduta maggiore della disponibilità");
	    }
	    disponibilita -= quantitaVenduta;
	}
	
	public boolean isGaranziaValida() {
	    LocalDate oggi = LocalDate.now();
	    LocalDate fineGaranzia = LocalDate.parse(dataProduzione, FORMATTER).plusMonths(mesiGaranzia);
	    return oggi.isBefore(fineGaranzia);
	}
	
	public void aggiornaPrezzo(float nuovoPrezzo) throws ProdottoException {
	    if (nuovoPrezzo <= 0) {
	        throw new ProdottoException("Il prezzo non può essere negativo o zero");
	    }
	    prezzo = nuovoPrezzo;
	}
	
	public boolean isInEsaurimento(int soglia) {
	    return disponibilita < soglia;
	}
	
	public boolean isDisponibile() {
	    return disponibilita > 0;
	}
	
	public boolean isNuovo() {
	    LocalDate oggi = LocalDate.now();
	    LocalDate dataProduzioneProdotto = LocalDate.parse(dataProduzione, FORMATTER);
	    return oggi.minusMonths(1).isBefore(dataProduzioneProdotto); // Consideriamo nuovo se la data di produzione è entro l'ultimo mese
	}

	@Override
    
    /**
     * Metodo per confrontare due prodotti in base alla loro marca, modello e prezzo.
     * 
     * @param altroProdotto il prodotto da confrontare
     * @return un valore negativo se questo prodotto è "prima" dell'altro, 
     *         un valore positivo se è "dopo", 0 se sono considerati uguali
     */
    public int compareTo(Prodotto altroProdotto) {  //torna 1 se sono diversi, torna 0 se sono uguali
        // Ordinamento per marca
        int confrontoMarca = this.marca.compareTo(altroProdotto.marca);
        if (confrontoMarca != 0) {
            return confrontoMarca;
        }
        
        // Se le marche sono uguali, confronto per modello
        int confrontoModello = this.modello.compareTo(altroProdotto.modello);
        if (confrontoModello != 0) {
            return confrontoModello;
        }
        
        // Se anche i modelli sono uguali, confronto per prezzo
        return Float.compare(this.prezzo, altroProdotto.prezzo);
    }
	
    // Attributi e metodi come nell'esempio precedente...

    // Metodo per la scrittura degli oggetti
    private void writeObject(ObjectOutputStream out) throws IOException {
       out.defaultWriteObject(); // Serializza gli attributi standard
        out.writeObject(dataProduzione); // Serializza la data di produzione
        out.writeObject(dataScadenza); // Serializza la data di scadenza
      
    }

    // Metodo per la lettura degli oggetti
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Deserializza gli attributi standard
        dataProduzione = (String) in.readObject(); // Deserializza la data di produzione
        dataScadenza = (String) in.readObject(); // Deserializza la data di scadenza
    }

	

}