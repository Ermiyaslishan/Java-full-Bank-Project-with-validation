// ermiyas lishan 
// Debre Birhan university 

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
    String name[] = new String[100];
    String sex[] = new String[100];
    int age[] = new int[100];
    long account[] = new long[100];
    double balance[] = new double[100];
    int num, count;
    int pin[] = new int[100] ;

    public static void main(String[] arg) {

        try {
            Scanner sc = new Scanner(System.in);
            Transaction tr = new Transaction();

            int option = 0;
            int count = 0;
            System.out.println("------------------------------------------------------------- ");
            System.out.println("                        Welcome                           	 ");
            System.out.println("                          To                              	 ");
            System.out.println("               Commercial Bank of Ethiopia                	 ");
            System.out.println("------------------------------------------------------------- ");
            do {
                System.out.printf("----------------------------------------------\n");
                System.out.println("   Our Service \n");
                System.out.println("Enter 1 for Record");
                System.out.println("Enter 2 for Display");
                System.out.println("Enter 3 for Deposit");
                System.out.println("Enter 4 for Withdraw");
                System.out.println("Enter 5 for Search");
                System.out.println("Enter 6 for Delete");
                System.out.println("Enter 7 for Transfer ");
                System.out.println("Enter 8 for Exit program");
                System.out.printf("----------------------------------------------\n");
               
                while(true){
                boolean opt = true;
                    try{
                    option = sc.nextInt();
                }catch(InputMismatchException e){
                    count++;
                    opt=false;
                    if(count==2){
                        System.out.println("Only you have one chance");
                    }
                    if(count==3){
                        System.out.println("sorry your for intrupting but you finished your chance ");
                        break;
                    }
                    sc.next();
                    System.out.println("Please insert only numerical value ");
                }
                if(opt==true)
                    break;
                }
    switch (option) {
        case 1:
            tr.record();
            break;
        case 2:
            tr.Display();
            break;
        case 3:
            tr.Deposit();
            break;
        case 4:
            tr.Withdraw();
            break;
        case 5:
            tr.Search();
            break;
        case 6:
            tr.Delete();
            break;
        case 7:
            tr.transfer();
            break;
        case 8:
            System.out.println("Thank You");
            System.out.println("          For Visiting...");
            System.out.println("-------------------------------------------------------------");
            System.exit(0);
            break;
        default:
            System.out.println("you Enter valid option");
    }
}while (option!=9);
            } catch(InputMismatchException e) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("\nOops !!! You Have Entered Wrong Input...");
            System.out.println("-------------------------------------------------------------");
        }
    }

}



