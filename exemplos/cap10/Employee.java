// Figura 10.4 - Employee.java
// Superclasse abstrata Employee

public abstract class Employee 
{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    
    // Construtor com três argumentos
    public Employee(String firstName, String lastName, 
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

    // O metodo abstract deve ser sobreescrito pelas subclasses concretas
    public abstract double earnings();// nenhuma implementacao aqui
}// fim da classe abstrata Employee
