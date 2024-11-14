// 6.14 - Exponenciação
// Escreva um método integerPower( base, exponent ) que retorna o valor de base^exponent; Por exemplo, integerPower( 3, 4 ) calcula 3^4 (ou 3 * 3 * 3 * 3). Assuma que exponent é um inteiro não-zero positivo, e base é um inteiro. O método integerPower deve utilizar um loop for ou while para controlar o cálculo. Não utilize nenhum método da biblioteca de matemática. Incorpore esse método a um aplicativo  que lê os valores inteiros para base e exponent e realiza o cálculo com o método integerPower
import java.util.Scanner;

public class Exerc_6_14 
{
    public static void main(String[] args) 
    {
       Scanner input = new Scanner(System.in);

       System.out.print("Digite a base: ");
       int base = input.nextInt();

       System.out.print("Agora o exponente: ");
       int exponente = input.nextInt();
       
       System.out.printf("%d ^ %d = %d ", base, exponente, integerPower(base, exponente));
    }
    
    public static int integerPower(int base, int exponente)
    {
        int valor = 1;
        
        for (int i = 1; i <= exponente ; i++)
        {
            valor *= base;
        }
        return valor;
    }
}
