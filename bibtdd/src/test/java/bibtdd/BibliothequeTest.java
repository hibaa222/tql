package bibtdd;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DynamicTest;
import java.util.*;
import java.util.stream.*;

public class BibliothequeTest {

    @Nested
    @Tag("ajout")
    class AjoutTests {

        @Test
        @Tag("rapide")
        void testAjoutLivre() {
            Bibliotheque b = new Bibliotheque();
            Livre l = new Livre("1984", "Orwell", "123");

            b.ajouterLivre(l);

            assertEquals(1, b.listerLivres().size());
        }

        @Tag("robustesse")
        @RepeatedTest(5)
        void testAjoutRepete() {
            Bibliotheque b = new Bibliotheque();

            b.ajouterLivre(new Livre("1984", "Orwell", "123"));

            assertEquals(1, b.listerLivres().size());
        }
    }

    @Nested
    @Tag("suppression")
    class SuppressionTests {

        @Test
        @Tag("important")
        void testSuppressionLivre() {
            Bibliotheque b = new Bibliotheque();
            Livre l = new Livre("1984", "Orwell", "123");

            b.ajouterLivre(l);
            b.supprimerLivre("123");

            assertEquals(0, b.listerLivres().size());
        }
    }

    @Nested
    @Tag("recherche")
    class RechercheTests {

        @Test
        @Tag("rapide")
        void testChercherLivreExiste() {
            Bibliotheque b = new Bibliotheque();
            Livre l = new Livre("1984", "Orwell", "123");

            b.ajouterLivre(l);

            assertNotNull(b.chercherLivre("123"));
        }

        @Test
        @Tag("edge-case")
        void testChercherLivreInexistant() {
            Bibliotheque b = new Bibliotheque();

            assertNull(b.chercherLivre("999"));
        }
    }

    @TestFactory
    Collection<DynamicTest> testLivresDynamiques() {

        List<Livre> livres = List.of(
            new Livre("1984", "Orwell", "123"),
            new Livre("Book2", "Author2", "456"),
            new Livre("Book3", "Author3", "789")
        );

        return livres.stream()
            .map(livre ->
                DynamicTest.dynamicTest(
                    "Test livre: " + livre.getTitre(),
                    () -> {
                        assertNotNull(livre.getIsbn());
                        assertNotNull(livre.getAuteur());
                    }
                )
            )
            .collect(Collectors.toList());
    }
}