package Probeklasur;

import java.util.ArrayList;

public class FormattedText {
    String text;

    public FormattedText(String text){
        this.text = text;
    }

    public void setText(String text){
        this.text = text;
    }

    private String addSpaces(String txt, int n){
        int strLen = txt.length();
        String[] split = txt.split(" ");
        String ftxt = "";

        for(int i = 0; i < split.length; i++){
           if(i  == split.length - 1){
               for(int j = 0; j < n - strLen ; j++){
                   ftxt = ftxt + "_";
               }
           }
           ftxt= ftxt + split[i] + " ";
        }
        return ftxt;
    }

    private ArrayList<String> justifyText(int n){
        String[] splitedT = this.text.split(" ");
        ArrayList<String> formatedT = new ArrayList<>();
        formatedT.add(splitedT[0]);
        int fListCount = 0;

        for(int i = 1 ; i < splitedT.length; i++){
            if(formatedT.get(fListCount).length() + splitedT[i].length() + 1 <= n){
                formatedT.set(fListCount,formatedT.get(fListCount) + " " + splitedT[i]);
            }else{
                formatedT.set(fListCount,addSpaces(formatedT.get(fListCount),n));
                formatedT.add(splitedT[i]);
                fListCount++;
            }
        }
        if(formatedT.get(fListCount).length() != n){
            formatedT.set(fListCount,addSpaces(formatedT.get(fListCount),n));
        }

        return formatedT;
    }

    public  String toString( int n ){
        String str = "";
        ArrayList<String> ftxt = justifyText(n);
        for(String s : ftxt){
            str = str + s + "\n";
        }
        return str ;
    }
}
