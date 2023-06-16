package hashtable;

import java.util.Scanner;

public class WordSortInsertion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the l of words (space-separated): ");
        String wordListInput = scanner.nextLine();

        String[] words = wordListInput.split(" ");

        insertionSort(words);

        System.out.println("Sorted List of Words:");
        for (String word : words) {
            System.out.println(word);
        }

        scanner.close();
    }

    public static void insertionSort(String[] words) {
        int n = words.length;

        for (int i = 1; i < n; i++) {
            String key = words[i];
            int j = i - 1;

            while (j >= 0 && words[j].compareTo(key) > 0) {
                words[j + 1] = words[j];
                j--;
            }

            words[j + 1] = key;
        }
    }
}
