package textAnalyse;

import java.util.*;




public class TextAnalyser {
    String text;

    public void setText(String text){
        this.text = text;
    };

    private ArrayList<tListe> sortList(ArrayList<tListe> list){

        for(int i = 0; i < list.size();i++){
            for (int j = 0; j < list.size() - i - 1 ;j++){
                if(list.get(j).lenght > list.get(j + 1).lenght ){
                    Collections.swap(list,j,j+1);
                }
            }
        }

        return list;
    }

    private ArrayList<tListe> analyseText(){

        ArrayList<tListe> list = new ArrayList<>();
        String[] splitText = this.text.split(" ");

        for(int i = 0; i < splitText.length; i++){
            if(list.size() == 0){
                list.add(new tListe(splitText[i].length(),splitText[i]));
            }else{
                boolean count = false;
                for (int j = 0; j < list.size(); j++){
                    if (list.get(j).lenght == splitText[i].length()) {
                        list.get(j).addToWords(splitText[i]);
                        count = true;
                    }
                }
                if(!count)list.add(new tListe(splitText[i].length(),splitText[i]));
            }
        }

        sortList(list);
        return list;
    }

    public String toString(){
        String formatedText = "";
        ArrayList<tListe> list= analyseText();
        for(tListe tl : list){
            formatedText = formatedText + tl.lenght + ": ";
            for(String ts : tl.words){
                formatedText = formatedText + ts + " ";
            }
            formatedText = formatedText + "\n";
        }
        return formatedText;
    }
}
