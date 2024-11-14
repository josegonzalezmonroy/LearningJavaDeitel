import java.util.Scanner;

public class Quadrado 
{
    public static void main(String[] args) 
    {
        int quadrado = 0;// lados do triangulo
        int count = 1;
        int branco = 1;// count para os espaços em branco

        Scanner input = new Scanner(System.in);

        System.out.print("Insira o tamanho do lado do quadrado: ");
        quadrado = input.nextInt();

        if (quadrado == 1)// quando o valor do quarado seja 1
        {
            System.out.print("*");
        }else //quando o lado do quadrado seja maior a 1
        {
            while (count <= quadrado)// imprime primeira linha 
            {
                System.out.print("* ");
                count++;
            }
            count = 1; // zera o count para iniciar o while na sequencia
            System.out.println();// linha em quadrado para separar a parte superior
                        
            while (branco <= quadrado - 2) // para imprimir os lados do quadrado e os espaços em branco
            {
                System.out.print("* ");// imprime o lado esquerdo do quadrado. print para poder imprimir os valores seguintes na mesma linha
                while (count <= quadrado - 2) 
                {
                    System.out.print("  ");//imprime os espaços em branco. print para poder imprimir os valores seguintes na mesma linha
                    count++;//adiciona 1 ao contador count 
                }
                System.out.println("* ");// imprime o lado direito do quadrado. println para saltar a proxima linha
                count = 1;//zera o count para poder imprimir de novo os espaços em branco caso seja necessario
                branco++;// adiciona 1 ao contador branco
            }
            count = 1;// zera o count para imiciar o while na sequencia
            
            while (count <= quadrado)// imprime a ultima linha 
            {
                System.out.print("* ");//print para poder imprimir os valores seguintes na mesma linha
                count++;//adiciona 1 ao contador count
            }
        }//fim do if...else
    }
}// fim da classe Quadrado
