# Projet Android 

## Présentation

Le but de ce projet était de réaliser un premier projet dans l'univers du développement mobile. L'objectif était de fournir une application basé sur firebase.

Cette application devait être composée de plusieurs éléments de base : 
- Une page de connexion
- Un RecyclerView
- Une page de détails pour chaque article du RecyclerView

## Quelle API ?

Au début l'application devait se baser sur une API de livres mais n'ayant pas trouvé une API qui me convenait, j'ai décidé d'utiliser une API Yugioh me permettant de recevoir plus de données et une meilleure manipulation de celle-ci dans un environnement mobile.

Voilà le lien API utilisé : https://ygoprodeck.com/api-guide/

Pour des raisons de simplicité, nous avons filtrer la requête API de façon à ne pas recevoir trop de données. Ainsi nous ne recevons que 5 cartes pour l'instant. Il est cependant possible de modifier l'API pour en recevoir bien plus. Vous pourrez retrouver les paramètres de la requête API dans le fichier DataClass API qui détaille l'objet reçu par l'API.

Dans la partie : ""cardinfo.php?banlist=ocg&has_effect=false"", supprimer : &has_effect=false , pour recevoir une centaine de cartes (14000 lignes à la récéption de l'API)

## Les fichiers activités: 

  Activity correspond à la page d'acceuil et de login de notre application.

  Pour le recyclerView : 
  - BookViewHolder.kt --> Gère l'activité interne au RecyclerView, en s'occupant d'afficher les données internes. Il fait également le lien avec la page de détails de chaque item.
  - List_booksActivity.kt --> Contient l'activité qui gère la page possédant le Recycler View. Elle regroupe l'adapter, le viewHolder et gère les paramètres du RecyclerView
  - bookAdapter.kt --> Récupère les données qui seront affichées dans le RecyclerView et permet la mise à jour de celui-ci.

Pour l'API : 
- DataClass API --> Contient le modèle de données que l'on reçoit ainsi que les paramètres de notre requête API
- Service API --> Contient le service qui permet d'initialiser notre requête API à son appel. On y définit également l'URL de base de notre requête.

  Details_Book --> Il s'agit de l'activité permettant de gérer l'affichage de chaque page de détails des items contenus dans le RecyclerVIew
