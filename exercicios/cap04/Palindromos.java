import java.util.Scanner;

public class Palindromos 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite um inteiro de 5 digitos: ");
        int number = input.nextInt();
        
        while (number >= 100000 || number < 10000)// loop para validar que o numero seja de 5 digitos
        {
            System.out.print("Numero nao valido, insira um inteiro de 5 digitos: ");
            number = input.nextInt();    
        }
        
        int divisao = number/1000;// 52525/1000 = 52
        int resto = number%100;// 52525%100 = 25
                
        if (divisao/10 == resto%10 && resto/10 == divisao%10)// Se (52/10 = 5) é igual (25%10 = 5) e tambem (25/10 = 2) é igual (52%10 = 2)
        {
            System.out.printf("O numero %d e um palindromo", number);
        }
        else
        {
            System.out.printf("O numero %d nao e um palindromo", number);
        }
    }    
}
