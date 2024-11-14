// 5.15 - Programa para impressao de triangulos
public class Exerc_5_15 
{
    public static void main(String[] args) 
    {          
        // (a)
        for (int i = 1; i <= 10; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // (b)
        for (int i = 1; i <= 10; i++)
        {
            for (int j = 10; j >= i; j--)
            {
                if (i == 10)
                    continue;

                System.out.print("*");
            }
            System.out.println();
        }

        // (c)
        for (int i = 10; i >= 1; i--)
        {
            for (int j = 1; j <= 10 - i; j++)
            {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        // (d)
        for (int i = 1; i <= 10; i++)
        {
            for (int j = 10; j > i; j--)
            {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
