
/**
 * ===============================================================
 * What does the program do:
 * A program that simulates the dice game 12
 * ===============================================================
 * Pseudocode steps:
 * 1. XXXX
 * 2. XXXX
 * 3. XXXX
 * ===============================================================
 * Alessandro Suha
 * alesuh-1
 */

import java.util.Scanner;
import java.util.Random;

class Main {
  final static String GAME_OVER = "Game Over!";
  final static int VICTORY = 12;
  final static int MIN = 1;
  final static int MAX = 6;

  public static int RANDOM_NUMBER_GENERATOR() { // Generates a random number between 1 and 6
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

    System.out.println("Welcome to the game 12. You must roll 1-3 dice and try to get the sum 12\n...");

    while (flag) {
      System.out.print("Enter which dice you want to roll [1,2,3] (exit with q): ");
      input = sc.next().charAt(0);
      switch (input) { // Roll dice
        case 'q':
          System.out.println(GAME_OVER);
          System.exit(0);
          break;
        case 'Q':
          System.out.println(GAME_OVER);
          System.exit(0);
          break;
        case '1':
          dice[0] = RANDOM_NUMBER_GENERATOR();
          System.out.println("random number " + dice[0]); // TODO: DEBUG
          missing_dice[0] = true;
          flag = false;
          break;
        case '2':
          dice[1] = RANDOM_NUMBER_GENERATOR();
          System.out.println("random number " + dice[1]); // TODO: DEBUG
          missing_dice[1] = true;
          flag = false;
          break;
        case '3':
          dice[3] = RANDOM_NUMBER_GENERATOR();
          System.out.println("random number " + dice[2]); // TODO: DEBUG
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
      for (int i = dice.length; i > 0; i--) {
        dice[i] = 0; // reset dice
      }
      System.out
          .println(dice[0] + " " + dice[1] + " " + dice[2] + " sum: " + result + "#win: " + win_counter + " # loss: "
              + lose_counter);
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
      }
      System.out
          .println(dice[0] + " " + dice[1] + " " + dice[2] + " sum: " + result + "#win: " + win_counter + " #loss: "
              + lose_counter);
      System.out.println("vector length " + dice.length); // TODO: DEBUG
      for (int i = dice.length; i > 0; i--) {
        dice[i] = 0; // reset dice
      }
    }

    sc.close();
  }
}