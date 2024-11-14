// Figura 8.12 - EmployeeTest.java
// Demonstraação do membro static

public class Fig_8_13 
{
    public static void main(String[] args) 
    {
        // mostra que a contagem é 0 antes de criar Employees
        System.out.printf("Employees before instatiation: %d%n", 
            Fig_8_12.getCount());
        
        // cria dois Employees; a contagem deve ser 2
        Fig_8_12 e1 = new Fig_8_12("Susan", "Baker");
        Fig_8_12 e2 = new Fig_8_12("Bob", "Blue");

        // mostra que a contagem é 2 depois de criar dois Employees
        System.out.printf("%nEmployees after instatiation: %n");
        System.out.printf("via e1.getCount(): %d%n", e1.getCount());
        System.out.printf("via e2.getCount(): %d%n", e2.getCount());
        System.out.printf("via Employee.getCount(): %d%n", 
            Fig_8_12.getCount());

        // obtem nomes de employees
        System.out.printf("Employee 1: %s %s%nEmployee 2: %s %s%n", 
            e1.getFirstName(), e1.getLastName(), 
            e2.getFirstName(), e2.getLastName());
    }    
}// fim da classe EmployeeTest
