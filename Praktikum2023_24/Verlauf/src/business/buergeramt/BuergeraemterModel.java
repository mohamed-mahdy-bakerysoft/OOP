package business.buergeramt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import factory.ConcreteCSVCreator;
import factory.ConcreteTxtCreator;
import factory.Creator;
import factory.Product;
import ownUtil.Observable;
import ownUtil.Observer;

public class BuergeraemterModel implements Observable{
	
	// Generics 
	public ArrayList<Buergeramt> buergeramter = new ArrayList<>();
	//public Buergeramt buergeramt;
	
	// Singleton
	private static BuergeraemterModel instance;
	
	// Observer
	private Vector<Observer> observers = new Vector<>(); 
	
		public void schreibeBuergeraemterInCsvDatei() throws IOException {
			Creator writerCreator = new ConcreteCSVCreator();
			Product writer = writerCreator.factoryMethod();
			//writer.fuegeInDateiHinzu(this.buergeramt);
			this.getBuergeramt().forEach(Buergeramt -> {
				try{
					writer.fuegeInDateiHinzu(Buergeramt);
				}catch (IOException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			writer.schliesseDatei();
		}
		
		public void schreibeBuergeraemterInTxtDatei() throws IOException {
			Creator writerCreator = new ConcreteTxtCreator();
			Product writer = writerCreator.factoryMethod();
			//writer.fuegeInDateiHinzu(this.buergeramt);
			this.getBuergeramt().forEach(Buergeramt -> {
				try{
					writer.fuegeInDateiHinzu(Buergeramt);
				}catch (IOException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			writer.schliesseDatei();
		}
		
		public ArrayList<Buergeramt> getBuergeramt() {
			return this.buergeramter;
		}

		public void addBuergeramt(Buergeramt buergeramt){
			buergeramter.add(buergeramt);
		}
		
		/**
		 * public void setBuergeramt(Buergeramt buergeramt) {
			this.buergeramt = buergeramt;
			}
		 */
		// Singleton
		public static BuergeraemterModel getInstance() {		
			if(instance == null) {
				instance = new BuergeraemterModel();
				return instance;
			} 
			return instance;
		}

		@Override
		public void addObserver(Observer obs) {
			// TODO Auto-generated method stub
			observers.addElement(obs);
		}

		@Override
		public void removeObserver(Observer obs) {
			// TODO Auto-generated method stub
			observers.removeElement(obs);
		}

		@Override
		public void notifyObserver() {
			// TODO Auto-generated method stub
			for(Observer current: observers) {
				current.update();
			}
		}

	}