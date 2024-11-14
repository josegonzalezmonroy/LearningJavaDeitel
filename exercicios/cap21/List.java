class ListNode<T> 
{
    // Dado armazenado no nó
    T data;
    // Referencia para o proximo nó
    ListNode<T> nextNode;

    // Construtor para criar um nó com o dado fornecido
    public ListNode(T object)
    {
        this(object, null);
    }

    // Construtor para criar um nó com dado e referencia para o proximo nó
    public ListNode(T object, ListNode<T> node)
    {
        data = object;
        nextNode = node;
    }
}

public class List<T> 
{
    // Cabeça da lista encadeada, inicializada como null
    private ListNode<T> head = null;

    // Metodo para adicionar um novo elemento na lista
    public void add(T data)
    {
        // Cria um novo nó com o dado fornecido
        ListNode<T> newNode = new ListNode<>(data);

        // Se a lista estiver vazia, o novo nó se torna a cabeça
        if (head == null)
            head = newNode;
        else 
        {
            // Caso contrario, percorre a lista até o final
            ListNode<T> current = head;

            while (current.nextNode != null) 
            {
                current = current.nextNode;    
            }

            // Adiciona o novo nó ao final da lista
            current.nextNode = newNode;
        }
    }

    // Metodo para imprimir os elementos da lista
    public void print()
    {
        ListNode<T> current = head;

        // Percorre a lista e imprime cada elemento
        while (current != null) 
        {
            System.out.print(current.data + " ");
            current = current.nextNode;    
        }
        System.out.println(); // Nova linha ao final da impressao
    }

    // Metodo para obter a cabeça da lista
    public ListNode<T> getHead()
    {
        return head;
    }

    // Metodo protegido para definir a cabeça da lista
    protected void setHead(ListNode<T> head)
    {
        this.head = head;
    }    
}

class ListConcatenate
{
    // Metodo estatico para concatenar duas listas
    public static <T> void concatenate(List<T> list1, List<T> list2)
    {
        // Se a primeira lista estiver vazia, define a cabeça da lista1 como a cabeça da lista2
        if (list1.getHead() == null)
            list1.setHead(list2.getHead());
        else
        {
            // Caso contrario, percorre a lista1 ate o final
            ListNode<T> current = list1.getHead();

            while (current.nextNode != null)
            {
                current = current.nextNode;
            }

            // Adiciona a cabeça da lista2 ao final da lista1
            current.nextNode = list2.getHead();
        }
    }
}
