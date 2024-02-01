package ReflextionBeispiel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Anwendung {
	public void gibObjektInKonsoleAus(Object obj) {
		try {
			String klassenname = obj.getClass().getName();
			Field[] attribute = obj.getClass().getDeclaredFields();
			// Ausgabe des Klassennamens
			System.out.println(klassenname);
			// Ausgabe der Attributnamen und Attributwerte
			String hilfe = null;
			String nameGetMethode = null;
			Method getMethode = null;
			for (Field attribut : attribute) {
				hilfe = attribut.getName();
				hilfe = ((char) (hilfe.charAt(0) - 32)) + hilfe.substring(1, hilfe.length());
				nameGetMethode = "get" + hilfe;
				getMethode = obj.getClass().getMethod(nameGetMethode);
				System.out.println(attribut.getName() + ": " + getMethode.invoke(obj));
			}
			// Aufruf der Methode zur Annotation @Ausgabe
			Method[] methoden = obj.getClass().getDeclaredMethods();
			for (Method methode : methoden) {
				if (methode.isAnnotationPresent(Ausgabe.class)) {
					System.out.println("Werte der Attribute als String: " + methode.invoke(obj));
				}
			}
			System.out.println("");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Anwendung anw = new Anwendung();
		Object obj = new Werkzeug(11, 12, "Werkzeugnorm");
		anw.gibObjektInKonsoleAus(obj);
		obj = new Auto("BO YC 123", 125);
		anw.gibObjektInKonsoleAus(obj);
	}
}
