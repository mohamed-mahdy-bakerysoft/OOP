package mvc_uebung;
import javafx.stage.Stage;

public class AnwendersystemControl {
	private AnwendersystemView anwView;
	private AnwendersystemModel anwModel;	
	
	public AnwendersystemControl(Stage primaryStage){
		this.anwModel = new AnwendersystemModel();
		this.anwView = new AnwendersystemView(this, primaryStage,anwModel);
	}
	
	public void schreibeInDatei(String text){
		try{
			this.anwModel.schreibeInDatei(text);
			this.anwView.zeigeInformationsfensterAn("Der Text wurde in die Datei geschrieben.");
		}catch(Exception exc){
			this.anwView.zeigeFehlermeldungAn("Fehler beim Schreiben in die Datei.");
		}
	}
}
