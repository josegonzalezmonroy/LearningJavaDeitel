// Figura 15.12 - JFileChooserDemo.java
// Demonstrando JFileChooser
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Fig_15_12 extends JFrame
{
    private final JTextArea outputArea;// exibe o conteudo do arquivo

    // configura a GUI
    public Fig_15_12() throws IOException
    {
        super("JFileChooser Demo");
        outputArea = new JTextArea();
        add(new JScrollPane(outputArea));// outputArea é rolavel
        analyzePath(); // obtem o Path do usuario e exibe informaçoes
    }

    // exibe informacoes sobre o arquivo ou diretorio que o usuario especifica 
    public void analyzePath() throws IOException
    {
        // obtem o Path para o arquivo ou diretorio selecionado pelo usuario 
        Path path = getFileOrDirectoryPath();

        if (path != null && Files.exists(path))// se existir, exibe as informacoes
        {
            // coleta as informacoes sobre o arquivo (ou diretorio)
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%s:%n", path.getFileName()));
            builder.append(String.format("%s a directory%n", 
                Files.isDirectory(path) ? "Is" : "Is not"));
            builder.append(String.format("%s an absolute path%n",
                path.isAbsolute() ? "Is" : "Is not"));
            builder.append(String.format("Last modified: %s%n", 
                Files.getLastModifiedTime(path)));
            builder.append(String.format("Size: %s%n", Files.size(path)));
            builder.append(String.format("Path: %s%n", path));
            builder.append(String.format("Absolute path: %s%n", 
                path.toAbsolutePath()));
            
            if (Files.isDirectory(path))// listagem de diretorio de saida
            {
                builder.append(String.format("%nDirectory contents:%n"));

                // objeto para iteracao pelo conteudo de um diretorio
                DirectoryStream<Path> directoryStream = 
                    Files.newDirectoryStream(path);
                
                for (Path p : directoryStream)
                    builder.append(String.format("%s%n", p));
            }

            outputArea.setText(builder.toString());// exibe o conteudo de String
        }
        else // Path nao existe
        {
            JOptionPane.showMessageDialog(this, path.getFileName() + 
                " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // permite que o usuario especifique o nome de arquivo ou diretorio
    private Path getFileOrDirectoryPath()
    {
        // configura o dialogo permitindo a selecao de um arquivo ou diretorio
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(
            JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this);

        // se o usuario clicou no botao cancel no dialogo, retorna
        if (result == JFileChooser.CANCEL_OPTION)
            System.exit(1);
        
        // retorna o Path representando o arquivo selecionado
        return fileChooser.getSelectedFile().toPath();
    } 
}
