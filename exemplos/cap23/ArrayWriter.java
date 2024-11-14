// Figura 23.6 - ArrayWriter.java
// Adiciona inteiros a um array compartilhado com outros Runnables
import java.lang.Runnable;

public class ArrayWriter implements Runnable
{
   private final SimpleArray sharedSimpleArray;
   private final int startValue;

   public ArrayWriter(int value, SimpleArray array)
   {
      startValue = value;
      sharedSimpleArray = array;
   }

   public void run()
   {
      for (int i = startValue; i < startValue + 3; i++)
      {
         sharedSimpleArray.add(i); // adiciona um elemento ao array compartilhado
      } 
   }
} // fim da classe ArrayWriter