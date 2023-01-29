package de.uni_hannover.hci.aufgabe3;

import de.uni_hannover.hci.aufgabe3.model.*;

public class Debug {
  public static void main(String[] args) {
    Animal[] animals = new Animal[3];
    animals[0] = new Animal("Kangaroo Bob", 2, 2);
    animals[1] = new Dog("Barks");
    animals[2] = new Monkey("King Kong");
    for (int i = 0; i < animals.length; ++i) {
      System.out.println(animals[i]);
    }
  }
}
/*
 ...
Zeile 3: class Animal : Klasse Animal wurde nicht als public definiert .
Fehlermeldung:
**************
java: de.uni_hannover.hci.aufgabe3.Animal is not public in de.uni_hannover.hci.aufgabe3; cannot be accessed from outside package
**************
Anere Klassen haben keinen zugriff auf die Klasse Animal.
 */

/*
 ...
Zeile 22: class Dog : Die Funktion getLegs is private definiert .
Zeile 22: class Monkey : Die Funktion getLegs is private definiert .
Fehlermeldung:
**************
java: name_ has private access in de.uni_hannover.hci.aufgabe3.Animal
**************
Klasse Debug hat kann auf die Funktionen nicht zugreifen.
 */

/*
 ...
Zeile 17/23: class Monkey :Return entscpricht nicht die Bedingung in  die Zeile 3 .
Fehlermeldung:
**************
keine
**************
Es wird für die Monkey faslshe Eingenschaft gegeben(0-Arms,4-Legs)
 */

/*
 ...
Zeile 28: class Monkey :Printfehler.
Fehlermeldung:
**************
keine
**************
Es wird dog anstatt monkey geprintet.
 */

/*
 ...
Zeile 3: class Dog :False comment.
Fehlermeldung:
**************
keine
**************
Es wird monkey anstatt dog geschrieben.
 */

/*
 ...
Zeile 28: class Dof :Printfehler.
Fehlermeldung:
**************
keine
**************
Die Variablen für legs und arms sind vertauscht.
 */