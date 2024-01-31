import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PalindromeChecker {

    public void tester() {
        String[] lines = new String[6]; 
        try {
            File myFile = new File("palindromes.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        System.out.println("There are " + lines.length + " lines");
        for (int i = 0; i < lines.length; i++) {
            if (palindrome(lines[i])) {
                System.out.println(lines[i] + " IS a palindrome.");
            } else {
                System.out.println(lines[i] + " is NOT a palindrome.");
            }
        }
    }

    public boolean palindrome(String word) {
        String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String reversed = reverse(cleanWord);
        return cleanWord.equals(reversed);
    }

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
