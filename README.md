# Pizza Recipes App - Android Java

## Description
Cette application Android permet de consulter une liste de recettes de pizzas et d'accéder aux détails de chaque préparation. Elle a été conçue avec une architecture modulaire et personnalisée pour garantir l'originalité du code.

## Structure du Projet (Packages)
- **com.example.myrecipeapp.model** : Contient la classe `Pizza` (entité métier).
- **com.example.myrecipeapp.data** : Contient l'interface générique `Repository` pour l'accès aux données.
- **com.example.myrecipeapp.service** : Contient `RecipeManager`, implémentant le pattern Singleton pour la gestion des données en mémoire.
- **com.example.myrecipeapp.adapter** : Contient `PizzaRecipeAdapter`, un adaptateur optimisé avec le pattern `ViewHolder`.
- **com.example.myrecipeapp.ui** : Contient les activités de l'interface utilisateur :
    - `SplashScreenActivity` : Écran de démarrage avec animation.
    - `RecipeListActivity` : Liste des pizzas avec `ListView` et `CardView`.
    - `RecipeDetailActivity` : Détails complets de la recette.

## Fonctionnalités Clés
- **Splash Screen Animé** : Utilisation d'une animation de fondu (`fade_in.xml`).
- **UI Moderne** : Utilisation de `CardView` pour les items de la liste pour un rendu élégant.
- **Optimisation** : Implémentation du `ViewHolder` dans l'adaptateur pour une fluidité accrue du défilement.
- **Navigation** : Passage d'identifiants entre activités via les `Intent`.

## Installation
1. Importer le projet dans Android Studio.
2. S'assurer que les images `pizza1` à `pizza10` sont présentes dans `res/mipmap`.
3. Lancer l'application sur un émulateur ou un appareil physique (API 24+).
