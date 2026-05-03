package bibtdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
	    assertTrue(l1.equals(l2));
	}

	@ParameterizedTest
	@CsvSource({
	    "1984, Orwell, 123",
	    "Book2, Author2, 456",
	    "Book3, Author3, 789"
	})
	void testCreationLivreParam(String titre, String auteur, String isbn) {
	    Livre l = new Livre(titre, auteur, isbn);

	    assertEquals(titre, l.getTitre());
	    assertEquals(auteur, l.getAuteur());
	    assertEquals(isbn, l.getIsbn());
	}

	@ParameterizedTest
	@CsvSource({
	    "111",
	    "222",
	    "333"
	})
	void testEgaliteISBNParam(String isbn) {
	    Livre l1 = new Livre("A", "B", isbn);
	    Livre l2 = new Livre("X", "Y", isbn);

	    assertTrue(l1.equals(l2));
	}
}