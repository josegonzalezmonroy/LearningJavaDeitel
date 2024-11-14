// 5.17 - Calculando vendas
// Um varejista on-line vende cinco produtos cujos preços no varejo são como a seguir: produto 1; US$ 2,98; produto 2; US$ 4,50; produto 3; US$ 9,98; produto 4; US$ 4,94; produto 5; US$ 6,87;.... Escreva um aplicativo que leia uma serie de pares de numeros como segue: a) numero de produto, b) quantidade vendida. Voce deve calcular e exibir o valor de varejo total de todos os produtos vendidos.

import java.util.Scanner;

public class Exerc_5_17 
{
    public static void main(String[] args) 
    {
        int produto = 1;
        int quantidade = 5;
        double totalProd01 = 0;
        double totalProd02 = 0;
        double totalProd03 = 0;
        double totalProd04 = 0;
        double totalProd05 = 0;

        double total;
        
        Scanner input = new Scanner(System.in);

        while (produto != -1) 
        {
            System.out.print("Digite o numero do produto (-1 para finalizar): ");
            produto = input.nextInt();
            if (produto == -1)
                break;

            System.out.print("Quantidades vendidas: ");
            quantidade = input.nextInt();

            switch (produto) 
            {
                case 1:
                    totalProd01 += quantidade * 2.98;                
                    break;
                case 2:
                    totalProd02 += quantidade * 4.50;                
                    break;
                case 3:
                    totalProd03 += quantidade * 9.98;
                    break;
                case 4:
                    totalProd04 += quantidade * 4.94;
                    break;
                case 5:
                    totalProd05 += quantidade * 6.87;
                    break;
            }    
        }

        total = totalProd01 + totalProd02 + totalProd03 + totalProd04 + totalProd05;
        
        if (total > 0 )
            System.out.println("Produtos vendidos: ");

        if (totalProd01 > 0)
            System.out.printf("Produto 01: %.2f%n", totalProd01);

        if (totalProd02 > 0)
            System.out.printf("Produto 02: %.2f%n", totalProd02);

        if (totalProd03 > 0)
            System.out.printf("Produto 03: %.2f%n", totalProd03);

        if (totalProd04 > 0)
            System.out.printf("Produto 04: %.2f%n", totalProd04);

        if (totalProd05 > 0)
            System.out.printf("Produto 05: %.2f%n", totalProd05);
        
        if (total > 0 )
            System.out.printf("Total geral: %.2f", total);
        else
            System.out.println("Sem vendas para mostrar");
    }
}
