package ReflextionBeispiel;

public class Auto {
	private String kennzeichen; 
	private int ps;
	public Auto(String kennzeichen, int ps) {
		super();
		this.kennzeichen = kennzeichen;
		this.ps = ps;
	}
	public String getKennzeichen() {
		return kennzeichen;
	}
	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	
	
	@Ausgabe 
	public String gibAttributeAn(){
	return this.getKennzeichen() + " " + this.getPs(); 
	} 
	
}
