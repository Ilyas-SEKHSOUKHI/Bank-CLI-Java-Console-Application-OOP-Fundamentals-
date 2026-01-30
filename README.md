# Bank Application – UI + Database Version

## 📌 Description
Ce dépôt contient une version améliorée du projet **Bank Application**.

Contrairement aux autres repositories du projet, cette version introduit :
- une **interface graphique (Swing)**
- une **base de données (SQLite)**
- une architecture plus structurée avec **DAO** et **Database**

L’objectif est de séparer clairement :
- l’interface utilisateur
- la logique métier
- l’accès aux données

---

## 🚀 Fonctionnalités
- Créer un compte bancaire (épargne ou courant)
- Effectuer un dépôt
- Effectuer un retrait
- Afficher un compte
- Lister tous les comptes
- Interface graphique avec Swing
- Persistance des données via SQLite

---

## 🗂️ Structure du projet

![Project Structure](Images/project-structure-ui-bd.png)
---

## 🆕 Différences avec les autres repositories

Les autres versions du projet :
- utilisent uniquement la **console (CLI)**
- stockent les données en mémoire (Map / List)
- ne contiennent pas de base de données
- n’ont pas d’interface graphique

👉 **Ce repository ajoute :**
- Swing (UI graphique)
- SQLite (persistance des données)
- DAO (séparation accès BD / logique métier)
- Architecture plus proche d’un projet réel

---
## 🚧 Project Status

⚠️ **This project is currently under development.**

The following features are still in progress:
- Full database integration
- Final DAO implementation
- UI–Service–DAO wiring
- Additional validations and error handling

The structure and architecture are already in place,  
but some parts are not fully implemented yet.


## 🛠️ Technologies utilisées
- Java
- Swing
- JDBC
- SQLite

---

## 🎯 Objectif pédagogique
Ce projet sert à pratiquer :
- la POO (héritage, polymorphisme)
- les interfaces et implémentations
- l’architecture en couches
- la connexion Java ↔ Base de données
- la séparation UI / Service / DAO
