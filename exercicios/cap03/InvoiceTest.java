import java.util.Scanner;

public class InvoiceTest 
{
    public static void main(String[] args)
    {
        Invoice invoice = new Invoice(null, null, 0, 0);

        Scanner input = new Scanner(System.in);

        System.out.print("Numero da fatura: ");
        String number = input.nextLine();
        invoice.setNumber(number);

        System.out.print("Descricao do produto: ");
        String descricao = input.nextLine();
        invoice.setDescription(descricao);

        System.out.print("Quantidade: ");
        int quantity = input.nextInt();
        invoice.setQuantity(quantity);

        System.out.print("Preco: ");
        double price = input.nextDouble();
        invoice.setPrice(price);

        double total = invoice.getInvoiceAmount(invoice.getQuantity(),invoice.getPrice());

        System.out.printf("%nResumo da fatura: %nProduto: %s%nQuantidade: %d%nPreco por unidade: %.2f%nTotal: %.2f", invoice.getDescription(), invoice.getQuantity(), invoice.getPrice(), total);
    }
}
