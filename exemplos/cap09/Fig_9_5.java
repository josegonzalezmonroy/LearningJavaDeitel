// Figura 9.5 - CommissionEmployeeTest.java
// Programa de teste da classe CommissionEmployeee

public class Fig_9_5 
{
    public static void main(String[] args) 
    {
        // instancia o objeto CommissionEmployee
        Fig_9_4 employee = new Fig_9_4(
            "Sue", "Jones", "222-22-2222", 10000, .06);

        // obtem os dados de empregado comissionado
        System.out.println(
            "Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is", 
            employee.getFirstName());
        System.out.printf("%s %s%n", "Last name is", 
            employee.getLastName());
        System.out.printf("%n%s %s%n", "Social security number is", 
            employee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Gross sales is", 
            employee.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate is", 
            employee.getCommissionRate());

        employee.setGrossSales(5000);
        employee.setCommissionRate(.1);

        System.out.printf("%n%s:%n%n%s%n", 
            "Update employee information obtained by toString", employee);
    }// fim de main
}// fim da classe CommissionEmployeeTest
