package business;

import java.io.IOException;

public class ConcreteKonsoleWriterProduct extends WriterProduct{
	public void schreibeArtikel(int anzahlArtikel, Artikel[] artikel)throws IOException{
		System.out.println("Anzahl vorhandener Artikel: "+ anzahlArtikel + "");
		System.out.println("");
		for(int i = 0; i < anzahlArtikel; i++) {
			System.out.println("Artikelnummer: " + artikel[i].getArtikelnummer());
			System.out.println("Artikelname: " + artikel[i].getArtikelname());
			System.out.println("Basispreis: " + artikel[i].getBasispreis());
			System.out.println("");
		}
	}
}