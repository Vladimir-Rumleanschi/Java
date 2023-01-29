package de.uni_hannover.hci.Vladimir_Rumleanschi.aufgabe2;
import de.uni_hannover.hci.Vladimir_Rumleanschi.aufgabe2.personal.*;
import de.uni_hannover.hci.Vladimir_Rumleanschi.aufgabe2.personal.IT_Personal.*;
import de.uni_hannover.hci.Vladimir_Rumleanschi.aufgabe2.personal.Management.*;
import java.util.Scanner;

/**main class. Starts the application to adding new employees to a list
 */
public class Main {
    public static void main(String[] args) {
        /*

        Sicherheitspersonal s = new Sicherheitspersonal("Vladimir","Rumleanschi",8,8,8);
        System.out.println(s.printguard());
        IT_Personal_Senior its = new IT_Personal_Senior("John","Snow",2010,40);
        System.out.println(its.printSenior_Developer());
        IT_Personal_Junior itj = new IT_Personal_Junior("John","Snow",2010,40);
        System.out.println(itj.printJunior_Developer());
        CEO_Manager ceo = new CEO_Manager("John","Snow",5);
        System.out.println(ceo.printCEO());
        Project_Manager proman = new Project_Manager("John","Snow",5);
        System.out.println(proman.printManager());

         */
        //eine leere Liste wird erstellt
        Employee[] list = new Employee[0];
        Scanner scan = new Scanner(System.in);
        int i = 0;
        //Die while Schleife funktioniert bis wann die Eingabe des Users kommt oder bis wann die Länge der Liste 15 ist.
        while(i < 15){
            System.out.println("Enter a command");
            System.out.println("<new_guard>,<new_manager>,<new_it>,<show_employees>");
            String command = scan.next();
            // Es wird die Einzelne comanden untersucht und je nach eingabe des Users wird einen nuen mitarbeiter zu der Liste eingefügt.
            if(command.equals("new_guard")){
                i++;
                System.out.println("Adding a guard");
                System.out.println("Firstname :");
                String firstname = scan.next();
                System.out.println("Lastname :");
                String lastname = scan.next();
                System.out.println("Night shifts per month :");
                int nshifts = Integer.parseInt(scan.next());
                System.out.println("Early shifts per month :");
                int eshifts = Integer.parseInt(scan.next());
                System.out.println("Late shifts per month :");
                int lshifts = Integer.parseInt(scan.next());
                Sicherheitspersonal guard = new Sicherheitspersonal(lastname,firstname,eshifts,lshifts,nshifts);
                list = setlist(list,guard);
                System.out.println("Added employee:");
                System.out.println(guard.toString());
            }
            if(command.equals("new_it")) {
                i++;
                System.out.println("Adding an IT Personal");
                System.out.println("Firstname :");
                String firstname = scan.next();
                System.out.println("Lastname :");
                String lastname = scan.next();
                //es wird untersucht was für einen Rank hat der It-Angestellter
                while(true){
                    System.out.println("Rank ( <JuniorDev> or <SeniorDev> :");
                    String rank = scan.next();
                    if (rank.equals("JuniorDev")){
                        System.out.println("Year joined:");
                        int year = Integer.parseInt(scan.next());
                        System.out.println("Weekhours :");
                        int hours = Integer.parseInt(scan.next());
                        IT_Personal_Junior itj = new IT_Personal_Junior(lastname,firstname,year,hours);
                        list = setlist(list,itj);
                        System.out.println("Added employee:");
                        System.out.println(itj.toString());
                        break;
                    }else if(rank.equals("SeniorDev")) {
                        System.out.println("Year joined:");
                        int year = Integer.parseInt(scan.next());
                        System.out.println("Weekhours :");
                        int hours = Integer.parseInt(scan.next());
                        IT_Personal_Senior its = new IT_Personal_Senior(lastname, firstname, year, hours);
                        list = setlist(list, its);
                        System.out.println("Added employee:");
                        System.out.println(its.toString());
                        break;
                    }
                }

            }

            if(command.equals("new_manager")){
                i++;
                System.out.println("Adding a Manager");
                System.out.println("Firstname :");
                String firstname = scan.next();
                System.out.println("Lastname :");
                String lastname = scan.next();
                //es wird untersucht was für einen Rank hat der Manager-Angestellter.
                while(true){
                    System.out.println("Rank ( <Projectmanager> or <CEO> ):");
                    String rank = scan.next();
                    if (rank.equals("Projectmanager")){
                        System.out.println("Projects done:");
                        int projectsdone = Integer.parseInt(scan.next());
                        Project_Manager proman = new Project_Manager(lastname,firstname,projectsdone);
                        list = setlist(list,proman);
                        System.out.println("Added employee:");
                        System.out.println(proman.toString());
                        break;
                    }else if(rank.equals("CEO")) {
                        System.out.println("Projects done:");
                        int projectsdone = Integer.parseInt(scan.next());
                        CEO_Manager ceo = new CEO_Manager(lastname, firstname, projectsdone);
                        list = setlist(list, ceo);
                        System.out.println("Added employee:");
                        System.out.println(ceo.toString());
                        break;
                    }
                }
            }

            if(command.equals("show_employees")){
                printList(list);
                break;
            }
        }
        //wenn dier Liste ist gleich 15 dann wird die Liste geprintet
        if (list.length == 15)printList(list);
    }

    /**The function add a element to the list
     * @param list list of employees
     * @param item new employee
     * @return new list;
     */
    private static Employee[] setlist(Employee[] list ,Employee item){
        if(item == null){
            Employee[] tempitem = {item};
            return tempitem;
        }
        Employee[] templist = new Employee[list.length + 1];
        for(int i = 0; i < list.length; i++){
            templist[i] = list[i];
        }
        templist[list.length] = item;
        return templist;
    }

    /**The function prints the list
     * @param list list of employees
     */
    private static void printList(Employee[] list){
        if(list == null){
            System.out.println("Noone was add to the list");
        }else{
            System.out.println("New added Employees:");
            for(int i = 0; i < list.length;i++){
                 System.out.println(list[i].toString());
            }
        }
    }
}
