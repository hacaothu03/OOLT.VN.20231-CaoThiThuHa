// lab01 exercise 6.5

package hust.soict.hedspi.lab01;
import java.util.*;

public class SortSumArray {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        // Ask the user for the array size
        System.out.print("Enter array size: ");
        int n = Input.nextInt();

        // Ask the user to enter array items
        System.out.print("Enter array items: ");

        int[] my_array1 = new int[n];

        // Loop to populate the array with user input
        for (int i = 0; i < n; i++) {
            my_array1[i] = Input.nextInt();

            // If there are more items to enter, prompt the user for the next item
            if (i < n - 1) {
                System.out.print("Enter next item: ");
            }
        }

        // Sort the array in ascending order
        Arrays.sort(my_array1);

        int Sum = 0;
        int numbers = 0;

        // Calculate the sum and count the numbers in the array
        for (int num : my_array1) {
            Sum += num;
            numbers += 1;
        }

        // Calculate the average value of the array
        int Avg = Sum / numbers;

        // Display the sorted array, sum, and average
        System.out.print(Arrays.toString(my_array1) + "\n");
        System.out.print("Sum of the array is: " + Sum + "\n");
        System.out.print("The average value of the array is: " + Avg + "\n");
    }
}
