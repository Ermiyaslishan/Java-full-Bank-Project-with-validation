
    
import java.util.InputMismatchException;
import java.util.Scanner;

public class Transaction extends Bank {
    Validator validation = new Validator();
    
    Scanner scan = new Scanner(System.in);
    int number;
    public void record() {
        while(true) {
            boolean record1 = true;
            try {
                System.out.println("Enter number of customer");
                number = scan.nextInt();
            } catch (InputMismatchException e) {
                count++;
                record1 = false;
                if (count == 2) {
                    System.out.println("Only you have one chance");
                }
                if (count == 3) {
                    System.out.println("sorry  for intrupting but you finished your chance ");
                }
                scan.next();
                System.out.println("Please insert only numerical value ");
            }
            if (record1 == true) {
                break;
            }
        }
        for (int i = 0; i < number; i++) {
            System.out.print("----------------------------------------------\n");
            boolean name1 = false;
            String TemporaryName;
            while (!name1) {
                try {
                        System.out.println("Enter the name of the customer  " + (i + 1));
                        TemporaryName = scan.next();
                    } catch(InputMismatchException e){
                        System.out.println("Name must be alphabet");
                        continue;
                    }
                    boolean Result = validation.nameValidate(TemporaryName);
                    if (!Result) {
                        System.out.println("Name must be greater than 3 try again a process!!\n");
                    } else {
                        name[i] = TemporaryName;
                        name1 = true;
                        break;
                    }
                }


            boolean gender = true;
            while (gender) {
                System.out.println("Enter the sex of the customer " + (i + 1));
                try {
                    sex[i] = scan.next();
                } catch (InputMismatchException e) {
                    System.out.println("Sorry sex of customers should be either male or female!");
                    scan.next();
                    gender = false;
                    continue;

                }
                if ((sex[i].equalsIgnoreCase("MALE") || sex[i].equalsIgnoreCase("FEMALE")
                 ||sex[i].equalsIgnoreCase("male")||sex[i].equalsIgnoreCase("female")
                 ||sex[i].equalsIgnoreCase("Male")||sex[i].equalsIgnoreCase("Fmale"))) {
                    gender = true;
                    break;
                } else {
                    System.out.println(" Sorry sex of customers should be either male or female!");
                    continue;
                }
            }


            while (true) {
                boolean isage = false;
                int age1;
                System.out.println("Enter the age of the customer " + (i + 1));
                try {
                    age1 = scan.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println(" Age must be numerical value");
                    continue;
                }
                if ((age1 >= 18) && (age1 <= 100)) {
                    age[i] = age1;
                    isage = true;
                    break;
                }
                if (isage == false) {
                    System.out.println(" Age is must be greater than 18 or less than 100 ");
                    continue;
                }

            }


/*

            while(true) {
                boolean pinCodeChecker = true;
                int pincode=0;
                int count=0;
                Boolean isPinRepted = true;
                System.out.println("Enter PIN Number");
                try {
                    pincode = scan.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println(" PIN must be a numerical value so try again the process");
                    pinCodeChecker = false;
                    continue;
                }

                while (pincode != 0) {
                    pincode = (pincode/ 10);
                    ++count;
                }
                if (count == 4) {
                    pin[i]= pincode;
                    pinCodeChecker = true;
                    break;
                }
                if (pinCodeChecker==false) {
                    System.out.println(" PIN length must be 4  ");
                    pinCodeChecker = false;
                    continue;
                }

            }
*/



            boolean Acc = true;
            while (Acc) {
                boolean isRepet = false;
                try {
                    System.out.println("Enter the account number of the customer " + (i + 1));
                    long temporaryAccount = 0;

                    temporaryAccount = scan.nextLong();

                    boolean resultAccount = validation.accountValidate(temporaryAccount);
                    if (!resultAccount) {
                        System.out.println(" The Account length is must be 13");
                        continue;
                    }
                    for(int n=0;n<account.length;n++){
                        if(account[n]==temporaryAccount){
                       System.out.println("Sorry this account already used by other Customer Please insert another");
                            isRepet = true;
                            break;
                        }
                    }
                   
                    if(isRepet==false&&resultAccount==true){
                        account[i] = temporaryAccount;
                        break;
                    }
                
                } catch (InputMismatchException e) {
                    System.out.println(" Input mismatch.Account number must be  numerical value!");
                    scan.next();
                    
                }
            }
                   


              

            boolean Init = true;
            while (Init) {
                double inbalance=0.0;
                try {
                    System.out.println("Enter the initial balance of the customer " + (i + 1));
                    inbalance = scan.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println(" Account number must be  numerical value!");
                    Init=false;
                }

                if (inbalance>= 25.0) {
                    balance[i]=inbalance;
                    break;
                }
                if (inbalance<25.0){
                        System.out.println(" Sorry for interrupting initial must be greater than 25");
                        continue;
                    }
                }

            }
        }


    public void Display() {
        System.out.println("CUSTOMER'S INFORMATION ARE");
        for (int i = 0; i < number; i++) {
            System.out.print("----------------------------------------------\n");
            System.out.println("Customer " + (i + 1));
            System.out.println("Name of the customer \t" + name[i]);
            System.out.println("Sex of the customer \t " + sex[i]);
            System.out.println("Age of the customer \t" + age[i]);
            System.out.println("Account of the customer \t" + account[i]);
            System.out.println("Initial balance of the customer \t" + balance[i]);
            System.out.print("----------------------------------------------\n");
        }
    }

    public void Deposit() {
        System.out.println("For Deposite");
        double Amount;
        long tempA = 0;
        int toCount =0;
        boolean IsDepositeCompleted = false;
        boolean dep;
        while(true){
           dep  = true;
        try{
        System.out.println("Enter your Account number");
        tempA = scan.nextLong();
        }catch(InputMismatchException e){
            System.out.println("Error occured insert only numerical value");
            dep = false;
            toCount++;
            if (toCount == 2) {
                System.out.println("Only you have one chance");
            }
            if (toCount == 3) {
                System.out.println("sorry for intrupting but you finished your chance ");
                     scan.next();
                      break;
            }
         scan.next();
        }

        if (dep == true) {
              break;
             }
                      
        }
if(dep==true){
        for (int i = 0; i < account.length; i++) {
            if (account[i] == tempA ) {
                System.out.println("Insert Amount to deposit");
                Amount = scan.nextInt();
                if (Amount > 0){
                 balance[i] += Amount;
                System.out.println( name[i]+" Your balance is " + balance[i]);
                IsDepositeCompleted = true;
                break;
            }
            }
        }
             if (IsDepositeCompleted==false) {
                System.out.println(" Sorry The Account Is Not Found");
            }
        }
        }

    

    public void Withdraw() {
        System.out.println("To Withdraw");
        double Withdraw1;
        long TemporaryAccount = 0;
        boolean isWithdrwalCompleted = false;
        int counting=0;
        boolean withdrwall1;
        while(true){
             withdrwall1 = true;
        try{
        System.out.println("Enter your Account number");
        TemporaryAccount  = scan.nextLong();
    }catch(InputMismatchException e){
        System.out.println("Error occured insert only numerical value");
        withdrwall1 = false;
         counting++;
        if (counting == 2) {
            System.out.println("Only you have one chance");
        }
        if (counting == 3) {
            System.out.println("sorry  for intrupting but you finished your chance ");
               scan.next();
                 break;
        }
        scan.next();  
    }
    if (withdrwall1 == true) { 
        break;
    }
    
    } 
    if(withdrwall1==true){
        for (int i = 0; i < account.length; i++) { 
            if (TemporaryAccount  == account[i]) {
                System.out.println("Welcome " + name[i]);
            System.out.println("Insert Amount to Withdrwal");
                Withdraw1 = scan.nextDouble();
                if (Withdraw1 >=25 && balance[i] >= 50) {
                    balance[i] -= Withdraw1;
                    System.out.println( name[i]+ " Your balance is " + balance[i]);
                    isWithdrwalCompleted = true;
                    break;
                }
                 else {
                     System.out.println(" sorry Minimum withdrawal is 25!");
                     isWithdrwalCompleted = false;
                    continue;
                }
            }

        }
    
        if (isWithdrwalCompleted==false) {
            System.out.println(" Sorry The Account Is Not Found");
                    
        }
    }
    }
    
    public void Search() {
        
        long tempS = 0;
        boolean search = false;
        boolean isFound;
        while(true){
         isFound = true;
        try{
        System.out.println("Enter your Account number you want to search");
        tempS = scan.nextLong();
    }catch(InputMismatchException e){
        System.out.println("Error occured insert only numerical value");
        count++;
        isFound = false;
       if (count == 2) {
            System.out.println("Only you have one chance");
        }
        if (count == 3) {
            System.out.println("sorry  for intrupting but you finished your chance ");
            scan.next();
                break;
        }
        scan.next(); 
    }
    if (isFound == true) 
        break;
    
}
if (isFound == true) { 
        for (int i = 0; i < account.length; i++) {
            if (tempS == account[i]) {
            System.out.println("--------------------------------------");
            System.out.println("------------ Search Result------------");
            System.out.println("--------------------------------------");
            System.out.println("Name of the customer " + name[i]);
            System.out.println("Sex of the customer  " + sex[i]);
            System.out.println("Age of the customer " + age[i]);
            System.out.println("Account of the customer " + account[i]);
            System.out.println("Initial balance of the customer " + balance[i]);
                search = true;
                System.out.println("----------------------------------------------");
               break;
            }
        }
        if (search == false) {
            System.out.println(" Sorry The Searched Account Is Not Found");
        }
    }
}
    public void Delete() {
        System.out.println("For  Deleting Customer");
        long temporaryDeleteAccount = 0;
        boolean isDeleted ;
        boolean fordeleteing = false;
        int countdelete =0;
        while(true){
              isDeleted = true;
         try{
        System.out.println("Enter Account number you want to Delete");
        temporaryDeleteAccount = scan.nextLong();
    }catch(InputMismatchException e){
        System.out.println("Error occured please insert only numerical value");
        isDeleted = false;
        countdelete++;
        if (countdelete == 2) {
            System.out.println("Only you have one chance");
        }
        if (countdelete == 3) {
            System.out.println("sorry  for intrupting but you finished your chance ");
            scan.next();
                  break;
        }
       scan.next(); 
    }
    if (isDeleted == true) {
        break;
    }
}
if (isDeleted == true){
        for (int i = 0; i < number; i++) {
            if (temporaryDeleteAccount == account[i]) {

                while(i<number){
                    account[i] = account[i + 1];
                    balance[i] = balance[i + 1];
                    name[i] = name[i + 1];
                    age[i] = age[i + 1];
                    sex[i ] = sex[i + 1];
                    i++;
                }

           number -= 1;
           System.out.println("Account is founded also it is deleted");
           fordeleteing = true;
                break;
            }
           
        }
         if(fordeleteing==false) {
                System.out.println("Account is not Found");
            }
    }
    }
   
    public void transfer(){

        long tempC;
        boolean transfer=false;
        double Balance = 0.0;
        boolean insufficientba =false;
          System.out.println("Enter Account number");
          tempC = scan.nextLong();
          for (int i = 0; i < account.length; i++) {
              if (tempC == account[i]){
                  System.out.println("Welcome " + name[i] + " please Enter the account number of the customer you want to transfer to");
                  long temp1 = scan.nextLong();
                  for (int j = 0; j < account.length; j++) {
                      if (temp1 == account[j]) {
                          System.out.println("Enter the amount to transfer");
                          int transfer_amount = scan.nextInt();
                          if (transfer_amount <= balance[i]) {
                              balance[j] = balance[j] + transfer_amount;
                              balance[i] = balance[i] - transfer_amount;
                              System.out.println("Dear customer you have transfered an amount of " + transfer_amount + " to the account " + account[j] + " your current balance is " + balance[i]);
                              transfer = true;
                              break;
                          }
                      }
                      else {
                          System.out.println(" transfer not completed your have insufficient balance!");
                          transfer= false;
                          insufficientba =true;
                          break;
                      }
              }
   
              }
          }if(insufficientba ==false){
          if (transfer == false) {
              System.out.println("Account not found");
          }
        }
       }
   



}
