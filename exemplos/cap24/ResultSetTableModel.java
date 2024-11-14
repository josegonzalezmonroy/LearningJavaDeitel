// Fig. 24.25: ResultSetTableModel.java
// Um TableModel que fornece dados de um ResultSet para um JTable.
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

// As linhas e colunas do ResultSet sao contadas a partir de 1 e as linhas e colunas do JTable 
// sao contadas a partir de 0. Ao processar as linhas ou colunas do ResultSet para uso em um JTable, 
// e necessario adicionar 1 ao numero da linha ou coluna para manipular a coluna correta do ResultSet 
// (ou seja, a coluna 0 do JTable e a coluna 1 do ResultSet, e a linha 0 do JTable e a linha 1 do ResultSet).
public class ResultSetTableModel extends AbstractTableModel 
{
   private final Connection connection;
   private final Statement statement;
   private ResultSet resultSet;
   private ResultSetMetaData metaData;
   private int numberOfRows;

   // Mantem o status de conexao com o banco de dados
   private boolean connectedToDatabase = false;
   
   // O construtor inicializa o resultSet e obtem o objeto de metadados;
   // determina o numero de linhas
   public ResultSetTableModel(String url, String username,
      String password, String query) throws SQLException
   {         
      // Conecta-se ao banco de dados
      connection = DriverManager.getConnection(url, username, password);

      // Cria o Statement para consultar o banco de dados
      statement = connection.createStatement(
         ResultSet.TYPE_SCROLL_INSENSITIVE,
         ResultSet.CONCUR_READ_ONLY);

      // Atualiza o status da conexao com o banco
      connectedToDatabase = true;

      // Define a consulta e executa-a
      setQuery(query);
   } 

   // Obtém a classe que representa o tipo de coluna
   public Class getColumnClass(int column) throws IllegalStateException
   {
      // Verifica se a conexao com o banco esta disponivel
      if (!connectedToDatabase) 
         throw new IllegalStateException("Nao Conectado ao Banco de Dados");

      // Determina a classe Java da coluna
      try 
      {
         String className = metaData.getColumnClassName(column + 1);
         
         // Retorna o objeto Class que representa className
         return Class.forName(className);
      }
      catch (Exception exception) 
      {
         exception.printStackTrace();
      } 
      
      return Object.class; // Se ocorrerem problemas, assume o tipo Object
   } 

   // Obtém o numero de colunas no ResultSet
   public int getColumnCount() throws IllegalStateException
   {   
      // Verifica se a conexao com o banco esta disponivel
      if (!connectedToDatabase) 
         throw new IllegalStateException("Nao Conectado ao Banco de Dados");

      // Determina o numero de colunas
      try 
      {
         return metaData.getColumnCount(); 
      }
      catch (SQLException sqlException) 
      {
         sqlException.printStackTrace();
      } 
      
      return 0; // Se ocorrerem problemas, retorna 0 para o numero de colunas
   } 

   // Obtém o nome de uma coluna especifica no ResultSet
   public String getColumnName(int column) throws IllegalStateException
   {    
      // Verifica se a conexao com o banco esta disponivel
      if (!connectedToDatabase) 
         throw new IllegalStateException("Nao Conectado ao Banco de Dados");

      // Determina o nome da coluna
      try 
      {
         return metaData.getColumnName(column + 1);  
      } 
      catch (SQLException sqlException) 
      {
         sqlException.printStackTrace();
      } 
      
      return ""; // Se houver problemas, retorna uma string vazia para o nome da coluna
   } 

   // Retorna o numero de linhas no ResultSet
   public int getRowCount() throws IllegalStateException
   {      
      // Verifica se a conexao com o banco esta disponivel
      if (!connectedToDatabase) 
         throw new IllegalStateException("Nao Conectado ao Banco de Dados");
 
      return numberOfRows;
   }

   // Obtém o valor de uma linha e coluna especifica
   public Object getValueAt(int row, int column) 
      throws IllegalStateException
   {
      // Verifica se a conexao com o banco esta disponivel
      if (!connectedToDatabase) 
         throw new IllegalStateException("Nao Conectado ao Banco de Dados");

      // Obtém um valor da linha e coluna especificada no ResultSet
      try 
      {
         resultSet.absolute(row + 1);
         return resultSet.getObject(column + 1);
      }
      catch (SQLException sqlException) 
      {
         sqlException.printStackTrace();
      } 
      
      return ""; // Se houver problemas, retorna uma string vazia
   } 
   
   // Define uma nova string de consulta ao banco de dados
   public void setQuery(String query) 
      throws SQLException, IllegalStateException 
   {
      // Verifica se a conexao com o banco esta disponivel
      if (!connectedToDatabase) 
         throw new IllegalStateException("Nao Conectado ao Banco de Dados");

      // Especifica a consulta e executa-a
      resultSet = statement.executeQuery(query);

      // Obtém os metadados do ResultSet
      metaData = resultSet.getMetaData();

      // Determina o numero de linhas no ResultSet
      resultSet.last(); // Move para a ultima linha
      numberOfRows = resultSet.getRow(); // Obtém o numero da linha      
      
      // Notifica o JTable que o modelo foi alterado
      fireTableStructureChanged();
   } 

   // Fecha o Statement e a Conexao               
   public void disconnectFromDatabase()            
   {              

      if (connectedToDatabase)                   
      {
         // Fecha o Statement e a Conexao            
         try                                          
         {                                            

            resultSet.close();                        
            statement.close();                        
            connection.close();                       

         }                                  
         catch (SQLException sqlException)          
         {                                            

            sqlException.printStackTrace();           
         }                              
         finally  // Atualiza o status da conexao com o banco
         {                                            

            connectedToDatabase = false;              
         }                             
      } 
   }         
} // fim da classe ResultSetTableModel
