// 18.9 - Metodo recursivo power
// Escreva uma método recursivo power(base, exponent) 

public class Exerc_18_9 
{
    public static void main(String[] args) 
    {
        // Definindo os valores da base e do expoente
        int base = 9;
        int exponent = 1;

        // Chamando o metodo recursivo power para calcular base^exponent
        int result = power(base, exponent);

        // Exibindo o resultado no formato base^exponent = resultado
        System.out.printf("%d^%d = %d%n", base, exponent, result);    
    } 
    
    // Metodo recursivo que calcula a potencia de base elevada ao expoente
    public static int power(int base, int exponent)
    {
        // Condicao de parada: se o expoente for 1, retorna a base
        if (exponent == 1)
            return base;
        else 
            // Chamada recursiva: multiplica a base pela potencia de base^(exponent - 1)
            return base * power(base, exponent - 1);
    }
}
