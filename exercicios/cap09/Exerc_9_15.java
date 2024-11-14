// 9.15 - Criando uma nova subclasse de Employee
// Outros tipos de Employees podem incluir SalariedEmployees, que recebem um salario semanal fixo; PieceWorkers, que sao pagos pelo numero de pecas que produzem; ou HourlyEmployees, que recebem um valor 50% maior para as horas extras. Crie uma classe HourlyEmployee, que e herdada da classe Employee (Exercicio 9.14), e tem variaveis de instancia hours (um double), que representa as horas trabalhadas, e wage (um double), que representa os salarios por hora, alem de um construtor que recebe como argumentos primeiro nome, sobrenome, numero de seguro social, salario por hora e numero de horas trabalhadas, metodos set e get para manipular hours e wage, um metodo earnings para calcular os rendimentos de um HourlyEmployee com base nas horas trabalhadas e um metodo toString que retorna a representacao String de HourlyEmployee. O metodo setWage deve assegurar que wage nao seja negativo, e setHours, que o valor das horas esteja entre 0 e 168 (o numero total de horas em uma semana). Use a classe HourlyEmployee em um programa de teste, semelhante ao da Figura 9.5.

public class Exerc_9_15 
{
    public static void main(String[] args) 
    {
        // Teste de Employee com dados validos
        System.out.println("Teste de Employee com dados validos:");
        Employee employee = new Employee("John", "Smith", "123-45-6789");
        System.out.println(employee);
        
        // Teste de HourlyEmployee com dados validos
        System.out.println("Teste de HourlyEmployee com dados validos:");
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Jane", "Doe", "987-65-4321", 20.00, 35);
        System.out.println(hourlyEmployee);
        System.out.printf("Ganhos: $%.2f%n", hourlyEmployee.earnings());

        // Teste de HourlyEmployee com horas e salario invalidos
        System.out.println("Teste de HourlyEmployee com dados invalidos:");

        try 
        {
            // Tentativa de criar HourlyEmployee com salario negativo
            HourlyEmployee invalidWageEmployee = new HourlyEmployee("Invalid", "Wage", "111-11-1111", -10.00, 40);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Erro esperado ao definir salario negativo: " + e.getMessage());
        }

        try 
        {
            // Tentativa de criar HourlyEmployee com horas negativas
            HourlyEmployee invalidHoursEmployee = new HourlyEmployee("Invalid", "Hours", "222-22-2222", 20.00, -5);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Erro esperado ao definir horas negativas: " + e.getMessage());
        }

        try 
        {
            // Tentativa de criar HourlyEmployee com horas acima do maximo permitido
            HourlyEmployee excessiveHoursEmployee = new HourlyEmployee("Excessive", "Hours", "333-33-3333", 20.00, 200);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Erro esperado ao definir horas acima do maximo: " + e.getMessage());
        }

        // Atualizacao de dados validos
        System.out.println("Atualizacao de dados validos do HourlyEmployee:");
        hourlyEmployee.setWage(22.00);
        hourlyEmployee.setHours(45);
        System.out.println(hourlyEmployee);
        System.out.printf("Ganhos atualizados: $%.2f%n", hourlyEmployee.earnings());

        // Teste de HourlyEmployee com horas e salario invalidos após a criacao
        System.out.println("Teste de HourlyEmployee com dados invalidos após criacao:");

        try 
        {
            // Tentativa de definir um salario negativo
            hourlyEmployee.setWage(-5.00);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Erro esperado ao definir salario negativo: " + e.getMessage());
        }

        try 
        {
            // Tentativa de definir horas negativas
            hourlyEmployee.setHours(-10);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Erro esperado ao definir horas negativas: " + e.getMessage());
        }

        try 
        {
            // Tentativa de definir horas acima do maximo permitido
            hourlyEmployee.setHours(170);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Erro esperado ao definir horas acima do maximo: " + e.getMessage());
        }
    }
}
