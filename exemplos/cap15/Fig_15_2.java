// Fig. 15.2 - FileAndDirectoryInfo.java
// A classe File utilizada para obter informacoes de arquivo e de diretorio.
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Fig_15_2
{
   public static void main(String[] args) throws IOException
   {
      Scanner input = new Scanner(System.in);

      System.out.println("Enter file or directory name:");

      // cria o objeto Path com base na entrada de usuario
      Path path = Paths.get(input.nextLine());

      if (Files.exists(path)) // se o caminho existe, gera uma saido das informacoes sobre ele
      {
         // exibe informacoes sobre o arquivo (ou diretorio)
      	System.out.printf("%n%s exists%n", path.getFileName());
      	System.out.printf("%s a directory%n", 
      		Files.isDirectory(path) ? "Is" : "Is not");
      	System.out.printf("%s an absolute path%n", 
      		path.isAbsolute() ? "Is" : "Is not");
      	System.out.printf("Last modified: %s%n", 
      		Files.getLastModifiedTime(path));
      	System.out.printf("Size: %s%n", Files.size(path));
      	System.out.printf("Path: %s%n", path);
      	System.out.printf("Absolute path: %s%n", path.toAbsolutePath());

         if (Files.isDirectory(path)) // listagem de diretorio de saida
         {
            System.out.printf("%nDirectory contents:%n");
            
            // objeto para iteracao pelo conteudo de um diretorio
            DirectoryStream<Path> directoryStream = 
               Files.newDirectoryStream(path);
   
            for (Path p : directoryStream)
               System.out.println(p);
         } 
      } 
      else // se nao for arquivo ou diretorio, gera saida da mensagem de erro
      {
         System.out.printf("%s does not exist%n", path);
      }   
   }
} // fim da classe FileAndDirectoryInfo
