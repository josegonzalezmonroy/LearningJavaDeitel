public class BasePlusCommissionEmployeePre 
{
    // Composição: BasePlusCommissionEmployee contém um objeto CommissionEmployeePre
    private CommissionEmployeePre commissionEmployee;
    private double baseSalary; // salário-base por semana
    
    // Construtor de seis argumentos
    public BasePlusCommissionEmployeePre(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary)
    {
        // Cria um novo objeto CommissionEmployeePre usando os parâmetros fornecidos
        commissionEmployee = new CommissionEmployeePre(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

        // Verifica se baseSalary é inválido, caso seja, lança uma exceção
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        // Inicializa o salário-base
        this.baseSalary = baseSalary;
    }

    // Métodos para obter os dados do CommissionEmployeePre
    public String getFirstName() 
    {
        return commissionEmployee.getFirstName();
    }

    public String getLastName() 
    {
        return commissionEmployee.getLastName();
    }

    public String getSocialSecurityNumber() 
    {
        return commissionEmployee.getSocialSecurityNumber();
    }

    // Métodos para configurar e obter as vendas brutas e a taxa de comissão
    public void setGrossSales(double grossSales) 
    {
        commissionEmployee.setGrossSales(grossSales);
    }

    public double getGrossSales() 
    {
        return commissionEmployee.getGrossSales();
    }

    public void setCommissionRate(double commissionRate) 
    {
        commissionEmployee.setCommissionRate(commissionRate);
    }

    public double getCommissionRate() 
    {
        return commissionEmployee.getCommissionRate();
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

    // Calcula os ganhos como a soma do salário-base e dos ganhos do CommissionEmployeePre
    public double earnings() 
    {
        return baseSalary + commissionEmployee.earnings();
    }

    // Retorna a representação de String de BasePlusCommissionEmployee
    @Override
    public String toString()
    {
        return String.format("%s: %s%n%s: %.2f", 
            "base-salaried", commissionEmployee.toString(), // Exibe as informações do CommissionEmployeePre
            "base salary", getBaseSalary() // Exibe o salário-base
        );
    }
}
