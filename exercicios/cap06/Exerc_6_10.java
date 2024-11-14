// 6.6 - Arredondando números
// Math.floor pode ser utilizado para arredondar um número para uma casa decimal específica. A instrução y = Math.floor( x * 10 + 0.5) / 10; arredonda x para a casa decimal (isto é, a primeira posição à direita do ponto de fração decimal). A instrução y = Math.floor( x * 100 + 0.5 ) / 100;arredonda x para a casa centensimal (isto é, a segunda posição à direita do ponto de fração decimal). Escreva um aplicativo que defina quatro métodos para arredondar um número x de várias maneiras: a) roundToInteger( number ) b) roundToTenths( number ) c) roundToHundredths( number ) d) roundToThousandths( number ) Para cada leitura de valor, seu programa deve exibir o valor original, o número arredondado para o inteiro mais próximo, o número arredondado para o décimo mais próximo, o número arredondado para o centésimo mais próximo e o número arredondado para o milésimo mais próximo.
import java.util.Scanner;

public class Exerc_6_10 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o valor: ");
        double number = input.nextDouble();
        
        System.out.println("Valor original: " + number);
        System.out.println("Inteiro mais proximo: " + (int) roundToInteger(number));
        System.out.println("Decimo mais proximo: " + roundToTenths(number));        
        System.out.println("Centesimo mais proximo: " + roundToHundredths(number));
        System.out.println("Milesimo mais proximo: " + roundToThousandths(number));
    }
    
    public static double roundToInteger(double x)
    {
        return Math.floor(x + 0.5);
    }

    public static double roundToTenths(double x)
    {
        return Math.floor(x * 10 + 0.5) / 10;
    }

    public static double roundToHundredths(double x)
    {
        return Math.floor(x * 100 + 0.5) / 100;
    }

    public static double roundToThousandths(double x)
    {
        return Math.floor(x * 1000 + 0.5) / 1000;
    }
}
