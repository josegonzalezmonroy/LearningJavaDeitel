// Figura 14.9 - StringValueOf.java
// Metodos valueOf de String

public class Fig_14_9 
{
    public static void main(String[] args) 
    {
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        boolean booleanValue = true;
        char characterValue = 'Z';
        int integerValue = 7;
        long longValue = 10000000000L;// sufijo L indica tipo long 
        float floatValue = 2.5f;// f indica que 2.5 é um tipo float
        double doubleValue = 33.333;// sen sufixo, tipo double é padrao
        Object objectRef = "hello";// atribui string a uma referencia Object

        System.out.printf(
            "char array = %s%n", String.valueOf(charArray));
        System.out.printf(
            "part of char array = %s%n", String.valueOf(charArray, 3, 3));
        System.out.printf(
            "boolean = %s%n", String.valueOf(booleanValue));
        System.out.printf(
            "char = %s%n", String.valueOf(characterValue));
        System.out.printf("int = %s%n", String.valueOf(integerValue));
        System.out.printf("long = %s%n", String.valueOf(longValue));        
        System.out.printf("float = %s%n", String.valueOf(floatValue));
        System.out.printf(
            "double = %s%n", String.valueOf(doubleValue));
        System.out.printf("Object = %s%n", String.valueOf(objectRef));
    }    
}// fim da classe StringValueOf
