import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) throws Exception {
        
        final int PASSWORD_LENGTH = 8;

        Scanner scan = new Scanner(System.in);
        System.out.println("This program verify passwords.");
        System.out.println("The password should be " + PASSWORD_LENGTH + " character long.");
        System.out.println("The first character should be Alphbet character and the last one sholdnt be equal to '?'");
        System.out.print("Please enter a password: ");
        
        String Password = scan.next();

        boolean ok = true;

        int length = Password.length();

        if(length == PASSWORD_LENGTH){
            char firstChar = Password.charAt(0);
            char lastChar = Password.charAt(Password.length()-1);
            if ((firstChar > 'Z' && firstChar < 'A') || (firstChar > 'z' && firstChar < 'a'))
                ok = false;
            if (lastChar =='?')
                ok = false;
        }
        else {
            System.out.println("Error, The password should be 8 length long");
        }

        if(ok){
            System.out.print("Please write the password again: ");
            String RePassword = scan.next();
            if(Password.equals(RePassword))
                System.out.println("The password is ok and was verified, Bye");
            else
                System.out.println("The password is not the same");
        }
        else {
            System.out.println("The password is not legal");
        }
    }
}
