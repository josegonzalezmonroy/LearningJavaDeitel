//4.32 - Padrao de tabuleiro de damas de asteriscos
// Subtituido os asteriscos por letras B = black e W = white

public class Damas 
{
    public static void main(String[] args) 
    {
        int counter = 1;
        int tabuleiro = 1;
        
        while (tabuleiro <= 4) 
        {  
            while (counter <= 4) 
            {
                System.out.print("W ");
                System.out.print("B ");
                counter++;    
            }
            System.out.println();
            counter = 1;
            
            while (counter <= 4) 
            {
                System.out.print("B ");
                System.out.print("W ");  
                counter++;
            }
            System.out.println();
            counter = 1;

            tabuleiro++;
        }
    }
    
}