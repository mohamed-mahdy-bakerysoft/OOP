package gui.XYZ;

import business.BuergeraemterModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class XYZControl implements Observer {
	private BuergeraemterModel model;
	private XYZView xyzView;

	public XYZControl(Stage stage) {
		
		this.model = BuergeraemterModel.getInstance();
		this.xyzView = new XYZView(stage,this,  this.model);
		this.model.addObserver(this);

	}

	@Override
	public void update() {
		this.xyzView.zeigeBuergeraemterAn();
	}
}
