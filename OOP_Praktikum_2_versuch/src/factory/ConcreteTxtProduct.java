package factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import business.Buergeramt;

public class ConcreteTxtProduct extends Product{
	private PrintWriter aus;
	
	public void fuegeInDateiHinzu(Buergeramt buergeramt) throws IOException{
		aus = new PrintWriter(new FileWriter("Buergeramter.txt", true));
		aus.println("Daten des Buergeramtes");
		aus.println("Name des Buergeramtes:" + buergeramt.getName());
		aus.println("oeffnungszeit des Buergeramtes:" + buergeramt.getGeoeffnetVon() + " - " + buergeramt.getGeoeffnetBis());
		aus.println("Strasse und Hausnummer des Buergeramtes:" + buergeramt.getStrasseHNr());
		aus.println("Dienstleistrungen des Freizeitbades:" + buergeramt.getDienstleistungen());
		aus.println();
	}
	
	public void schliesseDatei() throws IOException{
		aus.close();
	}
}
