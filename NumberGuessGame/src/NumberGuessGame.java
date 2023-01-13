import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class NumberGuessGame {
    public static void main(String[] args) throws Exception {

        int max = 101;
        Random InitialNumber = new Random();
        int int_random = InitialNumber.nextInt(max);
        System.out.println("Random integer value from 0 to " + (max - 1) + " : " + int_random);

        // Create ArrayList "NumbersList" to store all guesses
        ArrayList<Integer> NumbersList = new ArrayList();

        // Ask for Number
        Scanner AskforNumber = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter a number from 0-100");

        // Check if Input is Int.
        while (true) {

            // Check if input is an integer
            if (AskforNumber.hasNextInt()) {
                int NumberInput = AskforNumber.nextInt();

                // Check if number is within Bounds
                // Not within 0-100
                if (NumberInput < 0 || NumberInput > 100) {
                    System.out.println("Integer is not within bounds. Pick between 0-100.");
                }

                // Within 0-100
                else {
                    // Check if the Number is in the ArrayList

                    // In ArrayList
                    if (NumbersList.contains(NumberInput)) {
                        AskforNumber.next();
                        System.out.println("You have already used this number. Pick again");
                    }

                    // Not in ArrayList
                    else {
                        NumbersList.add(NumbersList.size(), NumberInput); // adds the number to ArrayList

                        // If the there is a number that matches the random number
                        if (NumberInput == int_random) {
                            System.out.println("Correct! The number is " + int_random + ". You solved it in "
                                    + NumbersList.size() + " tries!");
                            break;
                        }

                        // When the input does not match the random number
                        else {
                            // Number too Low
                            if (NumberInput < int_random) {
                                System.out.println("Too Low! The number is greater than " + NumberInput);
                            }

                            // Number too high
                            //if (NumberInput > int_random) {
                            else{
                                System.out.println("Too High! The number is less than " + NumberInput);
                            }

                        }

                    }
                }

            }

            // Input is not an integer
            else {
                AskforNumber.next();
                System.out.println("Please enter a valid integer");
            }
        }

    }
}
