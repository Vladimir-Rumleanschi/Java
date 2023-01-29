package Aufgabe3;

public class StringBilder {

    public Boolean nPrüfer(String text, int n) {

        String[] woerte = text.split(" ");

        int wortlaenge = woerte[0].length();

        for (int i = 1; i < woerte.length; i++) {
            if (wortlaenge < woerte[i].length()) {
                wortlaenge = woerte[i].length();
            }
        }

        if (wortlaenge >= n) {
            return true;
        }
        return false;
    }

    public void printBox(String[] box) {
        for (int i = 0; i < box.length; i++) {
            System.out.println(box[i]);
        }
    }

    public String[] addSpace(String[] box, int n) {
        //printBox(box);
        String spacedBox = "";
        for (int i = 0; i < box.length; i++) {
            String[] temparr = box[i].split(" ");
            if (box[i].length() != n) {
                spacedBox += temparr[0];
                // System.out.println(temparr[0]);
                for (int j = 0; j < n - box[i].length() + 1; j++) {
                    spacedBox += " ";
                }
                for (int j = 1; j < temparr.length; j++) {
                    if (j + 1 == temparr.length) {
                        spacedBox += temparr[j] + "%";
                    } else {
                        spacedBox += temparr[j] + " ";
                    }
                    //    System.out.println( spacedBox);
                }
            } else {
                spacedBox += box[i] + "%";
            }
        }
        //printBox(spacedBox.split("%"));
        return spacedBox.split("%");
    }

    public void boxText(String text, int n) {

        String[] woerte = text.split(" ");
        int i = 0;
        String neuesText = "";
        while (i < woerte.length) {
            //   if(woerte[i].length() + woerte[i + 1].length() + 1 <= n){
            //       String box = woerte[i] + " " + woerte[i + 1] + "%";
            //   }

            int laenge;
            if (i == 0) {
                laenge = -1;
            } else {
                laenge = 0;
            }

            int anzahlWoerte = 0;
            while (true) {
                if (i + anzahlWoerte > woerte.length - 1) break;
                laenge += woerte[i + anzahlWoerte].length() + 1;
                // System.out.println(laenge);
                if (laenge > n) {
                    break;
                }
                if (anzahlWoerte + i > woerte.length - 1) break;
                anzahlWoerte++;
            }
            //    System.out.println(anzahlWoerte);

            for (int j = 0; j < anzahlWoerte; j++) {
                if (j + 1 == anzahlWoerte) {
                    neuesText += woerte[i + j] + "%";
                } else {
                    neuesText += woerte[i + j] + " ";
                }
        //        System.out.println(neuesText);
            }
            i += anzahlWoerte;
        }

        String[] box = neuesText.split("%");
        box = addSpace(box, n);
         printBox(box);

    }


}


