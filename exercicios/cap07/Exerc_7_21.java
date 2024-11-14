// 7.21 - Gráficos de tartaruga
/* 
A linguagem Logo tornou famoso o conceito de gráfocos de tartaruga. Imagine uma tartaruga mecânica que caminha no lugar sob o controle de um aplicativo Java. A tartaruga segura uma caneta em uma de duas posições, para cima ou para baixo. Enquanto a caneta está para baixo a tartaruga desenha formas à medida que se move, e enquanto a caneta está para cima a tartaruga se move quase livremente sem escrever nada. Nesse problema, você simulará a operação da tartaruga e criará um bloco de rascunho computadorizado. Utilize um array de 20 por 20 'floor' que é inicializado com zeros. Leia comandos a partir de um array que contenha esses comandos. Monitore a posição atual da tartaruga todas as vezes e se a caneta está atualmente para cima ou para baixo. Suponha que a tartaruga inicia sempre na posição (0,0) do chão com sua caneta para cima. O conjunto de comandos de tartaruga que seu aplicativo deve processar é mostrado na figura 7.31.

                 Comando     Significado
                 1           Caneta para cima
                 2           Caneta para baixo
                 3           Vira para a direita
                 4           Vira para a esquerda
                 5,10        Avance 10 espaços (substitua 10 por um número diferente de espaços)                  6           Exiba o array 20 por 20
                 9           Fim dos dados (sentinela)
                
Escreva um aplicativo para implementar as capacidadesdos gráficos de tartaruga discutidos aqui. Escreva vários programas de gráfico de tartaruga para desenhar formas interessantes. Adicione outros comandos para aumentar a capacidade de sua linguagem de gráfico de tartaruga.
 */

import java.util.Scanner;

public class Exerc_7_21 
{
    public static int orientacaoTartaruga = 0;
    public static void main(String[] args) 
    {
        // variaveis inicializadas
        Scanner input = new Scanner(System.in);
        int[][] floor = new int[20][20];
        int linha = 0;
        int coluna = 0;
        boolean sentinela = false;
        boolean virar = true;// true: modifica coluna; false: modifica linha
        boolean caneta = true;

        while (!sentinela)// enquanto sentinela seja false
        {
            // Imprime as instruções
            System.out.printf("%nDigite un valor:%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n","Comando\tSignificado","1\tCaneta para cima", "2\tCaneta para baixo", "3\tVira para a direita", "4\tVira para a esquerda", "5,10\tAvance 10 espacos (substitua 10 por um numero diferente de espacos )", "6\tExiba o grafico", "9\tFechar o programa");

            double comando = input.nextDouble();// comando inserido pelo usuario
            int valor = (int) comando / 1;//  5.12 --> 5
            int pasos = (int) Math.round((comando % 1) * 100);//  5.12 --> 12
            int orientacao = orientacao(valor);

            if (valor == 9)// fecha o programa
            {
                System.out.println("Ok, saindo!");
                sentinela = true;
            }
            else if (valor == 1)// caneta para cima
                caneta = false;
            else if (valor == 2)// caneta para baixo
                caneta = true;
            else if (valor == 3 || valor == 4)// vira 
                virar = !virar;
            else if (valor == 6)// exibe o array
                imprimeGrafico(floor);
            else 
                if (valor != 5)// se o comando inserido é diferente das opcões exigidas pelo programa
                System.out.println("Valor nao valido");

            if (virar)// se virar for true
            {
                if (orientacao == 0 || orientacao == 1)
                {    
                    // coluna soma
                    if (pasos + coluna < floor[linha].length)
                    {   
                        for (int avanca = 0; avanca <= pasos; avanca++)
                            if (caneta)
                                floor[linha][coluna + avanca] = 1;
            
                        coluna += pasos;   
                    }
                    else // se o usuario tenta avancar mais do permitido
                        if (coluna == floor[linha].length - 1)
                            System.out.println("Nao e possivel avancar mais, tente virar");
                        else
                            System.out.printf("So pode avancar ate %d pasos%n", (floor[linha].length - coluna - 1));
                }
                else
                {   
                    if (coluna - pasos >= 0)
                    {
                        // coluna resta
                        for (int avanca = 0; avanca <= pasos; avanca++)
                            if (caneta == true)
                                floor[linha][coluna - avanca] = 1;
                        coluna -= pasos;  
                    }
                    else // se o usuario tenta avancar mais do permitido
                        if (coluna == 0)
                            System.out.println("Nao e possivel avancar mais, tente virar");   
                        else
                            System.out.printf("So pode avancar ate %d pasos%n", coluna);
                }
            }
            else // se virar for false
            {
                if (orientacao == 0 || orientacao == 1)
                {    
                    // linha soma
                    if (pasos + linha < floor.length)
                    {
                        for (int avanca = 0; avanca <= pasos; avanca++)
                            if (caneta == true)
                            floor[linha + avanca][coluna] = 1;

                        linha += pasos;
                    }
                    else // se o usuario tenta avancar mais do permitido
                        if (linha == floor.length - 1)
                            System.out.println("Nao e possivel avancar mais, tente virar");
                        else
                            System.out.printf("So pode avancar ate %d pasos%n", (floor.length - linha - 1));
                }
                else
                {    
                    if (linha - pasos >= 0)
                    {
                        // linha resta
                        for (int avanca = 0; avanca <= pasos; avanca++)
                            if (caneta == true)
                            floor[linha - avanca][coluna] = 1;
        
                        linha -= pasos;
                    }
                    else // se o usuario tenta avancar mais do permitido
                        if (linha == 0)
                            System.out.println("Nao e possivel avancar mais, tente virar");
                        else
                            System.out.printf("So pode avancar ate %d pasos%n", linha);
                }
            }

        }
    }

    public static void imprimeGrafico(int[][] floor)// Imprime o grafico
    {
        // Borda superior
        for (int linha = 0; linha < floor.length+2; linha++)
            System.out.printf("%s ", "#");
        System.out.println();

        // Imprime a parte interna
        for (int linha = 0; linha < floor.length; linha++)
        {
            // Borda lateral esquerda
            System.out.printf("%s ", "#");
            for (int coluna = 0; coluna < floor[linha].length; coluna++)
            {   
                if (floor[linha][coluna] == 1)
                    System.out.printf("%s ", "*");
                else
                    System.out.printf("%s ", " ");
            }
            // Borda lateral direita
            System.out.printf("%s ", "#");
            System.out.println();
        }

        // Borda inferior
        for (int linha = 0; linha < floor.length + 2; linha++)
            System.out.printf("%s ", "#");
        System.out.println();

    }
    public static int orientacao(int comando)// para saber a orientação da tartaruga
    {
        // soma 
        if (comando == 3)
            orientacaoTartaruga++;
        if (orientacaoTartaruga == 4)
            orientacaoTartaruga = 0;
        
        // substrai
        if (comando == 4)
            orientacaoTartaruga--;
        if (orientacaoTartaruga == -1)
            orientacaoTartaruga = 3;

        return orientacaoTartaruga;
    }    
}
