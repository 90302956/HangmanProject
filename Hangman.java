import java.util.Arrays;
import java.util.Scanner;

public class Hangman{
    public static void main(String[] args) {
        String[] words = {"writer", "that", "program"};
        // Pick random index of words array
        int randomWordNumber = (int) (Math.random() * words.length);
        // Create an array to store already entered letters
        char[] enteredLetters = new char[words[randomWordNumber].length()];
        int triesCount = 0;
        boolean wordIsGuessed = false;
        int triesCount2 = 0;
        do {
        switch (enterLetter(words[randomWordNumber], enteredLetters)) {
            case 0:
                triesCount++;
                triesCount2++;
                if(triesCount2 == 0) {
                	System.out.println("You have 6 tries left!");
                	System.out.println(" _____");
                	System.out.println("|");
                	
                }
                if(triesCount2 == 1) {
                	System.out.println("You have 5 tries left!");
                	System.out.println(" _____");
                	System.out.println("|     |");
                	System.out.println("|    |_|");
                	System.out.println("|");
                	System.out.println("|");
                }
                if(triesCount2 == 2) {
                	System.out.println("You have 4 tries left!");
                	System.out.println(" _____");
                	System.out.println("|     |");
                	System.out.println("|    |_|");
                	System.out.println("|     |");
                	System.out.println("|");
                }
                if(triesCount2 == 3) {
                	System.out.println("You have 3 tries left!");
                	System.out.println(" _____");
                	System.out.println("|     |");
                	System.out.println("|    |_|");
                	System.out.println("|     |");
                	System.out.println("|      \\");
                }
                if(triesCount2 == 4) {
                	System.out.println("You have 2 tries left!");
                	System.out.println(" _____");
                	System.out.println("|     |");
                	System.out.println("|    |_|");
                	System.out.println("|     |");
                	System.out.println("|    / \\");
                }
                if(triesCount2 == 5) {
                	System.out.println("You have 1 try left!");
                	System.out.println(" _____");
                	System.out.println("|     |");
                	System.out.println("|    |_|");
                	System.out.println("|     |-");
                	System.out.println("|    / \\");
                }
                if(triesCount2 == 6) {
                	System.out.println("You lose!");
                	System.out.println(" _____");
                	System.out.println("|     |");
                	System.out.println("|    |_|");
                	System.out.println("|    -|-");
                	System.out.println("|    / \\");
                }
                break;
            case 1:
                triesCount++;
                break;
            case 2:
                break;
            case 3:
                wordIsGuessed = true;
                break;
        }
        } while (! wordIsGuessed && triesCount2 < 6);
        System.out.println("\nThe word was " + "\"" + words[randomWordNumber] + "\"" + ".");
            
    }
    
    public static int enterLetter(String word, char[] enteredLetters)    {
        System.out.print("Enter a letter in word ");
        if (! printWord(word, enteredLetters))
            return 3;
        System.out.print(" Your guess---> ");
        Scanner input = new Scanner(System.in);
        int emptyPosition = findEmptyPosition(enteredLetters);
        char userInput = input.nextLine().charAt(0);
        if (inEnteredLetters(userInput, enteredLetters)) {
            System.out.println(userInput + " is already in the word");
            return 2;
        }
        else if (word.contains(String.valueOf(userInput))) {
            enteredLetters[emptyPosition] = userInput;
            return 1;
        }
        else {
            System.out.println(userInput + " is not in the word");
            return 0;
            
            }
    }

    public static boolean printWord(String word, char[] enteredLetters) {
        boolean asteriskPrinted = false;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (inEnteredLetters(letter, enteredLetters))
                System.out.print(letter);
            else {
                System.out.print('*');
                asteriskPrinted = true;
            }
        }
        return asteriskPrinted;
    }

    public static boolean inEnteredLetters(char letter, char[] enteredLetters) {
        return new String(enteredLetters).contains(String.valueOf(letter));
    }

    public static int findEmptyPosition(char[] enteredLetters) {
        int i = 0;
        while (enteredLetters[i] != '\u0000') i++;
        return i;
    }
}