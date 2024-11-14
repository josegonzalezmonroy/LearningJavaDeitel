// 18.23 - Tempo para calcular números de Fibonacci
// Aprimore o programa de Fibonacci da Figura 18.5 para que ele calcule a quantidade aproximada de tempo necessário a fim de efetuar o cálculo e o número de chamadas feitas para o método recursivo. Para esse fim, chame o método static System currentTimeMillis, que não aceita nenhum argumento e retorna a hora atual do computador em milissegundos. Chame esse método duas vezes, uma antes e outra depois da chamada para fibonacci. Salve cada valor e calcule a diferença em horas para determinar quantos milissegundos foram necessários ao cálculo. Então, adicione uma variável à classe FibonacciCalculator e utilize-a para estabelecer o número de chamadas feitas para o método fibonacci. Exiba seus resultados.
import java.math.BigInteger;

public class Exerc_18_23 
{
    private static BigInteger TWO = BigInteger.valueOf(2); // Constante para o valor 2 como BigInteger

    private static long chamadas = 0; // Variavel para contar o numero de chamadas recursivas

    // Metodo principal para exibir os valores de Fibonacci de 0 a 40
    public static void main(String[] args) 
    {
        long tempoInicial = System.currentTimeMillis(); // Marca o tempo inicial para calcular o tempo total

        // Loop para calcular Fibonacci para cada valor de 0 a 40
        for (int counter = 0; counter <= 40; counter++)
        {
            long inicio = System.currentTimeMillis(); // Marca o inicio de cada calculo de Fibonacci

            BigInteger fibonacci = fibonacci(BigInteger.valueOf(counter)); // Chama o metodo recursivo fibonacci
            
            long fim = System.currentTimeMillis(); // Marca o fim do calculo

            long tempo = fim - inicio; // Calcula o tempo gasto para esse Fibonacci

            // Exibe o resultado, o tempo gasto e o numero de chamadas recursivas
            System.out.printf("fibonacci(%d) = %d - Tempo: %.3fs - Chamadas: %d%n", counter, fibonacci, tempo / 1000.0, chamadas);

            chamadas = 0; // Reseta o contador de chamadas para o proximo numero de Fibonacci
        }

        long tempoFinal = System.currentTimeMillis(); // Marca o tempo final para calcular o tempo total

        long tempoTotal = tempoFinal - tempoInicial; // Calcula o tempo total gasto para todos os calculos

        // Exibe o tempo total
        System.out.printf("Tempo total: %.3fs", tempoTotal / 1000.0);
    }
    
    // Declaracao recursiva do metodo fibonacci
    public static BigInteger fibonacci(BigInteger number)
    {
        chamadas++; // Incrementa o contador de chamadas a cada execucao

        // Casos base: Fibonacci(0) = 0, Fibonacci(1) = 1
        if (number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)) 
            return number;
        else // Passo recursivo: Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2)
            return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
    }
}
