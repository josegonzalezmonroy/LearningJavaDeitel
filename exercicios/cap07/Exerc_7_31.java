// 7.31 - Embaralhamento e distribuição de cartas
// Utilize os métodos desenvolvidos no Exercício 7.30 para escrever um aplicativo que distribui duas mãos de pôque de cinco cartas, avalia cada mão e determina qual é a melhor mão.

////////////////////////////////////////////////////////////////////////
////////// ESTE EXERCICIO POSSIVELMENTE NAO VAI FUNCIONAR //////////////
////////// DEVIDO A MODIFICACAO NO ARQUIVO 'DECKOFCARDS' QUE ///////////
////////// FOI MODIfICADO PARA COMPLETAR OS EXERCICIOS FUTUROS /////////
////////// ENTAO AS LINHAS DE CODIGO COMENTADAS DESTE ARQUIVO //////////
////////// SAO AS QUE DEVEM SER REFATORADAS PARA QUE O CODIGO //////////
////////// POSSA FUNCIONAR /////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////

import java.util.Arrays;

public class Exerc_7_31 
{
    public static void main(String[] args) 
    {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // coloca Cards em ordem aleatoria
        
        int[] maos = new int[2];// guarda o valor de cada mao
        int[] mao1 = new int[5];// guarda o valor das cartas
        int[] mao2 = new int[5];// guarda o valor das cartas

        for (int mao = 0; mao < 2; mao++)
        {
            System.out.println("Mao 0" + (mao + 1));
            // imprime todas as 5 cartas na ordem em que elas são distribuidas
            for (int i = 1; i <= 5; i++)
            {
                // distribui e exibe uma Card
                //System.out.printf("%-19s", myDeckOfCards.dealCard());
            
                //if (i == 5) maos[mao] = myDeckOfCards.classificacao();
            }

            //if (mao == 0) mao1 = myDeckOfCards.mao[0];
            //if (mao == 1) mao2 = myDeckOfCards.mao[0];
        }

        // Determina qual mao é a melhor
        if (Arrays.equals(mao1, mao2))// se as maos forem exatamente iguais
            System.out.println("\nMaos iguais");

        else if (maos[0] > maos[1])// se o valor da mao 1 é maior
            System.out.println("\nMao 01 e a melhor");

        else if (maos[0] < maos[1])// se o valor da mao 2 é maior
            System.out.println("\nMao 02 e a melhor");

        else// no caso de carta alta
        {
            //converte o valor ace em 14 para facilitar o calculo de carta de maior valor
            for (int i = 0; i < mao1.length; i++)
            {
                if (mao1[i] == 1)
                    mao1[i] = 14;
                if (mao2[i] == 1)
                    mao2[i] = 14;
            }

            // ordena os arrays
            Arrays.sort(mao1);
            Arrays.sort(mao2);

            int valor1 = 0;
            int valor2 = 0;

            if (maos[0] == maos[1])// se ambos forem um tiverem a mesma mao
            {
                if (maos[0] != 6)// se nao for full house
                {
                    for (int maoMaior = mao1.length - 1; maoMaior > 0; maoMaior--)
                    {// faz um loop pelos arrays para encontrar o valor repetido
                        
                        // se achar o valor, é asignado a uma variavel
                        if (mao1[maoMaior] == mao1[maoMaior - 1])
                            valor1 = mao1[maoMaior];
                
                        if (mao2[maoMaior] == mao2[maoMaior - 1])
                            valor2 = mao2[maoMaior];
                    }
                }
                else // se for full house (no caso de full house temos que comparar 3 cartas ao mesmo tempo para saber o valor maior)
                {
                    for (int maoMaior = mao1.length - 1; maoMaior > 1; maoMaior--)
                    {// faz um loop pelos arrays para encontrar o valor repetido
                        
                        // se achar o valor, é asignado a uma variavel
                        if (mao1[maoMaior] == mao1[maoMaior - 1] && mao1[maoMaior] == mao1[maoMaior - 2])
                            valor1 = mao1[maoMaior];
                
                        if (mao2[maoMaior] == mao2[maoMaior - 1] && mao2[maoMaior] == mao2[maoMaior - 2])
                            valor2 = mao2[maoMaior];
                    }
                }
                // se o par da mao 1 for melhor
                if (valor1 > valor2)
                {
                    System.out.println("Mao 01 e a melhor");
                }
                // se o par da mao 2 for melhor
                else if (valor2 > valor1)
                {
                    System.out.println("Mao 02 e a melhor");
                }
                else // se os pares forem iguais
                {
                    for (int maoMaior = mao1.length - 1; maoMaior >= 0; maoMaior--)
                    {// busca o valor maior para o desempate
                        if (mao1[maoMaior] > mao2[maoMaior])
                        {
                            System.out.println("Mao 01 e a melhor");
                            break;
                        }
                        else if (mao2[maoMaior] > mao1[maoMaior])
                        {
                            System.out.println("Mao 02 e a melhor");
                            break;
                        }
                    }
                }                
            }  
        }
    }    
}