// Figura 10.7 - CommissionEmployee.java
// Classe CommissionEmployee estende Emmployee

public class CommissionEmployee extends Employee 
{    
    private double grossSales; // vendas brutas semanais
    private double commissionRate; // porcentagem da comissão

    // Construtor com cinco argumentos
    public CommissionEmployee(String firstName, String lastName, 
        String socialSecurityNumber, double grossSales, 
        double commissionRate)
    {
        super(firstName, lastName, socialSecurityNumber);

        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
                "Commission rate must be > 0.0 and < 1.0");

        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
            
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    } // fim do construtor

    // Configura a quantidade de vendas brutas
    public void setGrossSales(double grossSales)
    {
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");

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
        
        this.commissionRate = commissionRate;
    }

    // Retorna a taxa de comissão
    public double getCommissionRate()
    {
        return commissionRate;
    }

    // Calcula os lucros com base nas vendas brutas e na taxa de comissão
    @Override
    public double earnings()
    {
        return getCommissionRate() * getGrossSales();
    }

    // Retorna a representação String do objeto CommissionEmployee
    @Override
    public String toString()
    {
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",
            "commission employee", super.toString(),
            "gross sales", getGrossSales(),
            "commission rate", getCommissionRate());
    }
}// fim da classe CommissionEmployee
