package Passwort;


public class Generator {

    String text;
    String paswort;

    public Generator(String text ){
        this.text = text;
        genAlg(this.text);
    }

    private void genAlg(String text){
        int upCount = 0;
        String pass = "";

        String[] slpitedArray = text.split(" ");


        for (String s : slpitedArray) {
            System.out.println(s);
            pass = pass + s.charAt(0);
            if (Character.isUpperCase(s.charAt(0))) upCount++;

        }
        this.paswort = pass + upCount ;
    }

    public String toString(){
        return this.paswort;
    }
}
