// 11.21 - Capturando excecões com escopos externos
// Escreva um programa que mostra que um método com seu próprio bloco try nao precisa capturar todo possível erro gerado dentro do try. Algumas excecões podem escorregar para, e serem tratadas em, outros escopos.

public class ExceptionScopeTeste 
{
    public static void main(String[] args) 
    {
        try 
        {
            // Chama um método que pode lancar excecões
            method1();
        } 
        catch (Exception e) 
        {
            // Captura a excecao em um escopo externo
            System.out.println("Excecao capturada em main: " + e.getMessage());
        }
    }

    public static void method1() throws Exception 
    {
        try 
        {
            // Chama um método que pode lancar excecões
            method2();
        } 
        catch (RuntimeException e) 
        {
            // Captura RuntimeException, mas Exception é relancada
            System.out.println("RuntimeException capturada em method1: " + e.getMessage());
        }
        // Exception nao é capturada aqui, entao escorrega para o método main
    }

    public static void method2() throws Exception 
    {
        // Lanca uma excecao Exception
        throw new Exception("Erro em method2");
    }
}