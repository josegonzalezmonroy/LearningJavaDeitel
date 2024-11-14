// 14.22 - Código Morse
// Talvez o mais famoso de todos os esquemas de codificação seja o código Morse, desenvolvido por Samuel Morse em 1832 para utilização com o sistema de telégrafo. O código Morse atribui uma série de pontos e traços para cada letra do alfabeto, para cada dígito e alguns caracteres especiais (como ponto, vírgula, dois-pontos e ponto e vírgula). Em sistemas orientados para áudio, o ponto representa um som curto e o traço representa um som longo. Outras representações de pontos e traços são utilizadas com sistemas baseados em sinais luminosos e sistemas baseados em sinais de bandeira. A separação entre palavras é indicada por um espaço, ou, simplesmente, a ausência de um ponto ou traço. Em um sistema orientado a som, um espaço é indicado por um tempo curto durante o qual nenhum som é transmitido. A versão internacional do código Morse aparece na Figura 14.26. Elabore um aplicativo que lê uma frase em inglês e a codifica em código Morse. Elabore também um aplicativo que lê uma frase em código Morse e a converte no equivalente em inglês. Utilize um espaço em branco entre cada letra codificada em Morse e três espaços em branco entre cada palavra codificada em Morse.
public class Exerc_14_22 
{
    public static void main(String[] args) 
    {
        String text = "11 111 hola";
        String encoded = CodigoMorse.encodeToMorse(text);
        System.out.println("Texto: " + text);
        System.out.println("Codificado em Morse: " + encoded);

        String decoded = CodigoMorse.decodeFromMorse(encoded);
        System.out.println("Decodificado de Morse: " + decoded);
    }   
}
