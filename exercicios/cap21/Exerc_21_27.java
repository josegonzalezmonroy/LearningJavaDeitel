// 21.27 - Listas e filas sem referências de fim
// Nossa implementação de uma lista encadeada (Figura 21.3) utilizou tanto firstNode como lastNode. O lastNode foi útil para os métodos insertAtBack e removeFromBack da classe List. O método insertAtBack corresponde ao método enqueue da classe Queue. Reescreva a classe List de modo que ela não utilize um lastNode. Portanto, quaisquer operações no fim de uma lista devem começar pesquisando no início da lista. Isso afeta nossa implementação da classe Queue (Figura 21.13)?
import com.deitel.datastructures.List;

public class Exerc_21_27 
{
    public static void main(String[] args) 
    {
        // Cria uma nova lista
        List<String> lista = new List<>();
  
        // Teste: Inserir elementos no final da lista
        System.out.println("Inserindo elementos no final da lista:");
        lista.insertAtBack("A");
        lista.insertAtBack("B");
        lista.insertAtBack("C");
        lista.print(); // Espera-se: A B C
  
        // Teste: Inserir mais elementos no final
        System.out.println("Inserindo mais elementos no final:");
        lista.insertAtBack("D");
        lista.insertAtBack("E");
        lista.print(); 

        // Teste: Remover o primeiro elemento
        System.out.println("Removendo o primeiro elemento:");
        String removido = lista.removeFromFront();
        System.out.println("Elemento removido: " + removido); 
        lista.print(); 
  
        // Teste: Remover o elemento do final
        System.out.println("Removendo elemento do final:");
        removido = lista.removeFromBack();
        System.out.println("Elemento removido: " + removido); 
        lista.print(); 
  
        // Teste: Remover todos os elementos restantes do final
        System.out.println("Removendo todos os elementos restantes:");

        while (!lista.isEmpty()) 
        {
           System.out.println("Elemento removido: " + lista.removeFromBack());
           lista.print();
        }
  
        // Teste: Remover de uma lista vazia para verificar excecao
        System.out.println("Tentando remover de uma lista vazia:");
        try 
        {
           lista.removeFromBack();
        }
        catch (Exception e) 
        {
           System.out.println("Excecao capturada: " + e.getMessage()); // Espera-se mensagem de erro
        }
    }
}
