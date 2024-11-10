package gui;

import java.io.IOException;

import business.CafeVerwaltungModel;
import javafx.stage.Stage;

public class CafeVerwaltungControl {
	private CafeVerwaltungView cafeVerwaltungView;
	private CafeVerwaltungModel cafeVerwaltungModel;
	
	public CafeVerwaltungControl(Stage primaryStage) {
		this.cafeVerwaltungModel = new CafeVerwaltungModel();
		this.cafeVerwaltungView = new CafeVerwaltungView(this,cafeVerwaltungModel,primaryStage);
		
	
	}
	
	
	 public void leseCafeVerwaltungAusDatei(String typ) {
	        try {
	        	cafeVerwaltungModel.leseAusDatei(typ);
	            cafeVerwaltungView.zeigeInformationsfensterAn("Die Kurse wurden erfolgreich geladen!");
	        } catch (Exception exc) {
	        	cafeVerwaltungView.zeigeFehlermeldungsfensterAn("Fehler beim Laden der Datei: " + exc.getMessage());
	        }
	    }
	
	public void schreibeCafeVerwaltungInDatei() {
		try {
				this.cafeVerwaltungModel.schreibeCafeVerwaltungInCsvDatei();
				cafeVerwaltungView.zeigeInformationsfensterAn("Die KaffeeVerwaltung wurden gespeichert!");
			
		}	
		catch(IOException exc){
			cafeVerwaltungView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			cafeVerwaltungView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

}