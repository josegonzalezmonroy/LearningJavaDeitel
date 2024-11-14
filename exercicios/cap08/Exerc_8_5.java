// 8.5 - Modificando a representação interna de dados de uma classe
// Seria perfeitamente razoável que a classe Time2 da Figura 8.5 represente a data/hora internamente como o número de segundos a partir da meia-noite em vez dos três valores inteiros hour, minute e second. Os clientes poderiam utilizar os mesmos métodos public e obter os mesmos resultados. Modifique a classe Time2 da Figura 8.5 para implementar Time2 como o número de segundos desde a meia-noite e mostrar que não há alteração visível para os clientes da classe.

public class Exerc_8_5 
{
    public static void main(String[] args) 
    {
        
        Time2 time = new Time2(5,40,13);// hora inicial

        System.out.println("Hora inicial: " + time);// imprimindo hora padrao
        System.out.printf("HH: %02d; MM: %02d; SS: %02d%n", time.getHour(), time.getMinute(), time.getSecond());// mostrando valores separados

        time.setHour(3);// modificando hora
        time.setMinute(8);// modificando minuto
        time.setSecond(7);// modificando segundo
        
        System.out.println("Hora modificada: " + time);// imprimindo hora padrao
        System.out.printf("HH: %02d; MM: %02d; SS: %02d%n", time.getHour(), time.getMinute(), time.getSecond());// mostrando valores separados

        //tentativa de modificação nao valida
        try 
        {
            time.setHour(33);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
