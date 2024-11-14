// 10.16 - Modificação no sistema Contas a Pagar
// É possível incluir a funcionalidade do aplicativo de folha de pagamento (figuras 10.4 a 10.9) no aplicativo contas a pagar sem modificar as subclasses Employee SalariedEmployee, HourlyEmployee, CommissionEmployee ou BasePlusCommissionEmployee. Para fazer isso, modifique a classe Employee (Figura 10.4) para implementar a interface Payable e declare o método getPaymentAmount para invocar o método earnings. O método getPaymentAmount passaria então a ser herdado pelas subclasses na hierarquia Employee. Quando getPaymentAmount é chamado para um objeto de subclasse particular, ele invoca polimorficamente o método de earnings adequado para a subclasse. Reimplemente a Questão 10.15 usando a hierarquia Employee original a partir do aplicativo de folha de pagamento das figuras 10.4 a 10.9. Modifique a classe Employee como descrito nesta questão, e não modifique nenhuma das subclasses da classe Employee.

public abstract class Employee implements Payable
{
    private final String firstName; // Nome do funcionário
    private final String lastName; // Sobrenome do funcionário
    private final String socialSecurityNumber; // Número de segurança social 
    private final Date birthDate; // Data de nascimento do funcionário
    
    // Construtor com quatro argumentos
    public Employee(String firstName, String lastName, 
        String socialSecurityNumber, Date birthDate)
    {
        this.firstName = firstName; // Inicializa o nome do funcionário
        this.lastName = lastName; // Inicializa o sobrenome do funcionário
        this.socialSecurityNumber = socialSecurityNumber; // Inicializa o número de segurança social
        this.birthDate = birthDate; // Inicializa a data de nascimento
    } // fim do construtor

    // Retorna o mês da data de nascimento
    public int getMonth()
    {
        return birthDate.getMonth();
    }

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

    // Retorna o número de segurança social
    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }

    // Retorna a representação String do objeto Employee
    @Override
    public String toString()
    {
        return String.format("%s %s%nbirth date: %s%nsocial security number: %s", 
            getFirstName(), getLastName(), birthDate, getSocialSecurityNumber());
    }

    // O método abstract deve ser sobrescrito pelas subclasses concretas
    public abstract double earnings(); // nenhuma implementação aqui

    @Override
    public double getPaymentAmount() 
    {
        return earnings(); // chama o método earnings, polimórficamente
    }
} // fim da classe abstrata Employee
