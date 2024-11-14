public class BasePlusCommissionEmployee extends CommissionEmployee
{
    private double baseSalary; // salário-base por semana
    
    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary)
    {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

        // Verifica se baseSalary é inválido, caso seja, lança uma exceção
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        // Inicializa o salário-base
        this.baseSalary = baseSalary;
    }

    // Métodos para configurar e obter o salário-base
    public void setBaseSalary(double baseSalary) 
    {
        if (baseSalary < 0.0) 
            throw new IllegalArgumentException("Base salary must be >= 0.0");
    
        this.baseSalary = baseSalary;
    }
    
    public double getBaseSalary() 
    {
        return baseSalary;
    }
    
    // Calcula os ganhos como a soma do salário-base e dos ganhos do CommissionEmployee
    @Override
    public double earnings() 
    {
        return getBaseSalary() + super.earnings();
    }

    @Override
    public String toString()
    {
        return String.format("%s:%n%s%n%s: %.2f", 
            "base-salaried", super.toString(), // Exibe as informações do CommissionEmployee
            "base salary", getBaseSalary() // Exibe o salário-base
            );
    }
}
