package hust.soict.hedspi.lab01;
//lab01: exercise 2.2.5
import javax.swing.JOptionPane;

public class Calculate2Numbers {
	public static void main(String[] args) {
		String strNum1 = JOptionPane.showInputDialog("Please enter the first number: ");
		double num1 = Double.parseDouble(strNum1);
		
		String strNum2 = JOptionPane.showInputDialog("Please enter the second number: ");
		double num2 = Double.parseDouble(strNum2);
		
		if (num2 == 0) {
			JOptionPane.showMessageDialog(null, "ERROR: Division by zero is not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			double sum = num1 + num2;
			double difference = num1 - num2;
			double product = num1 * num2;
			double quoitient = num1 / num2;
			
			String result = "Sum: " + sum + "\nDifference: " + difference + "\nProduct: " + product + "\nQuoitient: " + quoitient;
			JOptionPane.showMessageDialog(null, result, "Results", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}