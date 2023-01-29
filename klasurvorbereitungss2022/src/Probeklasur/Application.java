package Probeklasur;

public class Application {
    public static void main(String[] args){
        FormattedText ft = new FormattedText("");
        TextInput ti = new TextInput();


        while(true) {
            System.out.println("Text eingeben: ");
            String value = ti.readLine();
            ft.setText(value);
            System.out.println(ft.toString(20));
            System.out.println("Nochmal? (y/n)");
            String value2 = ti.readLine();
            if(value2.equals("n"))break;
        }
    }
}
