// Figura 7.9 - Card.java
// Classe card representa uma carta de baralho

public class Card 
{
    private final String face;// face da carta ("Ace", "Deuce", ...)
    private final String suit;// naipe da carta ("Hearts", "Diamonds", ...)

    // construtor de dois argumentos inicializa face e naipe da carta 
    public Card(String cardFace, String cardSuit)
    {
        this.face = cardFace;// inicializa face da carta
        this.suit = cardSuit;// inicializa naipe da carta
    }

    // retorna representação String de card
    public String toString()
    {
        return face + " of " + suit;
    }

    // modificacoes do exerc 7.30
    public String getFace()
    {
        return face;
    }

    public String getSuit()
    {
        return suit;
    }
}// fim da classe Card
