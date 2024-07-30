import java.util.Scanner;
import java.util.ArrayList;

public class word_count {
    //Stop words in english chosen by me
    public static String[] Stop_Words_Array={
            "a", "an", "and", "are", "as", "at", "be", "by", "for", "from", "has",
            "he", "in", "is", "it", "its", "of", "on", "that", "the", "to", "was",
            "were", "will", "with"
        };
    public static boolean check_stop_word(String word){
        for(String stop_word:Stop_Words_Array){
            if(stop_word.equals(word)){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the text: ");
        String input=sc.nextLine().trim();

        //is input empty 
        if(input.isEmpty()){
            System.out.println("No input is provided");
            return ;
        }
        //split the text
        String[] text =input.split("\\W+"); //store in an Array

        //ArrayList
        ArrayList<String> unique_word_ArrayList=new ArrayList<>();
        ArrayList<Integer> freq_ArrayList=new ArrayList<>();
        int word_count=0;

        for(String word:text){ 
            if(!word.isEmpty()){ 
                word_count++;  //check the split word is empty or not
                word=word.toLowerCase();
                if(!check_stop_word(word) && !word.contains(",")){    //both will true then it will execute
                    int index=unique_word_ArrayList.indexOf(word); //initially all the index is -1
                    if(index==-1){
                        unique_word_ArrayList.add(word);
                        freq_ArrayList.add(1);
                        
                    }else{ // word is already present in the unique_word_ArrayList then only freq will incrase
                        freq_ArrayList.set(index, freq_ArrayList.get(index)+1);
                    }
                }
            }
        }

        // Display the total count of words
        System.out.println("Total count of words: " + word_count);

        // Display the frequency of each word
        System.out.println("Word frequencies:");
        for (int i = 0; i < unique_word_ArrayList.size(); i++) {
            System.out.println(unique_word_ArrayList.get(i) + ": " + freq_ArrayList.get(i));
        }

        sc.close();
    }
 
}
