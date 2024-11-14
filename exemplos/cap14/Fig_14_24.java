// Figura 14.24 - RegexMatches.java
// Classes Pattern e Matcher
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fig_14_24 
{
    public static void main(String[] args) 
    {
        // cria expressao regular
        Pattern expression = 
            Pattern.compile("J.*\\d[0-35-9]-\\d\\d-\\d\\d");

        String string1 = "Jane's Birthday is 05-12-75\n" + 
            "Dave's Birthday is 11-04-68\n" + 
            "John's Birthday is 04-28-73\n" +
            "Joe's Birthday is 12-17-77\n";

        // corresponde expressao regular a string e imprime as correspondencias
        Matcher matcher = expression.matcher(string1);

        while (matcher.find())
            System.out.println(matcher.group());
    }    
}
