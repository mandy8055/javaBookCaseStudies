package strings.Exercises;

import java.util.Scanner;
import java.util.Random;
public class Exercise25 {
    public static void main(String[] args){
        Hangman hangman = new Hangman();
        hangman.playGame();
    }
}

class Hangman{
    private static final Scanner sc = new Scanner(System.in);
    private static final Random random = new Random();
    private final String[] wordList = {"hurry", "body", "corrupt", "announce", "conspire",
            "transfer", "magnify", "uttermost", "kindhearted", "faithful", "obese", "mew", "Hello World"};
    private final int totalHints = 5;
    private String word;
    private String encrypted;
    private int hintsRemaining;
    private int gameState;
    Hangman(){
        word = getWord();
        word = word.toLowerCase();
        encrypted = getStars();
        hintsRemaining = totalHints;
        gameState = -1;
    }

//  Get a random word from the wordList array
    private String getWord(){
        return wordList[random.nextInt(wordList.length - 1)];
    }

    public void playGame(){
        while(true){
            System.out.println("Hints Remaining: " + hintsRemaining);
            System.out.print("(Guess) Enter a letter of the word " + encrypted + " > ");
            char ch = Character.toLowerCase(sc.nextLine().charAt(0));
            if(isPresent(word, ch)){
                if (isPresent(encrypted, ch))System.out.println(ch + " is already in the word.");
                else encrypted = getUpdatedString(ch);
            }else {
                System.out.println(ch + " is not in the word.");
                hintsRemaining--;
            }
            if(countStars() == 0)gameState = 0;
            if(hintsRemaining == 0 && gameState == -1){
                System.out.println(gameOver());
                break;
            }
            if(hintsRemaining != 0 && gameState == 0){
                System.out.println(victory());
                break;
            }
        }
    }

    private String getStars(){
        StringBuilder sb = new StringBuilder();
        for(char ch : word.toCharArray()){
            if(Character.isSpaceChar(ch))sb.append(" ");
            else sb.append("*");
        }
        return sb.toString();
    }

    private boolean isPresent(String word, char ch){
        for(char chr: word.toCharArray()){
            if(ch == chr)return true;
        }
        return false;
    }
//  Method to display message when a user looses
    private String gameOver(){
        return "Well Tried!!! The word was " + word + ". Better luck next time...";
    }

    private String getUpdatedString(char ch){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(char chr : word.toCharArray()){
            if(chr == ch)sb.append(ch);
            else if(chr == ' ')sb.append(' ');
            else if(encrypted.charAt(i) != '*')sb.append(chr);
            else sb.append("*");
            i++;
        }
        return sb.toString();
    }
//  Method to display message when a user wins the game
    private String victory(){
        return "Viola!! You guessed it right. The word is "+ word +". Congratulations on the job well done...";
    }

//  Method to count number of stars in the given encrypted String
    private int countStars(){
        int counter = 0;
        for(char ch: encrypted.toCharArray()){
            if(ch == '*')counter++;
        }
        return counter;
    }
}
