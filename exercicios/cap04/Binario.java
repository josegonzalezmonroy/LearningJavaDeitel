// 4.31 - Imprimindo o equivalente decimal de un numero binario
import java.util.Scanner;

public class Binario 
{
    public static void main(String[] args) 
    {
        int numero; 
        int soma = 0; // soma para determinar o decimal
        int counter = 0; 
        
        Scanner input = new Scanner(System.in);//Scanner para fazer a leitura de entrada de usuario

        System.out.println("Digite o numero binario (0-1):");
        numero = input.nextInt();//inteiro inserido pelo usuario

        while (numero/1 > 0) 
        {
            int potencia = (int)Math.pow(2, counter);// para determinar o valor de cada posicao no sistema binario
            int resto = numero%10 * potencia;
            soma += resto; // acrescenta o valor a soma total
            numero /= 10; // diminui um digito (direito) ao numero para o novo calculo
            counter++; // acrescenta +1 ao contador
        }
        System.out.printf("Decimal: %d", soma);// resultado final
    }
}
