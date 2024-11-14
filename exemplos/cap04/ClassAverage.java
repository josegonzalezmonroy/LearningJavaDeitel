// Figura 4.10 - ClassAverage.java
// Resolvendo o problema da média da classe usando repetição controlada por sentinela. 
import java.util.Scanner; // o programa usa a classe Scanner

public class ClassAverage 
{
   public static void main(String[] args)
   {
      // criar Scanner para obter entrada da janela de comando
      Scanner input = new Scanner(System.in);

      // fase de inicialização
      int total = 0; // inicializa a soma das notas
      int gradeCounter = 0; // inicializa o número de notas inseridas até agora
      
      // fase de processamento
      // solicitar entrada e ler nota do usuário
      System.out.print("Digite a nota ou -1 para sair: "); 
      int grade = input.nextInt(); 

      // loop até que o valor sentinela seja lido do usuário
      while (grade != -1) 
      {
         total = total + grade; // adicionar nota ao total
         gradeCounter = gradeCounter + 1; // incrementar contador 

         // solicitar entrada e ler a próxima nota do usuário
         System.out.print("Digite a nota ou -1 para sair: "); 
         grade = input.nextInt(); 
      }

      // fase de término
      // se o usuário inseriu pelo menos uma nota...
      if (gradeCounter != 0) 
      {
         // usar número com ponto decimal para calcular a média das notas
         double average = (double) total / gradeCounter;  

         // exibir total e média (com duas casas de precisão)
         System.out.printf("%nO total das %d notas inseridas é %d%n", 
            gradeCounter, total);
         System.out.printf("A média da classe é %.2f%n", average); 
      } 
      else // nenhuma nota foi inserida, então exibir mensagem apropriada
         System.out.println("Nenhuma nota foi inserida"); 
   } 
} // fim da classe ClassAverage
