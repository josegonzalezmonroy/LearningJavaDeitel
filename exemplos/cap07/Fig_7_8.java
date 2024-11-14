// Figura 7.8 - StudentPoll.java
// Programa de análise de enquete

public class Fig_7_8 
{
    public static void main(String[] args) 
    {
        // array das respostas dos alunos (mais tipicamente, inserido em tempo de execução)
        int[] responses = { 1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3, 2, 3, 3, 2, 14 };
    
        int[] frequency = new int[6]; // array de contadores de frequência

        // para cada resposta, seleciona elemento de respostas e utiliza esse valor 
        // como indice de frequência para determinar elemento a incrementar
        for (int answer = 0; answer < responses.length; answer++)
        {
            try 
            {
                ++frequency[responses[answer]];    
            } 
            catch (ArrayIndexOutOfBoundsException e) 
            {
                System.out.println(e); // invoca o método toString
                System.out.printf("   responses[%d] = %d%n%n", 
                answer, responses[answer]);
            }
        }

        System.out.printf("%s%10s%n", "Rating", "Frequency");

        // gera uma saída do valor de cada elemento do array 
        for (int rating = 1; rating < frequency.length; rating++)
            System.out.printf("%6d%10d%n", rating, frequency[rating]);
    }    
}// fim da classe StudentPoll
