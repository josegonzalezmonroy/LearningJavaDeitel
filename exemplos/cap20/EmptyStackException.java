// Classe EmptyStackException que estende RuntimeException
public class EmptyStackException extends RuntimeException
{
   // Construtor sem argumentos
   public EmptyStackException()
   {
      // Chama o outro construtor, passando a mensagem padrão "Stack is empty"
      this("Stack is empty");
   } 

   // Construtor que aceita uma mensagem como argumento
   public EmptyStackException(String message)
   {
      // Chama o construtor da superclasse (RuntimeException) com a mensagem fornecida
      super(message);
   }
} // fim da classe EmptyStackException