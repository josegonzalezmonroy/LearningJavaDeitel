// Figura 23.12 - UnsynchronizedBuffer.java
// UnsynchronizedBuffer mantém o inteiro compartilhado que é acessado por 
// uma thread produtora e uma thread consumidora.
public class UnsynchronizedBuffer implements Buffer
{
   private int buffer = -1; // compartilhado pelas threads produtora e consumidora

   // coloca valor no buffer
   public void blockingPut(int value) throws InterruptedException
   {
      System.out.printf("Produtor escreve\t%2d", value);
      buffer = value;
   } 

   // retorna valor do buffer
   public int blockingGet() throws InterruptedException
   {
      System.out.printf("Consumidor lê\t%2d", buffer);
      return buffer;
   } 
} // end class UnsynchronizedBuffer
