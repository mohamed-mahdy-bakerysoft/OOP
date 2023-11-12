package business;

import java.io.IOException;

public abstract class ReaderProduct {
	public abstract int leseAnzahlArtikel()
			throws IOException;
	
public abstract Artikel[] leseArtikel()
		throws IOException;
}