import java.util.Scanner;

/* 
    This class is meant to calculate the nearset point to the origin between three point.
    The three point will detrmine from the user input.
    The origin will be the point (0,0).
    The class get and return only intergers.
    If the class will get negative values of the coordinates, it will use absoulte method on Math to caluclate the absoulte distance
*/
public class Origin {
    public static void main(String[] args) {
        // Set the point coordinates of the origin, the sqrt number and the final messge
        final int X0 = 0;
        final int Y0 = 0;
        final int SQRT_NUMBER = 2;
        final int HIGHEST_INT = 2147483647;
        int smallestDistance = HIGHEST_INT;
        final String MESSAGE_OUTPUT = "The nearest point to the origin is ";

        // Gets the three point coordinates from the user
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter first point coordinates: ");
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        System.out.println("");
        System.out.print("Enter second point coordinates: ");
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        System.out.println("");
        System.out.print("Enter third point coordinates: ");
        int x3 = scan.nextInt();
        int y3 = scan.nextInt();
        System.out.println("");        

        // Calculate the distance for the three points
        int distanceFirstPoint = (int)(Math.sqrt(Math.pow(x1 - X0, SQRT_NUMBER) + Math.pow(y1 - Y0, SQRT_NUMBER)));
        int distanceSecondPoint = (int)(Math.sqrt(Math.pow(x2 - X0, SQRT_NUMBER) + Math.pow(y2 - Y0, SQRT_NUMBER)));
        int distanceThirdPoint = (int)(Math.sqrt(Math.pow(x3 - X0, SQRT_NUMBER) + Math.pow(y3 - Y0, SQRT_NUMBER)));

        // If the distance is negative change it to positive (Instead of using abs method that not allowed)
        if (distanceFirstPoint < 0)
            distanceFirstPoint *= -1;
        if (distanceSecondPoint < 0)
            distanceSecondPoint *= -1;
        if (distanceThirdPoint < 0)
            distanceThirdPoint *= -1;

        // Caluclate the minimum distance between the three points and assign the points of the closest point to origin (Instead of using min and abs methods that not allowed)
        smallestDistance = HIGHEST_INT;
        int closestPointOriginX;
        int closestPointOriginY;
        
        if(distanceFirstPoint < smallestDistance){
            smallestDistance = distanceFirstPoint;
            closestPointOriginX = x1;
            closestPointOriginY = y1;
        }
        else if(distanceSecondPoint < smallestDistance){
            smallestDistance = distanceSecondPoint;
            closestPointOriginX = x2;
            closestPointOriginY = y2;
        }
        else {
            smallestDistance = distanceThirdPoint;
            closestPointOriginX = x3;
            closestPointOriginY = y3;
        }

        // Output the results to the user
        System.out.println(MESSAGE_OUTPUT + "(" + closestPointOriginX + "," + closestPointOriginY + ")");
    }
}
