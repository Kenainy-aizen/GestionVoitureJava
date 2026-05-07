# GestionVoitureJava

Application de bureau Java pour la **gestion d'une concession automobile** — clients, voitures, achats, factures et recettes — avec authentification sécurisée et interface graphique Swing.

---

## Sommaire

- [Aperçu](#aperçu)
- [Fonctionnalités](#fonctionnalités)
- [Architecture du projet](#architecture-du-projet)
- [Technologies & Bibliothèques](#technologies--bibliothèques)
- [Prérequis](#prérequis)
- [Configuration de la base de données](#configuration-de-la-base-de-données)
- [Installation & Lancement](#installation--lancement)
- [Structure des sources](#structure-des-sources)
- [Auteur](#auteur)

---

## Aperçu

GestionVoitureJava est une application Java Swing développée sous **NetBeans**. Elle permet de gérer l'ensemble du cycle de vente d'une concession : enregistrement des clients, gestion du parc automobile, saisie des achats, génération de factures PDF et visualisation des recettes mensuelles.

---

## Fonctionnalités

| Module | Description |
|---|---|
| **Authentification** | Connexion sécurisée via nom d'utilisateur et mot de passe vérifiés en base de données |
| **Clients** | Ajout, modification, suppression et recherche des clients |
| **Voitures** | Gestion du catalogue de véhicules (ajout, modification, suppression, filtre par date) |
| **Achats** | Enregistrement des ventes avec association client/voiture, filtre par période |
| **Factures** | Consultation des factures, génération de PDF (iText) et envoi par e-mail (Jakarta Mail) |
| **Recette** | Tableau de bord des recettes accumulées par mois |

---

## Architecture du projet

```
testeLogin1/
├── src/
│   ├── testelogin1/       # Point d'entrée, Login, Accueil, ConnexionBD
│   ├── form/              # Panneaux principaux (clients, voitures, achats, factures, recette)
│   ├── boite/             # Boîtes de dialogue (ajout / modification)
│   ├── component/         # Composants réutilisables (Menu latéral, Header avec recherche)
│   ├── swing/             # Composants Swing personnalisés (Table, MenuItem, panelBorder…)
│   ├── Action/            # Renderers & editors pour les cellules de tableau
│   ├── Model/             # Modèles de données (Model_Menu)
│   ├── event/             # Interface événement (sélection de menu)
│   └── Images/            # Ressources graphiques
├── build/                 # Classes compilées (généré automatiquement)
├── dist/                  # JAR distributable (généré automatiquement)
├── nbproject/             # Fichiers de configuration NetBeans
├── build.xml              # Script Ant de build
└── manifest.mf
```

---

## Technologies & Bibliothèques

| Bibliothèque | Rôle |
|---|---|
| **Java 21** | Langage & plateforme |
| **Java Swing** | Interface graphique |
| **MySQL Connector/J 9.2.0** | Connexion JDBC à MySQL |
| **rs2xml.jar** | Conversion `ResultSet` → modèle de table Swing |
| **SwingX 1.6.5** | Composants Swing étendus |
| **JCalendar 1.4** | Sélecteur de date (`JDateChooser`) |
| **iText 2.1.7** | Génération de fichiers PDF |
| **Jakarta Mail 2.0.1** | Envoi d'e-mails |
| **Jakarta Activation 2.0.1** | Dépendance de Jakarta Mail |
| **JGoodies Common & Looks** | Thème graphique (JCalendar) |

---

## Prérequis

- **JDK 21** ou supérieur
- **NetBeans IDE** (recommandé) — ou tout autre IDE compatible Ant
- **MySQL 8+** en cours d'exécution sur `localhost`
- Les fichiers JAR listés ci-dessus (voir `nbproject/project.properties` pour les chemins)

---

## Configuration de la base de données

1. Créez la base de données `venteVoiture` dans MySQL :

```sql
CREATE DATABASE venteVoiture CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

2. Créez les tables nécessaires (exemple minimal) :

```sql
USE venteVoiture;

CREATE TABLE LOGIN (
    id       INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE CLIENT (
    idcli   INT PRIMARY KEY AUTO_INCREMENT,
    nom     VARCHAR(100),
    mail    VARCHAR(150),
    contact VARCHAR(50)
);

CREATE TABLE VOITURE (
    idvoit      INT PRIMARY KEY AUTO_INCREMENT,
    designation VARCHAR(150),
    prix        DECIMAL(10,2),
    nb          INT
);

CREATE TABLE ACHAT (
    numAchat INT PRIMARY KEY AUTO_INCREMENT,
    idcli    INT,
    idvoit   INT,
    qte      INT,
    date     DATE,
    FOREIGN KEY (idcli)  REFERENCES CLIENT(idcli),
    FOREIGN KEY (idvoit) REFERENCES VOITURE(idvoit)
);

-- Insérez un utilisateur de test
INSERT INTO LOGIN (userName, password) VALUES ('KENAINY', 'KENAINY');
```

3. Si nécessaire, modifiez les identifiants de connexion dans `ConnexionBD.java` :

```java
// src/testelogin1/ConnexionBD.java
Connection conn = DriverManager.getConnection(
    "jdbc:mysql://localhost/venteVoiture", "root", "votre_mot_de_passe"
);
```

---

## Installation & Lancement

### Avec NetBeans

1. Clonez ou téléchargez ce dépôt.
2. Ouvrez NetBeans → **File > Open Project** → sélectionnez le dossier `testeLogin1`.
3. Vérifiez que les bibliothèques JAR sont bien référencées (clic droit sur le projet → **Properties > Libraries**).
4. Lancez le projet avec **F6** ou le bouton **Run**.

### Avec Ant (ligne de commande)

```bash
# Compiler
ant compile

# Lancer
ant run

# Créer le JAR distributable
ant jar
```

Le JAR généré se trouve dans `dist/testeLogin1.jar`.

---

## Structure des sources

```
src/
├── testelogin1/
│   ├── TesteLogin1.java     ← Classe principale (main)
│   ├── Login1.java          ← Formulaire de connexion
│   ├── AccueilGui.java      ← Fenêtre principale après connexion
│   └── ConnexionBD.java     ← Singleton de connexion MySQL
│
├── form/
│   ├── form_client.java     ← Gestion des clients
│   ├── form_voiture.java    ← Gestion des voitures
│   ├── form_achat.java      ← Gestion des achats
│   ├── form_facture.java    ← Factures (PDF + e-mail)
│   ├── form_facture1.java   ← Vue alternative des factures
│   └── form_recette.java    ← Recette mensuelle
│
├── boite/
│   ├── ajoutClient.java     ← Dialogue ajout client
│   ├── modifClient.java     ← Dialogue modification client
│   ├── ajoutVoiture.java    ← Dialogue ajout voiture
│   ├── modifVoiture.java    ← Dialogue modification voiture
│   ├── ajoutAchat.java      ← Dialogue ajout achat
│   └── modifAchat.java      ← Dialogue modification achat
│
├── component/
│   ├── Menu.java            ← Menu latéral de navigation
│   └── header.java          ← En-tête avec barre de recherche
│
└── swing/
    ├── table.java           ← Table personnalisée
    ├── tableHeader.java     ← En-tête de table stylisé
    ├── MenuItem.java        ← Élément de menu cliquable
    ├── ListMenu.java        ← Liste des éléments du menu
    ├── panelBorder.java     ← Panneau avec bordure arrondie
    └── search.java          ← Composant de recherche
```

---

## Auteur

**kenainy** — Projet développé avec NetBeans IDE sur Linux.
