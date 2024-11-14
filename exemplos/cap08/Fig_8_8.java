// Figura 8.8 - Employee.java
// Classe Employee com referencia a outros objetos

public class Fig_8_8 
{
    private final String firstName;
    private final String lastName;
    private final Fig_8_7 birthDate;
    private final Fig_8_7 hireDate;

    // Construtor para inicializar nome, data de nascimento e data de contratação
    public Fig_8_8(String firstName, String lastname, Fig_8_7 birthDate, 
        Fig_8_7 hireDate)
    {
        this.firstName = firstName;
        this.lastName = lastname;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
    }

    // converte Employee em formato de String
    public String toString()
    {
        return String.format("%s, %s Hired: %s Birthday: %s",
            lastName, firstName, hireDate, birthDate);
    } 
}// fim da classe Employee
