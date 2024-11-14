import java.io.IOException;

public class ExceptionTeste2 
{
    public static void main(String[] args) 
    {
        try 
        {
            // Lançando exceções de diferentes tipos
            throw new ExceptionB("Exceção do tipo ExceptionB");
        } 
        catch (Exception e) 
        {
            // Captura qualquer exceção que herde de Exception
            System.out.println("Capturado: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        
        try 
        {
            // Lançando uma exceção de tipo ExceptionA
            throw new ExceptionA("Exceção do tipo ExceptionA");
        } 
        catch (Exception e) 
        {
            // Captura qualquer exceção que herde de Exception
            System.out.println("Capturado: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        
        try 
        {
            // Lançando uma exceção de tipo NullPointerException
            throw new NullPointerException("Exceção de NullPointerException");
        } 
        catch (Exception e) 
        {
            // Captura qualquer exceção que herde de Exception
            System.out.println("Capturado: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        
        try 
        {
            // Lançando uma exceção de tipo IOException
            throw new IOException("Exceção de IOException");
        } 
        catch (Exception e) 
        {
            // Captura qualquer exceção que herde de Exception
            System.out.println("Capturado: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
