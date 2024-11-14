// 19.6 (Classificação por borbulhamento aprimorada) Faça as seguintes modificações simples para melhorar o desempenho da classificação por borbulhamento que você desenvolveu na Questão 19.5: a) Depois da primeira passagem, garante-se que o número maior está no elemento de número mais alto do array; após a segunda passagem, os dois números mais altos estão "no lugar"; e assim por diante. Em vez de fazer nove comparações em cada passagem para um array de 10 elementos, modifique a classificação por borbulhamento para fazer oito comparações na segunda passagem, sete na terceira passagem e assim por diante. b) Os dados no array já podem estar na ordem adequada ou quase adequada, então por que fazer nove passagens se menos seriam suficientes? Modifique a classificação para verificar no fim de cada passagem se alguma troca foi feita. Se não houvesse nenhum, os dados já deveriam estar classificados, assim o programa deve terminar. Se trocas foram feitas, pelo menos mais uma passagem é necessária.
import java.security.SecureRandom; 
import java.util.Arrays; 

public class Exerc_19_6
{
    public static void main(String[] args) 
    {
        SecureRandom generator = new SecureRandom(); // Cria um gerador de numeros aleatorios seguro

        int[] array = new int[7]; // Cria um array de inteiros com tamanho 7

        // Preenche o array com numeros aleatorios entre 10 e 99
        for (int i = 0; i < array.length; i++) 
            array[i] = 10 + generator.nextInt(90);

        // Exibe o array antes da ordenacao
        System.out.printf("Array sem ordenar --> %s%n", Arrays.toString(array));

        bubbleSort(array); // Chama o metodo para ordenar o array

        // Exibe o array depois da ordenacao
        System.out.printf("Array ordenado -----> %s%n", Arrays.toString(array));
    }

    // Metodo que implementa a classificacao por borbulhamento
    public static void bubbleSort(int[] array) 
    {
        boolean trocou; // Variavel para verificar se houve troca

        // Loop para passar pelo array varias vezes
        for (int i = 0; i < array.length - 1; i++) 
        {
            trocou = false; // Reseta a variavel a cada passagem

            // Loop para comparar elementos adjacentes
            for (int j = 0; j < array.length - 1 - i; j++)
                // Compara os elementos adjacentes
                if (array[j] > array[j + 1]) 
                {
                    // Troca se estiver na ordem errada
                    int temp = array[j]; // Armazena o elemento atual em uma variavel temporaria
                    array[j] = array[j + 1]; // Troca o elemento atual pelo proximo
                    array[j + 1] = temp; // Coloca o elemento armazenado na posicao correta
                    trocou = true; // Indica que houve uma troca
                }
                
            // Se não houve troca, o array ja esta ordenado
            if (!trocou) 
                break; // Encerra o loop se o array estiver ordenado
        }
    }
}

