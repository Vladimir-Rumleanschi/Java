package Aufgabe2.Enums;

/**The Class EuroCalculator has the functions to simulate a payment.
 * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
 * @version 02.05.2021
 */
public class EuroCalculator {
    /**Enum EuroDenomination represent the virtual money
     */
    public enum EuroDenomination{
        Null,
        ECOIN1, ECOIN2,
        CCOIN1, CCOIN2, CCOIN5, CCOIN10, CCOIN20, CCOIN50,
        ESchein5,ESchein10,ESchein20,ESchein50,ESchein100,ESchein200,
    }
    /**
     *preis represents the preis of all products.
     *geld represents the Array of virtual money.
     */
    private int preis;
    private EuroDenomination[] geld;

    /**Calculate the value of virtual money.
     * @param geld represents the Array of virtual money.
     * @return the value of array in cent as a int value.
     * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
     */
    public int centcalc(EuroDenomination[] geld ){
        int summe = 0;

        for (int i = 0; i < geld.length; i++){
            switch (geld[i]){
                case Null:
                    summe += 0;
                    break;
                case CCOIN1:
                    summe += 1;
                    break;
                case CCOIN2:
                    summe += 2;
                    break;
                case CCOIN5:
                    summe += 5;
                    break;
                case CCOIN10:
                    summe += 10;
                    break;
                case CCOIN20:
                    summe += 20;
                    break;
                case CCOIN50:
                    summe += 50;
                    break;
                case ECOIN1:
                    summe += 100;
                    break;
                case ECOIN2:
                    summe += 200;
                    break;
                case ESchein5:
                    summe += 500;
                    break;
                case ESchein10:
                    summe += 1000;
                    break;
                case ESchein20:
                    summe += 2000;
                    break;
                case ESchein50:
                    summe += 5000;
                    break;
                case ESchein100:
                    summe += 10000;
                    break;
                case ESchein200:
                    summe += 20000;
                    break;
            }
        }
        return summe;
    }

    /**Build an array of virual money with the value of cent.
     * @param rest represents the money in cent as an int value.
     * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
     */
    public void rest(int rest){
        if(rest == 0){
            printgeld(this.geld);
            System.exit(0);
        }
        if(rest >= 20000){
            setGeld(EuroDenomination.ESchein200);
            rest(rest - 20000);
        }
        if(rest >= 10000){
            setGeld(EuroDenomination.ESchein100);
            rest(rest - 10000);
        }
        if(rest >= 5000){
            setGeld(EuroDenomination.ESchein50);
            rest(rest - 5000);
        }
        if(rest >= 2000){
            setGeld(EuroDenomination.ESchein20);
            rest(rest - 2000);
        }
        if(rest >= 1000){
            setGeld(EuroDenomination.ESchein10);
            rest(rest - 1000);
        }
        if(rest >= 500){
            setGeld(EuroDenomination.ESchein5);
            rest(rest - 500);
        }
        if(rest >= 200 ){
            setGeld(EuroDenomination.ECOIN2);
            rest(rest - 200);
        }
        if(rest >= 100){
            setGeld(EuroDenomination.ECOIN1);
            rest(rest - 100);
        }
        if(rest >= 50){
            setGeld(EuroDenomination.CCOIN50);
            rest(rest - 50);
        }
        if(rest >= 20){
            setGeld(EuroDenomination.CCOIN20);
            rest(rest - 20);
        }
        if(rest >= 10){
            setGeld(EuroDenomination.CCOIN10);
            rest(rest - 10);
        }
        if(rest >= 5){
            setGeld(EuroDenomination.CCOIN5);
            rest(rest - 5);
        }
        if(rest >= 2){
            setGeld(EuroDenomination.CCOIN2);
            rest(rest - 2);
        }
        if(rest >= 1){
            setGeld(EuroDenomination.CCOIN1);
            rest(rest - 1);
        }
    }
    /**Add a EuroDenomination value to the actual array.
     * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
     * @param geld represents a virtual bill/coin.
     * @return the array  of virtual money.
     */
    public EuroDenomination[] setGeld(EuroDenomination geld){
        if(this.geld == null){
            EuroDenomination[] tempgeld = {geld};
            this.geld = tempgeld;
            return this.geld;
        }
        EuroDenomination[] tempgeld = new EuroDenomination[this.geld.length + 1];
        for(int i = 0; i < this.geld.length; i++){
            tempgeld[i] = this.geld[i];
        }
        tempgeld[this.geld.length] = geld;
        this.geld = tempgeld;
        return this.geld;
    }

    /**Print the Array of virtual money as a string.
     * @param geld represents the money as an EnumDeomenation value.
     * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
     */
    public void printgeld(EuroDenomination[] geld){
        System.out.print("[");
        for(int i = 0; i < geld.length;i++){
            System.out.print(geld[i]);
            if(i == geld.length - 1){
                System.out.println("]");
            }else{
                System.out.print(",");
            }
        }
    }

    /**Create a String to a EuroDenomination value.
     * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
     * @param str represents the money as a string.
     * @return the value money as EuroDenomination value.
     */
    public EuroDenomination stringtoEuroDenom(String str){
        if(str.equals("CCOIN1"))return EuroDenomination.CCOIN1;
        if(str.equals("CCOIN2"))return EuroDenomination.CCOIN2;
        if(str.equals("CCOIN5"))return EuroDenomination.CCOIN5;
        if(str.equals("CCOIN10"))return EuroDenomination.CCOIN10;
        if(str.equals("CCOIN20"))return EuroDenomination.CCOIN20;
        if(str.equals("CCOIN50"))return EuroDenomination.CCOIN50;
        if(str.equals("ECOIN1"))return EuroDenomination.ECOIN1;
        if(str.equals("ECOIN2"))return EuroDenomination.ECOIN2;
        if(str.equals("ESchein5"))return EuroDenomination.ESchein5;
        if(str.equals("ESchein10"))return EuroDenomination.ESchein10;
        if(str.equals("ESchein20"))return EuroDenomination.ESchein20;
        if(str.equals("ESchein50"))return EuroDenomination.ESchein50;
        if(str.equals("ESchein100"))return EuroDenomination.ESchein100;
        if(str.equals("ESchein200"))return EuroDenomination.ESchein200;
        return EuroDenomination.Null;
    }

    /** Constructor function.
     */
    public EuroCalculator(){
    }

    /**Take the user Array of virtual money and give the rest back if are to much,or if is to less break the programm.
     * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
     * @param preis represents the money in cent as an int value.
     * @param geld represents the money in cent as an int value.
     */
    public EuroCalculator(int preis, EuroDenomination[] geld){
        this.preis = preis;
        this.geld = geld;
        if(centcalc(this.geld) < preis){
            System.out.println(String.format("%d Cent ist nicht ausreichend für einen Einkauf von %d Cent.",centcalc(this.geld),this.preis));
        }else if (centcalc(this.geld) == preis){
            System.out.println(String.format("Danke für den Einkauf von %d Cent. Rest beträgt 0 Cent.",centcalc(this.geld),this.preis));
        }else{
            int rest = centcalc(this.geld) - preis;
            System.out.println(String.format("Danke für den Einkauf von %d Cent. Rest beträgt: %d Cent.",this.preis,rest));
            this.geld = new EuroDenomination[0];
            rest(rest);
            printgeld(this.geld);
        }
    }
}
