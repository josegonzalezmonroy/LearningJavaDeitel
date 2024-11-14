// Figura 14.2 - StringMiscellaneous.java
// Esse aplicativo demonstra os metodos da classe String
// length, charAt e getChars

public class Fig_14_2 
{
    public static void main(String[] args) 
    {
        String s1 = "hello there";
        char[] charArray = new char[5];

        System.out.printf("s1: %s", s1);

        // testa o metodo length
        System.out.printf("%nLength of s1: %d", s1.length());

        // faz loop pelos caracteres em s1 com charAt e os exibe na ordem inversa
        System.out.printf("%nThe string reversed is: ");

        for (int count = s1.length() - 1; count >= 0; count--)
            System.out.printf("%c ", s1.charAt(count));

        // copia caracteres a partir de string para charArray
        s1.getChars(0, 5, charArray, 0);
        System.out.printf("%nThe caracter array is: ");

        for (char character : charArray) 
            System.out.print(character);

        System.out.println();
    }    
}
