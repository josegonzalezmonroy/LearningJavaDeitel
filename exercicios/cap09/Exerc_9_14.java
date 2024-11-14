// 9.14 - Hierarquia Employee
// Neste capitulo, voce estudou uma hierarquia de heranca em que a classe BasePlusCommissionEmployee e herdada da classe CommissionEmployee. Mas nem todos os tipos de empregados sao CommissionEmployees. Neste exercicio, voce criara uma superclasse Employee mais geral para calcular os atributos e comportamentos na classe CommissionEmployee que sao comuns a todos os Employees. Os atributos e comportamentos comuns a todos os Employees sao firstName, lastName, socialSecurityNumber, getFirstName, getLastName, getSocialSecurityNumber e uma parte do metodo toString. Crie uma nova superclasse Employee que contenha esses metodos e variaveis de instancia, alem de um construtor. Entao, reescreva a classe CommissionEmployee da Secao 9.4.5 como uma subclasse de Employee. A classe CommissionEmployee so deve conter os metodos e as variaveis de instancia que nao sao declarados na superclasse Employee. O construtor da classe CommissionEmployee deve chamar o construtor da classe Employee, e o metodo toString de CommissionEmployee deve invocar o metodo toString de Employee.

public class Exerc_9_14 
{
    public static void main(String[] args) 
    {
        // Instancia um objeto BasePlusCommissionEmployee com nome, sobrenome, número de segurança social, vendas brutas, taxa de comissão e salário base
        BasePlusCommissionEmployee employee = 
            new BasePlusCommissionEmployee("Bob", "Lewis", "333-33-3333", 5000, .04, 300);
        
        // Obtém e exibe os dados do empregado comissionado usando os métodos get
        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is", employee.getFirstName()); // Exibe o primeiro nome
        System.out.printf("%s %s%n", "Last name is", employee.getLastName()); // Exibe o sobrenome
        System.out.printf("%n%s %s%n", "Social security number is", employee.getSocialSecurityNumber()); // Exibe o número de segurança social
        System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales()); // Exibe as vendas brutas
        System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate()); // Exibe a taxa de comissão
        System.out.printf("%s %.2f%n", "Base salary is", employee.getBaseSalary()); // Exibe o salário base

        // Atualiza o salário base do empregado para 1000
        employee.setBaseSalary(1000);

        // Exibe as informações atualizadas do empregado usando o método toString
        System.out.printf("%n%s:%n%n%s%n", "Update employee information obtained by toString", employee.toString());
    } // fim de main    
}
