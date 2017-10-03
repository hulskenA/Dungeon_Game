<h1 style="text-align:center">PROJET 1 - Conception Orientée Objet<br/>Donjon</h1>

<table>
<tbody>
<tr><td style="border:none" rowspan="2"><img src="http://www.fil.univ-lille1.fr/portail/img/logo-FIL-transparent-site.png" width="300"/></td><th style="border:none">Enseignant responsable du module:<br/>  Romain Rouvoy/Jean-Christophe Routier</th></tr>
<tr><th style="border:none">Enseignant de travaux dirigés:<br/>Jean-Christophe Routier</th></tr>
<tbody>
</table>

## Auteurs: Alexandre HULSKEN - Martin VASILEV

#### L3S5 - Gr.1

> Ce projet portait sur la conception d'un jeu style *Rogue-like*. Le langage utilisé ici a été le Java.

> Ce README permattra de vous expliquer la structure complète de ce projet ainsi que chacun des choix qui ont été fait tout au long de celui-ci. Il vous indiquera aussi comment le compiler et l'utiliser.

---

## Table des matières

1. [Introduction](#1-introduction)
2. [Utilisation](#2-utilisation)
    > + [2.1. Récupération du dépôt](#21-récupération-du-dépôt)
    > + [2.2. La Documentation](#22-la-documentation)
    > + [2.3. La Génération d'éxecutable et son Execution](#23-la-génération-déxecutable-et-son-execution)

3. [Structure du projet](#3-structure-du-projet)
    > + [3.1. Le package principal](#31-le-package-principal)
    > + [3.2. Le package "util"](#32-le-package-util)
    > + [3.3. Le package "places"](#33-le-package-places)
    > + [3.4. Le package "entities"](#34-le-package-entities)

4. [Conception des Objets](#4-conception-des-objets)
    > + [4.1. Notre code](#41-notre-code)
    > + [4.2. Les Design Pathern](#42-les-design-pathern)

---

### 1 - Introduction

Comme il a été précisé précédemment, nous avons dû concevoir un jeu de donjon dans le cadre de ce projet. Les règles de ce jeu étant simple, le joueur parcourt les différentes salles d'un donjon. Lorsqu'il arrive dans une salle, le joueur peut choisir une action à executer parmi la liste des actions possibles à ce moment là. Une salle pouvant contenir des objets et être habitée par un ou plusieurs monstres. Les objets peuvent être utilisés par le joueur. Si le joueur rencontre un monstre, il faudra alors le tuer pour pouvoir quitter la salle qu'il habite. Le monstre sera passif, mais ripostera s'il est attaqué.
L'objectif du jeu est d'atteindre une sortie du donjon, mais s'il meurt avant, le joueur sera considéré comme perdant.

---

### 2 - Utilisation

**Remarque :** Lors de la suite de l'explication qui va suivre, nous allons vous donner des commandes qui necessitent d'avoir certains programmes déjà installé sur votre machine. Nous vous conseillons donc de télécharger `Maven` et `Git`.

<br/>

##### 2.1 - Récupération du dépôt

Afin de pouvoir utiliser notre travail, vous pourrez récupérer l'ensemble de nos codes en faisant un clône de ce dépôt sur votre machine grâce à cette simple commande :

```git
$ git clone https://gitlab-etu.fil.univ-lille1.fr/vasilev/COO-projet1
```

<br/>

##### 2.2 - La Documentation

Comme il est toujours plus utile de lire la documentation d'un objet au lieu d'esssayer de comprendre son fonctionnement en lisant directement son code, vous pouvez le faire également ici. Il vous suffira uniquement de vous placer dans le dossier racine du clône que vous venez de créer et d'utiliser la commande suivante :

```bash
$ mvn javadoc:javadoc
```

Vous pourrez ensuite trouver l'ensemble de la documentation que vous venez de générer dans le dossier *./docs*.

<br/>

##### 2.3 - La Génération d'éxecutable et son Execution

Vous pouvez maintenant vous occuper de la partie la plus amusante, en vous situant dans le dossier racine de ce projet, vous pouvez le compiler et créer un éxecutable par la commande :

```bash
$ mvn package
```

A partir de là, vous pouvez lancer le jeu grâce à la commande suivante :

```bash
$ java -jar target/COO-projet1-1.0-SNAPSHOT.jar
```

<br/>

>**Remarque :** Une fois que vous aurez fini, vous pouvez nettoyer votre dossier des fichiers compilés par la commande :
>```bash
>$ mvn clean
>```

---

### 3 - Structure du projet

Lors de ce projet nous avons structuré nos codes sources selon une certaine arborescence.Comme celle-ci est assez fournis, nous allons découper notre schéma UML en plusieurs parties pour vous le présenter.

Ce procédé à pour but de vous rendre ce diagramme plus facile à lire pour en comprendre son intégralité.

##### 3.1 - Le package principal

![Le package principal](http://www.plantuml.com/plantuml/png/bLFDRjim3BxdAGZqq0HhdFKmO0W20pqiHO6Y6BRZi8DiSGvRML95ELWsz5rspNFanKR9JOAsIzDTB8FaHtuVV_YEh5T1jL0RnNmHOw2gYtXLE_kLVY6y7tXLtwa6uGUPedQkK7g9DdO1uSHGiuXDmDKaVU3t0FeqSB6DkLGjPZl06BnHAmmmXS_vPv3Dxvu63pcg4CasNvnh9JGzPy-HeqTaWx4t34VxhBqh8R9rwKW_rYUUaoLUeCwUoZc3oehp8L4vgBFe8XaucN-SV_XqBcAE0-IXICZ_1HB6zJyXraK4nN1pddLSuox9h2eFvPbDgdAQuxFs4aI2THs30iQmf0YRFz2Yp1l1dA9bR2k3e95t85VTOcH02q5vxq84jSGwXOXD1qVYr1rePs-TBTx4RTkO5-nk4hML572MWLflDkjMWZVh8-JyOiLqto4CPrJYpoaOOUSniBDMMF1P7rWKnMn2vMW7nmWrmdr70kW284T8K-xpf1ogZYHSCkfjsXB-XQuh0t998jd6Pqgs2XA7D9YzCWdTh9Fql7V61Mbp6jA-BIfnWrPHXk-GzbJc9CTCpAcUL_l-91He9SrDrVF412PZpDkLjkpfoOxrjmLfZVRx-C112EJW3e_3Q-Zj4hoQmHoj__0N)

##### 3.2 - Le package "util"

![Le package util](http://www.plantuml.com/plantuml/png/dLHTQzim57tthxXqBmwRm_Om6CFDA2M1GEX2axUo1yM-JKHaoKZNtKV9Vz-LOyjo6rROYorVdVjnZexiZbBNmeeA2YMSko6oSjSGBWkZD_8FmiUa5iLHx16k7gMQ5iPCHVc4cXgBquQake9tYo-Bp_DFy9m0I4re7qM1i3BcA7OA8S-NVN0sQq40xw54LrXPapGwdS1Ns71ZlUVDKyAFTXXOIKUt1sCSsf3tx4YGB4vG73YULcuVaZ-09AmSV_l4V3lpTRV_aSS1jp1s9VIUYVkDdJ4AXUuBHZDk2g4rMgROZPWDhJQtDtTtytlVw8nANWvZKPIScch6i7IJy-iDr3_7EwT70wwP8eN3U2LZtMupxvH-ryW5t2LDlW7-8jIb2yVQYljaPDbtYmyhAnyEiYnH_yWYWHWq7YPh1bYKxejTWaIL6FA6BQUgauVz-VF0P3hgg9iAWdHvFkTljCBxCBWJO66xnLmdtUhwkbzbe4M5WsVxSDQl8dc5KdsprkQjcdra5We6pAZo9DGZSuwChqgdV7_IMokqKuAC3JmYCwxllwyvUMrDZPOakjSG_XKqn9YbVtCN5DK5IfolKw-kfzFD7PdX1PgweJ1bOmtCnZH66ShVpr71ZkN8OP4l1jwj5qz_0G00)

##### 3.3 - Le package "places"

![Le package places](http://www.plantuml.com/plantuml/png/dLHDRzim3BtdLn3jnO6JO3iCA0OtmD2aGu6kA9R3peh4fK9iqv3aO5YN_pvA_cxJnTr5iiX7ylbHbDthl116P21JOUqNvupUbWxl9EKR_HlXmwGGSYzs21S_TRgGH0kX3fYxqk2YI8L4Um6NjrUtdzOVuNa2W7cPmKeRb4vJ3acoPWCQuK_B9UYiI37ZU0klyvMEJVT4Ux5DCMG3U0Zh9gphiFwOXEtwkjhda8iCuJDic7k-gutpQe_XsJgkBOyWKXJHb74jkJgyFKU3HDCw0HK5MUtmH6mC2gqqkWZHquv3vNHK7OUUesSMr8RlHDdx5Ra4-SGjamwDvSJtshhaApE_QQtB6gTGg9kHMFx3h8NSyQ5nvAXtJrig3Jk_YI9f9PW5_csyNMahwO065IEtHAnt8t5FfXUDYaEIg15Rg8vm91ax9Ek5F91MDTfWnWNV4R13r_b2MzvK971PiO2HLt4Saz5mvk6nOoZuLaI-EOpqtoSBdm5nEM_jbUiQ77Fdrh-q2xv-r-91Iq-urT3PgyUq7vfR4wd-sCp0NoFVyjSK7ybQpTUy1LTyD-YIbsF7w3SAJElq3PDcw8VwZfdUqFxExx6LltiXXhzmTjozpFKCnr1fVgu5__k-X5BpSlvdMQd1nd-yu_wLwR_Ya-DV)

##### 3.4 - Le package "entities"

![Le package entities](http://www.plantuml.com/plantuml/png/dLJHQjim57tFLmZouf8vR0-34KOXwzPkK5XO-ZRs8CitjeYiQoGve-lwxxkM5DTEd3RTGr1ohywHTCx9jLkfQsvunOJYrYwTCp9h77mJgDVo3x2tavgBBI-0RQIQ2yGvptUWNMDWJejq4YoRNd-uVl_b7NkOCCOpwmmNBX2o6rx1LSdR2XZBP5Khg0XeH_WQHwLRn2tF57WongPCDCRGXX-85LkmTecDMxc15SgMQy5eYMKw7dJXoa6nG9N7mYIM7lOtVMIbTCa5jNSey-DkWUwhT9_k4-uSQG66TWwVDS3E-jXSGdAwgud5jzSakov6u625aRMJgFlxuiRX9HAr2YzyGnA4RnTnOm7kIInFj5TcnYhSmHqc9cfxSDcU-1xNoUz9rr7g0qgUvrsdkygGby0tPCanq5UBKOoqIoLtGR0CKG7NiQFGGll0KwS5un9NmdVwc4wpErpwpdE6FhPgXool5BydzqCmKrRxdrUyvfbKuO-me51Qzt4fMiSkzpu5NABgpfzww0-zkwEXc54pC1oQmVLdzCyVd1AQ8qaxYlNizLa-aS3G7CylUMi56kYPwqLyUP3CAzJMpudfRxfyEmDU0IP0zNz8xfKSmPw1IPkVfSnpqB_I5ozt9cD-5kDUg-T9EqLJyyGQ0ad0cEYqIVzU7kI0vYH9S5gyTbWF1Zyv3MR31R3U26-5_0S0)

Comme vous pouvez le voir ci-dessus, ce package est imposant, c'est pourquoi nous avons encore fait le choix de décomposer notre diagramme en trois autres parties :

+ **<em style="text-decoration:underline">Les actions</em> :**

  > ![Le package actions](http://www.plantuml.com/plantuml/png/pPHDQm8n48Rl_eh1NYp5q7CHGUb5QA5KUYeznEouExXc93jhiQt_lN5TsG-YRK_RosR9-pBpP3AJR4LsevrUWqbrbar472romPbXEwSFXDlUHfkLZX7wIqgLOLOwsgALtA7o2mbXfhGHOflruUez8K7ux06G5NHBRH0cXGgZqUoqDHuN5e0RCDfEyPujpkp0mHqyCw-l_RfWJb7RqXLvmtGts7ZXATKxT0VBbYdo-hxdFt-WLBbGwb5JYXE97UvAbg82u4lWGvN8H-6tc3-17Xt2Srza6myEol6tq8fZd2WUcFy3WtJDyCXRx9fXdfEXg7ECbwmRX193E4P9q9qTbc3t1jlfOiZgnizTGQWcfv3Dknhchmb54TgtOVa81JnfvMdaRjbSPQkoUblZlQWdR0IhAbAtj8zLcxYwxNm-bQklCGIo11G9AxK9QodD0hJ4gXiRmluR)

+ **<em style="text-decoration:underline">Les objets</em> :**

  > ![Le package items](http://www.plantuml.com/plantuml/png/pLLHQzim47xthpYQbvHYipqCnWY1TgGZ46Z0x6diGRKkzX57CfBSDUlotoVRQImf6bit1lMBnTtdq_TzFkdqbaJ35Dj1KJEjhurHTDyQN1PIvFGTuKq2zcbOiMKbmiM6wgoGCcFy0OLf5MRsHOPGPsHmfozWygsoAtZglmCWOL1jM86mj7cOpPRFWVaSyD6Wu1hEgxR6XbPIRjbzFHO3k0BIdpNoc_sqgTaU5No0TR-ujAi7ITo1SjI5eiQG5DCkdLjneZm23ibnySVQUb9MO4rbPKg5UuTNxrwt0OhIL6lPxUca0IQWZQLWxKYSw0la_5RG035o2CRoXoJWkw8DHhdMpQlZ-adM_6E5raMVQcdZCR8d_FJoxqK8jiDViVyV0dCZY-tYiQYOAD4JUdMU3uJz0zSpBdS2hzNEsiG4fz3nHf4zpeFbOpo59ssOeU80wxiyNzwi5ha5hKYRMNVqvw-eb_8QiUdKHJhg1TGEYVi-xj9VSod_KX7dABwcOoCEUUVCfIg6wa1ZixiO_thfWS6FIjiHFMuKHRfrVJjwU6XHoDNhn2GWdRNPZtdln2dXT_O0y3KxnWJV1zTgc0sOnce7ufqAtdYBpo6OtBw_VRTu6vbffmdbpRMX7Nu2)

+ **<em style="text-decoration:underline">Les monstres</em> :**

  > ![Le package monsters](http://www.plantuml.com/plantuml/png/nLLDRzim3BtxLmZT9S4Qe-ST1dHjqGtjq07PQSCEYipOH6mfaEZkeyj_dsp9hcodBhnvw258yaZgFP8YPNOezrppWecS6tDEf75J4dmGIgxn5x2pQC_5ZgV0JhQOnqAfc2Vt8AdK4Dil90GJ5qeQ0crEsAll6HAmXuWnlZ6akI1tDFleV6eJOw_PGsC_CCaBM2pP6xQsz3ADl8UFMEIVh0abdJ93xjVIUt0Ygsv16TpPZxx8U7KWwC_glBPOxsjxTekRYkHUOUBZ4tIy0KJAYGZrC7Q8XWcjzo2Gvrwb9uGV13Bf6zkaZyMCvAVa9SBLTWk2GfrTDJsgHi4uzVD5xHQEFLdZiP8EMwsaY_99fSLpBUh4Jgw63PZM4Ximsey9wcjTKwOdBWbpEq8vfXcb6dvwZUwwVL75ndg_LphnUAKeG1VB5kqFL8CdO8J6FQ6InymJctE80ddh70i8XDN_vv1qjESzyZij0chxxz-8EsVVAlLuNQf01xnijMyqtu4CH3bWnhHlB7gjDZbsM5hmPTCV29j3L8VXKlDKXGmEc97X7S-rIWC61ypAa5naO7TOoE6W_pYOVzzRtzLL-JN3907vRLMDSctonGfDhY6rDRYheKUJREtZzbDe3bPdrAphjcIhSlNxRUzjY08TbVKHzhUb3xUQkd17xf36bQxoSqFU3_SBQJIqMeZzkAO2mp3RIMiF7vYHmmzHyu8wfv67hTloFm00)

---

### 4 - Conception des Objets

##### 4.1 - Notre code

L'ensemble du cahier des charges a été traité lors de ce projet, mais nous avons voulu pousser notre travail encore plus loin grâce à de nouvelles fonctionnalités :

  + Nous avons créer plusieurs type de monstres différents ayant des capacités spéciales (lorsqu'il meurt et/ou attaque) ou non
  + Nous avons fait le choix d'avoir un traitement un peu différent pour une sortie par rapport à une pièce normale puisqu'il vous sera obligé de battre le Dragon qu'elle contient pour gagner
  + Il est également possible de fouiller les corps des monstres au lieu de gagner directement leur or lorsqu'il meurt
  + Une possibilité de suicide est disponible également au joueur
  + la `LookAction` a de nombreuse autres répercutions que d'afficher une description de la salle, puisqu'il est impossible de bouger, d'utiliser un objet ou de fouiller des corps tant qu'elle n'a pas été faite et si vous attaquez avant, vous perderez des points de vies automatiquement sans toucher aucun monstre.
  + Nous avons créer un objet, le `SleepedBadChest` qui a pour effet de créer un monstre `BadChest` lorsqu'il est utilisé, qui créera ensuite un objet `GoldChest` lorsqu'il meurt (en plus de sa capacité spécial d'attaque)
  + Nous avons finalement aussi implémenté un traducteur qui permet de choisir la langue dans laquelle vous jouez et de ne pas avoir à entrer directement dans les codes `Java` si vous souhaitez changer une traduction.

##### 4.2 - Les Design Pathern

Tout au long de ce projet, nous avons essayé de garder à l'esprit l'essentiel de la *Conception Orientée Objet*, Le principe **SOLID**.

Nous avons donc fait en sorte de garder cette idée de **Single responsibility principle** en ne permettant pas à une méthode de s'occuper de plusieurs traitements différents. Son unique "exception" si nous devions en donner une est la méthode `play()` de l'objet `AdventureGame`, mais comme vous pourrez le voire ci-dessous, nous avons grandement diminuer son nombre de traitements :

```java
public void play() {

  System.out.println(Translator.translate("Welcome"));

  while(!this.isFinished()) {
    System.out.println("\n\n------------------------------------------------");
    /* Print the description of the room by overriding the toString method */
    if (this.player.currentRoom().isDiscoverd())
      System.out.println(this.player.currentRoom().description());
    else
      System.out.println(this.player.currentRoom().toString());

    /* Finding out which actions the player can execute in the current room */
    List<Action> possibleActions = new ArrayList<Action>();
    /* We check whether action is do-able in the current room */
    /* If it is we add it to the list of available actions */
    for (Action a: this.getPlayer().canDo())
      if (a.canBeDoneIn(this.player.currentRoom()))
        possibleActions.add(a);
    System.out.println("------------------------------------------------\n");
    /* We let the player select an action to perform */
    Action a = ListChoser.chose(Translator.translate("AdventureGameAsk"),possibleActions);
    if (a==null)
      System.out.println("\t> "+Translator.translate("AdventureGameAborded"));
    else {
      /* We perform the action */
      a.doneByIn(this.getPlayer(), this.player.currentRoom());
    }
  }

}
```

Nous avons le **Open/closed principle** qui est omniscient dans notre projet puisque qu'il est excessivement simple de pouvoir supprimer une fonctionnalité, comme par exemple une action, où il ne vous suffira simplement d'enlever la ligne correspondante dans le `Main` (`thePlayer.addCapability(new SuicideAction());` si vous souhaitez enlever la possibilité au joueur de se suicider).

Au contraire si vous souhaitez ajouter une fonctionnalité, cela se fait très simplement, par exemple si vous souhaitez ajouter un objet qui a pour effet de tuer tous les monstres de la pièce lorsqu'il est utilisé, vous n'aurez besoin que de créer ce simple fichier :

```java
package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.util.langages.Translator;
import fil.coo.adventure.entities.Player;

public class Bomb extends Item {
	@Override
	public void isUsedBy(Player player) {
    for (GameCharacters g : player.currentRoom().getCharacters()) {
      g.die();
    }
		this.currentRoom().removeItem(this);
		System.out.println("\t> All monsters in this room die");
	}

	public String name() {
		return "Bomb";
	}

	public String toString() {
		return this.name();
	}

	@Override
	public String description() {
		return "Bomb\n\t[this is a bomb]";
	}

}
```

Pour ensuite l'utiliser, il faudra l'ajouter lors de la génération de la carte dans la méthode `generateMap()` se situant dans le `Main`;

> **Rq :** si vous souhaitez garder la propriété de traduction ici, vous devrez remplacer les chaînes de caractères par les codes `Translator.translate(id)` et de faire correspondre cet id (qui sera également une chaîne de caractères) à une autre chaîne dans chaque fichier *.properties* se trouvant dans le dossier racine du projet.

Si vous voulez aussi par exemple ajouter une nouvelle langue, rien de plus simple il faudra créer un nouveau fichier *newLangages.properties* dans le dossier racine dans lequel chacune des traduction se trouvera, et vous devrez ensuite ajouter `NL("newLangages")` dans l'énumération `Langages`.

Le **Liskov substitution principle** est totalement fonctionnel dans notre projet comme nous pouvons le voire par exemple dans la gestion de tous les personnages du donjon, puisque nous pouvons à chaque fois modifier une instance par un fils de celle-ci sans modifier notre cohérence.

  > Par exemple, notre gestion d'attaque se fait sur des objets de type `GameCharacters` mais nous pouvons très bien la remplacer par un `Monster` ou même plus précisément par un `Balrog` pour aller au plus bas de ce jeu d'héritage sans perdere aucune cohérence puisque un monstre est bien sensé attaquer.

Nous avons ensuite l'**Interface segregation principle** présent puisque comme vous pouvez le voire sur le diagramme UML du package `fil.coo.adventure.entities.items`, nous aurions pû implémenter une seule même interface, mais nous avons fait le choix d'implémenter un héritage d'interfaces avec l'interface `Item` qui hérite de `Lookable` ce qui permet de factoriser du code.

Finalement le dernier principe, celui de **Dependency inversion principle** est  présent mais pas pousser à son maximum dans notre gestion des actions puisque l'action que peut effectué un joueur n'est pas directement lié au joueur lui même mais a un traitement indépendant. Nous pourrions le voire de manière beaucoups plus marqué si nous avions fait le choix de créer plusieurs classes de joueurs ayant des traitements différents en fonction d'une action.

 > Par exemple une classe de joueur `Human` qui aurait le même traitement d'action que celui que nous possédons déjà, une class `Dwarf` qui possèderait une place dans ses poches pour un item et qui aurait le choix d'utiliser un item dans sa poche ou celui dans la pièce et finalement une dernière classe `Berserk` qui attaquerait deux fois de suite à chaque tour.
