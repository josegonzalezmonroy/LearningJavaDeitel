// Figura 10.5 - SalariedEmployee.java
// A classe concreta SalariedEmployee estende a classe abstrata Employee

public class SalariedEmployee extends Employee
{
    private double weeklySalary;

    //construtor
    public SalariedEmployee(String firstName, String lastName, 
        String socialSecurityNumber, Date birthDate, double weeklySalary)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate);

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

    // calcula os rendimentos; sobreescreve o metodo earnings em Employee
    @Override
    public double earnings()
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
