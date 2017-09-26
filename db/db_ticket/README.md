# Base de données : db_ticket

Voici les éléments relatifs à la base de données **db_ticket**.



## Détail des fichiers

-   `01_create_db_ticket.sql` : script de création du schéma de la base de données
-   `10_insert_data_db_ticket.sql` : script d'ajout de données de démo dans la base de données
-   `50_clear_db_ticket.sql` : script de purge de la base de données :
    -   supprime toutes les données contenues dans les tables
    -   réinitialise les séquences
-   `MPD_db_ticket.png` : modèle physique de données de la base de données




## Procédures


### Création de la base de données

Exécuter dans l'ordre, les scripts SQL suivants :
1.  `01_create_db_ticket.sql`
2.  `10_insert_data_db_ticket.sql`


### Purge de la base de données

Exécuter le script SQL : `50_clear_db_ticket.sql`


### Réinitialiser les données de la base de données

Exécuter dans l'ordre, les scripts SQL suivants :
1.  `50_clear_db_ticket.sql`
2.  `10_insert_data_db_ticket.sql`

