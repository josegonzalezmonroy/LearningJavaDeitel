// Figura 11.8 - AssertTest.java
// Verificando com assert se um valor esta dentro do intervalo
import java.util.Scanner;

public class Fig_11_8 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number between 0 and 10: ");
        int number = input.nextInt();

        // afirma que o valor é >= 0 e <= 10
        assert (number >= 0 && number <= 10) : "bad number: " + number;

        System.out.printf("You entered %d%n", number);
    }
}
