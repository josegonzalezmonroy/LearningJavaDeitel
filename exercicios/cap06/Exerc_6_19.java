// 6.19 - Exibindo um quadrado de qualquer caractere
/*
Modifique o método criado no Exercício 6.18 para formar o quadrado a partir de qualquer que seja o caracter contido no parâmetro de caractere fillCharacter. Portanto, se side for 5 e fillCharacter for '#', o método deve exibir
 					#####
 					#####
 					#####
 					#####
 					#####
 */
import java.util.Scanner;

public class Exerc_6_19 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o tamanho quadrado: ");
        int side = input.nextInt();
        System.out.print("Agora um caractere: ");
        char fill = input.next().charAt(0);

        squareOfAsterisks(side, fill);
    }
    
    public static char squareOfAsterisks(int x, char y)
    {
        char asterisk = y;

        for (int i = 1; i <= x; i++) 
        {    
            for (int j = 1; j <= x; j++)
            {
                System.out.print(asterisk + " ");    
            }
            System.out.println();
        }
        return asterisk;
    }
    
}
