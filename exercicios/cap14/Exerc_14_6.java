// 14.6 - Projeto: Limericks
// Um limerick é um poema humorístico de cinco versos em que a primeira e a segunda linha rimam com a quinta, e a terceira linha rima com a quarta. Utilizando técnicas semelhantes àquelas desenvolvidas na Questão 14.5, elabore um aplicativo Java que produz limericks aleatórios. Polir esse aplicativo para produzir bons limericks é um problema desafiador, mas o resultado vale o esforço!
import java.security.SecureRandom;

public class Exerc_14_6
{
    public static void main(String[] args) 
    {
        // Arrays de frases para o limerick
        String[] linha1 = {"Havia um ratinho no cais,", "Existia um passaro a cantar,", "Tinha um pequeno cãozinho no mar,"};
        String[] linha2 = {"Que comia queijo demais,", "Que adorava dançar e saltar,", "Que adorava nadar sem parar,"};
        String[] linha3 = {"Ele correu para o fundo,", "Ele cantava todo o dia,", "Ele nadava sem parar,"};
        String[] linha4 = {"Mas encontrou um segundo,", "E dançava com alegria,", "E encontrou uma amiga no mar,"};
        String[] linha5 = {"E voltou feliz para o cais.", "E voltou feliz para cantar.", "E voltou a nadar sem parar."};

        // Instancia o SecureRandom
        SecureRandom secureRandom = new SecureRandom();

        // Seleciona uma linha aleatória de cada array
        String limerick = 
            linha1[secureRandom.nextInt(linha1.length)] + "\n" + 
            linha2[secureRandom.nextInt(linha2.length)] + "\n" + 
            linha3[secureRandom.nextInt(linha3.length)] + "\n" + 
            linha4[secureRandom.nextInt(linha4.length)] + "\n" + 
            linha5[secureRandom.nextInt(linha5.length)];

        // Exibe o limerick gerado
        System.out.println(limerick);
    }
}
