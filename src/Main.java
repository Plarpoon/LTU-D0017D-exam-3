
/**
 * ===============================================================
 * What does the program do:
 * A program that simulates the dice game 12
 * ===============================================================
 * Pseudocode steps:
 * 1. Defining all the variables
 * 2. Create a global loop that will run the game until the user wants to stop
 * 3. Switch to determine which dice to roll
 * 4. Be sure to put flags to see which dice hasn't been rolled yet
 * 5. Print the results
 * 6. Zero the counters and restart the random number generator
 * ===============================================================
 * Alessandro Suha
 * alesuh-1
 */

import java.util.Scanner;
import java.util.Random;

class Main {
  public static int RANDOM_NUMBER_GENERATOR(int MIN, int MAX) { // Generates a random number between 1 and 6
    Random r = new Random();
    int randomNum = r.nextInt(MAX - MIN);
    int result = randomNum + MIN;
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char input;
    boolean flag = true;
    int[] dice = new int[] { 0, 0, 0 };
    int result;
    int win_counter = 0;
    int lose_counter = 0;
    boolean[] missing_dice = new boolean[3];

    final int MIN = 1;
    final int MAX = 6;
    final String GAME_OVER = "Game Over!";
    final int VICTORY = 12;

    System.out.println("Welcome to the game 12. You must roll 1-3 dice and try to get the sum 12\n...");

    while (true) {

      while (flag) {
        System.out.print("Enter which dice you want to roll [1,2,3] (exit with q): ");
        input = sc.next().charAt(0);
        switch (input) { // Roll dice
          case 'q':
            System.out.println(GAME_OVER);
            sc.close();
            System.exit(0);
          case 'Q':
            System.out.println(GAME_OVER);
            sc.close();
            System.exit(0);
          case '1':
            dice[0] = RANDOM_NUMBER_GENERATOR(MIN, MAX);
            missing_dice[0] = true;
            flag = false;
            break;
          case '2':
            dice[1] = RANDOM_NUMBER_GENERATOR(MIN, MAX);
            missing_dice[1] = true;
            flag = false;
            break;
          case '3':
            dice[2] = RANDOM_NUMBER_GENERATOR(MIN, MAX);
            missing_dice[2] = true;
            flag = false;
            break;
          default:
            System.out.println("Invalid input! Type either 1, 2, 3 or q/Q");
        }
      }
      result = dice[0] + dice[1] + dice[2]; // Calculate result

      if (result == VICTORY) {
        win_counter++; // win_counter = win_counter + 1;
        System.out
            .println(dice[0] + " " + dice[1] + " " + dice[2] + " sum: " + result + "#win: " + win_counter + " #loss: "
                + lose_counter);
        System.out.println("Next round!");
        for (int i = dice.length - 1; i >= 0; i--) {
          dice[i] = 0; // reset dice
        }
        flag = true;
      } else {
        switch (dice[0]) { // Check if dice 1 is missing
          case 0:
            missing_dice[0] = true;
            break;
          default:
            missing_dice[0] = false;
        }
        switch (dice[1]) { // Check if dice 2 is missing
          case 0:
            missing_dice[1] = true;
            break;
          default:
            missing_dice[1] = false;
        }
        switch (dice[2]) { // Check if dice 3 is missing
          case 0:
            missing_dice[2] = true;
            break;
          default:
            missing_dice[2] = false;
        }

        // If all dices are present, then the player loses
        if (missing_dice[0] == false && missing_dice[1] == false && missing_dice[2] == false) {
          lose_counter++; // lose_counter = lose_counter + 1;
          System.out
              .println(dice[0] + " " + dice[1] + " " + dice[2] + " sum: " + result + "#win: " + win_counter + " #loss: "
                  + lose_counter);
          System.out.println("Next round!");
          for (int i = dice.length - 1; i >= 0; i--) {
            dice[i] = 0; // reset dice
          }
        } else {
          System.out
              .println(dice[0] + " " + dice[1] + " " + dice[2] + " sum: " + result + "#win: " + win_counter + " #loss: "
                  + lose_counter);
        }
        flag = true;
      }
    }
  }
}