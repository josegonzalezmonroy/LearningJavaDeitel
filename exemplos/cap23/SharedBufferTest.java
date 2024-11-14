// Figura 23.13 - SharedBufferTest.java
// Aplicacao com duas threads manipulando um buffer nao sincronizado.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest
{
   public static void main(String[] args) throws InterruptedException
   {
      // cria um novo pool de threads com duas threads
      ExecutorService executorService = Executors.newCachedThreadPool();

      // cria um buffer nao sincronizado para armazenar inteiros       
      Buffer sharedLocation = new UnsynchronizedBuffer();

      System.out.println(
         "Acao\t\tValor\tSoma dos Produzidos\tSoma dos Consumidos");
      System.out.printf(
         "------\t\t-----\t---------------------\t-------------------%n%n");

      // executa o Produtor e o Consumidor, dando a cada um
      // acesso ao sharedLocation
      executorService.execute(new Producer(sharedLocation));
      executorService.execute(new Consumer(sharedLocation));

      executorService.shutdown(); // encerra aplicacao quando as tarefas terminam
      executorService.awaitTermination(1, TimeUnit.MINUTES); 
   } 
}
