package factory;

import java.io.IOException;

import business.Buergeramt;

public abstract class TxtProduct 
{
	public abstract void fuegeInDateiHinzu(Buergeramt buergeramt) throws IOException;
	
	public abstract void schliesseDatei() throws IOException;
}
