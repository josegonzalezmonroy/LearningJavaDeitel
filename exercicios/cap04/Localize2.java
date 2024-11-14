import java.util.Scanner;

public class Localize2 {
    public static void main(String[] args) {
        
        int counter = 1;
        int number;
        int largest = 0;
        int largestMax = 0;

        Scanner input = new Scanner(System.in);

        while (counter <= 10) 
        {
            System.out.print("Digite o inteiro: ");
            number = input.nextInt();
            
            if (number > largestMax) 
            {
                largest = largestMax;
                largestMax = number;
                
            } else if (number > largest) {
                largest = number;
            }
            
            counter++;
        }
    
        System.out.printf("O primeiro maior e %d%n", largestMax);
        System.out.printf("O segundo maior e %d", largest);
    }
}


