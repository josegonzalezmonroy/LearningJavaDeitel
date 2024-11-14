// Figura 3.13 - NameDialog.java
// Obtendo entrada do usuário a partir de um diálogo.
import javax.swing.JOptionPane;

public class NameDialog
{
   public static void main(String[] args)
   {
      // solicita ao usuário que insira o nome
      String name = JOptionPane.showInputDialog("Qual é o seu nome?");
      
      // cria a mensagem
      String message =                                              
         String.format("Bem-vindo, %s, ao Java Programming!", name);

      // exibe a mensagem para dar boas-vindas ao usuário pelo nome 
      JOptionPane.showMessageDialog(null, message);
   } 
} // fim da classe NameDialog
