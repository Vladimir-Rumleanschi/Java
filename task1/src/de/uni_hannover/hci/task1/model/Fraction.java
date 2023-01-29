package de.uni_hannover.hci.task1.model;

import org.w3c.dom.ls.LSOutput;

public class Fraction {
    int num;
    int denom;

    public Fraction(int num, int denom){

        this.num = num;
        this.denom = denom;
        reduce();
    }

    public int getNumerator(){
        return this.num;
    }
    public int getDenominator(){
        return this.denom;
    }
    public void setNumerator(int num){
        this.num = num;
        reduce();
    }
    public void setDenominator(int denom){
        this.denom = denom;
        reduce();
    }
    //Die Funktion ändert die Werte in den Bruch:
    public void setValues(int num, int denom){
        this.num = num;
        this.denom = denom;
        reduce();
    }
    //Die Funktion reduziert den Bruch:
    private void reduce(){
        int devisor = 0;
        int var;
        int tempnum = this.num;
        int tempdenom = this.denom;

        if(tempdenom >= tempnum){
            var = tempnum;
        }else{
            var = tempdenom;
        }
        for(int i = num; i > 0; i-- ){
            if(tempdenom % i == 0 && tempnum % i == 0){
                devisor = i;
                break;
            }
        }
        if (devisor != 0){
            this.num = tempnum / devisor;
            this.denom = tempdenom / devisor;

        }
    }
    //Die Funktion erweitert den Bruch:
    private void extend(int amount){
        this.num = this.num * amount;
        this.denom = this.denom * amount;
    }
    //Die Funktion addiert zwei Brüche:
    public static Fraction add(Fraction summandA, Fraction summandB){
        Fraction tempf1 = new Fraction(summandA.num, summandA.denom);
        Fraction tempf2 = new Fraction(summandB.num, summandB.denom);

        tempf1.extend(summandB.denom);
        tempf2.extend(summandA.denom);

        Fraction f = new Fraction(tempf1.num + tempf2.num, tempf1.denom);
        return f;

    }

    //Die Funktion multipliziert zwei Brüche:
    public static Fraction multiply(Fraction multiplicandA, Fraction multiplicandB){
        Fraction tempf1 = new Fraction(multiplicandA.num, multiplicandA.denom);
        Fraction tempf2 = new Fraction(multiplicandB.num, multiplicandB.denom);

        Fraction f = new Fraction(tempf1.num * tempf2.num, tempf1.denom * tempf2.denom);
        return f;
    }

    //Die Funktion gibt den Bruch als String zuruck:
    public String str(){
        return String.format("%d/%d",this.num,this.denom);
    }
}
