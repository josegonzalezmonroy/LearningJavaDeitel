// 8.10 
// Escreva um tipo enum TrafficLight, cuja constante (RED, GREEN, YELLOW) aceite um parâmetro — a duração da luz. Escreva um programa para testar o enum TrafficLight de modo que ele exiba a constante enum e suas durações.

public class Exerc_8_10 
{
    public static void main(String[] args) 
    {
        System.out.printf("%-11s%s%n","CONSTANTE", "VALOR");

        for (TrafficLight valor : TrafficLight.values())
            System.out.printf("%-11s%02d%n", valor, valor.getDuration());    
    }    
}
