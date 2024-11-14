// Figura 7.10 - DeckOfCards.java
// classe DeckOfCards representa um baralho
import java.security.SecureRandom;
import java.util.Arrays;

public class DeckOfCards 
{
    private Card[] deck; // array de objetos Card
    private int currentCard; // indice da proxima Card a ser distribuida (0-51)
    private static final int NUMBER_OF_CARDS = 52; // numero constante de Cards
    // gerador de numero aleatorio
    private static final SecureRandom randomNumbers = new SecureRandom();
    
    // valores das cartas
    public enum Face
    {
        Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
    }

    // naipes 
    public enum Suit
    {
        Hearts, Diamonds, Clubs, Spades
    }

    // construtor preenche baralho de cartas 
    public DeckOfCards()
    {
        deck = new Card[NUMBER_OF_CARDS]; // cria um array de objetos Card
        currentCard = 0; // a primeira Card distribuida sera o deck[0]

        // preenche baralho com objetos Card 
        for (int count = 0; count < deck.length; count++)
            deck[count] = new Card(Face.values()[count % 13].toString(), Suit.values()[count / 13].toString());
    }
    
    // embaralha as cartas com o algoritmo Fisher-Yates
    public void shuffle()
    {
        // a proxima chamada para o método dealCard deve começar no deck[0] novamente
        currentCard = 0;

        // o valor da primeira carta sera de 51 (deck.length - 1), e vai diminuindo até garantir uma passgem completa pelo array
        for (int first = deck.length - 1; first > 0; first--)
        {
            // seleciona um numero aleatorio entre 0 e o indice atual inclusive
            int second = randomNumbers.nextInt(first + 1);

            // compara card atual com card aleatoriamente selecionada
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    // distribui a card da mao
    public Card dealCard(int tipoDeMao, int indice)
    {
        // determina se ainda há Cards a serem distribuidas
        if (currentCard < deck.length)
        {
            carta(deck[currentCard].getFace(), deck[currentCard].getSuit(), tipoDeMao, indice);
            return deck[currentCard++];// retorna atual no array
        }
        else 
            return null;// retorna nulo para indicar que todas as cards foram distribuidas
    }
 
    // modificacoes do exercicio 7.30
    private int cartas = 0;

    int[] mao = new int[5];// guarda o valor face e suit das cartas
    int[] mao1 = mao;// guarda o valor das cartas da mao1
    int[] mao2 = new int[5];// guarda o valor das cartas da mao 2
    int[] maos = new int[2];// guarda o valor de clasificacao de cada mao

    public void carta(String face, String suit, int tipoDeMao, int indice)
    {
        // inicializa as variaveis
        int suitValue = 0;// armazena o valor em numero de suit
        int facesValue = 0;// armazena o valor em numero de face

        // converte os valores de suit e face para numero
        for (int i = 0; i < Face.values().length; i++)
            if (Face.values()[i].toString() == face)
                facesValue = i + 11;
            
        for (int i = 0; i < Suit.values().length; i++)
            if (Suit.values()[i].toString() == suit)
                suitValue = i;

        int valueCard = 10 * facesValue + suitValue; 

        if (tipoDeMao == 0)
            mao[cartas] = valueCard;
    
        if (tipoDeMao == 1)
            mao1[indice] = valueCard;
    
        if (tipoDeMao == 2)
            mao2[indice] = valueCard;
    }

    public void numberToString(int[] mao, boolean imprimir)
    {
        for (int i = 0; i < mao.length; i++) 
            System.out.printf("%n[%d] %s", i + 1, 
            imprimir ? Face.values()[facesCalculo(mao[i]) == 14 ? 0 : facesCalculo(mao[i]) - 1] + " of " + Suit.values()[mao[i] % 10] : "------------") ; 
    }

    public int quantidadeAleatoria(int valor)
    {
        return 1 + randomNumbers.nextInt(valor);
    }

    // distribui as maos
    public void distribuiMao()
    {

        if (cartas == 5)// cada mao tem 5 cartas, depois disso zera os valores
        {
            cartas = 0;// zera a contagem das cartas
            mao = new int[5];// zera o valor da mao
            mao2 = mao;// guarda o valor de cartas da mao 2
        }

        for (int i = 1; i <= 5; i++)// cinco cartas para cada mao
        {
            // distribui e exibe uma Card  
            dealCard(0,0);
            cartas++;
        }
    }

    public int facesCalculo(int valor)
    {
        return valor / 10 - 10;
    }

    public int aceToACE(int valor)
    {
        int naipe = valor % 10;
        return 240 + naipe;
    }

    public int valorMao(int[] mao)
    {
        int valor = 0;// inicializa a variavel valor
        
        // verifica se existe um flush
        for (int carta = 0; carta < mao.length; carta++)
            for (int carta2 = carta; carta2 < mao.length; carta2++)
            {
                if (carta == carta2) 
                    continue;
                if (mao[carta] % 10 == mao[carta2] % 10) 
                    valor++;    
            }

        // se existir um flush, retorna o valor
        if (valor == 10)
            return 5;

        // senao, zera o valor e busca outras classificacoes
        valor = 0;
        Arrays.sort(mao);// ordena o array de faces
        
        // no caso do Ace ter valor de 14, se considera straight
        if ((facesCalculo(mao[0]) == 1 && facesCalculo(mao[1]) == 10 && facesCalculo(mao[2]) == 11 && facesCalculo(mao[3]) == 12 && facesCalculo(mao[4]) == 13) || (facesCalculo(mao[0]) == 2 && facesCalculo(mao[1]) == 3 && facesCalculo(mao[2]) == 4 && facesCalculo(mao[3]) == 5 && facesCalculo(mao[4]) == 14))
            return 4;

        // faz um loop pelo array para determinar se existe um straight
        for (int carta = 0, carta2 = facesCalculo(mao[carta]); carta < mao.length; carta++, carta2++)
            if (facesCalculo(mao[carta]) == carta2) 
                valor++;

        if (valor == 5) // depois do array, se existir um straight, retorna 5
            return 4;
        
        // senao, zera o valor e busca outras classificacoes
        valor = 0;

        for (int carta = 0; carta < mao.length; carta++)
            for (int carta2 = carta; carta2 < mao.length; carta2++)
            {
                if (carta == carta2) 
                    continue;
                if (facesCalculo(mao[carta]) == facesCalculo(mao[carta2])) 
                    valor++;    
            }
            
        if (valor == 6)
            return 7;

        if (valor == 4)
            return 6;

        return valor;
    }

    public void autoAvaliaMao(int[] mao, int numeroDeMao)
    {
        int tipoDeMao = numeroDeMao + 1;

        if (maos[numeroDeMao] >= 0 && maos[numeroDeMao] <= 3)
        {
            int[] faces = new int[5];

            int indice = 0;

            for (int i = 0; i < faces.length; i++)
            {
                if (facesCalculo(mao[i]) == 1)
                    mao[i] = aceToACE(mao[i]);
    
                if (facesCalculo(mao[i]) >= 2 && facesCalculo(mao[i]) <= 9)
                    faces[i] = mao[i];
            }
            
            for (int i = 0; i < faces.length - 1; i++)
            {
                if (facesCalculo(mao[i]) == facesCalculo(mao[i + 1]))
                {
                    faces[i] = 0;
                    faces[i + 1] = 0;
                }
            }

            for (int face = 0; face < faces.length; face++)
            {
                if (faces[face] > 0)
                    indice++;
            }

            if (indice == 0)
                System.out.println("Sem cartas trocadas\n");
            else
            {
                int vezes = quantidadeAleatoria(indice);
                System.out.println("Cartas trocadas: " + vezes +  "\n");

                for (int i = 0; i < faces.length; i++)
                {
                    if (faces[i] != 0)
                    {
                        vezes--;
                        dealCard(tipoDeMao, i);
                    }
                    if (vezes == 0)
                        break; 
                }
                maos[numeroDeMao] = valorMao(mao);
            }
        }
    }

    // clasifica a mao dependendo do valor e mostra a mensagem dependendo do valor
    public int classificacao(int mao, boolean imprimir)
    {
        int valor = valorMao(mao == 1 ? mao1 : mao2);// chama o metodo
        String mensagem = "";
    
        switch (valor) 
        {
            case 1:// um par
                mensagem = "Par";
                break;
            case 2:// dois pares
                mensagem = "Dois pares";
                break;
            case 3:// tres do mesmo valor
                mensagem = "Trinca";
                break;
            case 4:// cinco cartas de valores consecutivos
                mensagem = "Straight";
                break;
            case 5:// cinco do mesmo naipe
                mensagem = "Flush";
                break;
            case 6:// duas cartas de un valor e tres de outro valor
                mensagem = "Full house";
                break;
            case 7:// quatro do mesmo valor
                mensagem = "Quadra";
                break;
            default:
                mensagem = "Nada";
                break;
        }

        if (!imprimir) 
            mensagem = "";

        System.out.printf("%n%n%s%n-------------------%n", mensagem);

        return valor;
    }

    // determina a melhor mao
    public int melhorMao(String nome)
    {
        int valor = 0;

        if (Arrays.equals(mao1, mao2))// se as maos forem exatamente iguais
        {
            System.out.println("\nMAOS IGUAIS");
            return valor;
        }

        else if (maos[0] > maos[1])// se o valor da mao 1 é maior
            valor = 1;

        else if (maos[0] < maos[1])// se o valor da mao 2 é maior
            valor = 2;

        else// no caso de carta alta
        {
            //converte o valor ace em 14 para facilitar o calculo de carta de maior valor
            for (int i = 0; i < mao.length; i++)
            {
                if (facesCalculo(mao1[i]) == 1)
                    mao1[i] = aceToACE(mao1[i]);
                    
                if (facesCalculo(mao2[i]) == 1)
                    mao2[i] = aceToACE(mao1[i]);
            }

            // ordena os arrays
            Arrays.sort(mao1);
            Arrays.sort(mao2);

            int valor1 = 0;
            int valor2 = 0;

            if (maos[0] == maos[1])// se ambos forem um tiverem a mesma mao
            {
                if (maos[0] == 0)
                {
                    for (int maoMaior = mao.length - 1; maoMaior >= 0; maoMaior--)
                    {// busca o valor maior para o desempate
                        if (facesCalculo(mao1[maoMaior]) > facesCalculo(mao2[maoMaior]))
                        {
                            valor = 1; //System.out.println("Mao 01 e a melhor");
                            break;
                        }
                        else if (facesCalculo(mao2[maoMaior]) > facesCalculo(mao1[maoMaior]))
                        {
                            valor = 2; //System.out.println("Mao 02 e a melhor");
                            break;
                        }
                    }
                }
                else 
                {
                    if (maos[0] != 6)// se nao for full house
                    {
                        for (int maoMaior = mao1.length - 1; maoMaior > 0; maoMaior--)
                        {// faz um loop pelos arrays para encontrar o valor repetido
                            
                            // se achar o valor, é asignado a uma variavel
                            if (facesCalculo(mao1[maoMaior]) == facesCalculo(mao1[maoMaior - 1]))
                                valor1 = mao1[maoMaior];
                    
                            if (facesCalculo(mao2[maoMaior]) == facesCalculo(mao2[maoMaior - 1]))
                                valor2 = mao2[maoMaior];
                        }
                    }
                    else// se for full house (no caso de full house temos que comparar 3 cartas ao mesmo tempo para saber o valor maior)
                    {
                        for (int maoMaior = mao1.length - 1; maoMaior > 1; maoMaior--)
                        {// faz um loop pelos arrays para encontrar o valor repetido
                            
                            // se achar o valor, é asignado a uma variavel
                            if (facesCalculo(mao1[maoMaior]) == facesCalculo(mao1[maoMaior - 1]) && facesCalculo(mao1[maoMaior]) == facesCalculo(mao1[maoMaior - 2]))
                                valor1 = mao1[maoMaior];
                    
                            if (facesCalculo(mao2[maoMaior]) == facesCalculo(mao2[maoMaior - 1]) && facesCalculo(mao2[maoMaior]) == facesCalculo(mao2[maoMaior - 2]))
                                valor2 = mao2[maoMaior];
                        }
                    }
                    // se o par da mao 1 for melhor
                    if (valor1 > valor2)
                    valor = 1; //System.out.println("Mao 01 e a melhor");

                    // se o par da mao 2 for melhor
                    else if (valor2 > valor1)
                    valor = 2; //System.out.println("Mao 02 e a melhor");

                    else if (valor1 == valor2) // se os pares forem iguais
                    {
                        for (int maoMaior = mao1.length - 1; maoMaior >= 0; maoMaior--)
                        {// busca o valor maior para o desempate
                            if (facesCalculo(mao1[maoMaior]) > facesCalculo(mao2[maoMaior]))
                            {
                                valor = 1; //System.out.println("Mao 01 e a melhor");
                                break;
                            }
                            else if (facesCalculo(mao2[maoMaior]) > facesCalculo(mao1[maoMaior]))
                            {
                                valor = 2; //System.out.println("Mao 02 e a melhor");
                                break;
                            }
                        }
                    }               
                }
            }  
        }
        
        String ganhador = "";
        switch (valor) 
        {
            case 1:
                ganhador = "COMPUTADOR";     
                break;
        
            case 2:
                ganhador = nome;     
                break;
        }
        System.out.println(ganhador + " GANHOU");
            
        return valor;

    }
}// fim da classe DeckOfCards
