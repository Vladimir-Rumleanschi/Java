package de.uni_hannover.hci.aufgabe3;

import de.uni_hannover.hci.aufgabe3.model.*;


public class Debug {
  public static void main(String[] args) {
    
    IntBinTreeNode treeSorted = new SortedIntBinTreeNode(1, null, null);
    IntBinTreeNode treeUnsorted = new UnsortedIntBinTreeNode(1, null, null);
    int[] toInsert = { 4, 2, 6, 8, 0, 2, 1, 5, 1 };
    // for each i in toInsert
    for (int i : toInsert) {
      treeSorted.insert(i);
      treeUnsorted.insert(i);
    }
    System.out.println(treeSorted);
    System.out.println(treeUnsorted);
  }
}


/*
 ...
Zeile -: class UnsortedIntBinTreeNode :Konstruktorfunktion für UnsortedIntBinTreeNode-Klasse ist nicht vorhanden.
Fehlermeldung:
**************
java: constructor UnsortedIntBinTreeNode in class de.uni_hannover.hci.aufgabe3.model.UnsortedIntBinTreeNode cannot be applied to given types;
  required: no arguments
  found: int,<nulltype>,<nulltype>
  reason: actual and formal argument lists differ in length
**************
In die mein Funktion kann keinen neues Objekt der Typ UnsortedIntBinTreeNode initialisiert werden.
 */


/*
 ...
Zeile -: class SortedIntBinTreeNode : Die Klasse vererbt die Information von eine abstracte Klasse allerdings nicht alle funtionen der abstrakte Klasse sind in die Klasse SortedIntBinTreeNode sind benutzt .
Fehlermeldung:
**************
java: de.uni_hannover.hci.aufgabe3.model.SortedIntBinTreeNode is not abstract and does not override abstract method contains(int) in de.uni_hannover.hci.aufgabe3.model.IntBinTreeNode
**************
Kompiler erkännt dass die Funtion von SortedIntBinTreeNode(contains()) ist nicht durch Override umgeschrieben.
 */

/*
 ...
Zeile 8: class UnsortedIntBinTreeNode : Die Variable rand ist als static definiert.
Zeile 12: class UnsortedIntBinTreeNode : Die Variable rand muss mit Random initialiesiert werden .
Zeile 24: class UnsortedIntBinTreeNode : Die Variable rand muss als this.rand geschrieben werden .
**************
Exception in thread "main" java.lang.NullPointerException
	at de.uni_hannover.hci.aufgabe3.model.UnsortedIntBinTreeNode.insert(UnsortedIntBinTreeNode.java:24)
	at de.uni_hannover.hci.aufgabe3.Debug.main(Debug.java:15)
**************
Die Variable rand wird nicht initialiesiert und Kompieler erkännt es als einen NullPointerException .
 */