// Figura 23.14 - BlockingBuffer.java
// Criando um buffer sincronizado usando a classe ArrayBlockingQueue.
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer
{
   private final ArrayBlockingQueue<Integer> buffer; // buffer compartilhado

   public BlockingBuffer()
   {
      buffer = new ArrayBlockingQueue<Integer>(1);
   }
   
   // coloca valor no buffer
   public void blockingPut(int value) throws InterruptedException
   {
      buffer.put(value); // coloca valor no buffer
      System.out.printf("%s%2d\t%s%d%n", "Produtor escreve ", value,
         "Células do buffer ocupadas: ", buffer.size());
   } 

   // retorna valor do buffer
   public int blockingGet() throws InterruptedException
   {
      int readValue = buffer.take(); // remove valor do buffer
      System.out.printf("%s %2d\t%s%d%n", "Consumidor lê ", 
         readValue, "Células do buffer ocupadas: ", buffer.size());

      return readValue;
   } 
} // fim da classe BlockingBuffer
