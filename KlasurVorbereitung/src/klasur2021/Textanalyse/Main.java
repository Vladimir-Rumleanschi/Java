package klasur2021.Textanalyse;

public class Main {

    public static void main(String[] args){
        TextInput input = new TextInput();
        TextAnalyser textarray = new TextAnalyser();

        while(true){
            System.out.println("Texteingabe:");
            String scan = input.readLine();
            textarray.setText(scan);
            String sortedWords =  textarray.analyseText();
            System.out.println(sortedWords);
            System.out.println("Wollen Sie noch einen Text analysieren(j/n)?");
            String check;
            while (true){
                check = input.readLine();
                if(check.equals("j") || check.equals("n"))break;
            }
            if (check.equals("n"))break;
        }
    }
}
