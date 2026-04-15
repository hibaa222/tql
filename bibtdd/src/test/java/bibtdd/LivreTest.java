package bibtdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivreTest {
	
	@Test
	void testCreationLivre() {
	    Livre livre = new Livre("1984", "Orwell", "123");

	    assertEquals("1984", livre.getTitre());
	    assertEquals("Orwell", livre.getAuteur());
	    assertEquals("123", livre.getIsbn());
	}
	
	@Test
	void testEgaliteLivresMemeISBN() {
	    Livre l1 = new Livre("Book1", "Author1", "111");
	    Livre l2 = new Livre("Book2", "Author2", "111");

	    assertEquals(l1, l2);
	}

}
