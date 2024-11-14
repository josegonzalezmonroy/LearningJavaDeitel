// 5.13 - Fatoriais
// Escreva um aplicativo que calcula os fatoriais de 1 a 20. Utilize o tipo long. Exiba os resultados em formato tabular.  
public class Exerc_5_13
{
    public static void main(String[] args) 
    {
        long fatorial = 1;

       System.out.printf("%4s%22s %n", "n", "n!");
       System.out.println("--------------------------");


        for (int i = 1; i <= 20; i++)// Serie do 1 ao 20
        {
            for (int f = 1; f <= i; f++) // for para calular o n! de cada inteiro 
            {
                fatorial *= f;
            }
            System.out.printf("%4d%22d%n", i, fatorial);
            System.out.println("--------------------------");

            fatorial = 1; // reinicia o fatorial para o novo calculo
        }    
    }
}
