// Figura 11.6 - UsingExceptions.java
// Desempilhandoe obtendo dados a partir de um objeto de exceção

public class Fig_11_6 
{
    public static void main(String[] args) 
    {
        try
        {
            method1();
        }    
        catch (Exception exception)// captura a excecao lancada em method1
        {
            System.err.printf("%s%n%n", exception.getMessage());
            exception.printStackTrace();

            // obtem informações de rastreamento de pilha 
            StackTraceElement[] traceElements = exception.getStackTrace();
            
            System.out.printf("%nStack trace from getStackTrace:%n");
            System.out.println("Class\t\tFile\t\tLine\tMethod");

            // faz um loop por traceElements para obter a descricao da excecao
            for (StackTraceElement element : traceElements)
            {
                System.out.printf("%s\t", element.getClassName());
                System.out.printf("%s\t", element.getFileName());                
                System.out.printf("%s\t", element.getLineNumber());
                System.out.printf("%s%n", element.getMethodName());
            }
        }
    }// fim de main
    
    // chama method2; lanca excecoes de volta para main
    public static void method1() throws Exception
    {
        method2();
    }

    // chama method3; lanca excecoes de volta para method1
    public static void method2() throws Exception
    {
        method3();
    }

    // lanca Exception de volta para method2
    public static void method3() throws Exception
    {
        throw new Exception("Exception thrown in method3");
    }
}
