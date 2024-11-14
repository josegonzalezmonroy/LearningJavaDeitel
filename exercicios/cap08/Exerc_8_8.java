// 8.8 - Aprimorando a classe Date
/*
 Modifique a classe Date da Figura 8.7 para realizar uma verificação de erros nos valores inicializadores das variáveis de instância month, day e year (atualmente ela valida somente o mês e dia). Forneça um método nextDay para incrementar o dia por um. Escreva um programa que testa o método nextDay em um loop que imprime a data durante cada iteração para ilustrar que o método funciona corretamente. Teste os seguintes casos:

    a) incrementar para o próximo mês e

    b) incrementar para o próximo ano.

 */
public class Exerc_8_8 
{
    public static void main(String[] args) 
    {
        try 
        {
            Date date1 = new Date(2, 25, 2024);

            for (int dia = 1; dia <= 395; dia++)
            {
                date1.nextDay();
                System.out.println(dia + ": " + date1);
            }
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Erro:\n" + e);
        }
        
    }    
}
