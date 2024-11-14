// 17.11 - Manipulando um Stream
// Use a classe Invoice fornecida na pasta exercises com os exemplos deste capítulo para criar um array de objetos Invoice. Use os dados de exemplo mostrados na Figura 17.20. A classe Invoice inclui quatro propriedades — uma PartNumber (tipo int), uma PartDescription (tipo String), uma Quantity do item sendo adquirido (tipo int) e um Price (tipo double). Realize as seguintes consultas no array dos objetos Invoice e exiba os resultados: a) Use lambdas e fluxos para classificar os objetos Invoice por PartDescription, então exiba os resultados. b) Use lambdas e fluxos para classificar os objetos Invoice por Price, então exiba os resultados. c) Use lambdas e fluxos para mapear cada Invoice para sua PartDescription e Quantity, classifique os resultados por Quantity, e então os exiba. d) Use lambdas e fluxos para mapear cada Invoice para sua PartDescription e o valor de Invoice (isto é, Quantity * Price). Ordene os resultados por valor Invoice. e) Modifique a Parte (d) para selecionar os valores Invoice no intervalo US$ 200 a US$ 500.

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Exerc_17_11 
{
    public static void main(String[] args)
    {
        // Cria um array de objetos Invoice
        Invoice[] invoices = {
            new Invoice(83, "Electric sander", 7, 57.98),
            new Invoice(24, "Power saw", 18, 99.99),
            new Invoice(7, "Sledge hammer", 11, 21.50),
            new Invoice(77, "Hammer", 76, 11.99),
            new Invoice(39, "Lawn mower", 3, 79.50),
            new Invoice(68, "Screwdriver", 106, 6.99),
            new Invoice(56, "Jig saw", 21, 11.00),
            new Invoice(3, "Wrench", 34, 7.50)
        };

        // Exibe as faturas classificadas por descricao
        System.out.println("\nBy Description");
        titles();
        Arrays.stream(invoices)
            .sorted(Comparator.comparing(Invoice::getPartDescription)) // Classifica por PartDescription
            .forEach(System.out::println); // Exibe cada Invoice

        // Exibe as faturas classificadas por preco
        System.out.println("\nBy Price");
        titles();
        Arrays.stream(invoices)
            .sorted(Comparator.comparing(Invoice::getPrice)) // Classifica por Price
            .forEach(System.out::println); // Exibe cada Invoice
        
        // Exibe descricao e quantidade, classificadas por quantidade
        System.out.println("\nBy Quantity");
        System.out.printf("%-20s%-10s%n", "Description", "Quantity");
        Arrays.stream(invoices)
            .sorted(Comparator.comparing(Invoice::getQuantity)) // Classifica por Quantity
            .map(invoice -> String.format("%-20s%-10d", invoice.getPartDescription(), invoice.getQuantity())) // Mapeia para descricao e quantidade
            .forEach(System.out::println); // Exibe descricao e quantidade

        // Exibe descricao e valor total da fatura (quantidade * preco), classificados por valor
        System.out.println("\nBy Value");
        System.out.printf("%-20s%-10s%n", "Description", "Value");
        Arrays.stream(invoices)
            .sorted(Comparator.comparing(invoice -> invoice.getQuantity() * invoice.getPrice())) // Classifica por valor total
            .map(invoice -> String.format("%-20s%-10.2f", invoice.getPartDescription(), invoice.getQuantity() * invoice.getPrice())) // Mapeia para descricao e valor
            .forEach(System.out::println); // Exibe descricao e valor total

        // Filtro para faturas com valor total entre 200 e 500
        Predicate<Invoice> filterByInvoiceValue = 
            invoice -> 
            {
                double total = invoice.getQuantity() * invoice.getPrice(); // Calcula o valor total
                return total >= 200 && total <= 500; // Filtra os valores entre 200 e 500
            };

        // Exibe descricao e valor total das faturas filtradas por intervalo de 200 a 500
        System.out.println("\nBy Value (200 - 500)");
        System.out.printf("%-20s%-10s%n", "Description", "Value");
        Arrays.stream(invoices)
            .filter(filterByInvoiceValue) // Aplica o filtro
            .sorted(Comparator.comparing(invoice -> invoice.getQuantity() * invoice.getPrice())) // Classifica por valor total
            .map(invoice -> String.format("%-20s%-10.2f", invoice.getPartDescription(), invoice.getQuantity() * invoice.getPrice())) // Mapeia para descricao e valor
            .forEach(System.out::println); // Exibe descricao e valor total
    }

    // Metodo para exibir os titulos das colunas
    private static void titles()
    {
        System.out.printf("%-10s%-20s%-10s%-10s%n", "Number", "Description", "Quantity", "Price");
    }

}
