// 6.12
/* Escreva instruções que atribuem inteiros aleatórios à variável n nos seguintes intervalos: 
        a) 1 =< n <= 2. 
        b) 1 <= n <= 100.
        c) 0 <= n <= 9. 
        d) 1000 <= n <= 1112. 
        e) -1 <= n <= 1. 
        f) -3 <= n <= 11 
*/
import java.security.SecureRandom;

public class Exerc_6_12 
{
    public static void main(String[] args) 
    {
        SecureRandom randomNumbers = new SecureRandom();

        int a = 1 + randomNumbers.nextInt(2);
        int b = 1 + randomNumbers.nextInt(100);
        int c = randomNumbers.nextInt(10);
        int d = 1000 + randomNumbers.nextInt(113);
        int e = -1 + randomNumbers.nextInt(3);
        int f = -3 + randomNumbers.nextInt(15);

        System.out.println("a) " + a);
        System.out.println("b) " + b);
        System.out.println("c) " + c);
        System.out.println("d) " + d);
        System.out.println("e) " + e);
        System.out.println("f) " + f);
    }
}
