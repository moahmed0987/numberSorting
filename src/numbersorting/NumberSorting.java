package numbersorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NumberSorting {

    static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     *             This is the main method of the program
     */
    public static void main(String[] args) {
        ArrayList<Integer> userNumbers = new ArrayList<>();
        int userNumber = 0;

        boolean go = true;
        while (go == true) {
            String[] x = getNumber();
            go = Boolean.valueOf(x[0]);
            String userNumberAsString = x[1];
            if (userNumberAsString != null) {
                userNumber = Integer.parseInt(userNumberAsString);
                userNumbers.add(userNumber);
            }

        }

        int[] userNumbersArray = new int[userNumbers.size()];
        for (int i = 0; i < userNumbers.size(); i++) {
            userNumbersArray[i] = userNumbers.get(i);
        }

        userNumbersArray = sort(userNumbersArray);

        double average = 0;
        int max, min;
        min = userNumbersArray[0];
        max = userNumbersArray[userNumbersArray.length - 1];
        for (int i = 0; i < userNumbersArray.length; i++) {
            average += userNumbersArray[i];
        }
        average /= userNumbersArray.length;

        System.out.println();
        System.out.println("Sorted numbers = " + Arrays.toString(userNumbersArray));
        System.out.println("Maximum number = " + max);
        System.out.println("Minimum number = " + min);
        System.out.println("Average of the numbers = " + average);

    }

    /**
     * @return String[] This method gets the user input and returns it as a string
     *
     *        This method also checks if the user wants to continue or not
     */
    public static String[] getNumber() {
        int userInt = 0;
        String[] x = new String[2];
        while (true) {
            try {
                System.out.print("Enter a number to add, F to finish adding or Q to quit: ");
                String userNumberStr = input.next().toUpperCase();
                if (userNumberStr.equals("Q")) {
                    //user has quit
                    System.exit(0);
                } else if (userNumberStr.equals("F")) {
                    x[0] = "false";
                    x[1] = null;
                } else {
                    userInt = Integer.parseInt(userNumberStr); //to check if is int
                    x[0] = "true";
                    x[1] = userNumberStr;
                }
                return x;
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Error, enter a valid input.");
            }
        }
    }

    /**
     * @param userNumbersArray This method sorts the array of numbers
     * @return int[] This method returns the sorted array of numbers
     */
    public static int[] sort(int[] userNumbersArray) {

        //declare and assign size
        int size = userNumbersArray.length;

        //for i in range(0, size - 1)
        for (int i = 0; i < size - 1; i++) {
            //for j in range(0, size - i - 1)
            for (int j = 0; j < size - i - 1; j++) {
                //if the value is bigger than the next
                if (userNumbersArray[j] > userNumbersArray[j + 1]) {
                    //swap them around
                    int temp = userNumbersArray[j];
                    userNumbersArray[j] = userNumbersArray[j + 1];
                    userNumbersArray[j + 1] = temp;
                }
                //else do nothing
            }
        }
        return userNumbersArray;
    }

}
