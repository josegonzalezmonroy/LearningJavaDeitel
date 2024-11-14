// 7.16 - Usando a instruçaõ for aprimorada
// Escreva um aplicativo que utiliza uma instrução for aprimorada para somar os valores double passados pelos argumentos de linha de comando. [Dica: Utilize o método static parseDouble da classe Double para converter uma String em um valor double.]

public class Exerc_7_16 
{
    public static void main(String[] args) 
    {
        double soma = 0;// soma o total dos argumentos passados pelo usuario

        for (String x : args)
        {
            soma += Double.parseDouble(x);// converte o valor de String a double
        }
        System.out.println(soma);// mostra o resultado
    }
}
