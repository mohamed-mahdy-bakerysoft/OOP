package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.buergeramt.Buergeramt;

class BuergeramtTest {
	private Buergeramt bgm;
	@BeforeEach
	void setUp() throws Exception {
		String[] arr = new String[2];
        arr[0] = "Hauptwohnsitz";
        arr[1] = "Nebenwohnsitz";
        this.bgm = new Buergeramt("QuerenBurg", 9.0f, 17.0f, "QuerenburgerHöhe256", arr);
	}

	@AfterEach
	void tearDown() throws Exception {
		 this.bgm = null;
	}

	@Test
	void test() {
		 assertTrue(() -> this.bgm.getName().equals("QuerenBurg")); 
	}
	
	@Test
	void test2() {
        Throwable exc= assertThrows(IllegalArgumentException.class,() -> {
        	new Buergeramt("QuerenBurg",9.0f,17.0f,"QuerenburgerHöhe256", null);});
        assertEquals("Dienstleistungen duerfen nicht null sein.", exc.getMessage());
    }
}
