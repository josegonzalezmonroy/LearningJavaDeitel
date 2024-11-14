public class Invoice 
{
    private int partNumber;           // Numero da peça
    private String partDescription;   // Descricao da peça
    private int quantity;             // Quantidade de itens
    private double price;             // Preco por item

    // Construtor para inicializar os atributos
    public Invoice(int partNumber, String partDescription, int quantity, double price) 
    {
        this.partNumber = partNumber;               // Inicializa o numero da peça
        this.partDescription = partDescription;     // Inicializa a descricao da peça
        this.quantity = quantity;                   // Inicializa a quantidade
        this.price = price;                         // Inicializa o preco
    }

    // Metodos getters para acessar os atributos

    public int getPartNumber() 
    { 
        return partNumber;  // Retorna o numero da peça
    }

    public String getPartDescription() 
    { 
        return partDescription;  // Retorna a descricao da peça
    }
    
    public int getQuantity() 
    {
        return quantity;  // Retorna a quantidade
    }
    
    public double getPrice() 
    {
        return price;  // Retorna o preco
    }

    // Sobrescreve o metodo toString para exibir os detalhes da fatura formatados
    @Override
    public String toString() 
    {
        return String.format("%-10d%-20s%-10d%-10.2f", 
                             getPartNumber(), getPartDescription(), getQuantity(), getPrice());
    }
}
