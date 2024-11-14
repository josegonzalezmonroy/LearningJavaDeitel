public class Exerc_18_10 
{
    // Metodo fatorial recursivo (supoe que o parametro e >= 0)
    private static int recuo = 0; // Variavel para rastrear o nivel de recuo

    // Metodo que gera uma string com espacos baseado no nivel de recuo
    public static String recuoString(int recuo)
    {
        String value = ""; // Inicializa a string que vai armazenar os espacos

        // Adiciona espacos a string para cada nivel de recuo
        for (int i = 0; i < recuo; i++)
            value += " "; // Concatena espacos
        
        return value; // Retorna a string com os espacos
    }

    // Metodo recursivo que calcula o fatorial de um numero
    public static long factorial(long number)
    {
        // Testa o caso basico: se o numero for 0 ou 1
        if (number <= 1) 
        {
            // Exibe a informacao do caso base
            System.out.printf("%sNivel %d -> number = %d (Caso base)%n", recuoString(recuo), recuo, number);
            return 1; // Casos basicos: 0! = 1 e 1! = 1
        }
        else // Passo de recursao
        {
            // Exibe a informacao da chamada recursiva
            System.out.printf("%sNivel %d -> number = %d -> (Entrando)%n", recuoString(recuo), recuo, number);
            recuo++; // Incrementa o nivel de recuo
            long result = number * factorial(number - 1); // Chamada recursiva para calcular o fatorial
            recuo--; // Decrementa o nivel de recuo ao retornar
            // Exibe a informacao do retorno
            System.out.printf("%sNivel %d <- number = %d (Retorno)%n", recuoString(recuo), recuo, result);
            return result; // Retorna o resultado do fatorial
        }
    } 

    // Metodo principal que gera a saida do fatorial
    public static void main(String[] args)
    {
        int valor = 5; // Valor para calcular o fatorial
        // Calcula o fatorial de 0 a 21
        System.out.printf("%d! = %d%n", valor, factorial(valor)); // Exibe o resultado
    }           
}
