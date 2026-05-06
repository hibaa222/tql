package bibtdd;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class interfaceGraphic extends Application {

    private Bibliotheque biblio = new Bibliotheque();

    @Override
    public void start(Stage stage) {

        TextField titleField = new TextField();
        titleField.setPromptText("Titre");

        TextField auteurField = new TextField();
        auteurField.setPromptText("Auteur");

        TextField isbnField = new TextField();
        isbnField.setPromptText("ISBN");

        TextArea output = new TextArea();

        Button addBtn = new Button("Ajouter");
        Button searchBtn = new Button("Rechercher");
        Button deleteBtn = new Button("Supprimer");

        addBtn.setOnAction(e -> {
            Livre l = new Livre(
                titleField.getText(),
                auteurField.getText(),
                isbnField.getText()
            );
            biblio.ajouterLivre(l);
            output.setText("Livre ajouté");
        });

        searchBtn.setOnAction(e -> {
            Livre l = biblio.chercherLivre(isbnField.getText());
            output.setText(l != null ? l.getTitre() + " - " + l.getAuteur() : "Introuvable");
        });

        deleteBtn.setOnAction(e -> {
            biblio.supprimerLivre(isbnField.getText());
            output.setText("Livre supprimé");
        });

        VBox root = new VBox(12,
            titleField,
            auteurField,
            isbnField,
            addBtn,
            searchBtn,
            deleteBtn,
            output
        );

        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 300, 400);
        stage.setTitle("Bibliothèque");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}