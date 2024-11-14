// 6.22 - Conversões de temperatura
// Implemente os seguintes métodos de inteiro: a) O método celsius retorna o equivalente em Celsius de uma temperatura em Fahrenheit utilizando o cálculo C = 5.0 / 9.0 * ( F - 32 ); b) O método fahrenheit retorna o equivalente em Fahrenheit de uma temperatura em Celcius utilizando o cálculo F = 9.0 / 5.0 * ( C - 32 ); c) Utilize os métodos nas partes (a) e (b) para escrever um aplicativo que permite ao usuário inserir uma temperatura em Fahrenheit e exibe o equivalente em Celsius ou inserir uma temperatura em Celsius e exibe o equivalente em Fahrenheit.
import java.util.Scanner;

public class Exerc_6_22 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Para converter digite: \n  Farenheith a Celsius: 1\nou \n  Celsius a Farenheith: 2");
        int opcao = input.nextInt();
        
        while (opcao != 1 && opcao != 2)// confirma que o valor seja 1 ou 2
        {
            System.out.println("Digite uma opcao valida (1 ou 2)");
            opcao = input.nextInt();
        }

        System.out.println("Agora digite o valor a converter: ");// depois de confirmado, pede para o usuario inserir o valor a converter
        double valor = input.nextDouble();// valor para a conversao

        switch (opcao) // imprime so uma resposta dependendo da opcao escolhida
        {
            case 1:
                System.out.printf("%.2f farenheit = %.2f celsius", valor, celsius(valor));
                break;
            case 2:
                System.out.printf("%.2f celsius = %.2f farenheit", valor, fahrenheit(valor));
                break;
        }
    }
    
    public static double celsius(double x)// Converte F -> C
    {
        return 5.0 / 9.0 * (x - 32);
    }

    public static double fahrenheit(double x)// Converte C -> F
    {
        return 9.0 / 5.0 * x + 32;
    }
}
