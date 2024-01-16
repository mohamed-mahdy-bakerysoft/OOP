package gui.guiStaedtischeEinrichtungen;

import business.buergeramt.BuergeraemterModel;
import business.sporthallen.SporthallenModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class StaedtischeEinrichtungenControl implements Observer {
	private BuergeraemterModel buergeraemterModel;
	private StaedtischeEinrichtungenView staedtischeEinrichtungenView;
	private SporthallenModel sporthallenModel;
	
	public StaedtischeEinrichtungenControl(Stage primaryStage){
		// TODO Auto-generated method stub
		// Singleton
		this.buergeraemterModel = BuergeraemterModel.getInstance();
		this.sporthallenModel = SporthallenModel.getInstance();
		this.staedtischeEinrichtungenView = new StaedtischeEinrichtungenView(this, primaryStage, this.buergeraemterModel, this.sporthallenModel);
		this.buergeraemterModel.addObserver(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.staedtischeEinrichtungenView.zeigeBuergeraemterAn();
	}
}
