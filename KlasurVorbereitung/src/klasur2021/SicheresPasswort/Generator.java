package klasur2021.SicheresPasswort;


import java.util.ArrayList;

public class Generator {
    public String text;
    public String passwort;



    public String toString(char[] passw){
        String pass = "";
        for(int i = 0; i < passw.length;i++){
            if (passw[i] != ' ')pass = pass + passw[i];
        }
        return  pass;
    }


    public void setText(String text) {
        this.text = text;
    }

    public void passwortGen(){

        String[] words = this.text.split(" ");
        char[] passw = new char[words.length + 1];

        int count = 0;

        for(int i = 0; i < words.length; i++){
            if(words[i].isEmpty()){
                passw[i] = ' ';
            }else{
                passw[i] = words[i].charAt(0);
                if(words[i].charAt(0) > 64 && words[i].charAt(0) < 91){
                    count++;
                }
            }
        }
        passw[words.length] = (char)(count + '0');

        this.passwort = toString(passw);
    }
}
