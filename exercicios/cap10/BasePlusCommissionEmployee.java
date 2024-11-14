// Figura 10.8 - BasePlusCommissionEmployee
// Classe BasePlusCommissionEmployee estende CommissionEmployee

public class BasePlusCommissionEmployee extends CommissionEmployee
{
    private double baseSalary; // salário-base por semana
    
    public BasePlusCommissionEmployee(String firstName, String lastName, 
        String socialSecurityNumber, Date birthDate, double grossSales, 
        double commissionRate, double baseSalary)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate, 
            grossSales, commissionRate);

        // Verifica se baseSalary é inválido, caso seja, lança uma exceção
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    }

    //configura o salário-base
    public void setBaseSalary(double baseSalary) 
    {
        if (baseSalary < 0.0) 
            throw new IllegalArgumentException("Base salary must be >= 0.0");
    
        this.baseSalary = baseSalary;
    }

    //obtem o salário-base    
    public double getBaseSalary() 
    {
        return baseSalary;
    }
    
    // Calcula os ganhos como a soma do salário-base e dos ganhos do CommissionEmployee
    @Override
    public double getPaymentAmount() 
    {
        return getBaseSalary() + super.getPaymentAmount();
    }

    // Retorna a representação String do objeto BasePlusCommissionEmployee
    @Override
    public String toString()
    {
        return String.format("%s %s; %s: $%,.2f", 
            "base-salaried", super.toString(),
            "base salary", getBaseSalary());
    }
}// fim da classe BasePlusCommissionEmployee
