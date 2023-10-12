package lab01;

import javax.swing.JOptionPane;

public class SolveEquation {
    public static void main(String[] args) {
        String[] options = {"Linear Equation", "Quadratic Equation", "System of Equations"};
        int choice = JOptionPane.showOptionDialog(null, "Select the type of equation to solve:", "Equation Solver",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            solveLinearEquation();
        } else if (choice == 1) {
            solveQuadraticEquation();
        } else if (choice == 2) {
            solveSystemOfEquations();
        }
    }

    // Solve a first-degree equation (linear equation)
    private static void solveLinearEquation() {
        String aStr = JOptionPane.showInputDialog("Enter the value of 'a' (a*x + b = 0):");
        double a = Double.parseDouble(aStr);

        String bStr = JOptionPane.showInputDialog("Enter the value of 'b' (a*x + b = 0):");
        double b = Double.parseDouble(bStr);

        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "Infinite solutions (0 = 0)", "Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No solution (0 != " + b + ")", "Result", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "The solution is x = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Solve a second-degree equation (quadratic equation)
    private static void solveQuadraticEquation() {
        String aStr = JOptionPane.showInputDialog("Enter the value of 'a' (a*x^2 + b*x + c = 0):");
        double a = Double.parseDouble(aStr);

        String bStr = JOptionPane.showInputDialog("Enter the value of 'b' (a*x^2 + b*x + c = 0):");
        double b = Double.parseDouble(bStr);

        String cStr = JOptionPane.showInputDialog("Enter the value of 'c' (a*x^2 + b*x + c = 0):");
        double c = Double.parseDouble(cStr);

        double discriminant = b * b - 4 * a * c;

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    JOptionPane.showMessageDialog(null, "Infinite solutions (0 = 0)", "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No solution (0 != " + c + ")", "Result", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                double x = -c / b;
                JOptionPane.showMessageDialog(null, "The solution is x = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            if (discriminant > 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                JOptionPane.showMessageDialog(null, "Two real roots: x1 = " + x1 + " and x2 = " + x2, "Result", JOptionPane.INFORMATION_MESSAGE);
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "One real double root: x = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No real roots (Discriminant < 0)", "Result", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Solve a system of first-degree equations with two variables
    private static void solveSystemOfEquations() {
        String a1Str = JOptionPane.showInputDialog("Enter the value of 'a1' in the first equation (a1*x + b1*y = c1):");
        double a1 = Double.parseDouble(a1Str);

        String b1Str = JOptionPane.showInputDialog("Enter the value of 'b1' in the first equation (a1*x + b1*y = c1):");
        double b1 = Double.parseDouble(b1Str);

        String c1Str = JOptionPane.showInputDialog("Enter the value of 'c1' in the first equation (a1*x + b1*y = c1):");
        double c1 = Double.parseDouble(c1Str);

        String a2Str = JOptionPane.showInputDialog("Enter the value of 'a2' in the second equation (a2*x + b2*y = c2):");
        double a2 = Double.parseDouble(a2Str);

        String b2Str = JOptionPane.showInputDialog("Enter the value of 'b2' in the second equation (a2*x + b2*y = c2):");
        double b2 = Double.parseDouble(b2Str);

        String c2Str = JOptionPane.showInputDialog("Enter the value of 'c2' in the second equation (a2*x + b2*y = c2):");
        double c2 = Double.parseDouble(c2Str);

        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            if (a1 * c2 - a2 * c1 == 0 && b1 * c2 - b2 * c1 == 0) {
                JOptionPane.showMessageDialog(null, "Infinite solutions", "Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No solution", "Result", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            double x = (c1 * b2 - c2 * b1) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            JOptionPane.showMessageDialog(null, "The solution is x = " + x + " and y = " + y, "Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
