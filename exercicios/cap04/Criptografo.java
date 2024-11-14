import java.util.Scanner;

public class Criptografo 
{
    public static void main(String[] args) 
    {
        int counter = 1;
        int chave = 7;
        int numberCriptoTotal = 0;
        
        int number;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite um inteiro de 4 digitos para criptografar: ");
        number = input.nextInt();

        if (number >= 1000 && number <= 10000)
        {
            while (counter < 10000) 
            {
                numberCriptoTotal += counter * (((number % 10) + chave) % 10);
                number /= 10;
                counter *= 10;
            }
            
            numberCriptoTotal = (numberCriptoTotal%100) * 100 + (numberCriptoTotal/100); 
            
            System.out.println("Numero criptografado: " + numberCriptoTotal);      
        }
        else
        System.out.print("Numero nao valido");
    }    
}
