// 7.33 - Embaralhamento e distribuição de cartas
// Modifique o aplicativo desenvolvido no Exercício 7.32 para que ele possa tratar a mão do carteador automaticamente, mas o jogador tenha permissão de decidir que cartas ele quer substituir. O aplicativo então deve avaliar ambas as mãos e determinar quem ganha. Agora utilize esse novo aplicativo para disputar 20 jogos contra o computador. Quem ganha mais jogos, você ou o computador ? Peça para um amigo jogar 20 jogos contra o computador. Quem ganha mais jogos ? Com base nos resultados desses jogos, refine seu aplicativo de pôquer. (Esse também é um problema difícil.) Dispute mais 20 jogos. Seu aplicativo modificado joga melhor ?
import java.util.Scanner;

public class Exerc_7_33 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int[] resultado = new int[3];// armazena o resultado de cada partida ganhada por jogador
        int jogos = 20;// quantidade de jogos a disputar

        System.out.println("Bem-vindo ao jogo\nDigite seu nome para continuar");
        String nome = input.nextLine().toUpperCase();// guarda o nome inserido
        
        for (int jogo = 0; jogo < jogos; jogo++)
        {
            DeckOfCards myDeckOfCards = new DeckOfCards();
            myDeckOfCards.shuffle(); // coloca Cards em ordem aleatoria
            int[] maos = myDeckOfCards.maos;
    
            System.out.printf("%nJOGO %02d/%02d%n", jogo + 1, jogos);// faz a contagem de cada jogo

            // Distribui as primeiras maos
            for (int mao = 0; mao < 2; mao++)
            {
                System.out.printf("MAO %s", mao == 0 ? "COMPUTADOR" : nome);
                
                // distribui e exibe uma mao
                myDeckOfCards.distribuiMao();
    
                int[] maoArray = mao == 0 ? myDeckOfCards.mao1 : myDeckOfCards.mao2;
                boolean imprimir = mao == 0 ? false : true;
    
                myDeckOfCards.numberToString(maoArray, imprimir);// converte o valor numerico da carta em string para imprimir na consola

                if (mao == 0)// mao 0 é a do computador
                {
                    maos[mao] = myDeckOfCards.classificacao(mao + 1, imprimir);// guarda o resultado da clasificacao da mao no array maos

                    myDeckOfCards.autoAvaliaMao(maoArray, mao);// avalia a mao e faz a auto subtituicao de cartas se precisar
                }
                else if (mao == 1)// mao 1 é a do jogador, ele mesmo deve avaliar e decidir se quer trocar alguma carta
                {
                    System.out.println("\n\nDigite o numero de cartas que deseja substituir \n(0 para cancelar)");
                    int quantidade = input.nextInt();

                    if (quantidade <= 0)
                        System.out.print("\nOk, sem cartas substituidas");
                    else
                    {
                        String[] exemplos = {"2", "42", "314", "1543", "12345"};

                        System.out.println("Agora digite " + (quantidade == 1 ? "a posicao da carta" : "as posicoes das cartas") + " a substituir\n(exemplo: " + exemplos[quantidade - 1] + ")");
                        int valor = input.nextInt();

                        for (int i = 10; quantidade > 0; quantidade--)
                        {
                            myDeckOfCards.dealCard(mao + 1, valor % i - 1);
                            valor = valor / i;
                        }
                    }
                    maos[mao] = myDeckOfCards.classificacao(mao + 1, !imprimir);// guarda o resultado da clasificacao da mao no array maos
                }
            }

            // avalia cada mao para saber qual ganhou
            System.out.println("MAOS AVALIADAS");
            for (int mao = 0; mao < 2; mao++)
            {
                int[] maoArray = mao == 0 ? myDeckOfCards.mao1 : myDeckOfCards.mao2;
    
                System.out.printf("%nMAO %s", mao == 0 ? "COMPUTADOR" : nome );
                myDeckOfCards.numberToString(maoArray, true);// converte o valor numerico da carta em string para imprimir na consola
                maos[mao] = myDeckOfCards.classificacao(mao + 1, true);// guarda o resultado da clasificacao da mao no array maos
                
            }
            resultado[myDeckOfCards.melhorMao(nome)]++;
        }

        // exibe os resultados
        System.out.println("\nRESULTADOS");
        System.out.println("COMPUTADOR: " + resultado[1]);
        System.out.println(nome + ": " + resultado[2]);
        if (resultado[0] > 0)
            System.out.println("Empate: " + resultado[0]);
    }    
}