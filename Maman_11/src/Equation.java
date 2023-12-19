import java.util.Scanner;

public class Equation {
    public static void main(String[] args) {
        final int numOfIntergers = 3;
        final int SQRT_NUMBER = 2;
        double x1 = 0;
        double x2 = 0;
        int numOfResults = 0;
        final String MESSAGE_INPUT = "Enter " + numOfIntergers + " coefficients of the polynomial equation: ";
        final String MESSAGE_OUTPUT_X1= " X1 = ";
        final String MESSAGE_OUTPUT_X2 = " X2 = ";
        final String MESSAGE_OUTPUT_FALSE = "There is no solution.";

        System.out.print(MESSAGE_INPUT);
        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        System.out.println("");

        // Calculate if there are roots to the polynomial quation
        double root = (Math.pow(b,2) - 4*a*c);
        boolean results = false;
        if (root > 0){
            numOfResults = 2;
            results = true;
            x1 = ((b*=-1) + (Math.sqrt(root)))/(2*a);
            x2 = ((b*=-1) - (Math.sqrt(root)))/(2*a);
        }
        else if (root == 0){
            numOfResults = 1;
            results = true;
            x1 = ((b*=-1) + (Math.sqrt(root)))/(2*a);
        }
        else{
            results = false;
        }

        final String MESSAGE_OUTPUT_TRUE = "There is " + numOfResults + " solutions.";

        if(results){
            if (numOfResults == 1){
                System.out.println(MESSAGE_OUTPUT_TRUE + MESSAGE_OUTPUT_X1 + x1 + ".");
            }
            if (numOfResults == 2){
                System.out.println(MESSAGE_OUTPUT_TRUE + MESSAGE_OUTPUT_X1 + x1 + "," + MESSAGE_OUTPUT_X2 + x2 + ".");
            }
        }
        else {
            System.out.println(MESSAGE_OUTPUT_FALSE);
        }
    }
}