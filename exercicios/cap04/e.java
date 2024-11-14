// 4.37 b, c - Fatorial
import java.util.Scanner;

public class e 
{
    public static double getFatorial(int n)
    {
        int fatorial = 1;

        while (n > 0) 
        {
           fatorial *= n;
           n--;
        }
        return fatorial;
    }
    public static void main(String[] args) 
    {
        int number;
        double euller = 1;
        double eullerExp = 1;
    
        Scanner input = new Scanner(System.in);
        
        System.out.print("Com quantos termos deseja calcular e ?: ");

        number = input.nextInt();
        int termos = number;

        while (number > 0)
        {
            euller += 1 / getFatorial(number);    
            number--;
        }
        System.out.printf("e com %d termos:%ne = %.10f...%n", termos, euller);

        System.out.print("\nAgora determine o valor do exponente de e: ");
        eullerExp = input.nextDouble();

        System.out.printf("e^%.2f = %.10f...", eullerExp, Math.pow(euller, eullerExp));
        
    }    
}
