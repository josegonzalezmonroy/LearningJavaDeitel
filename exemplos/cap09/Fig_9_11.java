// Figura 9.11 - BasePlusCommissionEmployee
// A classe BasePlusCommissionEmployee e herdada de CommissionEmployee
// e acessa os dados private da superclasse via
// metodos public herdados

public class Fig_9_11 extends Fig_9_10 // BasePlusCommissionEmployee extends CommissionEmployee
{
    private double baseSalary;// salario-base por semana
    
    // construtor de seis argumentos
    public Fig_9_11(String firstName, String lastName, 
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
        return getBaseSalary() + super.earnings();
    }

    // retorna a representacao de String de BasePlusCommissionEmployee
    @Override
    public String toString()
    {
        return String.format("%s: %s%n%s: %.2f", "base-salaried",
        super.toString(), "base salary", getBaseSalary());
    }
}// fim da classe BasePlusCommissionEmployee