// 8.13 - Conjunto de inteiros
/* 
Crie a classe IntegerSet. Cada objeto IntegerSet pode armazenar inteiros no intervalo de 0 a 100. O conjunto e representado por um array de booleans. O elemento do array a[i] e true se o inteiro i estiver no conjunto. O elemento do array a[j] e false se o inteiro j nao estiver no conjunto. O construtor sem argumento inicializa o array como um "conjunto vazio" (isto e, todos os valores false).

Forneca os seguintes metodos:

o metodo static union cria um conjunto que e a uniao teorica de dois conjuntos existentes (isto e, um elemento do array do novo conjunto e configurado como true se esse elemento for true em qualquer um dos conjuntos existentes ou em ambos — caso contrario, o elemento do novo conjunto e configurado como false).

O metodo static intersection cria um conjunto que e a intersecao teorica de dois conjuntos existentes (isto e, um elemento do array do novo conjunto e configurado como false se esse elemento for false em qualquer um ou em ambos os conjuntos existentes — caso contrario, o elemento do novo conjunto e configurado como true).

O metodo insertElement insere um novo inteiro k em um conjunto (configurando a[k] como true).

O metodo deleteElement exclui o inteiro m (configurando a[m] como false). O metodo toString retorna uma String contendo um conjunto como uma lista de numeros separados por espacos. Inclua somente os elementos que estao presentes no conjunto. Utilize --- para representar um conjunto vazio. O metodo isEqualTo determina se dois conjuntos sao iguais. Escreva um programa para testar a classe IntegerSet. Instancie varios objetos IntegerSet. Teste se todos os seus metodos funcionam adequadamente.
*/

public class Exerc_8_13 
{
    public static void main(String[] args) 
    {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.insertElement(0);
        set1.insertElement(10);
        set1.insertElement(100);
        System.out.println("Set1:" + set1);

        set2.insertElement(0);
        set2.insertElement(15);
        set2.insertElement(100);
        System.out.println("Set2:" + set2);

        System.out.println("Set1 == Set2: " + set1.isEqualTo(set2));
        IntegerSet union = IntegerSet.union(set1, set2);        
        IntegerSet intersection = IntegerSet.intersection(set1, set2);

        System.out.println("Uniao:" + union);
        System.out.println("Intersecao:" + intersection);

        try     
        {   
            IntegerSet set3 = new IntegerSet();
            set3.insertElement(-10);// Este valor está fora do intervalo permitido
        } 
        catch (Exception e) 
        {
            System.out.println("Error:\n" + e.getMessage());
        }

        set1.deleteElement(0);
        set1.deleteElement(10);
        set2.deleteElement(0);
        set2.deleteElement(15);

        System.out.println("Set1:" + set1);
        System.out.println("Set2:" + set2);

        System.out.println("Set1 == Set2: " + set1.isEqualTo(set2));
        intersection = IntegerSet.intersection(set1, set2);
        System.out.println("Intersecao:" + intersection);
    }    
}

class IntegerSet
{
    private boolean set[];

    public IntegerSet()// Construtor inicializa o conjunto como vazio
    {
        set = new boolean[101];
    }

    public boolean getElement(int value)// Retorna o valor do elemento no conjunto
    {
        return set[value];
    }

    public void insertElement(int value)// Insere um elemento no conjunto
    {
        if (value < 0 || value > 100)
            throw new IllegalArgumentException("Value (" + value + ") to be inserted must be between 0 and 100");

        this.set[value] = true;
    }

    public void deleteElement(int value)// Remove um elemento do conjunto
    {
        if (value < 0 || value > 100)
            throw new IllegalArgumentException("\"Value to be deleted must be between 0 and 100");

        this.set[value] = false;
    }

    public boolean isEqualTo(IntegerSet set2)// Verifica se este conjunto é igual a outro conjunto passado como argumento
    {
        for (int i = 0; i < set.length; i++)
            if (set[i] != set2.set[i])
                return false;// Se algum elemento for diferente, retorna false

        return true;// Se todos os elementos forem iguais, retorna true
    }

    public static IntegerSet union(IntegerSet set1, IntegerSet set2)// Método estático para criar a união de dois conjuntos
    {
        IntegerSet resultUnion = new IntegerSet();

        for (int i = 0; i < resultUnion.set.length; i++) 
        {
            resultUnion.set[i] = set1.set[i] || set2.set[i];
        }

        return resultUnion;
    }

    public static IntegerSet intersection(IntegerSet set1, IntegerSet set2)// Método estático para criar a interseção de dois conjuntos
    {
        IntegerSet resultIntersection = new IntegerSet();

        for (int i = 0; i < resultIntersection.set.length; i++)
        {
            resultIntersection.set[i] = set1.set[i] && set2.set[i];
        }

        return resultIntersection;
    }

    public String toString()
    {
        String value = "";

        for (int i = 0; i < set.length; i++)
            if (set[i] == true)
                value += " " + i;

        if (value.length() == 0)
            return " ---";

        return value;
    }
}
