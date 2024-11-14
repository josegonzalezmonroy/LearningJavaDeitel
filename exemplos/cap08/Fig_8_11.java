// Figura 8.11 - EnumTest.java
// Testando o tipo enum Book
import java.util.EnumSet;

public class Fig_8_11 
{
    public static void main(String[] args) 
    {
        System.out.println("All books:");
        
        // imprime todos os livros em enum book
        for (Fig_8_10 book : Fig_8_10.values())
            System.out.printf("%-10s%-45s%s%n", book, 
                book.getTitle(), book.getCopyrightYear());
        
        System.out.printf("%nDisplay a range of enum constants: %n");

        // imprime os primeiros quatro livros
        for (Fig_8_10 book : EnumSet.range(Fig_8_10.JHTP, Fig_8_10.CPPHTP))
            System.out.printf("%-10s%-45s%s%n", book, 
                book.getTitle(), book.getCopyrightYear());
    }
}
