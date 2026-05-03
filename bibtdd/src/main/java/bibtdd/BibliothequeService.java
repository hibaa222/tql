package bibtdd;

public class BibliothequeService {

    private Bibliotheque bibliotheque;

    public BibliothequeService(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public Livre trouverLivre(String isbn) {
        return bibliotheque.chercherLivre(isbn);
    }
}