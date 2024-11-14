// 7.18 - Jogo de dados craps
//Escreva um aplicativo que executa 1000 jogos de dados (Figura 6.8) e responda às perguntas: a) Quantos jogos são ganhos na primeira rolagem, segunda rolagem, ..., vigésima rolagem e depois da vigésima rolagem? b) Quantos jogos são perdidos na primeira rolagem, segunda rolagem, ..., vigésima rolagem e depois da vigésima rolagem? c) Quais são as chances de ganhar no jogo de dados? [Nota: Você deve descobrir que o craps é um dos jogos mais comuns de cassino. O que você supõe que isso significa?] d) Qual é o comprimento médio de um jogo de dados? e) As chances de ganhar aumentam com o comprimento do jogo?
public class Exerc_7_18 
{
    public static void main(String[] args) 
    {
        Exerc_7_18_Craps craps = new Exerc_7_18_Craps();
    
        int[][] lances = new int[21][2];// armazena cada lance

        int jogadas = 1000000;// numero de jogadas
        int acumulador = 0;// acumulador para calcular a duracao media dos jogos
        int ganha = 0;// acumulador para calcular a porcentagem de ganhos

        for (int vezes = 0; vezes < jogadas; vezes++)
        {
            Boolean jogo = craps.play();// joga os dados
            if (craps.rolagem > lances.length)// se a jogada ultrapassar as 20 rolagens
                craps.rolagem = lances.length;

            if (jogo == true)// se o jogador ganhar 
            {
                lances[craps.rolagem - 1][0]++;// adiciona 1 na posicao "ganhou" do array
                ganha++;// adiciona 1 para ganha
            }
            else
                lances[craps.rolagem - 1][1]++;// adiciona 1 na posicao "perdeu" do array
              
            craps.rolagem = 0;// zera a variavel rolagem para um novo lance
        }

        // Imprime as informações
        System.out.printf("%-10s%-10s%-10s%n", "Rolagem", "Ganhou", "Perdeu");

        for (int linha = 0; linha < lances.length; linha++)
        {
            if (linha == lances.length - 1)
                System.out.printf("%+d    ", (linha));
            else
                System.out.printf("%02d     ", (linha + 1));

            int ganhos = lances[linha][0];
            int perdas = lances[linha][1];
            int total = ganhos + perdas;

            // calcula o percentual de ganhos e perdas
            if (total > 0)
                System.out.printf("%8.2f%%%9.2f%%", ((double) ganhos / total * 100), ((double) perdas / total *100)); 
            else 
                System.out.printf("%10.2f%%%10.2f%%", 0.0, 0.0);

            // adiciona ao acumulador para calcular a duracao media do jogo
            acumulador += total * (linha + 1);
            
            // Imprime uma mensagem se ganhou ou perdeu
            if (lances[linha][0] > lances[linha][1])
                System.out.print("   Ganhou");

            if (lances[linha][0] < lances[linha][1])
                System.out.print("   Perdeu");

            System.out.println();
        }

        // Imprime as chances de ganhar
        System.out.printf("Chances de ganhar: %.2f%%%n", (double) ganha / jogadas * 100);

        // Imprime a duração media do jogo
        System.out.printf("Duracao media de um jogo:%n%.2f rolagens", (double) acumulador / jogadas);


    }

}
