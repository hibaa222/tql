package bibtdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BibliothequeServiceTest {

    @Test
    void testTrouverLivreAvecMock() {

        // 1. create fake Bibliotheque
        Bibliotheque mockBiblio = mock(Bibliotheque.class);

        // 2. fake result
        Livre livre = new Livre("1984", "Orwell", "123");

        // 3. define behavior
        when(mockBiblio.chercherLivre("123")).thenReturn(livre);

        // 4. inject into service
        BibliothequeService service = new BibliothequeService(mockBiblio);

        // 5. test
        Livre result = service.trouverLivre("123");

        assertEquals(livre, result);
    }
}