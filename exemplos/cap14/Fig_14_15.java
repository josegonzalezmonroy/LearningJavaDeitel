// Figura 14.15 - StaticCharMethods.java 
// Metodos estaticos Character parda testar caracteres e converter entre maiusculas e minusculas 
import java.util.Scanner;

public class Fig_14_15 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a character and press Enter");
        String input = scanner.next();
        char c = input.charAt(0);// obtem caracter de entrada

        // exibe informacoes de caractere
        System.out.printf("is defined %b%n", Character.isDefined(c));
        System.out.printf("is digit %b%n", Character.isDigit(c));
        System.out.printf("is first character in a Java identifier: %b%n", 
            Character.isJavaIdentifierStart(c));
        System.out.printf("is part of a Java identifier: %b%n", 
            Character.isJavaIdentifierPart(c));
        System.out.printf("is letter %b%n", Character.isLetter(c));
        System.out.printf("is letter or digit %b%n", 
            Character.isLetterOrDigit(c));
        System.out.printf("is lowerCase %b%n", 
            Character.isLowerCase(c));
        System.out.printf("is upperCase %b%n", 
            Character.isUpperCase(c));
        System.out.printf("to upper case %s%n", 
            Character.toUpperCase(c));
        System.out.printf("to lower case %s%n", 
            Character.toLowerCase(c));
    }
}
