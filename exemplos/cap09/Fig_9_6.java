// Figura 9.6 - BasePlusCommissionEmployee.java
// A classe BasePlusCommissionEmployee representa um empregado que recebe 
// um salario-base alem da comissao

public class Fig_9_6 
{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private double grossSales;// vendas brutas semanais
    private double commissionRate;// percentagem da commisao
    private double baseSalary;// salario-base por semana

    // construtor de cinco argumentos
    public Fig_9_6(String firstName, String lastName, 
        String socialSecurityNumber, double grossSales,
        double commissionRate, double baseSalary)
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

        // se baseSalary é invalido, lança uma execao
        if (baseSalary < 0.0)
            throw new IllegalArgumentException(
                "Base salary must be >= 0.0");
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
        this.baseSalary = baseSalary;
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

    // configura o salario-base
    public void setBaseSalary(double baseSalary)
    {
        if (baseSalary < 0.0)
            throw new IllegalArgumentException(
                "Base salary must be >= 0.0");
                
        this.baseSalary = baseSalary;
    }

    // retorna o salario-base
    public double getBaseSalary()
    {
        return baseSalary;
    }

    // calcula os lucros
    public double earnings()
    {
        return baseSalary + (commissionRate * grossSales);
    }

    // retorna a representacao String do objeto CommissionEmployee
    @Override // indica que esse metodo substitui um metodo da superclasse
    public String toString()
    {
        return String.format(
            "%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f", 
        "base-salaried commission employee", firstName, lastName,
        "social security number", socialSecurityNumber,
        "gross sales", grossSales, "commission rate", commissionRate,
        "base salary", baseSalary);
    }
    
}
