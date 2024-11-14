public class CommissionEmployeePre
{
    // Atributos finais para nome, sobrenome e número de seguro social (não podem ser modificados após a inicialização)
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    
    // Atributos para vendas brutas e taxa de comissão (podem ser modificados)
    private double grossSales; // vendas brutas semanais
    private double commissionRate; // porcentagem da comissão

    // Construtor com cinco argumentos
    public CommissionEmployeePre(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate)
    {
        // Verifica se grossSales é inválido, caso seja, lança uma exceção
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        
        // Verifica se commissionRate é inválido, caso seja, lança uma exceção
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        
        // Inicializa os atributos
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    } // fim do construtor

    // Retorna o primeiro nome
    public String getFirstName()
    {
        return firstName;
    }

    // Retorna o sobrenome
    public String getLastName()
    {
        return lastName;
    }

    // Retorna o número de seguro social
    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }

    // Configura a quantidade de vendas brutas
    public void setGrossSales(double grossSales)
    {
        // Verifica se grossSales é inválido, caso seja, lança uma exceção
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");

        // Atualiza o valor de grossSales
        this.grossSales = grossSales;
    }

    // Retorna a quantidade de vendas brutas
    public double getGrossSales()
    {
        return grossSales;
    }

    // Configura a taxa de comissão
    public void setCommissionRate(double commissionRate)
    {
        // Verifica se commissionRate é inválido, caso seja, lança uma exceção
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        
        // Atualiza o valor de commissionRate
        this.commissionRate = commissionRate;
    }

    // Retorna a taxa de comissão
    public double getCommissionRate()
    {
        return commissionRate;
    }

    // Calcula os lucros com base nas vendas brutas e na taxa de comissão
    public double earnings()
    {
        return getCommissionRate() * getGrossSales();
    }

    // Retorna a representação String do objeto CommissionEmployee
    @Override
    public String toString()
    {
        return String.format(
            "%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", 
            "commission employee", getFirstName(), getLastName(), // Exibe o nome e sobrenome
            "social security number", getSocialSecurityNumber(), // Exibe o número de seguro social
            "gross sales", getGrossSales(), // Exibe as vendas brutas
            "commission rate", getCommissionRate() // Exibe a taxa de comissão
        );
    }
} // fim da classe CommissionEmployee
