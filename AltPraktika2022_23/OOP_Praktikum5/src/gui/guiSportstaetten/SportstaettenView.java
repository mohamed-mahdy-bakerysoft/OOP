package gui.guiSportstaetten;
   
import java.io.IOException;

import business.businessFreizeitbaeder.FreizeitbaederModel;
import business.businessSporthallen.SporthallenModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class SportstaettenView {
	
	// Hier ergaenzen
	private SportstaettenControl spControl;
	private FreizeitbaederModel freizeitbaederModel;
	private SporthallenModel sporthallenModel;
	private Stage primaryStage;
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane     				       
 		= new  Pane();
    	private Label lblAnzeigeFreizeitbaeder     
 		= new Label("Anzeige Freizeitbäder");
    	private TextArea txtAnzeigeFreizeitbaeder  = new TextArea();
    	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
    	private Label lblAnzeigeSporthallen     
 		= new Label("Anzeige Sporthallen");
    	private TextArea txtAnzeigeSporthallen  = new TextArea();
    	private Button btnAnzeigeSporthallenCsv = new Button("csv-Import Anzeige");
    	private Button btnAnzeigeSporthallenTxt = new Button("txt-Import Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public SportstaettenView(/* Hier ergaenzen … */SportstaettenControl spControl, Stage primaryStage, FreizeitbaederModel freizeitbaederModel, SporthallenModel sporthallenModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von Sportstätten");
    		primaryStage.show();
    		// Hier ergaenzen
    		this.primaryStage = primaryStage;
    		this.spControl = spControl;
    		this.freizeitbaederModel = freizeitbaederModel;
    		this.sporthallenModel = sporthallenModel;
    		
		this.initKomponentenFreizeitbaeder();
		this.initKomponentenSporthallen();
		this.initListener();
    	}
    	private void initKomponentenFreizeitbaeder(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeFreizeitbaeder.setLayoutX(310);
    		lblAnzeigeFreizeitbaeder.setLayoutY(40);
    		lblAnzeigeFreizeitbaeder.setFont(font);
    		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeFreizeitbaeder);    
        	// Textbereich	
        	txtAnzeigeFreizeitbaeder.setEditable(false);
     		txtAnzeigeFreizeitbaeder.setLayoutX(310);
    		txtAnzeigeFreizeitbaeder.setLayoutY(90);
     		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
    		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeFreizeitbaeder);        	
        	// Button
          	btnAnzeigeFreizeitbaeder.setLayoutX(310);
        	btnAnzeigeFreizeitbaeder.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeFreizeitbaeder); 
   }
    	
    	
    	private void initKomponentenSporthallen(){
    		Font font2 = new Font("Arial", 20);
        	lblAnzeigeSporthallen.setLayoutX(30);
    		lblAnzeigeSporthallen.setLayoutY(40);
    		lblAnzeigeSporthallen.setFont(font2);
    		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeSporthallen);    
        	// Textbereich	
        	txtAnzeigeSporthallen.setEditable(false);
     		txtAnzeigeSporthallen.setLayoutX(30);
    		txtAnzeigeSporthallen.setLayoutY(90);
     		txtAnzeigeSporthallen.setPrefWidth(220);
    		txtAnzeigeSporthallen.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeSporthallen);        	
        	// Button
          	btnAnzeigeSporthallenCsv.setLayoutX(5);
        	btnAnzeigeSporthallenCsv.setLayoutY(290);
        	btnAnzeigeSporthallenCsv.setScaleX(0.7);
        	pane.getChildren().add(btnAnzeigeSporthallenCsv);
        	btnAnzeigeSporthallenTxt.setLayoutX(120);
        	btnAnzeigeSporthallenTxt.setLayoutY(290);
        	btnAnzeigeSporthallenTxt.setScaleX(0.7);
        	pane.getChildren().add(btnAnzeigeSporthallenTxt);
    	}
   
   private void initListener() {
	    btnAnzeigeFreizeitbaeder.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeFreizeitbaederAn();
	        	} 
   	    });
	    
	    btnAnzeigeSporthallenCsv.setOnAction(
	 			new EventHandler<ActionEvent>() {
		    		@Override
		        	public void handle(ActionEvent e) {
		            	try {
							zeigeSporthallenAnCsv();
						} catch (IOException | PlausiException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        	} 
	   	    });
	    
	    btnAnzeigeSporthallenTxt.setOnAction(
	 			new EventHandler<ActionEvent>() {
		    		@Override
		        	public void handle(ActionEvent e) {
		            	try {
							zeigeSporthallenAnTxt();
						} catch (IOException | PlausiException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        	} 
	   	    });
    }
   
   public void zeigeFreizeitbaederAn()
   {   
	 if(freizeitbaederModel.getFreizeitbaeder().size() > 0)
   	 {
   		 StringBuffer text = new StringBuffer();
   	
   		 // Ergaenzen: for each – Schleife ueber ArrayList
   	 
   		 freizeitbaederModel.getFreizeitbaeder().forEach(Freizeitbad -> text.append(Freizeitbad.gibFreizeitbadZurueck(' ') + "\n"));
   		 txtAnzeigeFreizeitbaeder.setText(text.toString());
   	 }
   	 
   	 else
   	 {
   		 zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
   	 }
   }
   
   
   public void zeigeSporthallenAnCsv() throws IOException, PlausiException
   {  
	   	 sporthallenModel.leseSporthallenAusCsvDatei();
	   
	   	 if(sporthallenModel.getSporthallen().size() > 0)
	   	 {
	   		 StringBuffer text = new StringBuffer();
	   	
	   		 // Ergaenzen: for each – Schleife ueber ArrayList
	   	 
	   		 sporthallenModel.getSporthallen().forEach(Sporthalle -> text.append(Sporthalle.gibSporthalleZurueck(' ') + "\n"));
	   		 txtAnzeigeSporthallen.setText(text.toString());
	   	 }
	   	 
	   	 else
	   	 {
	   		 zeigeInformationsfensterAn("Bisher wurde keine Sporthalle aufgenommen!");
	   	 }
   }

   public void zeigeSporthallenAnTxt() throws IOException, PlausiException
   {  
	   	 sporthallenModel.leseSporthallenAusTxtDatei();
	   
	   	 if(sporthallenModel.getSporthallen().size() > 0)
	   	 {
	   		 StringBuffer text = new StringBuffer();
	   	
	   		 // Ergaenzen: for each – Schleife ueber ArrayList
	   	 
	   		 sporthallenModel.getSporthallen().forEach(Sporthalle -> text.append(Sporthalle.gibSporthalleZurueck(' ') + "\n"));
	   		 txtAnzeigeSporthallen.setText(text.toString());
	   	 }
	   	 
	   	 else
	   	 {
	   		 zeigeInformationsfensterAn("Bisher wurde keine Sporthalle aufgenommen!");
	   	 }
   }
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(Alert.AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}

