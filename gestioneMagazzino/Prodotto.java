package GestioneMagazzino;

/**
 * Questa classe rappresenta un prodotto nel magazzino.
 * @author avara
 * @version 1.0
 */
public class Prodotto {
    
    //ATTRIBUTI
    private String marca;
    private String modello;
    private Integer seriale;
    private int quantita; //quanti può contenerli
    private float prezzo;
    private int disponibilita; //quanti ce ne sono ora
    private int etaMinimaUtilizzo;
    private int mesiGaranzia;
    
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
    public void setDisponibilita(int disponibilita) throws Exception {
        if(disponibilita<quantita)
            this.disponibilita = disponibilita;
        else
            throw new Exception("parametro errato");
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
    }}