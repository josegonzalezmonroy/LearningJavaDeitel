// 18.11 - Máximo divisor comum
// O máximo divisor comum dos inteiros x e y é o maior inteiro que divide tanto x como y. Escreva um método recursivo gcd que retorna o máximo divisor comum de x e y. O gcd de x e y é definido recursivamente como segue: se y é igual a 0, então gcd(x, y) é x; do contrário, gcd(x, y) é gcd(y, x % y), onde % é o operador de resto. Utilize esse método para substituir o que você escreveu no aplicativo do Exercício 6.27.
import java.util.Scanner;

public class Exerc_18_11 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        // Solicita ao usuario que insira dois numeros para calcular o MDC
        System.out.println("Digite dois numeros para calcular o MDC:");
        int x = input.nextInt(); // primeiro numero
        int y = input.nextInt(); // segundo numero

        // Calcula e imprime o MDC utilizando o metodo recursivo mcd
        System.out.printf("mcd(%d, %d) = %d%n", x, y, mcd(x, y));  
    }

    // Metodo recursivo para calcular o maximo divisor comum (MDC)
    public static int mcd(int x, int y)
    {
        // Caso base: se y for 0, retorna x, pois o MDC e x
        if (y == 0)
            return x;
        else 
            // Chamada recursiva: calcula o MDC de y e o resto da divisao de x por y
            return mcd(y, x % y);
    }
}
