// 20.8 - Classe genérica Pair
// Escreva uma classe genérica Pair que tem dois parâmetros de tipo — F e S —, cada um representando o tipo do primeiro e segundo elemento do par, respectivamente. Adicione os métodos get e set ao primeiro e ao segundo elemento do par. [Dica: o cabeçalho da classe deve ser public class Pair< F, S >.]
public class Exerc_20_8 
{
    public static void main(String[] args) {
        // Cria um par com um inteiro e uma string
        Pair<Integer, String> pair = new Pair<>(1, "Hello");
        
        // Exibe o par
        System.out.println(pair); // Saída: Pair [first=1, second=Hello]
        
        // Altera os elementos do par   
        pair.setFirst(2);
        pair.setSecond("World");
        
        // Exibe o par atualizado
        System.out.println(pair); // Saída: Pair [first=2, second=World]
    }
}

// Classe genérica Pair que contém dois elementos de tipos F e S
class Pair<F, S> 
{
    // Elemento do par do tipo F
    private F first;  
    // Elemento do par do tipo S
    private S second; 

    // Construtor que inicializa os elementos do par
    public Pair(F first, S second) 
    {
        this.first = first;  // Inicializa o primeiro elemento
        this.second = second; // Inicializa o segundo elemento
    }

    // Método para obter o primeiro elemento do par
    public F getFirst() 
    {
        return first; // Retorna o primeiro elemento
    }

    // Método para definir o primeiro elemento do par
    public void setFirst(F first) 
    {
        this.first = first; // Atualiza o primeiro elemento
    }

    // Método para obter o segundo elemento do par
    public S getSecond() 
    {
        return second; // Retorna o segundo elemento
    }

    // Método para definir o segundo elemento do par
    public void setSecond(S second) 
    {
        this.second = second; // Atualiza o segundo elemento
    }

    // Método toString para representar o par como uma string
    @Override
    public String toString() 
    {
        return String.format("Pair [first=%s, second=%s]", first, second); // Formato da saída
    }
}

