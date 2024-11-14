// Figura 10.1 - PolymorphismTest.java
// Atribuindo referencias de superclasse e subclasse a variaveis de superclasse
// e de subclasse
/* 
public class Fig_10_1 
{
    public static void main(String[] args) 
    {
        // atribui uma referencia de superclasse a variavel de superclasse 
        Fig_9_10 commissionEmployee = new Fig_9_10(
            "Sue", "Jones", "222-22-2222", 1000, .06);

        // atribui uma referencia de subclasse a variavel de subclasse
        Fig_9_11 basePlusCommissionEmployee = 
            new Fig_9_11(
            "Bob", "Lewis", "333-33-3333", 5000, .04, 300);

        // invoca toString no objeto de superclasse utilizando a variavel de superclasse
        System.out.printf("%s %s:%n%n%s%n%n",
            "Call CommissionEmployee's toString with superclasse reference ",
            "to superclass object", commissionEmployee.toString());

        // invoca toString no objeto de subclasse utilizando a variavel de subclasse
        System.out.printf("%s %s:%n%n%s%n%n",
            "Call BasePlusCommissionEmployee's toString with subclass",
            "reference to subclass object", 
            basePlusCommissionEmployee.toString());

        // invoca toString no objeto de subclasse utilizando a variavel de superclasse
        Fig_9_10 commissionEmployee2 = 
            basePlusCommissionEmployee;
        System.out.printf("%s %s:%n%n%s%n",
            "Call BasePlusCommissionEmployee's toString with superclass",
            "reference to subclass object", commissionEmployee2.toString());
    }// fim de main    
}// fim da classe PolymorphismTest
*/