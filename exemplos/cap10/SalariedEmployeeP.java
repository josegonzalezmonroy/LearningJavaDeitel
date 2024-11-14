// Figura 10.14 - SalariedEmployee.java
// A classe SalariedEmployee que implementa o metodo getPaymentAmount
// da interface Payable
public class SalariedEmployeeP extends EmployeeP
{
    private double weeklySalary;

    //construtor
    public SalariedEmployeeP(String firstName, String lastName, 
        String socialSecurityNumber, double weeklySalary)
    {
        super(firstName, lastName, socialSecurityNumber);

        if (weeklySalary < 0.0)
            throw new IllegalArgumentException(
                "Weekly salary must be >= 0.0");
        
        this.weeklySalary = weeklySalary;
    }

    // configura o salario
    public void setWeeklySalary(double weeklySalary)
    {
        if (weeklySalary < 0.0)
            throw new IllegalArgumentException(
                 "Weekly salary must be >= 0.0");
        
        this.weeklySalary = weeklySalary;
    }

    // retorna o salario
    public double getWeeklySalary()
    {
        return weeklySalary;
    }

    // calcula vencimentos; implementa o metodo Payable da interface 
    // que era abstrata na superclasse Employee
    @Override
    public double getPaymentAmount()
    {
        return getWeeklySalary();
    }

    // retorna a representacao String do objeto SalariedEmployee
    @Override
    public String toString()
    {
        return String.format("salaried employee: %s%n%s: $%,.2f",
            super.toString(), "weekly salary", getWeeklySalary());
    }
}// fim da classe SalariedEmployee
