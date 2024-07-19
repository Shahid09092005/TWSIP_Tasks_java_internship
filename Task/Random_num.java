import java.util.Scanner;   // for taking user value
import java.util.Random;    // for Generating random number

public class Random_num{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);   // callint Scanner library for taking input
        Random random=new Random();    //obj of the Random class
        int num_to_Guess = random.nextInt(100) + 1; // random.nextInt(100) will generate number btw [0,99]
        // that's why we added 1 to generate the random number [1,100]
        System.out.println("\n\t\t\t\t\t\t\tRandom Number Guessing Game");
        System.out.println("Note: 5 times you can guess!");
        int max_guess=5;
        Boolean guessConformation=false;

        while(!guessConformation){
            System.out.println();
            System.out.print("Enter the guess number: ");
            int user_guess=sc.nextInt();  // in this area it uses it first chance so the guessing number after this use it should be 4

            if(user_guess>0 && user_guess<101){
                if(max_guess<=0){
                    System.out.println("Sorry!, but you used all the  guessing chances!");
                    System.out.println("Availabile guess chances is "+max_guess);
                    System.out.println("The guess number is "+num_to_Guess);
                    break;
                }else{
                    if(user_guess<num_to_Guess){
                        System.out.println("Your guessing number is smaller than guess number!");
                        System.out.println("Availabile guess chances is "+max_guess+"\n");
                        max_guess--;
                    }else if(user_guess>num_to_Guess){
                        System.out.println("Your guessing number is larger than guess number!");
                        System.out.println("Availabile guess chances is "+max_guess+"\t");
                        max_guess--;
                    }else{
                        System.out.println("Congratulation !! , you correctly guess the number in "+(5-max_guess)+" chances");

                        guessConformation=true;
                    }             
                }

            }else{
                System.out.println("Please chose the number of 1-100 range");
                break;
            }
        }
        sc.close();

    }
}