# Projet microservices

Vous trouverez le rapport du projet [ici](https://github.com/aaron101295/microservice-compte/blob/master/Documentation/Rapport/Projet%20microservices%20Aaron%20LELLOUCHE%20Rapha%C3%AAl%20UZAN.pdf).

# Cloner le projet

```
git clone https://github.com/aaron101295/microservice-operation
```

# Compiler/builder le projet

```
mvn clean install
```
Cela va nous permettre de générer un .jar.

# Dockerisation

Construction de l'image Docker à partir du Dockerfile :
```
docker build -f Dockerfile -t microservice-operation . 
```

Lancement de notre image (i.e. de l'application) dans un conteneur :
```
docker run -p 8001:8001 microservice-operation
```
Pour information notre docker se lance sur l'IP 192.168.99.100.

# Exemple de requêtes

Méthod	| Path	| Description | Paramètres
------------- | ------------------------- | ------------- |:----------------:|
GET	| /operation/all	| Afficher toutes les opérations	| | 
POST	| /operation/creer	| Créer une operation  | Oui, cf Paramètres | 
DELETE	| /operation/supprimer/{id}	| Supprimer une opération	| id | 
PUT	| /operation/MAJOperation/{id}	| Modifier une operation | Oui, cf Paramètres | 
GET	| /operation/byType/{type}	| Rechercher une opération par type	| type | 
GET	| /operation/bydate?date=?	| Rechercher une opération par date	| date | 
GET	| /operation/source/{ibansource}/dest/{ibandest} | Rechercher une opération par iban source et iban dest	| ibansource, ibandest| 
PUT	| /operation/retirer?montant=?	| Retirer de l'argent | montant | 
PUT	| /operation/virement?montant=?&id1=?&id2=?	| Faire un virement d'un compte 1 à un compte 2 | montant, id1, id2 | 

Paramètres :
```
{
    "id": "xxx",
    "type": "xxx",
    "ibansource": "xxx",
    "ibandest": "xxx",
    "montant": "xxx",
    "date": "yyyy-MM-dd"
}