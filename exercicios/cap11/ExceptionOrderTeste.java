// 11.18 - Ordenando blocos catch
// Escreva um programa que demonstre que a ordem dos blocos catch é importante. Se você tentar capturar um tipo de exceção de superclasse antes de um tipo de subclasse, o compilador deve gerar erros.
/*
public class ExceptionOrderTeste 
{
    public static void main(String[] args) 
    {
        try 
        {
            // Lancando uma excecao de tipo ExceptionB
            throw new ExceptionB("Excecao do tipo ExceptionB");
        } 
        // Ordem incorreta: Excecões de superclasse (ExceptionA) devem vir após suas subclasses (ExceptionB). O compilador gerará um erro aqui porque o bloco catch para ExceptionA captura todas as excecões que o bloco catch para ExceptionB captura.
        catch (ExceptionA e) 
        {
            System.out.println("Capturado ExceptionA: " + e.getMessage());
        } 
        catch (ExceptionB e) 
        {
            System.out.println("Capturado ExceptionB: " + e.getMessage());
        } 
        catch (Exception e) 
        {
            System.out.println("Capturado Exception (generica): " + e.getMessage());
        }
    }
}
*/