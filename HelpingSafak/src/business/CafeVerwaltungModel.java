package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import gui.CafeVerwaltungView;

public class CafeVerwaltungModel {
	public CafeVerwaltung cafeVerwaltung;
	private CafeVerwaltungView cafeVerwaltungView;

	public void schreibeCafeVerwaltungInCsvDatei() throws IOException {
			BufferedWriter aus = new BufferedWriter(new FileWriter("CafeVerwaltungAusgabe.csv", true));
			aus.write(this.getCafeVerwaltung().gibCafeVerwaltungZuruck(';'));
			aus.close();		
	}	
	
	
	public CafeVerwaltung getCafeVerwaltung() {
		return cafeVerwaltung;
	}


	public void setCafeVerwaltung(CafeVerwaltung cafeVerwaltung) {
		this.cafeVerwaltung = cafeVerwaltung;
	}
	
	
	public void leseAusDatei(String typ) {
		try {
      		if("csv".equals(typ)){
      			 BufferedReader ein = new BufferedReader(new FileReader("CafeVerwaltungAusgabe.csv"));
                 String[] zeile = ein.readLine().split(";");

                 // Alles ab zeile[4] in ein String[] speichern
                 String[] produkte = new String[zeile.length - 4];
                 System.arraycopy(zeile, 4, produkte, 0, produkte.length);
                 
                 // Optional: Falls die Werte in den Produkten durch "_" getrennt sind, können wir das auch splitten
                 for (int i = 0; i < produkte.length; i++) {
                     produkte[i] = produkte[i].replace("_", ";"); // Optional: Ersetze _ mit einem Komma, wenn notwendig
                 }

                 // Erstelle das CafeVerwaltung-Objekt
                 this.cafeVerwaltung = new CafeVerwaltung(
                     zeile[0],          // CafeName
                     zeile[1],          // Ort
                     zeile[2],          // Adresse
                     produkte,          // Array von Produkten
                     Boolean.parseBoolean(zeile[3])  // Boolean-Wert
                 );
      				ein.close();
      				cafeVerwaltungView.zeigeInformationsfensterAn(
      	  	   			"Die KaffeeProdukte wurden gelesen!");
      		}
       		else{
       			cafeVerwaltungView.zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			cafeVerwaltungView.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			cafeVerwaltungView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}

}