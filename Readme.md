# Cloner le projet

```
git clone https://github.com/aaron101295/microservice-operation
```

# Compiler/builder le projet

```
mvn clean install
```
Cela va nous permettre de g�n�rer un .jar.

# Dockerisation

Construction de l'image Docker � partir du Dockerfile :
```
docker build -f Dockerfile -t microservice-operation . 
```

Lancement de notre image (i.e. de l'application) dans un conteneur :
```
docker run -p 8001:8001 microservice-operation
```
Pour information notre docker se lance sur l'IP 192.168.99.100.


# Exemple de requ�tes

Afficher toutes les operations :
```
GET 192.168.99.100:8001/operation/all
```

Cr�er une operation :
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

Supprimer une op�ration :
```
DELETE 192.168.99.100:8001/operation/supprimer/{id}
```

Modifier une op�ration :
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

Rechercher une op�ration par type :
```
GET 192.168.99.100:8001/operation//byType/{type}
```

Rechercher une op�ration par date:
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

# Exemple de requ�tes

Method	| Path	| Description | Param�tres
------------- | ------------------------- | ------------- |:----------------:|
GET	| /operation/all	| Afficher toutes les op�rations	| | 
POST	| /operation/creer	| Cr�er une operation  | Oui, cf Param�tres | 
DELETE	| /operation/supprimer/{id}	| Supprimer une op�ration	| | 
PUT	| /operation/MAJOperation/{id}	| Modifier une operation | Oui, cf Param�tres | 
GET	| /operation/byType/{type}	| Rechercher une op�ration par type	| | 
GET	| /operation/bydate/{yyyy-MM-dd"}	| Rechercher une op�ration par date	| | 
GET	| /operation/source/{ibansource}/dest/{ibandest} | Rechercher une op�ration par iban source et iban dest	| | 
PUT	| /operation/retirer?montant=?	| Retirer de l'argent | montant | 
PUT	| /operation/virement?montant=?&id1=?&id2=?	| Faire un virement | montant, id1, id2 | 

Param�tres :
```
{
    "id": "xxx",
    "type": "xxx",
    "ibansource": "xxx",
    "ibandest": "xxx",
    "montant": "xxx",
    "date": "yyyy-MM-dd"
}