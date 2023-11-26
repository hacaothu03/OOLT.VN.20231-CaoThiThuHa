package hust.soict.hedspi.lab01;
import java.util.Scanner;

public class DisplayDayOfMonth {
    // Function to calculate leap year
    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Function to calculate the number of days in a month
    static int daysInMonth(String inputMonth, int year) {
        switch (inputMonth) {
            case "January", "Jan", "Jan.", "1":
                return 31;
            case "February", "Feb", "Feb.", "2":
                return isLeapYear(year) ? 29 : 28;
            case "March", "Mar", "Mar.", "3":
                return 31;
            case "April", "Apr", "Apr.", "4":
                return 30;
            case "May", "5":
                return 31;
            case "June", "Jun", "Jun.", "6":
                return 30;
            case "July", "Jul", "Jul.", "7":
                return 31;
            case "August", "Aug", "Aug.", "8":
                return 31;
            case "September", "Sep", "Sept.", "9":
                return 30;
            case "October", "Oct", "Oct.", "10":
                return 31;
            case "November", "Nov", "Nov.", "11":
                return 30;
            case "December", "Dec", "Dec.", "12":
                return 31;
            default:
                return -1; // Invalid month
        }
    }

    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter month: ");
            String inputMonth = myInput.nextLine();

            System.out.println("Please enter year (digits only like 1999): ");
            String strYear = myInput.nextLine();

            int year = Integer.parseInt(strYear);

            int days = daysInMonth(inputMonth, year);
            if (days != -1) {
                System.out.println("Number of days: " + days);
                break;
            } else {
                System.out.println("Invalid month. Please try again.");
            }
        }
    }
}
