// 7.12 - Eliminação de duplicatas 
// Utilize um array unidimensional para resolver o seguinte problema: Escreva um aplicativo que insere cinco números, cada um dos quais está entre 10 e 100, inclusive. Enquanto cada número é lido, exibe somente se ele não tiver duplicata de um número já lido. Cuide de tratar o 'pior caso', em que todos os cinco* números são diferentes. Utilize o menor array possível para resolver esse problema. Exiba o conjunto completo de valores únicos inseridos depois que o usuário inserir cada valor novo.

public class Exerc_7_12 
{
    public static void main(String[] args) 
    {
        int[] valores = {24, 17, 54, 24, 54};

        eliminarDuplicados(valores);// função que elimina os duplicados

        for (int valor : valores)
            if (valor != 0)// ignora os valores iguais a 0
                System.out.println(valor);
    }    
    
    public static void eliminarDuplicados(int[] valores)
    {
        for (int i = 0; i < valores.length; i++)// faz o bluce pelo array
        {
            int numero = valores[i];// numero agora é o valor do indice i
                for (int j = i + 1; j < valores.length; j++)
                    if (numero == valores[j])// se encontrar um numero igual
                        valores[j] = 0;// agora sera 0
        }
    }
}