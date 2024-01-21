package mvc_uebung;
	import java.io.BufferedWriter;
	import java.io.FileWriter;

	import javafx.application.Application;
	import javafx.event.*;
	import javafx.geometry.*;
	import javafx.scene.Scene;
	import javafx.scene.control.*;
	import javafx.scene.control.Alert.AlertType;
	import javafx.scene.layout.*;
	import javafx.stage.Stage;

	public class Anwendersystem extends Application{

		private GridPane grid     = new GridPane();
		private TextField txtTest = new TextField();
		private Button btnTest    = new Button("Test");

		private void initKomponenten(){
		    this.grid.add(this.txtTest, 0, 0);
		    this.grid.add(this.btnTest, 1, 0);
		}	
		
		private void initListener(){
			  btnTest.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		            	  schreibeInDatei(txtTest.getText());
		            }
		      });
		}	
		
		public void schreibeInDatei(String text){
			try{
			    BufferedWriter aus 
		 			= new BufferedWriter(new FileWriter("Text.txt"));
		       	aus.write(text);
		       	aus.close();
		       	zeigeInformationsfensterAn("Der Text wurde in die Datei geschrieben.");
			}
			catch(Exception exc){	   
				zeigeFehlermeldungAn("Fehler beim Schreiben in die Datei.");
			}
		}
		
		
		private void zeigeInformationsfensterAn(String meldung){
		    Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("Information");
		    alert.setContentText(meldung);
			alert.showAndWait();
		}
		    
		private void zeigeFehlermeldungAn(String meldung){
		    Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehlermeldung");
			alert.setContentText(meldung);
			alert.showAndWait();
		}

		
		@Override
		public void start(Stage primaryStage) {
			this.grid.setAlignment(Pos.CENTER);
			this.grid.setHgap(10);
			this.grid.setVgap(10);
			this.grid.setPadding(new Insets(25, 25, 25, 25));
			primaryStage.setTitle("Hallo");
		    Scene scene = new Scene(grid, 350, 150);
			primaryStage.setScene(scene);
	        primaryStage.show();
	        
			this.initKomponenten();
			this.initListener();
		}	
		
		public static void main(String[] args) 
		{
			launch(args);
		}

	}
