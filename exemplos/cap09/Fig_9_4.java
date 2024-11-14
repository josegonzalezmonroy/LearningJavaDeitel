// Figura 9.4 - CommissionEmployee.java
// A classe CommissionEmployee representa um empregado que recebeu um 
// percentual das vendas brutas
public class Fig_9_4 extends Object
{
    protected final String firstName;
    protected final String lastName;
    protected final String socialSecurityNumber;
    protected double grossSales;// vendas brutas semanais
    protected double commissionRate;// percentagem da commisao

    // construtor de cinco argumentos
    public Fig_9_4(String firstName, String lastName, 
        String socialSecurityNumber, double grossSales,
        double commissionRate)
    {
        // a chamada implicita para o construtor padrao de object ocorre aqui

        // se grossSales e invalido, lanca uma exceçao
        if (grossSales < 0.0)
            throw new IllegalArgumentException(
                "Gross sales must be >= 0.0");
        
        // se commissionRate e invalido, lanca uma excecao
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
                "Commission rate must be > 0.0 and < 1.0");
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }// fim do construtor

    // retorna o nome 
    public String getFirstName()
    {
        return firstName;
    }

    // retorna o sobrenome
    public String getLastName()
    {
        return lastName;
    }

    // retorna o numero de seguro social
    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }

    // configura a quantidade de vendas brutas
    public void setGrossSales(double grossSales)
    {
        if (grossSales < 0.0)
            throw new IllegalArgumentException(
            "Gross sales must be >= 0.0");

        this.grossSales = grossSales;
    }

    // retorna a quantidade de vendas brutas
    public double getGrossSales()
    {
        return grossSales;
    }

    // configura a taxa de comissao
    public void setCommissionRate(double commissionRate)
    {
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
        throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");
        
        this.commissionRate = commissionRate;
    }

    // retorna a taxa de comissao
    public double getCommissionRate()
    {
        return commissionRate;
    }

    // calcula os lucros
    public double earnings()
    {
        return commissionRate * grossSales;
    }

    // retorna a representacao String do objeto CommissionEmployee
    @Override // indica que esse metodo substitui um metodo da superclasse
    public String toString()
    {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", 
        "commission employee", firstName, lastName,
        "social security number", socialSecurityNumber,
        "gross sales", grossSales,
        "commission rate", commissionRate);
    }
}// fim da classe CommissionEmployee
