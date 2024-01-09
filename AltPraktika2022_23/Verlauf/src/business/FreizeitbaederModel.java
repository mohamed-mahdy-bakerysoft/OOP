package business;

import java.io.IOException;
import java.util.Vector;
import Observer.Observable;
import Observer.Observer;
import fabrik.ConcreteCreator;
import fabrik.ConcreteTxtCreator;
import fabrik.Creator;
import fabrik.Product;
import fabrik.TxtCreator;
import fabrik.TxtProduct;

public class FreizeitbaederModel implements Observable
{
	private Vector<Observer> observers = new Vector<Observer>();
	//private FreizeitbaederControl control;
	private Freizeitbad freizeitbad;
	private static FreizeitbaederModel fbModel;
	
	private FreizeitbaederModel()
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
	
	public static FreizeitbaederModel getInstance()
	{
		if(fbModel == null)
		{
			fbModel = new FreizeitbaederModel();
		}
		return fbModel;
	}
	
	public void addObserver(Observer obs)
	{
		this.observers.addElement(obs);
	}
	
	public void removeObserver(Observer obs)
	{
		this.observers.removeElement(obs);
	}
	
	public void notifyObservers()
	{
		for(int i = 0; i<this.observers.size(); i++)
		{
			this.observers.elementAt(i).update();
		}
	}

}
 
