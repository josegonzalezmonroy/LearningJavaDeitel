// Figura 8.9 - EmployeeTest.java
// Demonstração de composição

public class Fig_8_9 
{
    public static void main(String[] args) 
    {
        Fig_8_7 birth = new Fig_8_7(7, 24, 1949);
        Fig_8_7 hire = new Fig_8_7(3, 12, 1988);
        Fig_8_8 employee = new Fig_8_8("Bob", "Blue", birth, hire);

        System.out.println(employee);
    }
}// fim da classe EmployeeTest
