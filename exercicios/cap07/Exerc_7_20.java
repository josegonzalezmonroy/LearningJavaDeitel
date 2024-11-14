// 7.20 - Vendas totais
// Utilize um array bidimensional para resolver o seguinte problema: Uma empresa tem quatro equipes de venda (1 a 4) que vendem cinco produtos diferentes (1 a 5). Uma vez por dia, cada vendedor passa uma nota de cada tipo de produto diferente vendido. Cada nota contém o seguinte: a) O número do vendedor b) O número do produto c) O valor total em reais desse produto vendido nesse dia Portanto, cada vendedor passa entre 0 e 5 notas de venda por dia. Assuma que as informações a partir de todas as notas durante o último mês estão disponpiveis. Escreva um aplicativo que leia todas essas informações sobre as vendas do último mês e resuma as vendas totais por vendedor e por produto. Todos os totais devem ser armazenados no array bidimensional 'sales'. Depois de processar todas as informações do último mês, exiba os resultados em formato tabular, com cada coluna representando um vendedor particular e cada linha representando um produto particular. Some cada linha para obter o total das vendas de cada produto no último mês. Some cada coluna para obter o total de vendas por vendedor no último mês. Sua saída tabular deve incluir esses totais cruzados à direita das linhas totalizandas e na parte inferior das colunas totalizadas.

import java.util.Scanner;

public class Exerc_7_20 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int vendedores = 4;// quantidade de vendedores
        int produtos = 5;// quantidade de produtos
        double[][] sales = new double[produtos][vendedores];// array para armazenar as vendas
        double totalGeral = 0;// armazena o total de vendas gerais
        String resposta = "";// sentinela

        while (!resposta.equals("n"))// enquanto nao e inserido o valor sentinela
        {
            System.out.println("Digite o numero do vendedor (1 a 4)");
            int vendedor = input.nextInt() - 1;// valor do vendedor inserido pelo usuario
            while (!(vendedor >= 0 && vendedor <= 3))// valida que seja un vendedor valido
            {
                System.out.println("Vendedor nao valido,\ndigite um numero de 1 a 4:");
                vendedor = input.nextInt() - 1;
            }
    
            System.out.println("Digite o numero do produto (1 a 5)");
            int produto = input.nextInt() - 1;// valor do produto inserido pelo usuario
            while (!(produto >= 0 && produto <= 4))// valida que seja un produto valido
            {
                System.out.println("Produto nao valido,\ndigite um numero de 1 a 5:");
                produto = input.nextInt() - 1;
            }

            System.out.println("Digite o total em reais desse produto vendido no dia");
            double vendasDoDia = input.nextDouble();// valor do total de vendas inserido pelo usuario
            while (!(produto >= 0 && produto <= 4))// valida que seja un valor >= 0
            {
                System.out.println("Valor nao valido,\ndigite um valor >= 0:");
                vendasDoDia = input.nextDouble();
            }

            sales[produto][vendedor] = vendasDoDia;// adiciona o valor das vendas ao produto e vendedor correspondente

            System.out.println("Deseja adicionar outra nota? (Y/N)");
            resposta = input.next().toLowerCase();// resposta do usuario se deseja ou nao continuar inserindo informacoes 
        }
        // Imprime as informacoes no formato tabular

        System.out.printf("%-11s", "");

        for (int vendedor = 0; vendedor < sales[0].length; vendedor++)
            System.out.printf("%12s%02d", "Vendedor ", vendedor + 1);
    
        System.out.printf("%14s%n", "Total");

        for (int linha = 0; linha < sales.length; linha++)
        {
            double totalProduto = 0;// armazena os valores de vendas totais de cada produto

            System.out.printf("Produto %02d:", linha + 1);
            for (double valor : sales[linha])
            {
                System.out.printf("%14.2f", valor);
                totalProduto += valor;// adiciona o valor ao total do produto
                totalGeral += valor;// adiciona o valor ao total geral
            }
            System.out.printf("%14.2f%n", totalProduto);
        }

        System.out.printf("%-11s", "Total");
        for (int vendedor = 0; vendedor < vendedores; vendedor++)
        {
            double totalVendedor = 0;// armazena as vendas totais de cada vendedor
            for (int produto = 0; produto < produtos; produto++)
                totalVendedor += sales[produto][vendedor];// adiciona o valor ao total de vendas de cada vendedor

            System.out.printf("%14.2f", totalVendedor);
        }
        System.out.printf("%14.2f", totalGeral);
    }   
}
