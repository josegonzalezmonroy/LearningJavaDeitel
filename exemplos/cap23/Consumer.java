// Figura 23.11 - Consumer.java
// Consumidor com um metodo run que loopa, lendo 10 valores do buffer.
import java.security.SecureRandom;

public class Consumer implements Runnable
{ 
   private static final SecureRandom generator = new SecureRandom();
   private final Buffer sharedLocation; // referencia ao objeto compartilhado

   // construtor
   public Consumer(Buffer sharedLocation)
   {
      this.sharedLocation = sharedLocation;
   }

   // ler o valor de sharedLocation 10 vezes e somar os valores
   public void run()                                           
   {
      int sum = 0;

      for (int count = 1; count <= 10; count++) 
      {
         // dormir de 0 a 3 segundos, ler o valor do buffer e adicionar à soma
         try 
         {
            Thread.sleep(generator.nextInt(3000));
            sum += sharedLocation.blockingGet();
         } 
         catch (InterruptedException exception) 
         {
            Thread.currentThread().interrupt(); 
         } 
      } 

      System.out.printf("%n%s %d%n%s%n", 
         "Consumidor leu valores totalizando", sum, "Terminando Consumidor");
   } 
} // fim da classe Consumer