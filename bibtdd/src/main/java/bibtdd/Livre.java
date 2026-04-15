package bibtdd;

public class Livre {
	private String titre;
	private String auteur;
	private String isbn;
	
	public Livre(String titre, String auteur, String isbn) {
	    this.titre = titre;
	    this.auteur = auteur;
	    this.isbn = isbn;
	}
	
	public String getTitre() { return titre; }
	public String getAuteur() { return auteur; }
	public String getIsbn() { return isbn; }
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Livre livre = (Livre) o;
	    return isbn.equals(livre.isbn);
	}

	@Override
	public int hashCode() {
	    return isbn.hashCode();
	}

}
