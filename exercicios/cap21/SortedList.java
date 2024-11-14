class NodeList<T>
{
    T data; // Armazena os dados do nodo
    NodeList<T> nextNode; // Referencia para o proximo nodo na lista

    // Construtor que inicializa o nodo com os dados e referencia nula para o proximo nodo
    public NodeList(T data)
    {
        this(data, null);
    }

    // Construtor que inicializa o nodo com os dados e uma referencia para o proximo nodo
    public NodeList(T data, NodeList<T> node)
    {
        this.data = data;
        nextNode = node;
    }
}

public class SortedList<T extends Comparable<T>>
{
    private NodeList<T> node; // Referencia para o primeiro nodo da lista
    private String name; // Nome da lista, usado para identificacao e impressao

    // Construtor que inicializa a lista com um nome padrao
    public SortedList()
    {
        this("Sorted List");
    }

    // Construtor que inicializa a lista com o nome especificado
    public SortedList(String listName)
    {
        name = listName;
        node = null; // A lista comeca vazia
    }

    // Metodo para inserir um valor na lista de forma ordenada
    public void insertValue(T value) 
    {
        NodeList<T> current = node; // Nodo atual para percorrer a lista
        NodeList<T> previous = null; // Nodo anterior para rastrear a posicao de insercao
        
        // Percorre a lista enquanto o valor do nodo atual for menor ou igual ao valor a ser inserido
        while (current != null && value.compareTo(current.data) >= 0) 
        {
            previous = current;
            current = current.nextNode;
        }
        
        NodeList<T> newNode = new NodeList<>(value); // Cria um novo nodo com o valor fornecido

        // Se previous for nulo, significa que o novo nodo deve ser inserido no inicio
        if (previous == null) 
        {
            newNode.nextNode = node;
            node = newNode;
        } 
        // Caso contrario, insere o novo nodo entre previous e current
        else 
        {
            previous.nextNode = newNode;
            newNode.nextNode = current;
        }
    }

    public void merge(SortedList<T> otherList)
    {
        // Se a lista a ser mesclada estiver vazia, não faz nada
        if (otherList.isEmpty()) 
            return;    
    
        // Inicializa o nodo atual da outra lista
        NodeList<T> currentOther = otherList.node;
    
        // Percorre todos os elementos da outra lista
        while (currentOther != null)
        {
            // Insere o valor do nodo atual na lista atual
            insertValue(currentOther.data);
            // Avança para o próximo nodo da outra lista
            currentOther = currentOther.nextNode;
        }
    }
    
    // Metodo para imprimir o conteudo da lista
    public void print()
    {
        System.out.println(name); // Imprime o nome da lista

        if (isEmpty())
            System.out.println("Lista vazia");
        else
        {
            NodeList<T> current = node;
            
            // Percorre a lista e imprime os dados de cada nodo
            while (current != null) 
            {
                System.out.print(current.data + " ");
                current = current.nextNode;    
            }

            System.out.println(); // Nova linha apos imprimir todos os nodos
        }
    }

    public boolean isEmpty()
    {
        // Retorna verdadeiro se a lista estiver vazia (nodo inicial é nulo)
        return node == null;
    }
    
}
