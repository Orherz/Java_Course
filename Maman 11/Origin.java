import java.util.Scanner;

/* 
    This program calculates and identifies the nearest point to the origin (0,0) among three points.
    The three points are determined by user input coordinates.
    If negative coordinate values are provided, the code calculates the absolute distance.
*/
public class Origin {
    public static void main(String[] args) {
        // Variables initialization
        final int X0 = 0; // X-coordinate of the origin
        final int Y0 = 0; // Y-coordinate of the origin
        final int SQRT_NUMBER = 2; // Used for square root calculation
        final double HIGHEST = 999999999; // A large value for initializing smallestDistance
        double smallestDistance = HIGHEST; // Initialize smallestDistance to a high value
        final String MESSAGE_OUTPUT = "The nearest point to the origin is ";

        // User input for three points
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

        // Calculate the distance from the origin for the three points
        double distanceFirstPoint = Math.sqrt(Math.pow(x1 - X0, SQRT_NUMBER) + Math.pow(y1 - Y0, SQRT_NUMBER));
        double distanceSecondPoint = Math.sqrt(Math.pow(x2 - X0, SQRT_NUMBER) + Math.pow(y2 - Y0, SQRT_NUMBER));
        double distanceThirdPoint = Math.sqrt(Math.pow(x3 - X0, SQRT_NUMBER) + Math.pow(y3 - Y0, SQRT_NUMBER));

        // Ensure distances are positive (absolute values)
        if (distanceFirstPoint < 0)
            distanceFirstPoint *= -1;
        if (distanceSecondPoint < 0)
            distanceSecondPoint *= -1;
        if (distanceThirdPoint < 0)
            distanceThirdPoint *= -1;

        // Determine the closest point to the origin
        int closestPointOriginX = 0;
        int closestPointOriginY = 0;

        // Compare distances and update closestPointOriginX and closestPointOriginY
        if(distanceFirstPoint < smallestDistance){
            smallestDistance = distanceFirstPoint;
            closestPointOriginX = x1;
            closestPointOriginY = y1;
        }
        if(distanceSecondPoint < smallestDistance){
            smallestDistance = distanceSecondPoint;
            closestPointOriginX = x2;
            closestPointOriginY = y2;
        }
        if(distanceThirdPoint < smallestDistance){
            smallestDistance = distanceThirdPoint;
            closestPointOriginX = x3;
            closestPointOriginY = y3;
        }

        // Output the results to the user
        System.out.println(MESSAGE_OUTPUT + "(" + closestPointOriginX + "," + closestPointOriginY + ")");
    }
}
