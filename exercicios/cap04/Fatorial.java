import java.util.Scanner;

public class Fatorial 
{
    public static void main(String[] args) 
    {
        int fatorial = 1;
        
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o valor  a calcular: ");
        int number = input.nextInt();
        
        System.out.print(number + "! = ");
        
        while (number > 0) 
        {
           fatorial *= number;
           number--;
        }
        System.out.print(fatorial);
    }
}
