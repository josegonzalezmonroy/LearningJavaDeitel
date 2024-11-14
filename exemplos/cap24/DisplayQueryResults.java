// Fig. 24.28: DisplayQueryResults.java
// Exibe os resultados de varias consultas.
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class DisplayQueryResults extends JFrame 
{
   // URL do banco de dados, usuario e senha
   private static final String DATABASE_URL = "jdbc:derby:books";
   private static final String USERNAME = "deitel";
   private static final String PASSWORD = "deitel";
   
   // consulta padrao que retorna todos os dados da tabela authors
   private static final String DEFAULT_QUERY = "SELECT * FROM authors";
   
   private static ResultSetTableModel tableModel;

   public static void main(String args[]) 
   {   
      // cria ResultSetTableModel e exibe a tabela do banco de dados
      try 
      {
         // cria TableModel para os resultados da consulta SELECT * FROM authors
         tableModel = new ResultSetTableModel(
            DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);

         // configura JTextArea onde o usuario digita as consultas
         final JTextArea queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
         queryArea.setWrapStyleWord(true);
         queryArea.setLineWrap(true);
         
         JScrollPane scrollPane = new JScrollPane(queryArea,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
         
         // configura JButton para submeter as consultas
         JButton submitButton = new JButton("Submeter Consulta");

         // cria Box para gerenciar o posicionamento de queryArea e 
         // submitButton na interface grafica
         Box boxNorth = Box.createHorizontalBox();
         boxNorth.add(scrollPane);
         boxNorth.add(submitButton);

         // cria JTable com base no tableModel
         JTable resultTable = new JTable(tableModel);
         
         JLabel filterLabel = new JLabel("Filtro:");
         final JTextField filterText = new JTextField();
         JButton filterButton = new JButton("Aplicar Filtro");
         Box boxSouth = Box.createHorizontalBox();
         
         boxSouth.add(filterLabel);
         boxSouth.add(filterText);
         boxSouth.add(filterButton);
         
         // coloca os componentes da interface no painel de conteudo do JFrame
         JFrame window = new JFrame("Exibindo Resultados da Consulta");
         window.add(boxNorth, BorderLayout.NORTH);
         window.add(new JScrollPane(resultTable), BorderLayout.CENTER);
         window.add(boxSouth, BorderLayout.SOUTH);

         // cria o ouvinte de eventos para submitButton
         submitButton.addActionListener(        
            new ActionListener() 
            {
               public void actionPerformed(ActionEvent event)
               {
                  // realiza uma nova consulta
                  try 
                  {
                     tableModel.setQuery(queryArea.getText());
                  }
                  catch (SQLException sqlException) 
                  {
                     JOptionPane.showMessageDialog(null, 
                        sqlException.getMessage(), "Erro no Banco de Dados", 
                        JOptionPane.ERROR_MESSAGE);
                     
                     // tenta recuperar de uma consulta invalida
                     // executando a consulta padrao
                     try 
                     {
                        tableModel.setQuery(DEFAULT_QUERY);
                        queryArea.setText(DEFAULT_QUERY);
                     } 
                     catch (SQLException sqlException2) 
                     {
                        JOptionPane.showMessageDialog(null, 
                           sqlException2.getMessage(), "Erro no Banco de Dados", 
                           JOptionPane.ERROR_MESSAGE);
         
                        // garante que a conexao com o banco seja fechada
                        tableModel.disconnectFromDatabase();
         
                        System.exit(1); // termina a aplicacao
                     }                 
                  } 
               } 
            }         
         ); // fim da chamada para addActionListener
         
         final TableRowSorter<TableModel> sorter = 
            new TableRowSorter<TableModel>(tableModel);
         resultTable.setRowSorter(sorter);
         
         // cria ouvinte de eventos para filterButton
         filterButton.addActionListener(           
            new ActionListener() 
            {
               // passa o texto do filtro para o ouvinte
               public void actionPerformed(ActionEvent e) 
               {
                  String text = filterText.getText();

                  if (text.length() == 0)
                     sorter.setRowFilter(null);
                  else
                  {
                     try
                     {
                        sorter.setRowFilter(
                           RowFilter.regexFilter(text));
                     } 
                     catch (PatternSyntaxException pse) 
                     {
                        JOptionPane.showMessageDialog(null,
                           "Padrao regex invalido", "Padrao regex invalido",
                           JOptionPane.ERROR_MESSAGE);
                     }
                  } 
               } 
            } 
         ); // fim da chamada para addActionListener

         // dispensa a janela quando o usuario fecha a aplicacao (isso substitui
         // o comportamento padrao de HIDE_ON_CLOSE)
         window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         window.setSize(500, 250); 
         window.setVisible(true); 
         
         // garante que o banco de dados seja fechado quando o usuario sair da aplicacao
         window.addWindowListener(
            new WindowAdapter() 
            {
               public void windowClosed(WindowEvent event)
               {
                  tableModel.disconnectFromDatabase();
                  System.exit(0);
               } 
            } 
         ); 
      } 
      catch (SQLException sqlException) 
      {
         JOptionPane.showMessageDialog(null, sqlException.getMessage(), 
            "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
         tableModel.disconnectFromDatabase();
         System.exit(1); // termina a aplicacao
      }     
   } 
} // fim da classe DisplayQueryResults
