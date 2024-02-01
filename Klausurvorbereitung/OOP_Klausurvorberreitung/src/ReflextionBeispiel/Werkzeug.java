package ReflextionBeispiel;

public class Werkzeug {
	private int identnummer; 
	private int basispreis; 
	private String werkzeugart;
	
	
	
	@Ausgabe 
	public String gibAttributeAus(){
	return this.getIdentnummer() + " " 
	+ this.getBasispreis() + " " 
	+ this.getWerkzeugart(); 
	}



	public int getIdentnummer() {
		return identnummer;
	}



	public void setIdentnummer(int identnummer) {
		this.identnummer = identnummer;
	}



	public int getBasispreis() {
		return basispreis;
	}



	public void setBasispreis(int basispreis) {
		this.basispreis = basispreis;
	}



	public String getWerkzeugart() {
		return werkzeugart;
	}



	public void setWerkzeugart(String werkzeugart) {
		this.werkzeugart = werkzeugart;
	}



	public Werkzeug(int identnummer, int basispreis, String werkzeugart) {
		super();
		this.identnummer = identnummer;
		this.basispreis = basispreis;
		this.werkzeugart = werkzeugart;
	} 
}
