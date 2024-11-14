// 7.30 - Embaralhamento e distribuição
/* Modifique o aplicativo na Figura 7.11 para distribuir uma mão de cinco cartas de pôker. Então modifique a classe deckOfCards da Figura 7.10 para incluir métodos que determinam se um mão contém
    a) um par      
    b) dois pares      
    c) uma trinca (por exemplo, três valetes)      
    d) uma quadra (por exemplo, quatro ases)      
    e) um flush (isto é, cinco cartas do mesmo nipe)      
    f) um straight (isto é, cinco cartas de valores consecutivos)      
    g) uma full house (isto é, duas cartas de um valor e três cartas de outro valor)

    [Dica: Adicione os métodos getFace e getSuit à classe card da Figura 7.9]
*/

////////////////////////////////////////////////////////////////////////
////////// ESTE EXERCICIO POSSIVELMENTE NAO VAI FUNCIONAR //////////////
////////// DEVIDO A MODIFICACAO NO ARQUIVO 'DECKOFCARDS' QUE ///////////
////////// FOI MODIfICADO PARA COMPLETAR OS EXERCICIOS FUTUROS /////////
////////// ENTAO AS LINHAS DE CODIGO COMENTADAS DESTE ARQUIVO //////////
////////// SAO AS QUE DEVEM SER REFATORADAS PARA QUE O CODIGO //////////
////////// POSSA FUNCIONAR /////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////

public class Exerc_7_30 
{
    public static void main(String[] args) 
    {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // coloca Cards em ordem aleatoria
        
        // imprime todas as 5 cartas na ordem em que elas são distribuidas
        for (int i = 1; i <= 5; i++)
        {
            // distribui e exibe uma Card
            //System.out.printf("%-19s", myDeckOfCards.dealCard());
        
            //if (i == 5) myDeckOfCards.classificacao();
        }
    }    
}
