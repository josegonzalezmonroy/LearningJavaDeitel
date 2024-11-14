// Figura 9.9 - BasePlusCommissionEmployee
// BasePlusCommissionEmployee herda variaveis de instancia protected de
// CommissionEmployee

public class Fig_9_9 extends Fig_9_4 // BasePlusCommissionEmployee extends CommissionEmployee
{
    private double baseSalary;// salario-base por semana
    
    // construtor de seis argumentos
    public Fig_9_9(String firstName, String lastName, 
    String socialSecurityNumber, double grossSales,
    double commissionRate, double baseSalary)
    {
        super(firstName, lastName,socialSecurityNumber, 
        grossSales, commissionRate);

        // se baseSalary é invalido, lança uma execao
        if (baseSalary < 0.0)
            throw new IllegalArgumentException(
            "Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
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
    @Override// indica que esse metodo substitui um metodo da superclasse
    public double earnings()
    {
        return baseSalary + (commissionRate * grossSales);
    }

    // retorna a representacao de String de BasePlusCommissionEmployee
    @Override
    public String toString()
    {
        return String.format(
        "%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f", 
        "base-salaried commission employee", firstName, lastName,
        "social security number", socialSecurityNumber,
        "gross sales", grossSales, "commission rate", commissionRate,
        "base salary", baseSalary);
    }
}// fim da classe BasePlusCommissionEmployee