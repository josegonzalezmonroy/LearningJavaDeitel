// 6.24 - Números perfeitos
// Dizemos que um número inteiro é um número perfeito se a soma de seus fatores, incluindo 1 (mas não o próprio número), é igual ao número. Por exemplo, 6 é um número perfeito porque 6 = 1 + 2 + 3. Escreva um método perfect que determina se parâmetro number é um número perfeito. Utilize esse método em um applet que determina e exibe todos os números perfeitos entre 1 e 1.000. Exiba os fatores de cada número perfeito confirmando que o número é de fato perfeito. Desafie o poder de computação de seu computador testando números bem maiores que 1.000. Exiba os resultados.
public class Exerc_6_24 
{
    public static void main(String[] args) 
    {
        int number = 10000;

        System.out.println("Numeros perfeitos entre 1 e " + number + ":");

        for (int i = 1; i <= number; i++)// faz o ciclo desde 1 até 10000
        {
            if (isPerfect(i))// se o numero é perfeito
            {
                System.out.print(i + " = ");// imprime o numero
                for (int j = 1; j < i; j++)// e gera a secuencia de fatores
                {
                    if (j == 1)// imprime unicamente "1" para evitar imprimir "+ 1"
                    {
                        System.out.print(j);
                        continue;
                    }
                    if (i % j == 0)// imprime a secuencia dos outros fatores
                        System.out.print(" + " + j);
                }
                System.out.println();
            }
        }
    }
    
    public static boolean isPerfect(int a)// determina se o numero inserido é perfeito
    {
        int soma = 0;// acumulador
        
        for (int i = 1; i < a; i++)
        {
            if (a % i == 0)
                soma += i;        
        }
        if (soma == a)// compara se a soma é igual ao numero
            return true;// se for retorna true
        else
            return false;// se não retorna false
    }
}
