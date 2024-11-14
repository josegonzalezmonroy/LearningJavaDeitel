// Fig. 24.23: DisplayAuthors.java
// Exibindo o conteudo da tabela de autores
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DisplayAuthors 
{
   public static void main(String args[])
   {
      final String DATABASE_URL = "jdbc:derby:books";
      final String SELECT_QUERY = 
         "SELECT authorID, firstName, lastName FROM authors";

      // usa try-with-resources para conectar e consultar o banco de dados
      try (  
         Connection connection = DriverManager.getConnection(
            DATABASE_URL, "deitel", "deitel"); 
         Statement statement = connection.createStatement(); 
         ResultSet resultSet = statement.executeQuery(SELECT_QUERY))
      {
         // obtem os meta dados do ResultSet
         ResultSetMetaData metaData = resultSet.getMetaData();
         int numberOfColumns = metaData.getColumnCount();     
         
         System.out.printf("Tabela de Autores do Banco de Dados Books:%n%n");

         // exibe os nomes das colunas no ResultSet
         for (int i = 1; i <= numberOfColumns; i++)
            System.out.printf("%-8s\t", metaData.getColumnName(i));
         System.out.println();
         
         // exibe os resultados da consulta
         while (resultSet.next()) 
         {
            for (int i = 1; i <= numberOfColumns; i++)
               System.out.printf("%-8s\t", resultSet.getObject(i));
            System.out.println();
         } 
      } 
      catch (SQLException sqlException)                                
      {                                                                  
         sqlException.printStackTrace();
      }                                                   
   } 
}
