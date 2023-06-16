package hashtable;

import java.util.Scanner;

public class ThinkNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of N (2^n): ");
        int N = scanner.nextInt();

        int low = 0;
        int high = N - 1;

        int guessCount = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            System.out.print("Is the number between " + low + " and " + mid + "? (true/false): ");
            boolean isBetween = scanner.nextBoolean();
            guessCount++;

            if (isBetween) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("The number you were thinking of is: " + low);
        System.out.println("Total guesses: " + guessCount);

        scanner.close();
    }
}
