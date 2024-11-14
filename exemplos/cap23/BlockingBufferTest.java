// Figura 23.15 - BlockingBufferTest.java
// Dois threads manipulando um buffer bloqueante que implementa corretamente 
// a relacao produtor/consumidor.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlockingBufferTest
{
   public static void main(String[] args) throws InterruptedException
   {
      // cria um novo pool de threads com dois threads
      ExecutorService executorService = Executors.newCachedThreadPool();

      // cria BlockingBuffer para armazenar ints
      Buffer sharedLocation = new BlockingBuffer();

      executorService.execute(new Producer(sharedLocation));
      executorService.execute(new Consumer(sharedLocation));

      executorService.shutdown();
      executorService.awaitTermination(1, TimeUnit.MINUTES); 
   } 
} // fim da classe BlockingBufferTest
