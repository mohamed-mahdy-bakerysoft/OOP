package factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import business.Buergeramt;

public class ConcreteTxtProduct extends Product{
	//private PrintWriter aus;
	private BufferedWriter aus;
	@Override
	public void fuegeInDateiHinzu(Buergeramt buergeramt) throws IOException {
		// TODO Auto-generated method stub
		/**
		 Funktrioniert nur bis Praktikum 3
		 * aus = new PrintWriter(new FileWriter("Buergeraemter.txt", true));
		aus.println("Daten des Buergeramts");
		aus.println("Name des Buergeramts: " + buergeramt.getName());
		aus.println("Oeffnungszeit des Buergamts: " + buergeramt.getGeoeffnetVon() + "-" + buergeramt.getGeoeffnetBis());
		aus.println("Strasse und Hausnummer des Buergamts: " + buergeramt.getStrasseHNr());
		aus.println("Dienstleistungen des Buegeramts: " + buergeramt.getDienstleistungenAlsString(';'));
		aus.println();
		 */
		
		aus = new BufferedWriter(new FileWriter("Buergeraemter.txt", true));
		Buergeramt activBuergeramt = buergeramt;
		String buergerAmtAlsString = getBuergeramtAlsString(activBuergeramt, ';');
		aus.write(buergerAmtAlsString);
		aus.flush();
	}
	
	private String getBuergeramtAlsString(Buergeramt buergeramt, char trenner) {
        return "Daten des Bürgeramts" + "\n"
                + "Name des Bürgeramts: " + buergeramt.getName() + "\n"
                + "Öffnungszeit des Bürgeramts: " + buergeramt.getGeoeffnetVon() + " - " + buergeramt.getGeoeffnetBis() + "\n"
                + "Strasse und Hausnummer des Bürgeramts: " + buergeramt.getStrasseHNr() + "\n"
                + "Dienstleistungen des Bürgeramts: " + buergeramt.getDienstleistungenAlsString(trenner) + "\n" + "\n";
    }
	
	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		aus.close();
	}

}