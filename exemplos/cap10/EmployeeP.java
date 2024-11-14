// Figura 10.13 - Employee.java
// Superclasse abstrata Employee que implementa Payable

public abstract class EmployeeP implements Payable
{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    
    // Construtor com três argumentos
    public EmployeeP(String firstName, String lastName, 
        String socialSecurityNumber)
    {
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
        return String.format("%s %s%nsocial security number: %s", 
            getFirstName(), getLastName(), getSocialSecurityNumber());
    }
    
    // Observacao:  nao implementamos o metodo getPaymentAmount de Payable aqui, assim
    // essa classe deve ser declarada abstrata para evitar um erro de compilacao
}// fim da classe abstrata Employee
