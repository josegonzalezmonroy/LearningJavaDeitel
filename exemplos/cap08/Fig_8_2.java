// Figura 8.2 - Time1Test.java
// objeto Time1 utilizado em um aplicativo

public class Fig_8_2 
{
    public static void main(String[] args) 
    {
        // cria e inicializa um objeto Time1
        Fig_8_1 time = new Fig_8_1();// invoca o construtor Time1

        // gera saida de representações de string da data/hora
        displayTime("After time object is created", time);
        System.out.println();

        // altera a data/hora e gera saída da data/hora atualizada 
        time.setTime(13, 27, 6);
        displayTime("After calling setTime", time);
        System.out.println();

        // tenta definir data/hora com valores invalidos
        try 
        {
            time.setTime(99, 99, 99); // todos os valores fora do intervalo    
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.printf("Exception: %s%n%n", e.getMessage());
        }

        // exibe a data/hora após uma tentativa de definir valores invalidos
        displayTime("After calling setTime with invalid values", time);
    }

    // exibe um objeto Time1 nos formatos de 24 horas e 12 horas 
    private static void displayTime(String header, Fig_8_1 t)// Fig_8_1 = Time1
    {
        System.out.printf("%s%nUniversal time: %s%nStandard time: %s%n", 
            header, t.toUniversalString(), t.toString());
    }
}// fim da classe Time1Test
