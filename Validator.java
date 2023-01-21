public class Validator extends Bank {
    boolean nameValidate(String ValidationName)  {

        boolean name = ValidationName.matches("[A-Za-z]\\D{2,15}");

        return name;

    }

    boolean initialValidate(double validationinitial) {

        boolean intial = false;
        if (validationinitial > 25) {
            intial = true;
        }

        return intial;
    }

   boolean accountRep(long validationnew){
    boolean account2 =false;

    for(int n=0;n<account.length;n++){
        if(account[n]==validationnew){
            account2=true;
        }
    }
    return account2;
}

    boolean accountValidate(long validationAccount) {
    int count =0;
        boolean account1 = false;
       
            while (validationAccount != 0) {
                validationAccount = (validationAccount / 10);
                ++count;
            }
            if (count == 13) {
                account1 = true;
            }

            return account1;
        }

    }