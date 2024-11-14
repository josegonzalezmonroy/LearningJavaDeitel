// Figura 18.3 - FactorialCalculator.java
// Metodo factorial recursivo

public class Fig_18_3 
{
    // metodo fatorial recursivo (supoe que o parametro e >= 0)
    public static long factorial(long number)
    {
        if (number <= 1) // testa o caso basico
            return 1; // casos basicos: 0! = 1 e 1! = 1
        else // passo de recursao
        {
            return number * factorial(number - 1);
        }
    } 

    // gera saida de factoriais para valores de 0 a 21
    public static void main(String[] args)
    {
        // calcula o fatorial de 0 a 21
        for (int counter = 0; counter <= 21; counter++)
            System.out.printf("%d! = %d%n", counter, factorial(counter));
    }       
}
