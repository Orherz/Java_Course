import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  
        int age;
        System.out.print("Please enter your age: ");
        age = scan.nextInt();
        System.out.println("You are " + age + " years old");
    }
}