// Figura 10.6 - HourlyEmployee.java
// Classe HourlyEmployee estende Employee

public class HourlyEmployee extends Employee 
{
    private double wage; // salário por hora
    private double hours; // horas trabalhadas durante a semana

    // construtor
    public HourlyEmployee(String firstName, String lastName, 
        String socialSecurityNumber, double wage, double hours) 
    {
        super(firstName, lastName, socialSecurityNumber);

        if (wage < 0.0)// valida remuneracao 
            throw new IllegalArgumentException(
                "Hourly wage must be >= 0.0");
            
        if (hours < 0.0 || hours > 168.0)// valida horas 
            throw new IllegalArgumentException(
                "Hours worked must be >= 0.0 and <= 168.0");
        
        this.wage = wage;
        this.hours = hours;
    }

    // configura remuneracao
    public void setWage(double wage) 
    {
        if (wage < 0.0) 
            throw new IllegalArgumentException(
                "Hourly wage must be >= 0.0");

        this.wage = wage;
    }

    // retorna a remuneracao
    public double getWage() 
    {
        return wage;
    }

    // configura as horas trabalhadas
    public void setHours(double hours) 
    {
        if (hours < 0.0 || hours > 168.0) // 168 horas é o máximo em uma semana
            throw new IllegalArgumentException(
                "Hours worked must be >= 0.0 and <= 168.0");

        this.hours = hours;
    }

    // retorna as horas trabalhadas
    public double getHours() 
    {
        return hours;
    }

    // calcula os rendimentos; sobreescreve o metodo earnings de Employee
    @Override
    public double earnings() 
    {
        if (getHours() <= 40) 
            return getWage() * getHours(); // Cálculo de ganhos para até 40 horas
        else 
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5; // Cálculo de ganhos para horas extras
    }

    // retorna a representacao String do objeto HourlyEmployee
    @Override
    public String toString() 
    {
        return String.format("hourly employee: %s%n%s: $%,.2f; %s: $%,.2f", 
            super.toString(), "hourly wage", getWage(),
            "hours worked", getHours());
    }
}// fim da classe HourlyEmployee
