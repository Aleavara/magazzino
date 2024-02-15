package GestioneMagazzino;

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
	
	//COSTRUTTORE
	public Prodotto(String marca, String modello, int seriale, int quantita, float prezzo, int disponibilita) {
		
		this.marca = marca;
		this.modello = modello;
		this.seriale = seriale;
		this.quantita = quantita;
		this.prezzo = prezzo;
		this.disponibilita = disponibilita;
	}
	
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public Integer getSeriale() {
		return seriale;
	}
	public void setSeriale(int seriale) {
		this.seriale = seriale;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) throws ProdottoException {
		if (quantita < 0) {
            throw new ProdottoException("quantità inammissibile");
        }
		this.quantita = quantita;
	}
	public float getPrezzo() {
		return prezzo;
	}
	  public void setPrezzo(float prezzo) throws ProdottoException {
	        if (prezzo <= 0) {
	            throw new ProdottoException("Il prezzo non può essere negativo o zero");
	        }
	        this.prezzo = prezzo;
	    }
	
	public int getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(int disponibilita) throws Exception {
		if(disponibilita<quantita)
		this.disponibilita = disponibilita;
		else
			throw new Exception("parametro errato");
	}
	public void setEtaMinimaUtilizzo(int eta) throws ProdottoException  {
		if (eta <= 0) {
            throw new ProdottoException("età inammissibile");
        }     
		this.etaMinimaUtilizzo=eta;
	}
	public void setMesiGaranzia(int mesi) throws ProdottoException {
		if (mesi <= 0) {
            throw new ProdottoException("valore errato");
        }
		this.mesiGaranzia=mesi;
	}
	public int getEtaminimaUtilizzo() {
		return this.etaMinimaUtilizzo;
	}
	public int getMesiGaranzia() {
		return this.mesiGaranzia;
	}
	
}

