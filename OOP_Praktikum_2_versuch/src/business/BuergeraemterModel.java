package business;

import java.io.IOException;

import factory.ConcreteCreator;
import factory.ConcreteTxtCreator;
import factory.Creator;
import factory.Product;
import factory.TxtCreator;
import factory.TxtProduct;

public class BuergeraemterModel {
	
	public Buergeramt buergeramt;
	
		public void schreibeBuergeraemterInCsvDatei() throws IOException {
			Creator writerCreator = new ConcreteCreator();
			Product writer = writerCreator.factoryMethod();
			writer.fuegeInDateiHinzu(this.buergeramt);
			writer.schliesseDatei();
		}
		public void schreibeBuergeraemterInTxtDatei()throws IOException{
			TxtCreator writerCreator = new ConcreteTxtCreator();
			TxtProduct writer = writerCreator.factoryMethod();
			writer.fuegeInDateiHinzu(this.buergeramt);
			writer.schliesseDatei();
		}
		
		
		public Buergeramt getBuergeramt() {
			return this.buergeramt;
		}

		public void setBuergeramt(Buergeramt buergeramt) {
			this.buergeramt = buergeramt;
		}
}
