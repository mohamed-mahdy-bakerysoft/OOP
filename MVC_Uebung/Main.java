package mvc_uebung;

import javafx.application.Application;
import javafx.stage.Stage;
	public class Main extends Application {
		@Override
		public void start(Stage primaryStage) {
			new AnwendersystemControl(primaryStage);
		}
		
		public static void main(String[] args) {
			launch(args);
		}
}
