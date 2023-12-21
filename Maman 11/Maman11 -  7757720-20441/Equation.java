import java.util.Scanner;

/*
    This program calculates the roots of a quadratic equation of the form: ax^2 + bx + c = 0.
    It takes three coefficients (a, b, and c) as input and calculates the real solutions (roots) of the equation.
    The program then displays the number of solutions and the values of the roots, if they exist.
*/
public class Equation {
    public static void main(String[] args) {
        // Variables initialization
        final int numOfIntergers = 3;
        double x1 = 0;
        double x2 = 0;
        int numOfResults = 0;
        final String MESSAGE_INPUT = "Enter " + numOfIntergers + " coefficients of the polynomial equation: ";
        final String MESSAGE_OUTPUT_FALSE = "There is no solution.";

        // User input
        System.out.print(MESSAGE_INPUT);
        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        System.out.println("");

        // Calculate the discriminant (b^2 - 4ac) to determine the amount of the solutions
        double discriminant = ((Math.pow(b, 2)) - (4 * a * c));

        // Check if there are solutions using discriminant >= 0
        if (discriminant >= 0) {
            if (discriminant > 0) {
                numOfResults = 2; // Two solutions
                x1 = ((-b + Math.sqrt(discriminant))) / (2 * a);
                x2 = ((-b - Math.sqrt(discriminant))) / (2 * a);
            } else {
                numOfResults = 1; // One solution
                x1 = ((-b + Math.sqrt(discriminant))) / (2 * a);
            }

            final String MESSAGE_OUTPUT_TRUE = "There is " + numOfResults + " solution";
            final String MESSAGE_OUTPUT_X1 = " X1 = " + x1;
            final String MESSAGE_OUTPUT_X2 = " X2 = " + x2;

            // Output the solutions
            if (numOfResults == 1) {
                System.out.println(MESSAGE_OUTPUT_TRUE + "." + MESSAGE_OUTPUT_X1 + ".");
            } else if (numOfResults == 2) {
                System.out.println(MESSAGE_OUTPUT_TRUE + "s." + MESSAGE_OUTPUT_X1 + "," + MESSAGE_OUTPUT_X2 + ".");
            }
        } else {

            // Output if there are no solutions
            System.out.println(MESSAGE_OUTPUT_FALSE);
        }
    }
}