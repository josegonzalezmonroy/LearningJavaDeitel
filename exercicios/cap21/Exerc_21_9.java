// 21.9 - Copiando uma lista de trás para a frente
// Escreva um método static reverseCopy que recebe uma List como um argumento e retorna uma cópia dessa List com seus elementos invertidos. Teste esse método em um aplicativo.

public class Exerc_21_9 
{
    public static void main(String[] args) 
    {
        // Cria uma nova lista do tipo String
        List<String> lista = new List<>();
        
        // Adiciona elementos à lista
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add("D");
        lista.add("E");
        lista.add("F");
        
        // Imprime a lista original
        lista.print();

        // Cria uma nova lista com os elementos invertidos
        List<String> reverse = reverseCopy(lista);
        
        // Imprime a lista invertida
        reverse.print();
    } 

    // Metodo generico para inverter a lista
    public static <T> List<T> reverseCopy(List<T> lista)
    {
        // Cria uma nova lista para armazenar os elementos invertidos
        List<T> reversedList = new List<>();

        // Obtém o primeiro nodo da lista original
        ListNode<T> current = lista.getHead();

        // Percorre a lista original enquanto houver elementos
        while (current != null) 
        {
            // Cria um novo nodo com o dado atual
            ListNode<T> newList = new ListNode<>(current.data);

            // Aponta o novo nodo para o inicio da lista invertida
            newList.nextNode = reversedList.getHead();

            // Atualiza o inicio da lista invertida para o novo nodo
            reversedList.setHead(newList);

            // Avança para o próximo nodo na lista original
            current = current.nextNode;
        }
        // Retorna a lista invertida
        return reversedList;
    }   
}
