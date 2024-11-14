// Figura 14.14 - StringBuilderInsertDelete.java
// Metodos StringBuilder insert, delete e deleteCharAt

public class Fig_14_14 
{
    public static void main(String[] args) 
    {
        Object objectRef = "hello";
        String string = "goodbye";
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        boolean booleanValue = true;
        char characterValue = 'Z';
        int integerValue = 7;
        long longValue = 10000000000L;
        float floatValue = 2.5f;
        double doubleValue = 33.333;

        StringBuilder buffer = new StringBuilder();

        buffer.insert(0, objectRef)
            .insert(0, "  ")// cada um desses contem dois espaços
            .insert(0, string)
            .insert(0, "  ")
            .insert(0, charArray)            
            .insert(0, "  ")
            .insert(0, charArray, 3, 3)            
            .insert(0, "  ")
            .insert(0, booleanValue)            
            .insert(0, "  ")
            .insert(0, characterValue)            
            .insert(0, "  ")
            .insert(0, integerValue)            
            .insert(0, "  ")
            .insert(0, longValue)            
            .insert(0, "  ")
            .insert(0, floatValue)            
            .insert(0, "  ")
            .insert(0, doubleValue);          
        
        System.out.printf(
            "buffer after inserts:%n%s%n%n", buffer.toString());

        buffer.deleteCharAt(10); // exclui 5 em 2.5
        buffer.delete(2, 6); // exclui .333 em 33.333

        System.out.printf(
            "buffer after deletes:%n%s%n", buffer.toString());
    }    
}
