public class HourlyEmployee extends Employee 
{
    private double hours; // horas trabalhadas
    private double wage; // salário por hora

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) 
    {
        super(firstName, lastName, socialSecurityNumber);

        setWage(wage); // validação no método setWage
        setHours(hours); // validação no método setHours
    }

    public void setWage(double wage) 
    {
        if (wage < 0.0) 
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");

        this.wage = wage;
    }

    public double getWage() 
    {
        return wage;
    }

    public void setHours(double hours) 
    {
        if (hours < 0.0 || hours > 168.0)// 168 horas é o máximo em uma semana 
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");

        this.hours = hours;
    }

    public double getHours() 
    {
        return hours;
    }

    public double earnings() 
    {
        if (getHours() <= 40) 
            return getWage() * getHours(); // Cálculo de ganhos para até 40 horas
        else 
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5; // Cálculo de ganhos para horas extras
    }

    @Override
    public String toString() 
    {
        return String.format("hourly employee:%n%s%nhourly wage: $%.2f%nhours worked: %.2f", 
            super.toString(), // Exibe as informações do Employee
            getWage(), // Exibe a taxa salarial
            getHours() // Exibe as horas trabalhadas
        );
    }
}
