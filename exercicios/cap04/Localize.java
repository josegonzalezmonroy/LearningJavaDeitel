import java.util.Scanner;

public class Localize {
    public static void main(String[] args) {
        
        int counter = 1;
        int number;
        int largest = 0;

        Scanner input = new Scanner(System.in);

        while (counter <= 10) 
        {
            System.out.print("Digite o inteiro: ");
            number = input.nextInt();

            if (number > largest)
                largest = number;
        
            counter++;
        }
        System.out.printf("O maior numero e %d", largest);
    }
}
