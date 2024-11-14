// 21.10 - Imprimindo uma frase na ordem inversa usando um pilha
// Escreva um programa que insere uma linha de texto e usa uma pilha para exibir as palavras da linha na ordem inversa.
import java.util.Scanner;

public class Exerc_21_10 
{
    public static void main(String[] args) 
    {
        // Cria um objeto Scanner para receber a entrada do usuario
        Scanner input = new Scanner(System.in);
        
        // Solicita ao usuario que digite uma frase
        System.out.print("Digite uma frase: ");
        String frase = input.nextLine();     
        
        // Divide a frase em palavras usando espacos como delimitadores
        String[] fraseInversa = frase.split(" ");

        // Cria uma pilha para armazenar as palavras
        Stack<String> pilha = new Stack<>();

        // Adiciona cada palavra da frase na pilha
        for (String palavra : fraseInversa)
            pilha.push(palavra);

        // Exibe a pilha (palavras na ordem inversa)
        pilha.print();
    }    
}

