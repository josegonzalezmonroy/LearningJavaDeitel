// Figura 11.5 - UsingExceptions.java
// mecanismo de tratamento de exceção try...catch...finally

public class Fig_11_5 
{
    public static void main(String[] args) 
    {
        try 
        {
            throwException();    
        }
        catch (Exception exception) // excecao lancada por throwException 
        {
            System.err.println("Exception handled in main");
        }
        
        doesNotThrowException();
    }        

    // demonstra try...catch...finally
    public static void throwException() throws Exception
    {
        try
        {// lanca uma excecao e imediatamente a captura
            System.out.println("Method throwException");
            throw new Exception();// gera a excecao
        }
        catch (Exception exception)// captura a excecao lancada em try
        {
            System.err.println(
                "Exception handled in method throwException");
            throw exception;//lança novamente para procesamento adicional

            // o codigo aqui nao seria alcançado; poderia causar erros de compilaçao

        }
        finally
        {// executa independentemente do que ocorre em try..catch
            System.err.println("Finally executed in throwException");
        }

        // o codigo aqui nao seria alcançado; poderia causar erros de compilaçao
        
    }

    // demonstra finally quando nenhuma exceção ocorrer
    public static void doesNotThrowException()
    {
        try
        {// bloco try nao lanca uma excecao
            System.out.println("Method doesNotThrowException");
        }
        catch (Exception exception)// nao executa
        {
            System.err.println(exception);
        }
        finally
        {// executa independentemente do que ocorre em try..catch 
            System.err.println(
                "Finally executed in doesNotThrowException"); 
        }

        System.out.println("End of method doesNotThrowException");
    }
}// fim da classe UsingExceptions
