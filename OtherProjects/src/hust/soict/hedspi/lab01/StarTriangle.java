package hust.soict.hedspi.lab01;
import java.util.Scanner;

public class StarTriangle {
	    public static void main(String[] args)
	    {
	        Scanner keyboard = new Scanner(System.in);

	        System.out.println("Input n");
	        int n = keyboard.nextInt();
	        int i = 0;

	        while (i < n)
	        {
	            int j = 0;
	            while (j < n-i)
	            {
	                j++;
	                System.out.print(" ");
	            }

	            int k = 0;
	            while (k < 2*i+1)
	            {
	                k++;
	                System.out.print("*");
	            }
	            System.out.print("\n");
	            i++;
	        }
	    }
	}
