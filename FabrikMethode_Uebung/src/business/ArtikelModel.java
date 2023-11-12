package business;

import java.io.*;

public class ArtikelModel {
	
	private Artikel[] artikel = new Artikel[100];
	private int anzahlArtikel;
	
	public int getAnzahlArtikel() {
		return anzahlArtikel;
	}

	public void setAnzahlArtikel(int anzahlArtikel) {
		this.anzahlArtikel = anzahlArtikel;
	}
	
	public void schreibeArtikelInTxtDatei()
			 throws IOException{
			WriterCreator writerCreator = new ConcreteTxtWriterCreator();
			WriterProduct writer = writerCreator.factoryMethod();
			writer.schreibeArtikel(this.getAnzahlArtikel(), this.artikel);
			}
	
	public void leseArtikelAusCsvDatei()throws IOException{
			ReaderCreator readerCreator = new ConcreteCsvReaderCreator();
			ReaderProduct reader = readerCreator.factoryMethod();
			this.setAnzahlArtikel(reader.leseAnzahlArtikel());
			this.artikel = reader.leseArtikel();
			}
	
			public void schreibeArtikelInKonsole()
			throws IOException{
			WriterCreator writerCreator = new ConcreteKonsoleWriterCreator();
			WriterProduct writer = writerCreator.factoryMethod();
			writer.schreibeArtikel(this.getAnzahlArtikel(), this.artikel);
			}

	
}
