import java.util.Scanner;
class BankingSystem{
    float balance=0;
    String name;
    int  pin;
    public void Details(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter you name: ");
        name=sc.nextLine();
        System.out.print("Enter you pin number: ");
        int pin=sc.nextInt();
        if(checkPin(pin)){
            options();
        }else{
            System.out.println("Enter correct 4 digit pin number");
        }
    }
    public static boolean checkPin(int pin){
        if(String.valueOf(pin).length()==4){
            return true;
        }else{
            return false;
        }
    }

    public void options(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n\t\t\t\t\t\t\tOPTIONS");
        System.out.println("1 for Deposit\n2 for Withdraw\n3 for check balance\n4 for Exit\n");
        System.out.print("Enter your preference: ");
        int user_choice=sc.nextInt();
        do{
        switch (user_choice) {
            case 1:
                Deposit();
            case 2:
                Withdraw();
            case 3:
                CheckBalance();
            case 4:
                System.out.println("Exiting... Thank you for using the ATM!");
                break;
            default:
                System.out.println("Enter a correct option!");
        }
    } while (user_choice != 4);
}


    public void Deposit(){
        Scanner sc=new Scanner(System.in);
            System.out.println("Enter the the amount you want to deposit: ");
            float amount=sc.nextFloat();
            balance+=amount; 
            System.out.println("Deposit Sucessfully");
        options(); 
    }

    public void Withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter amount to withdraw: ");
        float amount=sc.nextFloat();
        if(balance>0 && amount<balance ){
            balance -=amount;
            System.out.println("Withdraw Successfully!!");
        }
        options();
    }

    public void CheckBalance(){
        System.out.println("Available Amount is "+balance);
        options();
    }

}


public class atm {
    public static void main(String[] args) {
        BankingSystem user=new BankingSystem();
        System.out.println("\t\t\t\t\t\t\tATM");
        user.Details();
        
    }
    
}
