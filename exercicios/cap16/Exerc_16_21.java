// 16.21 - Alterando a ordem de classificação de uma PriorityQueue
// A saída da Figura 16.15 mostra que PriorityQueue ordena os elementos Double em ordem crescente. Reescreva a Figura 16.15 de modo que ela ordene os elementos Double em ordem decrescente (isto é, 9.8 deve ser o elemento de maior prioridade em vez de 3.2).

import java.util.Comparator;
import java.util.PriorityQueue;

public class Exerc_16_21 
{
    public static void main(String[] args) 
    {
       // fila de capacidade 11 com ordenação decrescente
       PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
 
       // insere elementos na fila
       queue.offer(3.25);
       queue.offer(9.87);
       queue.offer(5.49);
 
       System.out.print("Polling from queue: ");
 
       // exibe elementos na fila
       while (queue.size() > 0)
       {
          System.out.printf("%.2f ", queue.peek()); // visualiza o elemento superior
          queue.poll(); // remove o elemento superior
       } 
    }  
}
