package hashtable;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word list (comma-separated): ");
        String wordListInput = scanner.nextLine();
        System.out.println("enter a word to search in the list: ");
        String searchword = scanner.nextLine();

        String[] words = wordListInput.split(",");
        Arrays.sort(words);

        boolean found = binarySearch(words,searchword);
        if(found){
            System.out.println("The word '"+ searchword + "' was found in the list");
        }else {
            System.out.println("the word '"+searchword+"' was not found in the list");
        }
        scanner.close();
    }

    private static boolean binarySearch(String[] words, String searchword) {
        int low = 0;
        int high = words.length-1;

        while (low<=high){
            int mid = low + (high-low)/2;
            int comparison = searchword.compareTo(words[mid]);
            if (comparison == 0){
                return true;
            } else if (comparison<0) {
                high = mid - 1;

            }else {
                low = mid + 1;
            }
        }
        return false;
    }
}

