// Figura 15.13 - JFileChooserTest.java
// Testa a classe JFileChooserDemo
import java.io.IOException;
import javax.swing.JFrame;

public class Fig_15_13 
{
    public static void main(String[] args) throws IOException 
    {
        Fig_15_12 application = new Fig_15_12();
        application.setSize(400, 400);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setVisible(true);
    }    
}// fim da classe JFileChooserTest
