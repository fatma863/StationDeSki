# Station de Ski

Application backend de gestion d'une station de ski, développée avec **Java 17**, **Spring Boot 3.5.7** et **Spring Data JPA**. Elle expose une API REST permettant de gérer les skieurs, les moniteurs, les pistes, les cours, les inscriptions et les abonnements.

## Fonctionnalités

- Gestion des skieurs : création, consultation, modification et suppression.
- Gestion des moniteurs.
- Gestion des pistes de ski.
- Gestion des cours.
- Gestion des inscriptions des skieurs.
- Association d'une inscription à un skieur et affectation d'une inscription à un cours.
- Gestion des abonnements.

## Technologies

| Technologie | Utilisation |
|---|---|
| Java 17 | Langage |
| Spring Boot 3.5.7 | Framework backend |
| Spring Web | Création des API REST |
| Spring Data JPA / Hibernate | Persistance et accès aux données |
| MySQL | Base de données |
| Maven | Gestion des dépendances et build |
| Lombok | Réduction du code répétitif |

## Prérequis

Avant de lancer le projet, installez :

- JDK 17 ou une version compatible.
- MySQL Server.
- Git (facultatif, pour cloner le dépôt).
- Un IDE Java comme IntelliJ IDEA, Eclipse ou Spring Tool Suite (facultatif).

## Installation et lancement

### 1. Récupérer le projet

```bash
git clone <URL_DU_DEPOT>
cd Station_De_Ski
```

Ou téléchargez et décompressez l'archive du projet.

### 2. Préparer la base de données

Démarrez MySQL. La configuration actuelle utilise :

- Base de données : `tpstation`
- Hôte : `localhost`
- Port : `3306`
- Utilisateur : `root`
- Mot de passe : vide

La base `tpstation` est créée automatiquement si elle n'existe pas, grâce à `createDatabaseIfNotExist=true`.

Si vos identifiants MySQL sont différents, modifiez les propriétés dans :

`src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tpstation?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
```

### 3. Démarrer l'application

Avec le Maven Wrapper :

**Windows**
```bash
mvnw.cmd spring-boot:run
```

**Linux / macOS**
```bash
./mvnw spring-boot:run
```

Vous pouvez également lancer la classe principale `StationDeSkiApplication` depuis votre IDE.

L'API démarre par défaut sur :

```text
http://localhost:8089
```

## API REST

Toutes les routes sont préfixées par `http://localhost:8089`.

| Ressource | Méthode | Endpoint | Description |
|---|---|---|---|
| Abonnement | GET | `/api/abonnement/allabonnement` | Liste des abonnements |
| Abonnement | GET | `/api/abonnement/{id}` | Consulter un abonnement |
| Abonnement | POST | `/api/abonnement/addabonnement` | Ajouter un abonnement |
| Abonnement | PUT | `/api/abonnement/updateabonnement` | Modifier un abonnement |
| Abonnement | DELETE | `/api/abonnement/deleteabonnement/{id}` | Supprimer un abonnement |
| Cours | GET | `/api/cour/allcours` | Liste des cours |
| Cours | GET | `/api/cour/{id}` | Consulter un cours |
| Cours | POST | `/api/cour/addcours` | Ajouter un cours |
| Cours | PUT | `/api/cour/updatecours` | Modifier un cours |
| Cours | DELETE | `/api/cour/deletecours/{id}` | Supprimer un cours |
| Inscription | GET | `/api/inscription/allinscriptions` | Liste des inscriptions |
| Inscription | GET | `/api/inscription/{id}` | Consulter une inscription |
| Inscription | POST | `/api/inscription/addinscription` | Ajouter une inscription |
| Inscription | PUT | `/api/inscription/updateinscription` | Modifier une inscription |
| Inscription | DELETE | `/api/inscription/deleteinscription/{id}` | Supprimer une inscription |
| Inscription | POST | `/api/inscription/add/{numSkieur}` | Ajouter une inscription et l'associer à un skieur |
| Inscription | POST | `/api/inscription/assign` | Associer une inscription à un cours |
| Moniteur | GET | `/api/moniteur/allmoniteurs` | Liste des moniteurs |
| Moniteur | GET | `/api/moniteur/{id}` | Consulter un moniteur |
| Moniteur | POST | `/api/moniteur/addmoniteur` | Ajouter un moniteur |
| Moniteur | PUT | `/api/moniteur/updatemoniteur` | Modifier un moniteur |
| Moniteur | DELETE | `/api/moniteur/delete/{id}` | Supprimer un moniteur |
| Piste | GET | `/api/piste/allpistes` | Liste des pistes |
| Piste | GET | `/api/piste/{id}` | Consulter une piste |
| Piste | POST | `/api/piste/addpiste` | Ajouter une piste |
| Piste | PUT | `/api/piste/updatepiste` | Modifier une piste |
| Piste | DELETE | `/api/piste/delete/{id}` | Supprimer une piste |
| Skieur | GET | `/api/skieur/allskieurs` | Liste des skieurs |
| Skieur | GET | `/api/skieur/{id}` | Consulter un skieur |
| Skieur | POST | `/api/skieur/addskieur` | Ajouter un skieur |
| Skieur | PUT | `/api/skieur/updateskieur` | Modifier un skieur |
| Skieur | DELETE | `/api/skieur/delete/{id}` | Supprimer un skieur |

### Exemple : affecter une inscription à un cours

Endpoint :

```http
POST /api/inscription/assign
Content-Type: application/json
```

Corps JSON attendu :

```json
{
  "numRegistration": 1,
  "numCourse": 2
}
```

Les identifiants doivent correspondre à des inscriptions et des cours existants.

> **Note sur les requêtes HTTP :** les contrôleurs `CoursController`, `PisteController` et certaines méthodes de `InscriptionController` ne déclarent pas explicitement `@RequestBody` sur leurs paramètres de création ou de modification. Si vous envoyez du JSON depuis Postman ou un frontend, vérifiez ces méthodes et ajoutez `@RequestBody` lorsque c'est le format attendu. Les routes listées reflètent les mappings présents dans le code source.

## Structure du projet

```text
src/
└── main/
    ├── java/org/example/station_de_ski/
    │   ├── controllers/       # Contrôleurs REST
    │   ├── entites/           # Entités JPA et DTO
    │   ├── repositories/      # Accès aux données
    │   ├── services/
    │   │   ├── interfaces/    # Interfaces des services
    │   │   └── implementing/  # Implémentations métier
    │   └── StationDeSkiApplication.java
    └── resources/
        └── application.properties
```

L'architecture sépare les contrôleurs REST, les services métier, les repositories et les entités persistées en base de données.

## Configuration complémentaire

Le fichier `application.properties` contient également :

```properties
server.port=8089
spring.application.name=Station_De_Ski
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

`spring.jpa.hibernate.ddl-auto=update` permet à Hibernate de mettre à jour le schéma selon les entités. Pour un environnement de production, configurez explicitement la base de données, les identifiants et une stratégie de migration adaptée. Ne conservez pas un mot de passe vide en production.

## Tests

Pour exécuter les tests disponibles :

```bash
./mvnw test
```

Sous Windows :

```bash
mvnw.cmd test
```

## Améliorations possibles

- Ajouter une validation des données avec Jakarta Bean Validation.
- Uniformiser l'utilisation de `@RequestBody` dans les endpoints.
- Ajouter une gestion centralisée des exceptions et des réponses HTTP.
- Ajouter Swagger / OpenAPI pour documenter et tester l'API.
- Ajouter des tests d'intégration pour les endpoints et les services.
- Sécuriser les accès et externaliser les secrets de configuration.

---

Projet de gestion d'une station de ski — API backend.
