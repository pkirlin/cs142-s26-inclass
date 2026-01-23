package lab1;
import java.util.Objects;
import java.util.Scanner;
/**
 * Write a program to simulate a single turn of the game "One is Zero." The game works
 * like this:
 * - During a turn, you roll a six-sided die.
 * - If you roll 2-6, you get that number of points and may roll again to get more
 * points, or you may choose to end your turn. Whenever you choose to end your
 * turn, you earn all the accumulated points from the previous die rolls.
 * - However, if you ever roll a 1, your turn ends, you lose any points you already
 * accumulated for that turn, and you earn zero total points for that turn.
 * - Print the total points you receive for that turn at the end.
 * - Bonus: If there is time, allow two players to alternate taking turns (points
 * accumulate for each turn), and after five turns each, the game ends. Print final
 * point totals and the winner.
 */

public class OneIsZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points = 0;
        int roll = 0;
        String answer = "y";
        while (roll != 1 && answer.equals("y")) { // don't worry about the equals part for now
            roll = (int) (Math.random() * 6) + 1;
            System.out.println("You rolled " + roll);
            if (roll != 1) {
                points += roll;
                System.out.println("You have " + points + " points");
                System.out.print("Do you want to roll again? y/n: ");
                answer = scanner.nextLine();
            }
            else {
                points = 0;  // lose all points
            }
        }
        System.out.println("You end with " + points + " points");
    }

}