package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import fabrik.ConcreteCreator;
import fabrik.ConcreteTxtCreator;
import fabrik.Creator;
import fabrik.Product;
import fabrik.TxtCreator;
import fabrik.TxtProduct;

public class FreizeitbaederModel 
{
	//private FreizeitbaederControl control;
	private Freizeitbad freizeitbad;
	
	public FreizeitbaederModel()
	{
		//this.control = control;
	}
	
	public String getUeberschrift()
	{
		 return "Verwaltung von Freizeitbädern";
	} 
	
	public void schreibeFreizeitbaederInCsvDatei() throws IOException
	{
			// Kreieren eines Creator-Objekts und Abspeicherung mit Hilfe
			// einer Variablen vom Typ der entsprechenden abstrakten
			// Creator-Klasse.
			Creator writerCreator = new ConcreteCreator();
		
		
			// Kreieren eines Product-Objekts mit Hilfe der Factory-
			// Methode des Creator-Objekts und Abspeicherung mit Hilfe
			// einer Variablen vom Typ der entsprechenden abstrakten
			// Product-Klasse.
			Product writer = writerCreator.factoryMethod();
			
			
			writer.fuegeInDateiHinzu(this.freizeitbad);
			writer.schliesseDatei();
	} 
	
	public void schreibeFreizeitbaederInTxtDatei() throws IOException
	{
		TxtCreator writerCreator = new ConcreteTxtCreator();
		TxtProduct writer = writerCreator.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
	}
	
	public Freizeitbad getFreizeitbad()
	{
		return freizeitbad;
	}
	
	public void setFreizeitbad(Freizeitbad freizeitbad)
	{
		this.freizeitbad = freizeitbad;
	}
}
 
