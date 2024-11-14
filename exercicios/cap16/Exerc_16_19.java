// 16.19 - Números primos e fatores primos
// Escreva um programa que recebe um número inteiro de entrada de um usuário e determina se ele é primo. Se o número não for primo, exiba seus fatores primos únicos. Lembre-se de que os fatores de um número primo são somente 1 e o próprio número primo. Cada número que não é primo tem uma fatoração em primos única. Por exemplo, considere o número 54. Os fatores primos de 54 são 2, 3, 3 e 3. Quando os valores são multiplicados, o resultado é 54. Para o número 54, a saída dos fatores primos deve ser 2 e 3. Utilize Sets como parte de sua solução.
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exerc_16_19 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        // Recebe um numero inteiro do usuário
        System.out.print("Digite um numero inteiro: ");
        int numero = scanner.nextInt();

        // Verifica se o numero e primo
        if (isPrime(numero)) 
            System.out.println(numero + " e um numero primo.");
        else 
        {
            // Obtém os fatores primos unicos
            Set<Integer> fatoresPrimos = getFatoresPrimosUnicos(numero);
            System.out.println("Fatores primos unicos de " + numero + ": " + fatoresPrimos);
        }
    }

    // Função para verificar se um numero e primo
    public static boolean isPrime(int numero) 
    {
        if (numero < 2) 
            return false;

        for (int i = 2; i <= Math.sqrt(numero); i++) 
            if (numero % i == 0) 
                return false;

        return true;
    }

    // Função para obter os fatores primos unicos de um numero
    public static Set<Integer> getFatoresPrimosUnicos(int numero) 
    {
        Set<Integer> fatoresPrimos = new HashSet<>();
        int fator = 2;
        
        while (numero > 1) 
            // Se o numero for divisível pelo fator atual
            if (numero % fator == 0) 
            {
                fatoresPrimos.add(fator); // Adiciona o fator ao conjunto
                numero /= fator; // Divide o numero pelo fator
            } 
            else
                fator++; // Passa para o próximo fator

        return fatoresPrimos;
    }    
}
