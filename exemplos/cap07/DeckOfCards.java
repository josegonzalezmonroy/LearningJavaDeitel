// Figura 7.10 - DeckOfCards.java
// classe DeckOfCards representa um baralho
import java.security.SecureRandom;

public class DeckOfCards 
{
    private Card[] deck; // array de objetos Card
    private int currentCard; // indice da proxima Card a ser distribuida (0-51)
    private static final int NUMBER_OF_CARDS = 52; // numero constante de Cards
    // gerador de numero aleatorio
    private static final SecureRandom randomNumbers = new SecureRandom();
    
    // construtor preenche baralho de cartas 
    public DeckOfCards()
    {
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", 
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

        deck = new Card[NUMBER_OF_CARDS]; // cria um array de objetos Card
        currentCard = 0; // a primeira Card distribuida sera o deck[0]

        // preenche baralho com objetos Card 
        for (int count = 0; count < deck.length; count++)
            deck[count] = 
                new Card(faces[count % 13], suits[count / 13]);
    }
    
    // embaralha as cartas com um algoritmo de uma passagem
    public void shuffle()
    {
        // a proxima chamada para o método dealCard deve começar no deck[0] novamente
        currentCard = 0;

        // para cada Card, seleciona outra Card aleatoria (0 - 51) e as compara
        for (int first = 0; first < deck.length; first++)
        {
            // seleciona um numero aleatorio entre 0 e 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            // compara card atual com card aleatoriamente selecionada
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    // distribui uma card
    public Card dealCard()
    {
        // determina se ainda há Cards a serem distribuidas
        if (currentCard < deck.length)
        {
            return deck[currentCard++];// retorna atual no array
        }
        else 
            return null;// retorna nulo para indicar que todas as cards foram distribuidas
    }

}// fim da classe DeckOfCards
