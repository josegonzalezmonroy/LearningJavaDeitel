// Figura 5.9 - LetterGrades.java
// A classe LetterGrades usa a instrução switch para contar notas.

import java.util.Scanner; 

public class LetterGrades 
{
   public static void main(String[] args)
   {
      int total = 0; // soma das notas                  
      int gradeCounter = 0; // número de notas inseridas
      int aCount = 0; // contagem de notas A             
      int bCount = 0; // contagem de notas B             
      int cCount = 0; // contagem de notas C             
      int dCount = 0; // contagem de notas D             
      int fCount = 0; // contagem de notas F             

      Scanner input = new Scanner(System.in);

      System.out.printf("%s%n%s%n   %s%n   %s%n", 
         "Digite as notas inteiras no intervalo de 0-100.", 
         "Digite o indicador de fim de arquivo para terminar a entrada:",
         "No UNIX/Linux/Mac OS X digite <Ctrl> d e pressione Enter",
         "No Windows digite <Ctrl> z e pressione Enter");

      // loop até que o usuário insira o indicador de fim de arquivo
      while (input.hasNext()) 
      {
         int grade = input.nextInt(); // ler nota
         total += grade; // adicionar nota ao total
         ++gradeCounter; // incrementar o número de notas
         
         // incrementar o contador de notas apropriado   
         switch (grade / 10)                            
         {                                                
            case 9:  // nota entre 90               
            case 10: // e 100, inclusivo                
               ++aCount;         
               break; // sai do switch         
                                                          
            case 8: // nota entre 80 e 89        
               ++bCount;            
               break; // sai do switch                      
            
            case 7: // nota entre 70 e 79        
               ++cCount;            
               break; // sai do switch                      
            
            case 6: // nota entre 60 e 69        
               ++dCount;             
               break; // sai do switch                      
            
            default: // nota inferior a 60            
               ++fCount;              
               break; // opcional; sai do switch de qualquer maneira
         } // fim do switch                                  
      } // fim do while 

      // exibir relatório de notas
      System.out.printf("%nRelatório de Notas:%n");

      // se o usuário inseriu pelo menos uma nota...
      if (gradeCounter != 0) 
      {
         // calcular a média de todas as notas inseridas
         double average = (double) total / gradeCounter;  

         // exibir resumo dos resultados
         System.out.printf("Total das %d notas inseridas é %d%n", 
            gradeCounter, total);
         System.out.printf("Média da turma é %.2f%n", average);
         System.out.printf("%n%s%n%s%d%n%s%d%n%s%d%n%s%d%n%s%d%n", 
            "Número de alunos que receberam cada nota:", 
            "A: ", aCount,   // exibir número de notas A
            "B: ", bCount,   // exibir número de notas B
            "C: ", cCount,   // exibir número de notas C 
            "D: ", dCount,   // exibir número de notas D
            "F: ", fCount); // exibir número de notas F
      } // fim do if
      else // nenhuma nota foi inserida, então exibir mensagem apropriada
         System.out.println("Nenhuma nota foi inserida");
   } // fim do main
} // fim da classe LetterGrades
