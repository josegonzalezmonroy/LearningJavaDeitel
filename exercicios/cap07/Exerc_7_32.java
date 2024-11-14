// 7.32 - Embaralhamento e distribuição de cartas
// Modifique o aplicativo desenvolvido no Exercício 7.31 para que possa simular o carteador. A mão de cinco cartas do carteador é distribuída 'no escuro', então o jogador não pode vê-la. O programa deve avaliar a mão do carteador e com base na qualidade da mão, o carteador deve distribuir uma, duas ou três mais cartas para substituiro número correspondente de cartas desnecessárias na mão original. [Atenção: Esse é um problema difícil!]

public class Exerc_7_32 
{
    public static void main(String[] args) 
    {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // coloca Cards em ordem aleatoria
    
        int[] maos = myDeckOfCards.maos;

        // distribui e exibe a mao original
        System.out.print("MAO ORIGINAL");
        myDeckOfCards.distribuiMao();// distribui 5 cartas
        myDeckOfCards.numberToString(myDeckOfCards.mao1, false);// converte o valor numerico da carta em string para imprimir na consola
        maos[0] = myDeckOfCards.classificacao(1, false);// guarda o resultado da clasificacao da mao no array maos

        myDeckOfCards.autoAvaliaMao(myDeckOfCards.mao1, 0);// avalia a mao e faz a subtituicao de cartas se precisar

        // exibe a mao avaliada
        System.out.print("MAO AVALIADA");
        myDeckOfCards.numberToString(myDeckOfCards.mao1, true);// converte o valor numerico da carta em string para imprimir na consola
        maos[0] = myDeckOfCards.classificacao(1, true);// clasifica novamente a mao e substitui o valor pelo novo


    }    
}