public class Employee 
{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    
    // Construtor com três argumentos
    public Employee(String firstName, String lastName, String socialSecurityNumber)
    {
        // Inicializa os atributos
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    } // fim do construtor

    // Retorna o primeiro nome
    public String getFirstName()
    {
        return firstName;
    }

    // Retorna o sobrenome
    public String getLastName()
    {
        return lastName;
    }

    // Retorna o número de seguro social
    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }

    // Retorna a representação String do objeto Employee
    @Override
    public String toString()
    {
        return String.format(
            "%s: %s %s%n%s: %s%n", 
            "commission employee", getFirstName(), getLastName(), // Exibe o nome e sobrenome
            "social security number", getSocialSecurityNumber() // Exibe o número de seguro social
        );
    }
}
