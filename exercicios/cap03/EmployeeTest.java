
public class EmployeeTest {

    public static void main(String[] args)//metodo main inicia a execucao do aplicativo Java
    {
        Employee employee1 = new Employee("Marie", "Marques", 120);
        Employee employee2 = new Employee("Pedre", "Perez", -7);

        System.out.println("Salarios dos funcionarios:");
        System.out.printf("%nNome: %s%nSobrenome: %s%nSalario mensal: %.2f%nSalario anual: %.2f%nAumento 10%%: %.2f%nSalario anual com aumento: %.2f", employee1.getNome(), employee1.getSobrenome(), employee1.getSalario(), employee1.salarioAnual(),employee1.salarioAnual()*.1, employee1.salarioAnual()*1.1);
        
        System.out.printf("%nNome: %s%nSobrenome: %s%nSalario mensal: %.2f%nSalario anual: %.2f%nAumento 10%%: %.2f%nSalario anual com aumento: %.2f", employee2.getNome(), employee2.getSobrenome(), employee2.getSalario(), employee2.salarioAnual(),employee2.salarioAnual()*.1, employee2.salarioAnual()*1.1);
    }

    
    
}
