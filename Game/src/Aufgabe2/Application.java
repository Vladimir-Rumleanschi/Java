package Aufgabe2;

import Aufgabe2.Enums.*;

import java.util.Scanner;

/**The Class Application simulate an virtual self-service shop.
 * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
 * @version 02.05.2021
 */
public class Application {

    /**Main function of the Application.
     * @param args nothing.
     * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
     */
    public static void main(String[] args) {
        //EuroCalculator.EuroDenomination[] geld1 = {EuroCalculator.EuroDenomination.CCOIN1,EuroCalculator.EuroDenomination.CCOIN1};
        //EuroCalculator.EuroDenomination[] geld2 = {EuroCalculator.EuroDenomination.ESchein5,EuroCalculator.EuroDenomination.ESchein10};
        //EuroCalculator.EuroDenomination[] geld3 = {EuroCalculator.EuroDenomination.ECOIN1,EuroCalculator.EuroDenomination.ESchein20};

        //EuroCalculator einkauf1 = new EuroCalculator(1500,geld1);
        //EuroCalculator einkauf2 = new EuroCalculator(1500,geld2);
        //EuroCalculator einkauf3 = new EuroCalculator(1503,geld3);

        System.out.println("Produkt:\t\t\t\tPreis: ");
        Product pr1 = new Product("Bread",119);
        pr1.printpro();
        Product pr2 = new Product("Butter",149);
        pr2.printpro();
        Product pr3 = new Product("Pizza",1249);
        pr3.printpro();
        Product pr4 = new Product("SWatch",4299);
        pr4.printpro();
        Product pr5 = new Product("SPhone",11949);
        pr5.printpro();
        Product pr6 = new Product("AppleTV",44999);
        pr6.printpro();

        Product[] listpro = {pr1,pr2,pr3,pr4,pr5,pr6} ;
        ConsoleInput input = new ConsoleInput();
        String msg = "Wellcome to our self-service shop !";
        String[] pro = {pr1.getProname(),pr2.getProname(),pr3.getProname(), pr4.getProname(),pr5.getProname(), pr6.getProname()};
        String[] list =input.getMultipleChoices(pro,msg);

        int summe = 0;
        for(int i = 0; i < list.length;i++){
            for(int j = 0; j < listpro.length;j++){
                if(list[i].equals(listpro[j].getProname())){
                    summe += listpro[j].getPreis();
                }
            }
        }
        System.out.println(String.format("You have to pay: %d Cent.",summe));


        EuroCalculator.EuroDenomination[] geld = {};
        EuroCalculator sg = new EuroCalculator();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter one of the enums to pay for your products,or \"done\" to cancel the buy :");
        System.out.println("(ECOIN1, ECOIN2, CCOIN1, CCOIN2, CCOIN5, CCOIN10, CCOIN20, CCOIN50, ESchein5,ESchein10,ESchein20,ESchein50,ESchein100,ESchein200)");
        while(true){
            String schein = scan.next();
            if(schein.equals("done")){
                break;
            }else{
                geld = sg.setGeld(sg.stringtoEuroDenom(schein));
            }

        }
        EuroCalculator einkauf = new EuroCalculator(summe,geld);
    }
}
