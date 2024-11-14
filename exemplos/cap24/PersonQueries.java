// Classe PersonQueries com comandos SQL pre-compilados para aplicacao de agenda
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries 
{
   private static final String URL = "jdbc:derby:addressbook";
   private static final String USERNAME = "deitel";
   private static final String PASSWORD = "deitel";

   private Connection connection; // gerencia a conexao
   private PreparedStatement selectAllPeople; 
   private PreparedStatement selectPeopleByLastName; 
   private PreparedStatement insertNewPerson; 
    
   // Construtor que inicializa a conexao e os comandos SQL
   public PersonQueries()
   {
      try 
      {
         // cria a conexao com o banco de dados
         connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

         // prepara comando para selecionar todas as entradas na tabela AddressBook
         selectAllPeople = connection.prepareStatement("SELECT * FROM Addresses");
         
         // prepara comando para selecionar entradas com um sobrenome especifico
         selectPeopleByLastName = connection.prepareStatement(
            "SELECT * FROM Addresses WHERE LastName = ?");
         
         // prepara comando para inserir uma nova entrada no banco de dados
         insertNewPerson = connection.prepareStatement(
            "INSERT INTO Addresses " + 
            "(FirstName, LastName, Email, PhoneNumber) " + 
            "VALUES (?, ?, ?, ?)");
      }
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
         System.exit(1);
      }
   }
   
   // Seleciona todas as pessoas no banco de dados
   public List< Person > getAllPeople()
   {
      List< Person > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executa o comando e armazena os resultados
         resultSet = selectAllPeople.executeQuery(); 
         results = new ArrayList< Person >();
         
         // itera sobre os resultados e adiciona cada um a lista
         while (resultSet.next())
         {
            results.add(new Person(
               resultSet.getInt("addressID"),
               resultSet.getString("firstName"),
               resultSet.getString("lastName"),
               resultSet.getString("email"),
               resultSet.getString("phoneNumber")));
         } 
      } 
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();         
      } 
      finally
      {
         try 
         {
            resultSet.close();
         } 
         catch (SQLException sqlException)
         {
            sqlException.printStackTrace();         
            close();
         }
      }
      
      return results;
   } 

   // Seleciona pessoas pelo sobrenome especificado
   public List< Person > getPeopleByLastName(String name)
   {
      List< Person > results = null;
      ResultSet resultSet = null;

      try 
      {
         selectPeopleByLastName.setString(1, name); // define o sobrenome para busca

         // executa o comando e armazena os resultados
         resultSet = selectPeopleByLastName.executeQuery(); 
         results = new ArrayList< Person >();

         // itera sobre os resultados e adiciona cada um a lista
         while (resultSet.next())
         {
            results.add(new Person(resultSet.getInt("addressID"),
               resultSet.getString("firstName"),
               resultSet.getString("lastName"),
               resultSet.getString("email"),
               resultSet.getString("phoneNumber")));
         } 
      } 
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
      } 
      finally
      {
         try 
         {
            resultSet.close();
         }
         catch (SQLException sqlException)
         {
            sqlException.printStackTrace();         
            close();
         }
      } 
      
      return results;
   } 
   
   // Adiciona uma nova pessoa no banco de dados
   public int addPerson(
      String fname, String lname, String email, String num)
   {
      int result = 0;
      
      // define os parametros e executa o comando para insercao
      try 
      {
         insertNewPerson.setString(1, fname);
         insertNewPerson.setString(2, lname);
         insertNewPerson.setString(3, email);
         insertNewPerson.setString(4, num);

         // executa o comando de insercao; retorna o numero de linhas afetadas
         result = insertNewPerson.executeUpdate(); 
      }
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
         close();
      } 
      
      return result;
   } 
   
   // Fecha a conexao com o banco de dados
   public void close()
   {
      try 
      {
         connection.close();
      } 
      catch (SQLException sqlException)
      {
         sqlException.printStackTrace();
      } 
   } 
} 
