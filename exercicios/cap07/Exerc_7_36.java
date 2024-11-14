// 7.36 - Simpletron (Programação em linguagem de maquina)
import java.util.Scanner;

public class Exerc_7_36 
{
    final static int READ = 10;
    final static int WRITE = 11;

    final static int LOAD = 20;
    final static int STORE = 21;

    final static int ADD = 30;
    final static int SUBTRACT = 31;
    final static int DIVIDE = 32;
    final static int MULTIPLY = 33;
    final static int MEDIA = 34;

    final static int BRANCH = 40;
    final static int BRANCHNEG = 41;
    final static int BRANCHZERO = 42;
    final static int HALT = 43;

    public static void main(String[] args) 
    {
        int[] memory = new int[100];

        //////////////////////////////////////////////////////////////
        //////// EXEMPLO A 
        //////// le 10 numeros positivos, calcula e exibe a soma 
        //////////////////////////////////////////////////////////////

        Scanner input = new Scanner(System.in);
        int[] sml = // instrucoes do programa
        {
            1023, 1024, 1025, 1026, 1027, 1028, 1029, 1030, 1031, 1032, 2023, 3024, 3025, 3026, 3027, 3028, 3029, 3030, 3031, 3032, 4300, 2133, 1133
        };

        for (int i = 0; i < sml.length; i++)// le as instrucoes e as aplica na memory
            memory[i] = sml[i];

        int[] valor = new int[10];// armazena os valores inseridos pelo usuario

        int sentinela = 0;

        while (sentinela < 10) 
        {   
            System.out.printf("Digite o valor %02d/10 para calcular a soma:%n", sentinela + 1);
            valor[sentinela++] = input.nextInt();
        }
        
        // Imprime o titulo
        System.out.println("SIMPLETRON");

        int posicao = 0;
        int acumulador = 0;

        for (int i = 0; i < sml.length; i++)
        {
            switch (memory[i] / 100) 
            {
                case READ:
                memory[memory[i] % 100] = valor[posicao++];
                break;

                case LOAD:
                acumulador = memory[memory[i] % 100];
                break;
                
                case ADD:
                acumulador += memory[memory[i] % 100];
                break;
                
                case STORE:
                memory[memory[i] % 100] = acumulador;
                break;

                case WRITE:
                System.out.println("Soma: " + memory[memory[i] % 100]);
                break;

                case HALT:
                System.out.println("Tarefa completada ");
                break;
            }
        }
        //////////////////////////////////////////////////////////////
        //////// EXEMPLO B
        //////// leia sete numeros, alguns negativos e alguns positivos, e compute e exiba sua media
        //////////////////////////////////////////////////////////////
        memory = new int[100];

        int[] sml2 = // instrucoes do programa
        {
            1020, 
            1021,
            1022,
            1023,
            1024,
            1025,
            1026,
            1027,
            2020,
            3021,
            3022,
            3023,
            3024,
            3025,
            3026,
            3227,
            2128,
            1128,
            4300
        };

        for (int i = 0; i < sml2.length; i++)// le as instrucoes e as aplica na memory
            memory[i] = sml2[i];

        int[] valor2 = 
        {
            1,2,3,-4,5,-66,7,7
        };

        // Imprime o titulo
        System.out.println("SIMPLETRON");

        posicao = 0;
        acumulador = 0;

        for (int i = 0; i < sml2.length; i++)
        {
            switch (memory[i] / 100) 
            {
                case READ:
                memory[memory[i] % 100] = valor2[posicao++];
                break;
            
                case LOAD:
                acumulador = memory[memory[i] % 100];
                break;

                case ADD:
                acumulador += memory[memory[i] % 100];
                break;

                case STORE:
                memory[memory[i] % 100] = acumulador;
                break;

                case DIVIDE:
                acumulador /= memory[memory[i] % 100];
                break;
            
                case WRITE:
                System.out.println("Media: " + memory[memory[i] % 100]);
                break;
            
                case HALT:
                System.out.println("Tarefa completada ");
                break;
            }
        }
    }    
}
