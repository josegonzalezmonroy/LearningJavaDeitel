// 21.21 - Pesquisar recursivamente uma lista
// Modifique a classe List da Figura 21.3 para incluir o método search, que pesquisa recursivamente em um objeto de lista encadeada em um valor especificado. O método deve retornar uma referência ao valor se ele for encontrado; caso contrário, ele deve retornar null. Utilize seu método em um programa de teste que cria uma lista de inteiros. O programa deve solicitar ao usuário um valor para localizar na lista.
import com.deitel.datastructures.List;

public class Exerc_20_21 
{
    public static void main(String[] args) 
    {
        // Cria uma nova lista do tipo Integer chamada "list"
        List<Integer> list = new List<>("Array");
        
        // Insere elementos no final da lista
        list.insertAtBack(1);
        list.insertAtBack(5);
        list.insertAtBack(7);
        list.insertAtBack(8);
        list.insertAtBack(10);
        list.insertAtBack(12);

        // Imprime os elementos da lista
        list.print();
        // Busca o valor 10 na lista
        list.search(5);
        // Busca o valor 0 na lista (não deve encontrar)
        list.search(0);
    }   
}
