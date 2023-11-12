package business;
import java.io.IOException;

public abstract class WriterProduct {
	public abstract void schreibeArtikel(int anzahlArtikel, Artikel[] artikel)throws IOException;
}