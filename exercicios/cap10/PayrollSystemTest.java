public class PayrollSystemTest 
{
    // Constante para armazenar o valor do bônus de aniversário
    private static final double BIRTHDAY_BONUS = 100;

    public static void main(String[] args) 
    {
        // Criação de objetos das subclasses Employee, cada um representando um tipo diferente de empregado.
        // Cada empregado tem um nome, sobrenome, número de seguro social, data de nascimento e seus respectivos salários.

        Date salariedBirthDay = new Date(1,15,1994);
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", salariedBirthDay, 800.00);

        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", new Date(3,25,1994), 16.75, 40);

        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", new Date(8,15,1994), 10000, .06);

        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", new Date(9,5,1994), 5000, .04, 300);

        PieceWorker pieceWorker = new PieceWorker("Alice", "Brown", "555-55-5555", new Date(7, 12, 1990), 12.00, 150);
        
        // Processamento individual de cada empregado, chamando o método earnings() para calcular o salário.
        // O método toString() também é chamado para exibir as informações do empregado.
        System.out.println("Employees processed individually:");

        System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned", salariedEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n", commissionEmployee, "earned", commissionEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n", pieceWorker, "earned", pieceWorker.earnings());
        
        // Criação de um array de objetos Employee para processar os empregados polimorficamente.
        Employee[] employees = new Employee[5];

        // Inicialização do array com os objetos Employee criados anteriormente.
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        employees[4] = pieceWorker;
        
        // Processamento polimórfico dos empregados no array.
        System.out.printf("Employees processed polymorphically:%n%n");

        // Loop for-each para iterar sobre cada empregado no array employees.
        for (Employee currentEmployee : employees) 
        {
            // Data corrente simulada, usada para verificar se o mês de aniversário do empregado é o mesmo que o mês atual.
            Date currentDate = new Date(9, 25, 2024);

            // Cálculo inicial do salário usando o método earnings().
            double earnings = currentEmployee.earnings();
            
            // Exibe as informações do empregado chamando o método toString().
            System.out.println(currentEmployee);
            
            // Verifica se o empregado atual é uma instância de BasePlusCommissionEmployee.
            if (currentEmployee instanceof BasePlusCommissionEmployee)
            {
                // Faz o downcast de Employee para BasePlusCommissionEmployee
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;

                // Aplica um aumento de 10% ao salário base
                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
            }// fim do if

            // Se o mês de aniversário do empregado for igual ao mês atual, aplica o bônus de aniversário.
            if (currentDate.getMonth() == currentEmployee.getMonth())
            {
                System.out.printf("birthday bonus: $%,.2f%n", BIRTHDAY_BONUS);
                earnings += BIRTHDAY_BONUS; // Adiciona o bônus ao salário
            }

            // Exibe o salário total ganho pelo empregado, incluindo o bônus, se aplicável.
            System.out.printf("earned $%,.2f%n%n", earnings);
        }// fim do loop for
    }// fim do método main
}// fim da classe PayrollSystemTest
