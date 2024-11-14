// Figura 8.6 - Time2Test.java
// Construtores sobrecarregados utilizados para inicializar objetos Time2

public class Fig_8_6 
{
    public static void main(String[] args) 
    {
        Fig_8_5 t1 = new Fig_8_5();// 00:00:00
        Fig_8_5 t2 = new Fig_8_5(2);// 02:00:00
        Fig_8_5 t3 = new Fig_8_5(21, 34);// 21:34:00
        Fig_8_5 t4 = new Fig_8_5(12, 25, 42);// 12:25:42
        Fig_8_5 t5 = new Fig_8_5(t4);// 12:25:42        

        System.out.println("Constructed with:");
        displayTime("t1: all default arguments:", t1);
        displayTime("t2: hour specified; default minute and second", t2);
        displayTime("t3: hour and minute specified; default second", t3);
        displayTime("t4: hour, minute and second specified", t4);
        displayTime("t5: Time2 object t4 specified", t5);

        // tenta inicializar t6 com valores invalidos 
        try 
        {
            Fig_8_5 t6 = new Fig_8_5(27, 74, 99);// valores invalidos
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.printf("%nException while initializing t6: %s%n", 
                e.getMessage());
        }
    }
    
    // exibe um objeto Time2 nos formatos de 24 horas e 12 horas 
    private static void displayTime(String header, Fig_8_5 t)// Fig_8_5 = Time2
    {
        System.out.printf("%s%n %s%n %s%n", 
            header, t.toUniversalString(), t.toString());
    }
}// fim da classe Time2Test
