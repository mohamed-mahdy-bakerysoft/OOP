package gui.guiFeizeitbaeder;

import java.io.IOException;
import Observer.Observer;
import business.Freizeitbad;
import business.FreizeitbaederModel;
import gui.guiSportstaetten.SportstaettenControl;
import javafx.stage.Stage; 
import ownUtil.PlausiException;

public class FreizeitbaederControl implements Observer
{
	private FreizeitbaederView view;
	private FreizeitbaederModel model;
	// speichert temporaer ein Objekt vom Typ Freizeitbad
    //private Freizeitbad freizeitbad;
    
	public FreizeitbaederControl(Stage primaryStage)
	{
		this.model = FreizeitbaederModel.getInstance();
		this.view = new FreizeitbaederView(this, primaryStage, model);
		model.addObserver(this);
	}
	
    public void nehmeFreizeitbadAuf(String name, String von, String bis, String laenge, String temperatur)
    {
    	try{
    		model.addFreizeitbad(new Freizeitbad(name, von, bis, laenge, temperatur));
    		//this.update();
    		model.notifyObservers();
    		//view.zeigeInformationsfensterAn("Das Freizeitbad wurde aufgenommen!");
       	}
       	catch(PlausiException exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getPlausiTyp() + "er ", exc.getMessage());
     	}
    }
    
   /* public Freizeitbad getFreizeitbad()
    {
    	return freizeitbad;
    }
    */
    void schreibeFreizeitbaederInDatei(String typ)
    {
    	 try{
    		 if("csv".equals(typ))
    		 {
    			 // Aufruf des Models zum Schreiben des
    			 // Freizeitbads in die Datei des vorgegebenen
    			 // Typs und Ausgabe der Meldung
    			 model.schreibeFreizeitbaederInCsvDatei();
    		 }
    		 else
    	 	{
    		 model.schreibeFreizeitbaederInTxtDatei();
    	 	}
    	 	}
    	
    	 catch(IOException exc)
    	 {
    		 view.zeigeFehlermeldungsfensterAn(exc.getCause() + "er ", "IOException beim Speichern!");
    	 }
    	catch(Exception exc)
    	 {
    		view.zeigeFehlermeldungsfensterAn(exc.getCause() + "er ", "Unbekannter Fehler beim Speichern!");
    	}
    }
    
    public void update()
    {
    	view.zeigeFreizeitbaederAn();
    }
}
