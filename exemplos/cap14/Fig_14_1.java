// Figura 14.1 - StringConstructors.java
// Construtores da classe String

public class Fig_14_1 
{
    public static void main(String[] args) 
    {
        char[] charArray = {'b', 'i', 'r', 't', 'h', ' ', 'd', 'a', 'y'};
        String s = new String("hello");
        
        // utiliza os construtores String
        String s1 = new String();
        String s2 = new String(s);
        String s3 = new String(charArray);
        String s4 = new String(charArray, 6, 3);

        System.out.printf(
            "s1 = %s%ns2 = %s%ns3 = %s%ns4 = %s%n", s1, s2, s3, s4);
        
    }    
}
