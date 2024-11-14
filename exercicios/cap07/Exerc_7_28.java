// 7.28 - Simulação: a tartaruga e a lebre 
/* Neste problema, você recriará a clássica corrida da tartaruga e da lebre. Você utilizará geração de números aleatórios para desenvolver uma simulação desse memorável evento. Nossos competidores começam a corrida no quadrado 1 de 70 quadrados. Cada quadrado representa uma possível posição ao longo do percurso da competição. A linha de chegada está no quadrado 70. O primeiro competidor a alcançar ou passar o quadrado 70 é recompensado com um cesto de cenouras frescas e alface. O percurso envolve subir uma montanha escorregadia, então ocasionalmente os competidores perdem terreno. Um relógio emite um tique por segundo. A cada tique do relógio, seu aplicativo deve ajustar a posição dos animais de acordo com as regras na Figura 7.32. Utilize variáveis para monitorar a posição dos animais (isto é, os números de posição são 1-70). Inicie cada animal na posição 1 (a 'partida'). Se um animal escorregar para a esquerda do quadrado 1, mova-o novamente para o quadrado 1. Gere as percentagens na Figura 7.32 produzindo um inteiro aleatório i no intervalo 1 <= i <= 10. Para a tartaruga, realize uma 'caminhada rápida' quando 1 <= i <= 5, um 'escorregão' quando 6 <= i <= 7 ou uma 'caminhada lenta' quando 8 <= i <= 10. Utilize uma técnica semelhante para mover a lebre. 

        ANIMAL      Tipo de movimento    Porcentagem do tempo     Movimento Real 
        Tartaruga   Caminhada rápida            50%               3 quadrados à direita              
                    Escorregão                  20%               6 quadrados à esquerda              
                    Caminhada lenta             30%               1 quadrados à direita
        Lebre       Dormir                      20%               Nenhum movimento              
                    Salto grande                20%               9 quadrados à direita              
                    Escorregão grande           10%               12 quadrados à esquerda              
                    Salto pequeno               30%               1 quadrados à direita              
                    Escorregão pequeno          20%               2 quadrados à esquerda 
                            
        Figura 7.32 Regras para ajustar as posições da tartaruga e da lebre
 */
import java.security.SecureRandom;
import java.util.Scanner;

public class Exerc_7_28 
{
    // variaveis de controle
    private static int tartaruga = 0;
    private static int lebre = 0;
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String[] board = new String[70];// tabuleiro
        String enter = "";// sentinela

        for (int valor = 0; valor < board.length; valor++)
            board[valor] = "";// inicializa cada valor do tabuleiro
        
        System.out.print("\nBANG !!!\nE LA VAO ELES !!!");// mensagem inicial
        imprimeArray(board, tartaruga, lebre);// posicoes iniciais no tabuleiro
        
        while (enter.isEmpty())// enquanto o sentinela nao seja acionado
        {            
            if (tartaruga >= board.length - 1 && lebre >= board.length - 1)
            {// se ambos chegarem na meta ao mesmo tempo
                imprimeArray(board, tartaruga, lebre);
                System.out.println("\nOCORREU UM EMPATE\n");
                break;// fecha o programa
            }
            else
            {
                if (tartaruga >= board.length - 1) 
                {
                    tartaruga = board.length - 1;
                    imprimeArray(board, tartaruga, lebre);
                    System.out.println("\nTARTARUGA VENCEU!!! EH!!!\n");
                    break;// fecha o programa
                }
                if (lebre >= board.length - 1)
                {
                    lebre = board.length - 1;
                    imprimeArray(board, tartaruga, lebre);
                    System.out.println("\nA LEBRE GANHOU. OH\n");
                    break;// fecha o programa
                }
            }
            
            System.out.print("\nPresione enter para continuar");// pede para continuar com o programa 
            enter = input.nextLine();

            // gera os numero aleatorios
            int aleatorioTartaruga = movimentoAleatorio();
            int aleatorioLebre = movimentoAleatorio();

            // chama o metodo com os numeros aleatorios gerados
            movimentos(board, aleatorioTartaruga, aleatorioLebre);
        }
    }

    // aumenta ou diminui o valor das variaveis tartaruga e lebre dependendo do numero aleatorio gerado
    public static void movimentos(String[] board, int aleatorioTartaruga, int aleatorioLebre)
    {
        String mensagemTartaruga = "";
        String mensagemLebre = "";

        if (aleatorioTartaruga >= 1 && aleatorioTartaruga <= 5)
        {
            tartaruga += 3;
            mensagemTartaruga = "Caminhada rapida";
        }
        else if (aleatorioTartaruga >= 6 && aleatorioTartaruga <= 7)
        {
            tartaruga -= 6;
            mensagemTartaruga = "Escorregao";
        }
        else if (aleatorioTartaruga >= 8 && aleatorioTartaruga <= 10)
        {
            tartaruga += 1;
            mensagemTartaruga = "Caminhada lenta";
        }

        if (aleatorioLebre >= 1 && aleatorioLebre <= 2)
        {
            mensagemLebre = "Dormir";
        }
        else if (aleatorioLebre >= 3 && aleatorioLebre <= 4)
        {
            lebre += 9;
            mensagemLebre = "Salto grande";
        }
        else if (aleatorioLebre == 5)
        {
            lebre -= 12;
            mensagemLebre = "Escorregao grande";
        }
        else if (aleatorioLebre >= 6 && aleatorioLebre <= 8)
        {
            lebre++;
            mensagemLebre = "Salto pequeno";
        }
        else if (aleatorioLebre >= 9 && aleatorioLebre <= 10)
        {
            lebre -= 2;
            mensagemLebre = "Escorregao pequeno";
        }

        // evita que os valores seja negativos
        if (tartaruga < 0)
            tartaruga = 0;
        if (lebre < 0)
            lebre = 0;

        // se tartaruga e lebre estao juntas
        if (tartaruga == lebre)
            System.out.print("\nAI!!!\nA TARTARUGA MORDEU A LEBRE");
        
        // imprime informacoes
        // array
        imprimeArray(board, tartaruga, lebre);
        // mensagens
        System.out.println("\nTartaruga: " + mensagemTartaruga);
        System.out.println("Lebre: " + mensagemLebre);        
    }

    public static int movimentoAleatorio()// gera um numero aleatorio entre 0 e 7
    {
        SecureRandom randomNumbers = new SecureRandom();
        
        return 1 + randomNumbers.nextInt(10);// gera os numeros entre 1 e 10
    }
    
    // imprime o tabuleiro
    public static void imprimeArray(String[] array, int tartaruga, int lebre)
    {
        for (int valor = 0; valor < array.length; valor++)
        {// imprime fileiras de 7 espacos 
            if (valor % 7 == 0)
            {
                System.out.println("\n_____________________________");
                System.out.print("|");
            }

            if (valor == tartaruga && valor == lebre)
                System.out.print("T-L|");
            else if (valor == tartaruga)
                System.out.print(" T |");
            else if (valor == lebre)
                System.out.print(" L |");
            else
                System.out.print("   |");
            
        }
        System.out.println("\n_____________________________");
    }
}
