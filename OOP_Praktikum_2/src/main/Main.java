package main;

import javafx.application.Application;
import javafx.stage.Stage;
import main.Buergeraemter.BuergeraemterControl;

public class Main extends Application{
// Gitkey
// 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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		new BuergeraemterControl(primaryStage);
	}

}
