// 8.12 - Employee.java
// Variavel static utilizada para manter uma contagem do numero de
// objetos Employee na memoria

public class Fig_8_12 
{
    private static int count = 0; // numero de Employees criados
    private String firstName;
    private String lastName;
    
    // inicializa employee, adiciona 1 s static count e
    // gera a saida de string indicando que o construtor foir chamado
    public Fig_8_12(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;

        ++count; // incrementa a contagem estatica de empregados 
        System.out.printf("Employee constructor: %s %s; count = %d%n", 
            firstName, lastName, count);
    }

    // obtem o primeiro nome
    public String getFirstName()
    {
        return firstName;
    }

    // obtem o ultimo nome
    public String getLastName()
    {
        return lastName;
    }

    // metodo statico para obter valor de contagem estatica
    public static int getCount()
    {
        return count;
    }
}// fim da classe Employee
