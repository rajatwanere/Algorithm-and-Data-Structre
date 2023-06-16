package hashtable;

import java.util.Scanner;

public class PalPrime
    {




            public static void main(String args[])
            {
                int startRange, endRange;

                //create scanner class object
                Scanner sc=new Scanner(System.in);

                //show custom message
                System.out.println("Enter start value");

                //store user entered value into variable startRange
                startRange = sc.nextInt();

                //show custom message
                System.out.println("Enter last value");

                //store user entered value into variable endRange
                endRange = sc.nextInt();

                System.out.println("The PalPrime Numbers between" + startRange + " and " + endRange + "are:");
                for(int i = startRange; i <= endRange; i++){
                    if(checkPalPrimeNumber(i))
                        System.out.println(i);
                }

            }

            static boolean checkPalPrimeNumber( int number){

                //declare and initialize variables
                int temp, rem, i;
                int count = 0;
                int sum = 0;

                //store number in a temporary variable temp
                temp = number;

                //use for loop check whether number is prime or not
                for(i = 1; i <= temp; i++)
                {
                    if(temp%i == 0)
                    {
                        count++;    //increment counter when the reminder is 0
                    }
                }

                //use while loop to check whether the number is palindrome or not
                while(number > 0)
                {
                    // get last digit of the number
                    rem = number%10;

                    // store the digit last digit
                    sum = sum*10+rem;

                    // extract all digit except the last
                    number = number/10;
                }

                //check whether the number is palindrome and Prime or not
                if(temp == sum && count == 2)
                    return true;
                else
                    return false;
            }
        }
