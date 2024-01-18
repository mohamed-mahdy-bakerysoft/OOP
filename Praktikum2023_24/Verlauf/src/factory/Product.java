package factory;

import java.io.IOException;

import business.buergeramt.Buergeramt;

public abstract class Product {
	public abstract void fuegeInDateiHinzu(Buergeramt buergeramt) throws IOException;
	
	public abstract void schliesseDatei() throws IOException;
}
