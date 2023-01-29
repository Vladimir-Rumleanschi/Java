package textAnalyse;

public class Application {
    public static void main(String[] args){

        textInput tInp = new textInput();
        TextAnalyser txt = new TextAnalyser();

        while(true){
            System.out.println("Wie lautet Ihre Eingabe ?");
            txt.setText(tInp.readLine());
            System.out.println(txt.toString());

            System.out.println("Wollen Sie noch einen Text analysieren (j/n)?");
            String Abfarge = tInp.readLine();
            if(Abfarge.equals("n")){
                break;
            }
            if(!Abfarge.equals("j")){
                System.out.println("Falsche Eingabe das Programm wurde beendet");
                break;
            }
        }
    }
}
