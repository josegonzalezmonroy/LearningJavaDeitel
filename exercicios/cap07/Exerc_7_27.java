// 7.27 - Crivo de Eratóstenes 
// Um numero primo é qualquer inteiro maior que um que é igualmente divisível apenas por si mesmo e por 1. O crivo de Eratóstenes é um método de localizar números primos. Ele opera como segue: a) Crie um array booleano de tipo primitivo com todos os elementos inicializados como true. Os elementos do array com índices primos permanecerão true. Todos os outros elementos do array por fim são configurados como false. b) Iniciando o índice de array 2, determine se um dado elemento é true. Se for, faça um loop pelo restante do array e configure como false cada elemento cujo índice é múltiplo do índice para o elemento com valor true. Então continue o processo com o próximo elemento com valor true. Para o índice de array 2, todos os elementos alé do elemento 2 no array que tiverem que tiverem índices múltiplos de 2 (índices 4, 6, 8, 20 etc) serão configurados como false; para o índice de array 3, todos os elementos além do elemento 3 no array que tiverem múltiplos de 3 (índices 6, 9, 12, 15 etc) serão configurados como false; e assim por diante. Quando esse processo for concluído, os elementos de array que ainda forem true indicam que o índice é um número primo. Esses índices podem ser exibidos. Escreva um aplicativo que utiliza um array de 1000 elementos para determinar e exibir os números primos entre 2 e 999. Ignore elementos de array 0 e 1.

public class Exerc_7_27 
{
    public static void main(String[] args) 
    {
        // cria um array com 1000 elementos
        boolean[] primos = new boolean[1000];
        
        // inicializa cada elemento do array com valor  true
        for (int i = 0; i < primos.length; i++)
            primos[i] = true;

        // faz um loop pelo array, iniciando pelo numero 2 que é primo    
        for (int primo = 2; primo < primos.length; primo++)
            if (primos[primo])// se o valor for true
                for (int numero = primo + 1; numero < primos.length; numero++)// inicializa um loop a partir do seguinte numero e o avalia para saber si é divisivel
                    if (numero % primo == 0)// se for divisivel, nao é primo
                        primos[numero] = false;// muda o valor a false

        for (int valor = 2; valor < primos.length; valor++)
            if (primos[valor])// imprime cada valor true, ou seja cada numero primo
                System.out.printf("%2d ", valor);
    }        
}
