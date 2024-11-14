// 9.3 - Uso de composicao em vez de heranca
// Muitos programas escritos com heranca podem ser escritos com composicao, e vice-versa. Reescreva a classe BasePlusCommissionEmployee (Figura 9.11) da hierarquia CommissionEmployee–BasePlusCommissionEmployee para utilizar composicao em vez de heranca.

public class Exerc_9_3 
{
    public static void main(String[] args) 
    {
        // Instancia um objeto BasePlusCommissionEmployee com nome, sobrenome, número de segurança social, vendas brutas, taxa de comissão e salário base
        BasePlusCommissionEmployeePre employee = 
            new BasePlusCommissionEmployeePre("Bob", "Lewis", "333-33-3333", 5000, .04, 300);
        
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
