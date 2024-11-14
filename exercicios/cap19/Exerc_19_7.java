// 19.7 - Bucket sort
// Uma classificação do tipo bucket sort inicia com um array unidimensional de inteiros positivos a ser classificado e um array bidimensional de inteiros com linhas indexadas de 0 a 9 e colunas indexadas de 0 a n – 1, onde n é o número dos valores a ser classificado. Cada linha do array bidimensional é chamada bucket. Escreva uma classe chamada BucketSort que contém um método chamado sort que opera desta maneira: a) Coloque cada valor do array unidimensional em uma linha do array de bucket, com base nas "unidades" (mais à direita) do digito. Por exemplo, 97 é colocado na linha 7, 3 é colocado na linha 3 e 100 é colocado na linha 0. Esse procedimento é chamado de passagem de distribuição. b) Realize um loop pelo array de bucket linha por linha e copie os valores de volta para o array original. Esse procedimento é chamado passagem de coleta. A nova ordem dos valores precedentes no array unidimensional é 100, 3 e 97. c) Repita esse processo para a posição de cada digito subsequente (dezenas, centenas, milhares etc.). Na segunda passagem (digitos das dezenas), 100 é colocado na linha 0, 3 é colocado na linha 0 (porque 3 não tem nenhum digito de dezena) e 97 é colocado na linha 9. Depois da passagem de coleta, a ordem dos valores no array unidimensional é 100, 3 e 97. Na terceira passagem (digitos das centenas), 100 é colocado na linha 1, 3 é colocado na linha 0 e 97 é colocado na linha 0 (depois do 3). Depois dessa última passagem de coleta, o array original está na ordem classificada. O array bidimensional dos buckets tem 10 vezes o comprimento do array de inteiros sendo classificado. Essa técnica de classificação fornece um melhor desempenho do que uma classificação por borbulhamento, mas exige muito mais memória — a classificação por borbulhamento exige espaço para somente um elemento adicional de dados. Essa comparação é um exemplo da relação de troca espaço/tempo: a bucket sort utiliza mais memória que a classificação por borbulhamento, mas seu desempenho é melhor. Essa versão da bucket sort requer cópia de todos os dados de volta para o array original a cada passagem. Outra possibilidade é criar um segundo array de bucket bidimensional e permutar os dados repetidamente entre os dois arrays de bucket.
import java.security.SecureRandom;
import java.util.Arrays;

public class Exerc_19_7 
{
    public static void main(String[] args) 
    {
        SecureRandom generator = new SecureRandom(); // Cria um gerador de numeros aleatorios seguro

        int[] lista = new int[7]; // Cria um array de inteiros com tamanho 7

        // Preenche o array com numeros aleatorios entre 10 e 999
        for (int i = 0; i < lista.length; i++) 
            lista[i] = 10 + generator.nextInt(990);

        System.out.println("Antes:  " + Arrays.toString(lista));

        sort(lista);

        System.out.println("Depois: " + Arrays.toString(lista));
    }
    
    public static void sort(int[] lista) 
    {
        int[][] bidimensional = new int[10][lista.length]; // 10 buckets
        int[] count = new int[10]; // Array para contar elementos em cada bucket

        for (int i = 1; i <= 1000; i *= 10) 
        { // Para cada digito (unidade, dezena, centena)
            // Passagem de distribuicao
            for (int valor : lista) 
            {
                int linha = (valor / i) % 10; // Determina em qual bucket o valor vai
                bidimensional[linha][count[linha]++] = valor; // Adiciona o valor ao bucket
            }

            // Passagem de coleta
            int index = 0; // indice para o array original
            for (int j = 0; j < bidimensional.length; j++) 
            {
                for (int k = 0; k < count[j]; k++) 
                lista[index++] = bidimensional[j][k]; // Copia do bucket para o array original
                
                count[j] = 0; // Reseta o contador do bucket para a próxima iteracao
            }
            System.out.println(Arrays.toString(lista));
        }
    }
}
