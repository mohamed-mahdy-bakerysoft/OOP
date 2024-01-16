package gui.guiStaedtischeEinrichtungen;
   
import java.io.IOException;

import business.buergeramt.BuergeraemterModel;
import business.buergeramt.Buergeramt;
import business.sporthallen.Sporthalle;
import business.sporthallen.SporthallenModel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class StaedtischeEinrichtungenView {
	
	private BuergeraemterModel buergeraemterModel;
	private SporthallenModel sporthallenModel;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeBuergeraemter = new Label("Anzeige Bürgerämter");
	private TextArea txtAnzeigeBuergeraemter = new TextArea();
	// Sporthallen
	private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthallen");
	private TextArea txtAnzeigeSporthallen = new TextArea();
	private Button btnAnzeigeSporthallen = new Button("CSV Import und Anzeige");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public StaedtischeEinrichtungenView(StaedtischeEinrichtungenControl seControl, Stage primaryStage,
			BuergeraemterModel buergeraemterModel, SporthallenModel sporthallenModel) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von städtischen Einrichtungen und Sporthallen");
		primaryStage.show();
		// Hier ergaenzen
		this.buergeraemterModel = buergeraemterModel;
		this.sporthallenModel = sporthallenModel;
		this.initKomponentenBuergeramt();
		this.initKomponentenSporthalle();
		this.initListener();
	}

	private void initKomponentenBuergeramt() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeBuergeraemter.setLayoutX(310);
		lblAnzeigeBuergeraemter.setLayoutY(40);
		lblAnzeigeBuergeraemter.setFont(font);
		lblAnzeigeBuergeraemter.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeBuergeraemter);

		txtAnzeigeBuergeraemter.setEditable(false);
		txtAnzeigeBuergeraemter.setLayoutX(310);
		txtAnzeigeBuergeraemter.setLayoutY(90);
		txtAnzeigeBuergeraemter.setPrefWidth(220);
		txtAnzeigeBuergeraemter.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeBuergeraemter);

	}

	private void initKomponentenSporthalle() {
		Font font = new Font("Arial", 20);
		lblAnzeigeSporthallen.setLayoutX(50);
		lblAnzeigeSporthallen.setLayoutY(40);
		lblAnzeigeSporthallen.setFont(font);
		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeSporthallen);

		txtAnzeigeSporthallen.setEditable(false);
		txtAnzeigeSporthallen.setLayoutX(50);
		txtAnzeigeSporthallen.setLayoutY(90);
		txtAnzeigeSporthallen.setPrefWidth(220);
		txtAnzeigeSporthallen.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeSporthallen);

		btnAnzeigeSporthallen.setLayoutX(50);
		btnAnzeigeSporthallen.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeSporthallen);
	}

	private void initListener() {
		btnAnzeigeSporthallen.setOnAction(ae -> {
			try {
				this.sporthallenModel.leseSporthallenAusCsvDatei();
				zeigeSporthallenAn();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	public void zeigeBuergeraemterAn() {
		if (buergeraemterModel.getBuergeramter() != null) {
			String txt = "";
			for (Buergeramt current : buergeraemterModel.getBuergeramter()) {
				txt += current.gibBuergeramtZurueck(' ');
			}
			txtAnzeigeBuergeraemter.setText(txt);
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Bürgeramt aufgenommen!");
		}
	}

	public void zeigeSporthallenAn() {
		String output = "";
		for (Sporthalle current : this.sporthallenModel.getSporthallen()) {
			output += current + "\n";
		}
		txtAnzeigeSporthallen.setText(output);
	}

	private void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}
}

