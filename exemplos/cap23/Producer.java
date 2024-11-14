// Figura 23.10 - Producer.java
// Produtor com um metodo run que insere os valores de 1 a 10 no buffer.
import java.security.SecureRandom;

public class Producer implements Runnable
{
   private static final SecureRandom generator = new SecureRandom();
   private final Buffer sharedLocation; // referencia ao objeto compartilhado

   // construtor
   public Producer(Buffer sharedLocation)
   {
      this.sharedLocation = sharedLocation;
   } 

   // armazena valores de 1 a 10 em sharedLocation
   public void run()                             
   {
      int sum = 0;

      for (int count = 1; count <= 10; count++)
      {
         try // dormir de 0 a 3 segundos, depois colocar valor no Buffer
         {
            Thread.sleep(generator.nextInt(3000)); // dormir aleatoriamente
            sharedLocation.blockingPut(count); // definir valor no buffer
            sum += count; // incrementar soma dos valores
         } 
         catch (InterruptedException exception) 
         {
            Thread.currentThread().interrupt(); 
         } 
      } 

      System.out.printf(
         "Produtor terminou de produzir%nTerminando Produtor%n");
   } 
} // fim da classe Producer