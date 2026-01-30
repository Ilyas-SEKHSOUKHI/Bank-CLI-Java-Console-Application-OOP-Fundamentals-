## 0) Point important avant l’UI (à comprendre)

Actuellement, ton `BankService` / `BankServiceImpl` est fait pour la console : les méthodes n’ont **pas de paramètres** et lisent directement au clavier avec `Scanner`.  

➡️ Donc, pour que Swing soit “propre”, il faut que **l’UI fournisse les valeurs** (id, nom, montant…) et que le service **arrête de demander via Scanner**. (Sinon tu aurais une interface graphique… qui te redemande quand même dans le terminal.)

Garde cette règle simple :

* **UI = saisie + affichage**
* **Service = logique bancaire**
* **Service ne doit pas faire de Scanner** (c’est pour le CLI).  

---

# 1) `MainFrame.java`

### Rôle

La **fenêtre principale** (l’équivalent du menu console). 

### Doit contenir

* Les boutons (ou menus) :

  1. Créer compte courant
  2. Créer compte épargne
  3. Dépôt
  4. Retrait
  5. Afficher un compte
  6. Lister tous les comptes
  7. Quitter 
* Une zone centrale qui affiche `AccountsListPanel` (la liste/tableau).

### Doit faire

* Créer/recevoir une instance de `BankServiceImpl` (ou `BankService`) et la garder.
* Ouvrir les formulaires (`AccountForm`, `DepositForm`, `WithdrawForm`) quand on clique.
* Après une opération réussie : demander à `AccountsListPanel` de **rafraîchir**.

### Ne doit pas faire

* Pas de SQL, pas de règles de découvert, pas de calcul du solde.

---

# 2) `AccountForm.java`

### Rôle

Le formulaire “Créer un compte”.

### Doit contenir (champs)

* `id` (int)
* `ownerName` (String)
* `balance` initial (double)
* Choix de type : **Savings** ou **Current**
* Selon le type :

  * `interestRate` (Savings) 
  * `overdraftLimit` (Current) 

### Doit faire

* Lire les champs.
* Vérifier juste l’UI : champ vide, nombre invalide (pas la logique bancaire).
* Appeler le service pour créer le compte (c’est l’action `createSavingsAccount` / `createCurrentAccount`). 
* Fermer le formulaire et demander le refresh de la liste si succès.
* Sinon afficher un message via `MessageDialog`.

### Ne doit pas faire

* Ne doit pas décider des règles métier.
* Ne doit pas utiliser `Scanner`.

---

# 3) `DepositForm.java`

### Rôle

Formulaire “Dépôt”.

### Doit contenir

* `id_account`
* `amount`

### Doit faire

* Vérifier : `amount` est un nombre et > 0 (validation UI minimale).
* Appeler le service “deposit” (actuellement c’est une action dédiée). 
* Afficher succès/erreur (ex : “id introuvable”). 
* Rafraîchir la liste si succès.

### Ne doit pas faire

* Pas de calcul de solde : c’est le `Account.deposit()` / service. 

---

# 4) `WithdrawForm.java`

### Rôle

Formulaire “Retrait”.

### Doit contenir

* `id_account`
* `amount`

### Doit faire

* Vérifier : `amount` est un nombre.
* Appeler le service “withdraw”. 
* Afficher le résultat :

  * succès
  * ou erreur (id introuvable / montant invalide). 
* Rafraîchir la liste si succès.

### Ne doit pas faire

* Ne doit pas gérer la règle “courant autorise découvert / épargne non”.

  * Cette règle doit rester dans tes classes (`CurrentAccount`/`SavingsAccount`) et ton service. 

---

# 5) `AccountsListPanel.java`

### Rôle

Afficher **tous les comptes** (équivalent de “printAllAccounts”). 

### Doit contenir

* Un tableau (ou liste) avec colonnes :

  * `id`
  * `ownerName`
  * `balance`
  * `type` (Savings / Current)

### Doit faire

* Avoir une méthode “refresh” (conceptuellement) :

  * récupérer la liste des comptes depuis le service
  * mettre à jour le tableau
* Si tu veux afficher “type” :

  * tu détectes si l’objet est un `SavingsAccount` ou `CurrentAccount` (polymorphisme). 

### Ne doit pas faire

* Pas de println
* Pas de logique métier
* Pas de Scanner

---

# 6) `MessageDialog.java`

### Rôle

Centraliser les messages UI (propre et simple).

### Doit faire

* Fournir 2-3 types de messages :

  * succès (“Compte créé”, “Dépôt OK”)
  * erreur (“Id introuvable”, “Montant invalide”)
  * (optionnel) confirmation (“Voulez-vous quitter ?”)

### Pourquoi c’est utile

* Tu évites de répéter 10 fois la même logique de popup dans chaque formulaire.

---

## La “mini-modif” indispensable côté service (pour que Swing marche bien)

Aujourd’hui tes méthodes font la saisie avec `Scanner` (ex: `createSavingsAccount()` demande “Enter your Id”). 
Pour Swing, le service doit **recevoir** ces valeurs au lieu de les demander.

En simple :

* `createSavingsAccount` doit recevoir (id, nom, solde, interestRate)
* `deposit` doit recevoir (id, amount)
* `withdraw` doit recevoir (id, amount)
* et “lister comptes” doit **retourner** une liste au lieu de `System.out.println(...)`. 


