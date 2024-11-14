// Figura 10.15 - PayableInterfaceTest.java
// Programa de teste da interface Payable que procesa Invoices e 
// Employees polimorficamente 
public class PayableInterfaceTest 
{
    public static void main(String[] args) 
    {
        // cria array Payable de quatro elementos
        Payable[] payableObjects = new Payable[4];
        
        // preenche o array com objetos que implementan Payable
        payableObjects[0] = new Invoice("01234", "seat", 2, 375);
        payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
        payableObjects[2] = 
            new SalariedEmployeeP("John", "Smith", "111-11-1111", 800);
        payableObjects[3] = 
            new SalariedEmployeeP("Lisa", "Barnes", "888-88-8888", 1200);
        
        System.out.println(
            "Invoices and Employees processed polymorphically");
        
        // processa genericamente cada elemento no array payableObjects
        for (Payable currentPayable : payableObjects)
        {
            // gera saida de currentPayable e sua quantia de pagamento apropriado
            System.out.printf("%n%s %n%s: $%,.2f%n",
                currentPayable.toString(),// poderia invocar implicitamente
                "payment due", currentPayable.getPaymentAmount());
        }
    }// fim de main
}// fim da classe PayableInterfaceTest
