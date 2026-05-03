package bibtdd;

import java.util.*;

public class Bibliotheque {
    private List<Livre> livres = new ArrayList<>();

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    public void supprimerLivre(String isbn) {
        livres.removeIf(l -> l.getIsbn().equals(isbn));
    }

    public Livre chercherLivre(String isbn) {
        return livres.stream()
                .filter(l -> l.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public List<Livre> listerLivres() {
        return livres;
    }
}