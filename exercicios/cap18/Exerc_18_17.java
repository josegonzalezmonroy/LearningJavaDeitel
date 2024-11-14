// 18.17 - Exibir um array de trás para a frente
// Escreva um método recursivo stringReverse que aceita um array de caracteres contendo uma string como um argumento e a exibe de trás para a frente. [Dica: utilize o método String toCharArray, que não aceita nenhum argumento, para obter um array char contendo os caracteres na String.]
public class Exerc_18_17 
{
    public static void main(String[] args) 
    {
        // Define a string que sera revertida
        String teste = "Hello";
        
        // Converte a string em um array de caracteres
        char[] lista = teste.toCharArray();

        // Chama o metodo recursivo para exibir a string de tras para frente
        stringReverse(lista);
    } 

    public static void stringReverse(char[] lista) 
    {
        // Chama a sobrecarga do metodo stringReverse, passando o array e o indice inicial (ultimo elemento do array)
        stringReverse(lista, lista.length - 1);
    }
    
    // Metodo recursivo que recebe o array e o indice do ultimo elemento
    public static void stringReverse(char[] lista, int index)
    {
        // Caso base: se o indice for menor que 0, a recursao para
        if (index < 0)
            return;

        // Exibe o caractere atual
        System.out.print(lista[index]);

        // Chama o metodo novamente para o proximo caractere (indice anterior)
        stringReverse(lista, index - 1);
    }
}
