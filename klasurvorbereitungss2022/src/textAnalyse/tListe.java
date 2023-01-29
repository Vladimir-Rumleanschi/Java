package textAnalyse;

import java.util.ArrayList;
import java.util.Collections;

public class tListe {
    int lenght;
    ArrayList<String> words;

    public tListe(int n, String word){
        this.lenght = n;
        this.words = new ArrayList<>();
        this.words.add(word);
    }

    public void addToWords(String word){
        this.words.add(word);
    }
}
