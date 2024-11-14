// 11.20 - Relançando exceções
// Escreva um programa que ilustra o relançamento de uma exceção. Defina os métodos someMethod e someMethod2. O método someMethod2 deve lançar inicialmente uma exceção. O método someMethod deve chamar someMethod2, capturar a exceção e relançá-la. Chame someMethod a partir do método main e capture a exceção relançada. Imprima o rastreamento de pilha dessa exceção.

public class ExceptionRethrowTest 
{
    public static void main(String[] args) 
    {
        try 
        {
            // Chama someMethod, que pode lançar uma exceção
            someMethod();
        } 
        catch (Exception e) 
        {
            // Captura a exceção relançada e imprime o rastreamento de pilha
            System.out.println("Exceção capturada no main: " + e.getMessage());
            e.printStackTrace(); // Imprime o rastreamento de pilha
        }
    }

    public static void someMethod() throws Exception 
    {
        try 
        {
            // Chama someMethod2, que lança uma exceção
            someMethod2();
        } 
        catch (Exception e) 
        {
            // Captura a exceção lançada por someMethod2 e a relança
            System.out.println("Exceção capturada em someMethod e relançada: " + e.getMessage());
            throw e; // Relança a exceção
        }
    }

    public static void someMethod2() throws Exception 
    {
        // Lança uma exceção para simular um erro
        throw new Exception("Erro em someMethod2");
    }
}