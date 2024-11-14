// 21.20 - Imprimir recursivamente uma lista de trás para a frente
// Modifique a classe List da Figura 21.3 para incluir o método printListBackward, que gera recursivamente os itens em um objeto de lista encadeada na ordem inversa. Escreva um programa de teste que cria uma lista de inteiros e imprime a lista em ordem inversa.
import com.deitel.datastructures.List;

public class Exerc_21_20 
{
    public static void main(String[] args) 
    {
        List<Integer> list = new List<>("Array");
        
        list.insertAtBack(1);
        list.insertAtBack(5);
        list.insertAtBack(7);
        list.insertAtBack(8);
        list.insertAtBack(10);
        list.insertAtBack(12);

        list.print();
        list.printListBackward();

    }    
}
