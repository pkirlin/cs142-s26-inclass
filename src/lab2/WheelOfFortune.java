package lab2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Wheel of Fortune is a classic TV show in which contestants must guess letters to fill
 * in a phrase.
 */
public class WheelOfFortune {
    public static void main(String[] args) {
        String guessedLetters = "";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a secret phrase: ");
        // read a line from the scanner, turn it into a char array
        char[] secretArray = scanner.nextLine().toCharArray();

        // create the "puzzle array," which is the secret phrase array but with
        // unguessed letters replaced with dashes.
        char[] puzzleArray = makePuzzleArray(secretArray, guessedLetters);

        while (!Arrays.equals(puzzleArray, secretArray)) {
            System.out.println("The puzzle is: " + charArrayToString(puzzleArray));

            System.out.print("Guess a letter: ");
            // read just one single character
            char letter = scanner.nextLine().charAt(0);

            // count the frequency that this character appears in the secret phrase
            int frequency = countLetter(secretArray, letter);

            System.out.println("The letter " + letter + " appears " + frequency + " times.");

            // this letter is now guessed, so add it to our collection of guessed letters
            guessedLetters += letter;

            // recreate the puzzle array
            puzzleArray = makePuzzleArray(secretArray, guessedLetters);
        }

        System.out.println("You win!");
    }

    /**
     * This function takes a character array filled with the "secret phrase" and
     * a String containing all the letters that have been guessed so far, and returns
     * a new character array that is a copy of the secret array, except all letters
     * that have *not* been guessed yet are replaced with dashes.
     */
    public static char[] makePuzzleArray(char[] secretArray, String guessedLetters) {
        char[] puzzleArray = new char[secretArray.length];

        for (int i = 0; i < puzzleArray.length; i++) {
            if (guessedLetters.indexOf(secretArray[i]) != -1) {
                puzzleArray[i] = secretArray[i];
            } else if (secretArray[i] == ' ') {
                puzzleArray[i] = ' ';
            } else {
                puzzleArray[i] = '-';
            }
        }

        return puzzleArray;
    }

    /**
     * This function counts number of times a given letter appears in the
     * character array secretArray.
     */
    public static int countLetter(char[] secretArray, char letter) {
        int count = 0;
        for (int i = 0; i < secretArray.length; i++) {
            if (secretArray[i] == letter)
                count++;
        }
        return count;
    }

    /**
     * This function takes a character array and turns it into a String.
     */
    public static String charArrayToString(char[] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str += array[i];
        }
        return str;
    }

}