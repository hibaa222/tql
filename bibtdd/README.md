TP TDD - Gestion de Bibliothèque
Conception et Implémentation

Le développement a été réalisé en binôme en suivant l’approche TDD, ce qui signifie que chaque fonctionnalité a été précédée par l’écriture de tests.

Nous avons implémenté les classes Livre et Bibliotheque avec les opérations principales : ajout, suppression et recherche de livres.
La méthode equals() a été redéfinie dans la classe Livre en se basant sur l’ISBN afin d’assurer une comparaison correcte entre objets, notamment lors des tests.

Démarche TDD et Organisation des tests

Les tests ont été écrits avec JUnit en couvrant à la fois les cas normaux et les cas limites (comme la recherche ou suppression d’un livre inexistant).

Pour améliorer la lisibilité et la structure :

@Nested a été utilisé pour regrouper les tests par fonctionnalité
@Tag permet de classer les tests (rapides, critiques, etc.) et facilite leur exécution sélective selon le contexte
@RepeatedTest sert à vérifier la stabilité du comportement en exécutant plusieurs fois un même test

Les tests paramétrés ont permis d’éviter la duplication du code de test en testant plusieurs entrées avec une seule méthode. Les tests dynamiques ont été utilisés pour générer automatiquement plusieurs scénarios de test.

Tests avancés, outils et interface graphique

Mockito a été utilisé pour simuler certaines dépendances et tester des composants de manière isolée, sans dépendre de l’implémentation réelle de toutes les classes.

JaCoCo a permis de mesurer la couverture de tests afin d’identifier les parties du code exécutées ou non pendant les tests, ce qui aide à améliorer la qualité et la fiabilité globale du projet.

Une interface graphique a été développée avec JavaFX afin de rendre l’application plus interactive et facile à utiliser. Elle permet à l’utilisateur d’ajouter, rechercher et supprimer des livres via des champs de saisie et des boutons.
Cette interface est directement connectée à la classe Bibliotheque, ce qui permet d’exécuter les mêmes fonctionnalités que dans les tests, mais de manière visuelle et interactive. Les données restent en mémoire durant l’exécution de l’application, ce qui signifie qu’elles ne sont pas conservées après la fermeture.