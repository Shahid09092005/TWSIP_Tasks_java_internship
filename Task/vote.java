import java.util.Scanner;
import java.util.ArrayList;

class OnlineVoting {

static ArrayList<Integer> aadharList = new ArrayList<>();

//Information of the user
    public static void information(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your name: ");
    String name = sc.nextLine();
    System.out.print("Enter your age: ");
    int age = sc.nextInt();
    System.out.print("Enter your Aadhar number: ");
    int aadharNumber = sc.nextInt();
    System.out.println();
    //Stroing the aadhar card number
    // Length of AadharNumber
    int len = String.valueOf(aadharNumber).length();
    
    eligible(age,len,aadharList,aadharNumber);  // checking the eligibility to vote or not
    }

//eligibiliy
    public static void eligible(int age,int len,ArrayList<Integer> aadharList,int aadharNumber){
        // Checking the age of the person and the length of Aadhar Card
        if (age > 17) {  
            //checking unique adhar card
            uniqueAadharNumber(aadharList, aadharNumber);
        } else {
            System.out.println("Enter your correct Age");
            }
     }
//unique adharnumber
     public static void uniqueAadharNumber(ArrayList<Integer> aadharList,int aadharNumber){
        if (aadharList.contains(aadharNumber)==true) {
            System.out.println("You already voted.\n");
            information();
            } else {
            // Adding the new Aadhar number to the list to mark as voted
            aadharList.add(aadharNumber);
            //call the party method
                checkStatus();
            }
     }
    
// Party votes
    static int count_A = 0, count_B = 0, count_C = 0, count_D = 0; //Static because shared among all instances of the OnlineVoting class.

//checkStatus
    public static void checkStatus() {
        if(count_A < 6 && count_B < 6 && count_C < 6 && count_D < 6) {
            // checking is the user adhar card number is unique or not
            party();
        } else {
            winParty();
        }
    }


// Party 
    public static void party() {
        System.out.println("----------------------------------------------Party----------------------------------------------------");
        System.out.println("1 for A");
        System.out.println("2 for B");
        System.out.println("3 for C");
        System.out.println("4 for D");
        vote();   // Calling vote() method
    }

//vote
    public static void vote() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your vote: ");
        int user_vote = sc.nextInt();
        if(user_vote>4){
            System.out.println("Invalid Party");
            party();
        }else{
            switch (user_vote) {
                case 1:
                    count_A++;
                    break;
                case 2:
                    count_B++;
                    break;
                case 3:
                    count_C++;
                    break;
                case 4:
                    count_D++;
                    break;
                default:
                    System.out.println("Choose the correct party");
                    exit();
                    break;
            }
            System.out.println("Thankyou for Voting !\n");
            //ask to another user to vote or not
            exit();
        }
    }

//exit
    public static void exit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("NOTE: for Voting type 'y' or exit type 'n' : ");
        char askVote = sc.next().charAt(0);  // Read the first character of the user input
        if (askVote == 'y') {
            information();
            // checkStatus();
        } else if (askVote == 'n') {
            System.out.println("Toh phir jao. kishi dushre ko aaen doh\n");
            // Optionally, you can also call user.currentVote() here if needed
            vote();
        } else {
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
            exit();  // Call exit() again for another chance to input
        }
    }
    

//currentVote
    public static void currentVote() { // Check party current votes
        System.out.println("Party A: " + count_A);
        System.out.println("Party B: " + count_B);
        System.out.println("Party C: " + count_C);
        System.out.println("Party D: " + count_D);
    }
    
//wiinParty
    public static void winParty() {  // If any party has vote count greater than 5, then it will win!
        if (count_A > 5) {
            System.out.println("Party A wins!");
        } else if (count_B > 5) {
            System.out.println("Party B wins!");
        } else if (count_C > 5) {
            System.out.println("Party C wins!");
        } else if (count_D > 5) {
            System.out.println("Party D wins!");
        }
    }

}



public class vote{
    public static void main(String[] args) {
        System.out.println("\n\t\t\t\t\t\tOnline Voting System\n");
        OnlineVoting user = new OnlineVoting();  
        user.information(); //
    }
}
