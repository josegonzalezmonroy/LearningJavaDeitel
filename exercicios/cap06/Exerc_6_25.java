// 6.25 - Números primos
public class Exerc_6_25 
{
    public static void main(String[] args) 
    {
        int contador = 1;// para gerar uma lista

        System.out.println("Lista de numeros primos: "); 

        for (int i = 2; i <= 50; i++) // determina a quantidade de numeros a avaliar
        {
            if (primo(i))
            {
                System.out.println(contador + ": " + i);
                contador++; // para saber a ordem na sequencia de cada numero primo que aparece
            }
        }
    }
    
    public static boolean primo(int x)// determina se o valor é primo
    {
        boolean number = true; // valor a retornar inicializado

        for (int i = 3; x > i; i += 2)// inicia o ciclo com divisor 3 e continua com divisores impares
        {
            if (x % 2 == 0)// se for != de 0, o valor é par e por definição não é primo (exeto o 2)
            {
                number = false;
                break;// para o ciclo for, não precisa executar o resto do código
            }

            if (x % i == 0)// se for impar, mas o valor é divisivél por outros numeros, não é primo
            {
                number = false;
            }
        }
        return number;// retorna true ou false
    }
}
