// 11.19 - Falha de construtor
// Escreva um programa que mostra um construtor que passa informações sobre a falha do construtor para uma rotina de exceção. Defina a classe SomeClass, que lança um Exception no construtor. O seu programa deve tentar criar um objeto do tipo SomeClass e capturar a exceção que é lançada do construtor.

public class ConstructorExceptionTest 
{
    public static void main(String[] args) 
    {
        try 
        {
            // Tentando criar uma instância de SomeClass
            SomeClass obj = new SomeClass();
        } 
        catch (Exception e) 
        {
            // Captura e trata a excecao lancada pelo construtor
            System.out.println("Excecao capturada: " + e.getMessage());
        }
    }
}
