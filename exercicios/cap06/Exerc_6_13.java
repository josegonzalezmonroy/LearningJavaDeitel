// 6.13
/* Escreva instruções que exibirão um número aleatório de cada um dos seguintes conjuntos: 
        a) 2, 4, 6, 8, 10. 
        b) 3, 5, 7, 9, 11.
        c) 6, 10, 14, 18, 22.
*/
import java.security.SecureRandom;

public class Exerc_6_13 
{
    public static void main(String[] args) 
    {
        SecureRandom randomNumbers = new SecureRandom();

        int number = 1 + randomNumbers.nextInt(5);

        int a = number * 2;
        int b = a + 1;
        int c = b * 2;
        
        System.out.println("a) " + a);
        System.out.println("b) " + b);
        System.out.println("c) " + c);
    }    
}
