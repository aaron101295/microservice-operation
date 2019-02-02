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

Afficher toutes les operations :
```
GET 192.168.99.100:8001/operation/all
```

Créer une operation :
```
POST 192.168.99.100:8001/operation/creer
```
```
{
    "id": "xxx",
    "type": "xxx",
    "ibansource": "xxx",
    "ibandest": "xxx",
    "montant": "xxx",
    "date": "yyyy-MM-dd"
}
```

Supprimer une opération :
```
DELETE 192.168.99.100:8001/operation/supprimer/{id}
```

Modifier une opération :
```
PUT 192.168.99.100:8001/operation/MAJOperation/{id}
```
```
{
    "id": "xxx",
    "type": "xxx",
    "ibansource": "xxx",
    "ibandest": "xxx",
    "montant": "xxx",
    "date": "yyyy-MM-dd"
}
```

Rechercher une opération par type :
```
GET 192.168.99.100:8001/operation//byType/{type}
```

Rechercher une opération par date:
```
GET 192.168.99.100:8001/operation/bydate/{yyyy-MM-dd"}
```

Retirer de l'argent :
```
PUT 192.168.99.100:8001/operation/retirer?montant=?
```

Faire un virement :
```
PUT 192.168.99.100:8001/operation/virement?montant=?&id1=?&id2=?
```

# Exemple de requêtes

Method	| Path	| Description | Paramètres
------------- | ------------------------- | ------------- |:----------------:|
GET	| /operation/all	| Afficher toutes les opérations	| | 
POST	| /operation/creer	| Créer une operation  | Oui, cf Paramètres | 
DELETE	| /operation/supprimer/{id}	| Supprimer une opération	| | 
PUT	| /operation/MAJOperation/{id}	| Modifier une operation | Oui, cf Paramètres | 
GET	| /operation/byType/{type}	| Rechercher une opération par type	| | 
GET	| /operation/bydate/{yyyy-MM-dd"}	| Rechercher une opération par date	| | 
GET	| /operation/source/{ibansource}/dest/{ibandest} | Rechercher une opération par iban source et iban dest	| | 
PUT	| /operation/retirer?montant=?	| Retirer de l'argent | montant | 
PUT	| /operation/virement?montant=?&id1=?&id2=?	| Faire un virement | montant, id1, id2 | 

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