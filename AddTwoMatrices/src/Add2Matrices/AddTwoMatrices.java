package Add2Matrices;
import java.util.*;
public class AddTwoMatrices {

  public static void main(String[] args)
	    {
	        Scanner myInput = new Scanner(System.in);

	        System.out.print("Enter matrix size (m x n): ");

	        int m = myInput.nextInt();
	        int n = myInput.nextInt();

	        int[][] Matrix1 = new int[m][n];
	        int[][] Matrix2 = new int[m][n];
	        int[][] SumMatrix = new int[m][n];

	        System.out.println("Enter matrix 1: ");

	        for (int i = 0; i < m; i++)
	        {
	            for (int j = 0; j < n; j++)
	            {
	                Matrix1[i][j] = myInput.nextInt();
	            }
	        }

	        System.out.println("Enter matrix 2: ");

	        for (int i = 0; i < m; i++)
	        {
	            for (int j = 0; j < n; j++)
	            {
	                Matrix2[i][j] = myInput.nextInt();
	                SumMatrix[i][j] = Matrix1[i][j] + Matrix2[i][j];
	            }
	        }

	        System.out.println("Sum of 2 matrices = ");

	        for (int i = 0; i < m; i++)
	        {
	            for (int j = 0; j < n; j++)
	            {
	                System.out.printf("%d ", SumMatrix[i][j]);
	            }
	            System.out.println();
	        }
	    }
	}
