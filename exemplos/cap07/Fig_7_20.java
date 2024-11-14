// Figura 7.20 - VarargsTest.java
// Utilizando listas de argumentos de comprimento variável

public class Fig_7_20 
{
    // calcula a média
    public static double average(double... numbers)
    {
        double total = 0;

        // calcula total utilizando a instrução for aprimorada 
        for (double d : numbers)
            total += d;
    
        return total / numbers.length;
    }

    public static void main(String[] args) 
    {
        double d1 = 10;
        double d2 = 20;
        double d3 = 30;
        double d4 = 40;

        System.out.printf("d1 = %.1f%nd2 = %.1f%nd3 = %.1f%nd4 = %.1f%n%n",
            d1, d2, d3, d4);

        System.out.printf("Average of d1 and d2 is %.1f%n",
            average(d1, d2));
        System.out.printf("Average of d1, d2 and d3 is %.1f%n",
            average(d1, d2, d3));
        System.out.printf("Average of d1, d2, d3 and d4 is %.1f%n",
            average(d1, d2, d3, d4));
    }    
}// fim da classe VarargsTest