# NQUEENS-PROBLEM
Problème des N-Queens :
Le problème des N-Queens est un problème classique de placement de reines sur un échiquier de taille N×N, de telle sorte qu'aucune reine ne puisse menacer une autre. Plus précisément, il s'agit de placer N reines sur un échiquier de manière à ce qu'aucune reine ne puisse partager la même ligne, la même colonne ou la même diagonale avec une autre reine.

Description du projet :
Dans ce projet, j'ai tenté de résoudre le problème des N-Queens en utilisant le langage de programmation Java. Mon objectif était de développer un algorithme efficace pour trouver toutes les configurations possibles de placement des reines sur l'échiquier, de manière à satisfaire les contraintes du problème.

Pour résoudre ce problème, j'ai utilisé une approche récursive basée sur la technique du "backtracking". L'idée principale était de placer une reine dans une colonne donnée, puis de passer à la colonne suivante tout en vérifiant si la position actuelle était valide. Si une position ne respectait pas les contraintes, l'algorithme revenait en arrière (backtrack) pour explorer d'autres possibilités.

J'ai implémenté une fonction récursive qui parcourait chaque colonne de l'échiquier et essayait toutes les positions possibles pour placer une reine. Lorsque toutes les reines étaient placées de manière satisfaisante, j'ai enregistré cette configuration comme une solution valide.

Pour améliorer les performances de l'algorithme, j'ai utilisé des techniques d'optimisation telles que l'élagage (pruning) pour éviter d'explorer des branches inutiles de l'arbre de recherche.

En fin de compte, mon projet a réussi à résoudre le problème des N-Queens en trouvant toutes les configurations possibles pour un échiquier de taille donnée. J'ai également ajouté des fonctionnalités supplémentaires, telles que l'affichage des solutions trouvées et la possibilité de spécifier la taille de l'échiquier en tant que paramètre d'entrée.

Ce projet m'a permis de renforcer mes compétences en programmation Java et de comprendre les concepts de backtracking et d'optimisation dans le contexte d'un problème concret.
