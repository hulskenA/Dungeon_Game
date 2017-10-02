<h1 style="text-align:center">PROJET 1 - Conception Orientée Objet<br/>Donjon</h1>

<table>
<tbody>
<tr><td style="border:none" rowspan="2"><img src="http://www.fil.univ-lille1.fr/portail/img/logo-FIL-transparent-site.png" width="300"/></td><th style="border:none">Enseignant responsable du module:<br/>  Romain Rouvoy/Jean-Christophe Routier</th></tr>
<tr><th style="border:none">Enseignant de travaux dirigés:<br/>Jean-Christophe Routier</th></tr>
<tbody>
</table>

## Auteurs: Alexandre HULSKEN - Martin Vasilev

#### L3S5 - Gr.1

> Ce projet portait sur la conception d'un jeu style *Rogue-like*. Le langage utilisé ici a été le Java.

> Ce README permattra de vous expliquer la structure complète de ce projet ainsi que chacun des choix qui ont été fait tout au long de celui-ci. Il vous indiquera aussi comment le compiler et l'utiliser.

---

## Table des matières

1. [Introduction](#1-introduction)
2. [Utilisation](#2-utilisation)
    + [2.1. Récupération du dépôt](#2.1-recuperation-du-depot)
    + [2.2. La Documentation](#2-2-la-documentation)
    + [2.3. La Génération d'éxecutable et son Execution](#2-3-la-generation-d-executable-et-son-execution)
3. [Structure du projet](#3-structure-du-projet)
    + [2.1. Le package principal](#2.1-le-package-principal)
    + [2.2. Le package "util"](#2-2-le-package-util)
    + [2.3. Le package "entities"](#2-3-le-package-entities)
4. [Conception des Objets](#4-conception-des-objets)


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

```puml
@startuml
skinparam classAttributeIconSize 0
package "fil.coo.adventure" #lightgrey/grey {
  class AdventureGame {
    + {static} TRANSLATOR : Translator
    - player : Player

    + AdventureGame(startingRoom : Room, player : Player)
    + getPlayer() : Player
    + play() : void
    - isFinished() : boolean
  }


  package "fil.coo.adventure.entities" #F8F5E1 {
    abstract class GameCharacters {
      # currentRoom : Room
      # LifePoints : int
      # strength : int
      # gold : int

      + {abstract} die() : void
      + {abstract} attack(theOtherCharacterToAttack : GameCharacters) : void
      + {abstract} name() : String
      + {abstract} description() : String

      + GameCharacters()
      + GameCharacters(lP : int, st : int)
      + getLifePoints() : int
      + moveTo(r : Room) : void
      + currentRoom() : Room
      + getStrength() : int
      + addStrength(st : int) : void
      + getGold() : int
      + addGold(g : int) : void
      + isAlive() : boolean
      + loseLife(st : int) : void
    }

    class Player {
      - playerCapabilities : List<Action>

      + Player(lp : int, sp : int)
      + addCapability(a : Action) : void
      + canDo() : List<Action>
      + die() : void
      + description() : String
      + attack(theOtherCharacterToAttack : GameCharacters) : void
      + name() : String
      + getscore() : int
    }

    package "fil.coo.adventure.entities.actions" #white {
      interface Action <<Interface>> {
        + canBeDoneIn(r : Room) : boolean
        + doneByIn(p : Player, r : Room) : void
      }

      package "fil.coo.adventure.entities.actions.util" #lightgrey {
        class AttackAction {
          + canBeDoneIn(r : Room) : boolean
          + doneByIn(p : Player, r : Room) : void
          + toString() : String
        }

        class LookAction {
          + canBeDoneIn(r : Room) : boolean
          + doneByIn(p : Player, r : Room) : void
          + toString() : String
        }

        class LootAction {
          + canBeDoneIn(r : Room) : boolean
          + doneByIn(p : Player, r : Room) : void
          + toString() : String
        }

        class MoveAction {
          + canBeDoneIn(r : Room) : boolean
          + doneByIn(p : Player, r : Room) : void
          + toString() : String
        }

        class SuicideAction {
          + canBeDoneIn(r : Room) : boolean
          + doneByIn(p : Player, r : Room) : void
          + toString() : String
        }

        class UseAction {
          + canBeDoneIn(r : Room) : boolean
          + doneByIn(p : Player, r : Room) : void
          + toString() : String
        }
      }

      together {
        class AttackAction
        class LookAction
        class LootAction
      }

      together {
        class MoveAction
        class SuicideAction
        class UseAction
      }

      SuicideAction -u[hidden]- Action

      SuicideAction -l[hidden]- MoveAction
      SuicideAction -r[hidden]- UseAction

      AttackAction -u[hidden]- MoveAction
      LookAction-u[hidden]- SuicideAction
      LootAction -u[hidden]- UseAction

      AttackAction .u.|> Action
      LookAction .u.|> Action
      LootAction .u.|> Action
      MoveAction .u.|> Action
      SuicideAction .u.|> Action
      UseAction .u.|> Action

    }


    package "fil.coo.adventure.entities.monstres" #white {
      abstract class Monster {
        + {abstract} name() : String

        + Monster(lP : int, st : int)
        + attack(theOtherCharacterToAttack : GameCharacters) : void
        + die() : void
        + toString() : String
      }

      abstract class SpecialMonsterAttack {
        + {abstract} specialeffect(gm : GameCharacters) : void
        + SpecialMonsterAttack(lP : int, st : int)
        + attack(theOtherCharacterToAttack : GameCharacters) : void
      }

      interface SpecialMonsterDie <<Interface>> {
        + specialeffect() : void
        + die() : void
      }

      package "fil.coo.adventure.entities.monstres.util" #lightgrey {
        class ZombiesHord {
          + ZombiesHord()
          + name() : String
          + description() : String
          + specialeffect(gm : GameCharacters) : void
        }

        class Slime {
          + Slime()
          + name() : String
          + description() : String
          + specialeffect() : void
          + specialeffect(gm : GameCharacters) : void
        }

        class Orc {
          + Orc()
          + name() : String
          + description() : String
        }

        class Looter {
          + Looter()
          + name() : String
          + description() : String
          + specialeffect(gm : GameCharacters) : void
        }

        class Kraken {
          + Kraken()
          + name() : String
          + description() : String
        }

        class KingGoblin {
          + KingGoblin()
          + name() : String
          + description() : String
          + specialeffect(gm : GameCharacters) : void
        }

        class Goblin {
          + Goblin()
          + name() : String
          + description() : String
        }

        class Dragon {
          + Dragon()
          + name() : String
          + description() : String
        }

        class Balrog {
          + Balrog()
          + name() : String
          + description() : String
        }

        class BadChest {
          + BadChest()
          + name() : String
          + description() : String
          + specialeffect() : void
          + specialeffect(gm : GameCharacters) : void
        }

        together {
          class Slime
          class BadChest
        }

        BadChest -l[hidden]- KingGoblin
        BadChest -d[hidden]- Looter
        KingGoblin -d[hidden]- ZombiesHord

        Kraken -u[hidden]- Balrog
        Orc -u[hidden]- Dragon
      }

      Monster -u-|> GameCharacters
      SpecialMonsterAttack -l-|> Monster
      BadChest -d-|> SpecialMonsterAttack
      BadChest .u.|> SpecialMonsterDie
      Balrog -u-|> Monster
      Dragon -u-|> Monster
      Goblin -u-|> Monster
      KingGoblin -d-|> SpecialMonsterAttack
      Kraken -u-|> Monster
      Looter -d-|> SpecialMonsterAttack
      Orc -u-|> Monster
      Slime -u-|> Monster
      Slime .u.|> SpecialMonsterDie
      ZombiesHord -d-|> SpecialMonsterAttack
    }


    package "fil.coo.adventure.entities.items" #white {
      abstract class Item {
        # currentRoom : Room

        + {abstract} isUsedBy(player : Player) : void
        + {abstract} description() : String

        + currentRoom() : Room
        + setRoom(r : Room) : r
      }

      package "fil.coo.adventure.entities.items.util" #lightgrey {
        class StrengthPotion {
          # st : int

          + isUsedBy(player : Player) : void
          + description() : String
          + toString() : String
        }

        class LifePotion {
          # lp : int

          + isUsedBy(player : Player) : void
          + description() : String
          + toString() : String
        }

        class GoldChest {
          # gold : int

          + GoldChest()
          + isUsedBy(player : Player) : void
          + name() : String
          + description() : String
          + toString() : String
        }

        class GoldStockExchange {
          + GoldStockExchange()
          + name() : String
          + description() : String
        }

        class OneArmedBandit {
          # price : int
          - {static} POSSIBLES : List<Item>

          + isUsedBy(player : Player) : void
          + description() : String
          + toString() : String
        }

        class SleepedBadChest {
          + isUsedBy(player : Player) : void
        }
      }
    }

    Item -d[hidden]- GoldChest

    LifePotion -r[hidden]- GoldChest
    GoldChest -r[hidden]- StrengthPotion
    OneArmedBandit -u[hidden]- LifePotion
    OneArmedBandit -r[hidden]- SleepedBadChest
    SleepedBadChest -r[hidden]- GoldStockExchange

    GoldChest -u-|> Item
    GoldStockExchange -u-|> GoldChest
    LifePotion -u-|> Item
    StrengthPotion -u-|> Item
    SleepedBadChest -u-|> GoldChest
    OneArmedBandit -u-|> Item
  }


  package "fil.coo.adventure.places" #F8F5E1 {
    enum Direction <<Enumeration>> {
      N
      S
      E
      W

      - name : String

      + {static} alea() : Direction
      - Direction(name : String)
      + opposite() : Direction
      + description() : String
      + toString() : String
    }

    class Room {
      - {static} descriptions : ArrayList<String>
      # characters : List<GameCharacters>
      # deadCharacterscharacters : List<GameCharacters>
      # items : List<Item>
      # neighbour : Map<Direction, Room>
      # isDiscovered : int

      + {static} generateMap() : Room
      + Room()
      + addCharacter(c : GameCharacters) : void
      + removeCharacter(c : GameCharacters) : void
      + getCharacters() : List<GameCharacters>
      + addDead(dead : GameCharacters) : void
      + removeDead(dead : GameCharacters) : void
      + getDeads() : List<GameCharacters>
      + addItem(item : Item) : void
      + removeItem(item : Item) : void
      + getItems() : List<Item>
      + isExit() : boolean
      + isDiscovered() : boolean
      + discovered() : void
      - addNeighbour(d : Direction, r : Room) : void
      + getPossibleDirections() : Set<Direction
      + getNeighbour(d : Direction) : Room
      + alea() : GameCharacters
      + description() : String
      + toString() : String
    }

    class Exit {
      + Exit()
      + isExit() : boolean
      + description() : String
      + toString() : String
    }
  }


  package "fil.coo.adventure.util" #F8F5E1 {
    interface Lookable <<Interface>> {
      + description() : String
    }

    class ListChooser {
      + {static} chose(msg : String, items : List<T>) : T
      + {static} chose(msg : String, items : List<T>, isForLangages : boolean) : T
    }

    class ScannerInt {
      - {static} SCANNER : Scanner

      + {static} readInt(n : int) : int
      + {static} readInt(n : int, isForLangages : boolean) : int
    }

    class PrintLookable {
      + {static} printList(type : string, items : List<? extends Lookable>) : void
    }

    ListChooser -d[hidden]- ScannerInt
    PrintLookable -u[hidden]- ListChooser
    Lookable -u[hidden]- ScannerInt

    package "fil.coo.adventure.util.langages" #white {
      enum Langages <<Enumeration>> {
        Fr
        En

        - name : String

        + {static} allLangages() : List<Langages>
        - Langages(name : String)
        + toString() : String
      }

      class Translator {
        - PROP : Properties
        - LANG : Langages
        - input : InputStream

        + Translator()
        + translate(str : String) : String
        + close() : void
      }

      ListChooser -u[hidden]- Translator
    }
  }

  Item .|> Lookable
  Room .|> Lookable
  Direction .r.|> Lookable
  GameCharacters .u.|> Lookable
  Exit -u-|> Room
  Player -r-|> GameCharacters
}
@enduml
```

Afin de vous rendre ce diagramme plus facile à lire nous allons le décomposer ensemble pour en voir son intégralité.

##### 3.1 - Le package principal

![Le package principal](http://www.plantuml.com/plantuml/png/ZLDDRnen4BtpAqRg8Q26fRqYj1ANLf4YMX5kLG_UzGGcyTeRZnULHloNNlaT_B6ElNo8H0GkwvNdlPdtPiRyJBPMNbLG6iKy3i5JqGIyAvrzeBy8NpgrAf_L7E6HJ5OwboczH1iQZ_39q7mHvXvNW_Y1rmwqQM2yntnN5QPxWC_moa45AjSmcuud3_VZsOyf367cbMMZWlC9reVQg1LwYVnCFvqT-oHdLrBvG7O-TQuIQ3nktp9xE-OSGtlHxHspjg78IBTBHtfNd_WRMU85wXGfd3Eeh0JNKShPTcHD82DUBmFbe438Lu55ONa2jIuWA8R9rwJt7W_aKP6Vuuy6HJvC-EGn1v5gNSEWWD4lAS3s7rGeuqSmDsWPgy8WQEG3oHLF61ZGWbTrxNm0jSGoGkHEUqSIr0rePv-SpQxIjc_4EtMJA6qb1PnbeAessqqbuEtcWhXwiM9wQH2w8yhnpn2CgAlHixDMLF1j2yooR3IWl7UWOu0IuQKX8JGUa0F4QRPvOWvL1X8jYNMTjyX_v-lEW3miiMp36oTx1r537CpHcK2tcsWzxPTnNjeSXtHiYuhQe5AKw0UclP4voTicvbYlLiV-H1PeUNSGgwU92Kt6cBOhRjdf2-xhNmlI6ktl_fd55yhPtUtxZzZx9VWmWxbOV_qV)

```puml
skinparam classAttributeIconSize 0
package fil.coo.adventure #lightgrey/grey {
  class AdventureGame {
    + {static} TRANSLATOR : Translator
    - player : Player

    + AdventureGame(startingRoom : Room, player : Player)
    + getPlayer() : Player
    + play() : void
    - isFinished() : boolean
  }

  package fil.coo.adventure.util {

  }

  package fil.coo.adventure.entities {

  }

  package fil.coo.adventure.places {

  }

  note as N1
    Le package <b>fil.coo.adventure.places</b>:
        -> il nous a servit à mettre l'ensemble des
        objets en rapport avec des endroits du donjon.
    Le package <b>fil.coo.adventure.entities</b>:
        -> Nous y avons implémenté l'ensemble des
        objets physique (<i>ex: les personnages, objet...</i>)
        et ce qui leur est utile (<i>les actions</i>).
    Le package <b>fil.coo.adventure.util</b>:
        -> Il contient l'ensemble des objets qui nous
        ont été util lors de l'implémentation mais qui
        n'apparaissent pas physiquement dans le donjon
  end note

  AdventureGame -d[hidden]- fil.coo.adventure.util
  fil.coo.adventure.places -r[hidden]- fil.coo.adventure.entities
  fil.coo.adventure.places -l[hidden]- fil.coo.adventure.util
}
```

##### 3.2 - Le package "util"

![Le package util](http://www.plantuml.com/plantuml/png/dLDDYzim4BtxLmpRYqFhq1uAfPYKi2Gb4DAmoQtqeCYpYOWi6KdUVYpvxnqviYntbrtenH-ZDpDltZpPir0DCwm6BfcrS-UCEBGELrohdVY3y3vh63-p8yBDlP1JhlMKLG-eN6jmsZeXR-3DyjFou-83F6O0GZaqzumZhBK-iuD4ACjL7vpDEX30MwZGSYCQ9xJA9_0PTjHO7Udmaj6Z8mDhOTtjIMkB9kOzMiUSu1VW9uhdjJt6v7SW7DQM_drYkP_vkll_oAE0NMgpPkf8W_k3WzOIcUeB9Xntd2c5XaOC58kXrUvsljaixdoZAohxbun1Lb5ghWX3qaskhrTGBzAxfYS4jpIYYyju8cFJ7TFSkVlT81Mmpsdo1V2NGrNPkDPEt0SjghvRkgoY-duILONgHv48HA0ncQ8TO4cwB_OS9Ab4a5TiEPL17lBdpnCD4qP7rTOGfIlB1VsZOTw7qPq0InC-5YeBNmKeLkFWr11Ef6HIzeKxItVAzP5PB1CnetgJMC_fQsHyBOBA_LRtXYahcTCcSYvWU_TjIpbReniqJg0TUiutNpsZq3h6wVAtZWvM_aszaDN3O4EFF64NWfYJKGRsOweUoAM_PubBuWGZfoJx7Vfrdhhy1G00)

```puml
@startuml
skinparam classAttributeIconSize 0
package "fil.coo.adventure.util" #F8F5E1 {
  interface Lookable <<Interface>> {
    + description() : String
  }

  class ListChooser {
    + {static} chose(msg : String, items : List<T>) : T
    + {static} chose(msg : String, items : List<T>, isForLangages : boolean) : T
  }

  class ScannerInt {
    - {static} SCANNER : Scanner

    + {static} readInt(n : int) : int
    + {static} readInt(n : int, isForLangages : boolean) : int
  }

  class PrintLookable {
    + {static} printList(type : string, items : List<? extends Lookable>) : void
  }

  ListChooser -d[hidden]- ScannerInt
  PrintLookable -u[hidden]- ListChooser
  Lookable -u[hidden]- ScannerInt

  package "fil.coo.adventure.util.langages" #white {
    enum Langages <<Enumeration>> {
      Fr
      En

      - name : String

      + {static} allLangages() : List<Langages>
      - Langages(name : String)
      + toString() : String
    }

    class Translator {
      - PROP : Properties
      - LANG : Langages
      - input : InputStream

      + Translator()
      + translate(str : String) : String
      + close() : void
    }

    ListChooser -u[hidden]- Translator
  }
}
@enduml
```

##### 3.2 - Le package "places"

![Le package places](http://www.plantuml.com/plantuml/png/hLHHQzim47xFhpZQ5uVKPdiOZ642PKb6eIjZUTYp8bqT4LioaXpQTVtlEycE73SfTSTUREk-x-u-VMV9xgIgcM4Ly99PU-sSaPl6uGtNQYr_8toOr8plM85mSI_BZ6kTCR57vHg3MLqoZlO2BbUVLv-M7-5f0e2ggM0X3N8djO8yNr803VEh-JnG0Ex2SnsUo_3yDGcl51Ih4Bx0ceIeeWtEuCawAi2VWPN8aYdXiKEN5jV9eC2qAw3hMblfy4pk30HQRcGTigTzxnPqkbqEaMUlB5W6FxMkkcsblT2ZcfOIhurXZxVIkhmjCG_yI-1RCfyxD9uKy6ya_skC7dW2cUYZOxDemrMatD3Y02YKnNQZ6qFWTrRdqP6hi9sORnVIShr7WuAOKhcJWHIe_72HgWI7V7h7yP_9OG1CzFeJJiIXOf-wrr9qR8CLTNr7Ge6knuAGLsq9MXRaP-9D7QTaD9rqUEuO2NuUYPyGCVttsSPlaAYTZnwrwwSye_4j7wGBs4PhEZag0lrSpy1Y2CP-gPTzT_Xr4d5ybAx0TDC_bVX3Moit9KPogtUDBdzv58dzIeCNFrUy28R-_fSJxLthJlGCMWlVSlHV6uPMQPF-cRURes2uJx8i8_RfZTiu2jrglMFavwI_PaVn_m80)

```puml
@startuml
skinparam classAttributeIconSize 0
package "fil.coo.adventure.places" #F8F5E1 {
  enum Direction <<Enumeration>> {
    N
    S
    E
    W

    - name : String

    + {static} alea() : Direction
    - Direction(name : String)
    + opposite() : Direction
    + description() : String
    + toString() : String
  }

  class Room {
    - {static} descriptions : ArrayList<String>
    # characters : List<GameCharacters>
    # deadCharacterscharacters : List<GameCharacters>
    # items : List<Item>
    # neighbour : Map<Direction, Room>
    # isDiscovered : int

    + {static} generateMap() : Room
    + Room()
    + addCharacter(c : GameCharacters) : void
    + removeCharacter(c : GameCharacters) : void
    + getCharacters() : List<GameCharacters>
    + addDead(dead : GameCharacters) : void
    + removeDead(dead : GameCharacters) : void
    + getDeads() : List<GameCharacters>
    + addItem(item : Item) : void
    + removeItem(item : Item) : void
    + getItems() : List<Item>
    + isExit() : boolean
    + isDiscovered() : boolean
    + discovered() : void
    - addNeighbour(d : Direction, r : Room) : void
    + getPossibleDirections() : Set<Direction
    + getNeighbour(d : Direction) : Room
    + alea() : GameCharacters
    + description() : String
    + toString() : String
  }

  class Exit {
    + Exit()
    + isExit() : boolean
    + description() : String
    + toString() : String
  }

  Exit -u-|> Room
}

Room ...() fil.coo.adventure.util.Lookable
Direction ...() fil.coo.adventure.util.Lookable
@enduml
```

##### 3.3 - Le package "entities"

![Le package entities](http://www.plantuml.com/plantuml/png/fLDDQzmm4BtxLmZsuf1wIG-54afWoHU1GfTkRgM7MMbYYyYIaUGjQRh_lMD9TjORfzac1oDxPjwRqPjdTozr0nPgnXKuj_3UodNhyOORlPA_aPra3V1xA97TIJNdnin1R53xrkAS3kabEZQx-dprwV8ZUymOWxNp5hYFXEmQQZole8kWTQ62iHdZhRK4_svCpKvPTwJ4Ltc7IoErTnId8uM94tNfgr6mD4gaG8WSiyU--vO9YVaHPJT6YkTPy9wkbViAlz5ZXmblpI9a23YU_6KgJNMXqugqq-N49EYubOsNHk_MfS9nc_neEgoMyQ8VI8durXUMw9yq2_ozGCUiDXkyDRbD4k_TOMS70JTi8P2kak9xb234a1b66VCI-9esynmOekKaHhg5afkeuzeOXQ1JHXc7tGMdkcqx4QFFbWeUq2P_5Qm9d-VGm5ggQD9JyfRpNnQyMyHPBt_4vQePz6t6-jBS0yr33fIC3FjYWhumOVnHbvYSyE8BfaWzt-dEQKlINXmt5dSM4mHy_GUVrqQxyF_EVbNI8ydy7s02r6z3Gb1n0di0fcX_L588r3-BLuSxa54SnDXhzM_IGT72Fh56Cn8mkRbeYpzdUwlEicpx5m00)

```puml
@startuml
skinparam classAttributeIconSize 0
package fil.coo.adventure.entities #F8F5E1 {
  abstract class GameCharacters {
    # currentRoom : Room
    # LifePoints : int
    # strength : int
    # gold : int

    + {abstract} die() : void
    + {abstract} attack(theOtherCharacterToAttack : GameCharacters) : void
    + {abstract} name() : String
    + {abstract} description() : String

    + GameCharacters()
    + GameCharacters(lP : int, st : int)
    + getLifePoints() : int
    + moveTo(r : Room) : void
    + currentRoom() : Room
    + getStrength() : int
    + addStrength(st : int) : void
    + getGold() : int
    + addGold(g : int) : void
    + isAlive() : boolean
    + loseLife(st : int) : void
  }

  class Player {
    - playerCapabilities : List<Action>

    + Player(lp : int, sp : int)
    + addCapability(a : Action) : void
    + canDo() : List<Action>
    + die() : void
    + description() : String
    + attack(theOtherCharacterToAttack : GameCharacters) : void
    + name() : String
    + getscore() : int
  }

  package fil.coo.adventure.entities.monsters #white {

  }

  package fil.coo.adventure.entities.items #white {

  }

  package fil.coo.adventure.entities.actions #white {

  }

  fil.coo.adventure.entities.actions -u[hidden]- fil.coo.adventure.entities.items
  fil.coo.adventure.entities.actions -d[hidden]- fil.coo.adventure.entities.monsters
  fil.coo.adventure.entities.monsters -r[hidden]- Player
  Player -u-|> GameCharacters


}
@enduml
```

Comme vous pouvez le voir ci-dessus, ce package est imposant, c'est pourquoi nous avons encore fait le choix de décomposer notre diagramme en trois autres parties :

+ **<em style="text-decoration:underline">Les actions</em> :**

  > ![Le package actions](http://www.plantuml.com/plantuml/png/rPJ1Ri8m38RlF8N5BamRqSuJGWBjWhH9qz1EqmuXDQr5YL7gCh6DTry6XGPeqRXrlIJg_oN-xIJEPcGNskavc5HdsK34qIGN71csO_f4k6k1_nRQp7ICq9vIgWopqj4IhUGEbHz823EbZH3Rh0rN7ma9mjTc9G1PGJVL1c6m8Q3N6-r-zVjx3E06ZBP3V62B8zjnS0ylpFDhFqwOKzGs82CF3LSUMtZvETKhTBSGBbaoHGM_RXMJ2x9GkL3gKqafJYHsk0fyRYe5lbH-koAbKhmaZKiJsQuG7lj3id7dLzrEz_e-rPtBH-R_u56Qxl69bzXqZ-ES34MDj_cQDS_YaLNX62L1T_RHrxwqsklzvp3bRJjtn7LrFGvpU2-w-Lj2KOJslLiqv1ekBRaJFqUeAz7IHO4UzCam-CccPGL3h2hbe6E4wFdOAbVVVQY9MADAlHfqX0hri40LGFaAJiJr3m00)

    >>>
    ```puml
    @startuml
    skinparam classAttributeIconSize 0
    package "fil.coo.adventure.entities.actions" #white {
      interface Action <<Interface>> {
        + canBeDoneIn(r : Room) : boolean
        + doneByIn(p : Player, r : Room) : void
      }

      package "fil.coo.adventure.entities.actions.util" #lightgrey {
        class AttackAction {
          + canBeDoneIn(r : Room) : boolean
          + doneByIn(p : Player, r : Room) : void
          + toString() : String
        }

        class LookAction {
          + canBeDoneIn(r : Room) : boolean
          + doneByIn(p : Player, r : Room) : void
          + toString() : String
        }

        class LootAction {
          + canBeDoneIn(r : Room) : boolean
          + doneByIn(p : Player, r : Room) : void
          + toString() : String
        }

        class MoveAction {
          + canBeDoneIn(r : Room) : boolean
          + doneByIn(p : Player, r : Room) : void
          + toString() : String
        }

        class SuicideAction {
          + canBeDoneIn(r : Room) : boolean
          + doneByIn(p : Player, r : Room) : void
          + toString() : String
        }

        class UseAction {
          + canBeDoneIn(r : Room) : boolean
          + doneByIn(p : Player, r : Room) : void
          + toString() : String
        }
      }

      together {
        class AttackAction
        class LookAction
        class LootAction
      }

      together {
        class MoveAction
        class SuicideAction
        class UseAction
      }

      SuicideAction -u[hidden]- Action

      SuicideAction -l[hidden]- MoveAction
      SuicideAction -r[hidden]- UseAction

      AttackAction -u[hidden]- MoveAction
      LookAction-u[hidden]- SuicideAction
      LootAction -u[hidden]- UseAction

      AttackAction .u.|> Action
      LookAction .u.|> Action
      LootAction .u.|> Action
      MoveAction .u.|> Action
      SuicideAction .u.|> Action
      UseAction .u.|> Action
    }
    @enduml
    ```
    >>>

+ **<em style="text-decoration:underline">Les objets</em> :**

  > ![Le package items](http://www.plantuml.com/plantuml/png/pLJ1QkCm4BtxAqHxIGasUovBeLrA2GGQrkofx46HflOGMpBIkDriwdzVsKvYMN6WkqkXlaZelHczUHwDtQ2gkE4b4mMtzfR8uBecM0YjKlmDx4l4t5TniU4Pi8jdB1AXTSBb2oYg3IHkGKAm2HAKze9TlkPkntPT76DyRSbmGNr-jd2a8yRO9HErCIx5TwrBTitQ9JgYSxOxX3SCxGyBycuxgmg-1UF8gsvpvNOl6kLqb0Gh35Q4MirQPkhgKvb_XIUWOtGI1jX23vazr5BC7cyEUTvjJr8J5iwZ0hESCWDRpulU82SGL4RvIhUQFRWrovAx7HL5tkdy_Swqv3E6-1JI_U4KtaI1tYK-mwJMelfqMXzq8R_bu5mSIytS-PJO8tzszUz5A5x2EVKVKM1AMcpkVucSgmn6XSvFyQ2m_z1wekLHmQqfdKrSIGmThmmAs5i-dCTiPuaJYeQj7jDqSRUyJnrfYPQ-jeFZvXFrKbe0L6rr4ntr5zAQo5_tjtH3CfPFEKe9wcSyDE809-vpGay7JZjXagNM6xukeC_dlT7OdCiwF0wVCnv77J7uiN4zi8UB9fb-th5z7JsqDDGwwjme55t7RpUTDKTW_19wmhXctvXnV326GpHKEf7xnAP3XZy0)

    >>>
    ```puml
    @startuml
    skinparam classAttributeIconSize 0
    package "fil.coo.adventure.entities.items" #white {
      abstract class Item {
        # currentRoom : Room

        + {abstract} isUsedBy(player : Player) : void
        + {abstract} description() : String

        + currentRoom() : Room
        + setRoom(r : Room) : r
      }

      package "fil.coo.adventure.entities.items.util" #lightgrey {
        class StrengthPotion {
          # st : int

          + isUsedBy(player : Player) : void
          + description() : String
          + toString() : String
        }

        class LifePotion {
          # lp : int

          + isUsedBy(player : Player) : void
          + description() : String
          + toString() : String
        }

        class GoldChest {
          # gold : int

          + GoldChest()
          + isUsedBy(player : Player) : void
          + name() : String
          + description() : String
          + toString() : String
        }

        class GoldStockExchange {
          + GoldStockExchange()
          + name() : String
          + description() : String
        }

        class OneArmedBandit {
          # price : int
          - {static} POSSIBLES : List<Item>

          + isUsedBy(player : Player) : void
          + description() : String
          + toString() : String
        }

        class SleepedBadChest {
          + isUsedBy(player : Player) : void
        }
      }
    }

    Item -d[hidden]- GoldChest
    Item ....() fil.coo.adventure.util.Lookable

    LifePotion -r[hidden]- GoldChest
    GoldChest -r[hidden]- StrengthPotion
    OneArmedBandit -u[hidden]- LifePotion
    OneArmedBandit -r[hidden]- SleepedBadChest
    SleepedBadChest -r[hidden]- GoldStockExchange

    GoldChest -u-|> Item
    GoldStockExchange -u-|> GoldChest
    LifePotion -u-|> Item
    StrengthPotion -u-|> Item
    SleepedBadChest -u-|> GoldChest
    OneArmedBandit -u-|> Item

    @enduml
    ```
    >>>

+ **<em style="text-decoration:underline">Les monstres</em> :**

  > ![Le package monsters](http://www.plantuml.com/plantuml/png/pLPDZzCm4BtdLrZB9HKauenMbVP3MbOBMgHo0d5mdMbYrR4hUx88blvtdDX9xJG4hRPeELHjtxoPzyOPsp5RBdTKqvemGOsvGDHytI3SCYLN_2UGjycEiYqjWPnjkCYPKZaj7a1Yeo6tNnmvcBnMqY1eSqPUVQyu0dbC2A5hWveoTAN9HyVfGeIy9ezzV4yahI5Ta7TaPULbcNY6pqZ59nlY4jyGW-xNmZCeedMNOWNtzgElAjeM1FrPNNGHoxwnjGVSj28FYXS-l-1EDu1GEHEX7qBsoN53gnqmJeLtwGKdkZEE1viDC4pB-c-cfkh-epNeshArG6yeWv7oDGToVdxRHvVBeRcue_arxIIUCaDvWrpOGHAyhB3KyCFBkaN_ekgrPRzNkl1ugncWwM90nsFLumKOflaEkP9JuQSzhtqIk5i9NaFWg_j_QaUH_3CDtsiMsBN_dcSsglr1gSD-RnCTyA8Fw4xJBSZ0amDEsFMTHM_KMl18PG1VjFiZNwVm52bSQrggKC419rIuf4AhCb1mm4aLYgiAx34RQZZe_zpAg4feZ_x1S70OHKZVHfWyT9k9hnKl2f3Vic1UHvpYm76xkOi7CnyoWbFPQVdTbpK7ZdjwNRGzYyAG6vt-2fcyRJEH_Lhsxmb9PBGDJEM4hBp9ZrZsrkietPHbJLpVZ_SOxdiVmT6opFWPbYLEz-VdRAfRipZFNKBJw9yx3Y_M6Sbzqh_7EO6P2pqUtDy0)

```puml
@startuml
skinparam classAttributeIconSize 0
package "fil.coo.adventure.entities.monsters" #white {
  abstract class Monster {
    + {abstract} name() : String

    + Monster(lP : int, st : int)
    + attack(theOtherCharacterToAttack : GameCharacters) : void
    + die() : void
    + toString() : String
  }

  abstract class SpecialMonsterAttack {
    + {abstract} specialeffect(gm : GameCharacters) : void
    + SpecialMonsterAttack(lP : int, st : int)
    + attack(theOtherCharacterToAttack : GameCharacters) : void
  }

  interface SpecialMonsterDie <<Interface>> {
    + specialeffect() : void
    + die() : void
  }

  package "fil.coo.adventure.entities.monsters.util" #lightgrey {
    class ZombiesHord {
      + ZombiesHord()
      + name() : String
      + description() : String
      + specialeffect(gm : GameCharacters) : void
    }

    class Slime {
      + Slime()
      + name() : String
      + description() : String
      + specialeffect() : void
      + specialeffect(gm : GameCharacters) : void
    }

    class Orc {
      + Orc()
      + name() : String
      + description() : String
    }

    class Looter {
      + Looter()
      + name() : String
      + description() : String
      + specialeffect(gm : GameCharacters) : void
    }

    class Kraken {
      + Kraken()
      + name() : String
      + description() : String
    }

    class KingGoblin {
      + KingGoblin()
      + name() : String
      + description() : String
      + specialeffect(gm : GameCharacters) : void
    }

    class Goblin {
      + Goblin()
      + name() : String
      + description() : String
    }

    class Dragon {
      + Dragon()
      + name() : String
      + description() : String
    }

    class Balrog {
      + Balrog()
      + name() : String
      + description() : String
    }

    class BadChest {
      + BadChest()
      + name() : String
      + description() : String
      + specialeffect() : void
      + specialeffect(gm : GameCharacters) : void
    }

    together {
      class Slime
      class BadChest
    }

    BadChest -l[hidden]- KingGoblin
    BadChest -d[hidden]- Looter
    KingGoblin -d[hidden]- ZombiesHord

    Kraken -u[hidden]- Balrog
    Orc -u[hidden]- Dragon
  }

  SpecialMonsterAttack -l-|> Monster
  BadChest -d-|> SpecialMonsterAttack
  BadChest .u.|> SpecialMonsterDie
  Balrog -u-|> Monster
  Dragon -u-|> Monster
  Goblin -u-|> Monster
  KingGoblin -d-|> SpecialMonsterAttack
  Kraken -u-|> Monster
  Looter -d-|> SpecialMonsterAttack
  Orc -u-|> Monster
  Slime -u-|> Monster
  Slime .u.|> SpecialMonsterDie
  ZombiesHord -d-|> SpecialMonsterAttack
}
Monster -u-|> fil.coo.adventure.entities.GameCharacters
@enduml
```

### 4 - Conception des Objet
