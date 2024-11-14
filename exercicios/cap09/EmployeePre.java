public class EmployeePre 
{
    private String nome;
    private String sobrenome;
    private double salario;

    // Construtor
    EmployeePre(String nome, String sobrenome, double salario) 
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        if (salario > 0)
            this.salario = salario;
    }

    // Definir o nome
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    // Obter o nome
    public String getNome()
    {
        return nome;
    }

    // Definir o sobrenome
    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }

    // Obter o sobrenome
    public String getSobrenome()
    {
        return sobrenome;
    }

    // Definir o salario
    public void setSalario(double salario)
    {
        if (salario > 0)
            this.salario = salario;
    }

    // Obter o salario
    public double getSalario()
    {
        return salario;
    }

    // Calcular o salario anual
    public double salarioAnual()
    {
        return salario * 12;
    }

    // Sobrescrever o metodo toString para fornecer uma representacao em string do objeto Employee
    @Override
    public String toString() 
    {
        return String.format("Funcionario: %s %s%nSalario Mensal: %.2f%nSalario Anual: %.2f", 
                              getNome(), getSobrenome(), getSalario(), salarioAnual());
    }
}
