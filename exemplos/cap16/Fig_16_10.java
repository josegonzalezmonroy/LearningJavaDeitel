// Figura 16.10 - DeckOfCards.java
// Embaralhamento e distribuicao de cartas com metodo shuffle de Collections

// classe para representar uma card de um baralho

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Card
{
    public static enum Face {Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King};
    public static enum Suit {Hearts, Diamonds, Clubs, Spades};

    private final Face face;
    private final Suit suit;

    // construtor
    public Card(Face face, Suit suit)
    {
        this.face = face;
        this.suit = suit;
    }

    // retorna a face da carta
    public Face getFace()
    {
        return face;
    }

    // retorna naipe de Card
    public Suit geSuit()
    {
        return suit;
    }

    // retorna representacao String de Card
    public String toString()
    {
        return String.format("%s of %s", face, suit);
    }
}

public class Fig_16_10
{
    private List<Card> list;// declara list que armazena Cards

    // configura baralho de Cards e embaralha 
    public Fig_16_10()
    {
        Card[] deck = new Card[52];
        int count = 0;// numero de cartas

        // preenche baralho com objetos Card
        for (Card.Suit suit : Card.Suit.values())
        {
            for (Card.Face face : Card.Face.values())
            {
                deck[count++] = new Card(face, suit);
                //++count;
            }
        }

        list = Arrays.asList(deck);// obtem list
        Collections.shuffle(list);// embaralha as cartas
    }// fim do construtor 

    // gera saida e baralho 
    public void printCards()
    {
        // exibe 52 cartas em duas colunas
        for (int i = 0; i < list.size(); i++)
            System.out.printf("%-19s%s", list.get(i), 
                ((i + 1) % 4 == 0 ? "\n" : ""));
    }

    public static void main(String[] args) 
    {
        Fig_16_10 cards = new Fig_16_10();
        cards.printCards();    
    }
}
