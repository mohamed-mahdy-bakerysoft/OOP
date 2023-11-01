package MVC_Uebung;
import java.io.*;
public class AnwendersystemModel {
	public AnwendersystemModel(){
	}
	
	public String getUeberschrift(){
		return "Hallo";
	} 
	public void schreibeInDatei(String text)
			throws Exception {
				BufferedWriter aus = new BufferedWriter(new FileWriter("Text.txt"));
				aus.write(text);
				aus.close();
			} 
}