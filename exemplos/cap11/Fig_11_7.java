// Figura 11.7 - UsingChainedExceptions.java
// Exceções encadeadas

public class Fig_11_7 
{
    public static void main(String[] args) 
    {
        try
        {
            method1();    
        }
        catch (Exception exception) // exceções lancadas de method1
        {
            exception.printStackTrace();
        }
    }
    
    // chama method2; lanca excecoes de volta para main
    public static void method1() throws Exception
    {
        try
        {
            method2();
        }
        catch (Exception exception)// excecao lançada de methodo2
        {
            throw new Exception("Exception thrown in method1", exception);
        }
    }

    // chama methodo3; lanca excecoes de volta para methodo1
    public static void method2() throws Exception
    {
        try
        {
            method3();
        }
        catch (Exception exception)// excecao lançada de methodo3
        {
            throw new Exception("Exception thrown in method2", exception);
        }
    }

    // lanca Exception de volta para method2
    public static void method3() throws Exception
    {
        throw new Exception("Exception thrown in method3");
    }
}
