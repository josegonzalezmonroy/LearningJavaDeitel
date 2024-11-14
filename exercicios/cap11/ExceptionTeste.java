// 11.16 - Capturando exceções com superclasses
// Utilize herança para criar uma superclasse de exceção (chamada ExceptionA) e subclasses de exceção ExceptionB e ExceptionC, em que ExceptionB herda de ExceptionA e ExceptionC herda de ExceptionB. Escreva um programa para demonstrar que o bloco catch para tipo ExceptionA captura exceções de tipos ExceptionB e ExceptionC.

public class ExceptionTeste 
{
    public static void main(String[] args) 
    {
        try 
        {
            // Lancando uma excecao de tipo ExceptionC
            throw new ExceptionC("Excecao do tipo ExceptionC");
        } 
        catch (ExceptionA e) 
        {
            // Captura qualquer excecao que seja uma instância de ExceptionA ou suas subclasses
            System.out.println("Excecao capturada: " + e.getMessage());
        }
    }    
}
