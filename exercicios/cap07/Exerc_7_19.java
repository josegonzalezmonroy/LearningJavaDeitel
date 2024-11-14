// 7.19 - Sistema de reservas de passagens aéreas
// Uma pequena companhia aérea acabou de comprar um computador para seu novo sistema automatizado de reservas. Você foi solicitado a desenvolver o novo sistema. Você escreverá um aplicativo para atribuir assentos em cada vôo da companhia aérea para somente um avião (capacidade: dez acentos). Seu aplicativo deve exibir as seguintes alternativas: 'Please type 1 for first class' e 'Please type 2 for Economy' [Por favor digite 1 para Primeira classe e Por favor digite 2 para Classe Econômica]. Se o usuário digitar 1, seu aplicativo deve atribuir assentos na primeira classe (poltronas 1-5). Se o usuário digitar 2, seu aplicativo deve atribuir um assento na classe econômica (poltronas 6-10). Em seguida, seu aplicativo deve exibir um cartão de embarque indicando o número da poltrona da pessoa e se ela está na primeira classe ou na classe econômica. Utilize um array unidimensional do tipo primitivo boolean para representar o gráfico de assentos do avião. Inicialize todos os elementos do array como false para indicar que todas as poltronas estão desocupadas. À medida que cada assento é atribuido, configure os assentos correspondentes do array como true para indicar que o assento não está mais disponível. Seu aplicativo nunca deve atribuir uma poltrona que já foi reservada. Quando a classe econômica estiver lotada, seu aplicativo deve perguntar à pessoa se ela aceita ficar na primeira classe (e vice-versa). Se sim, faça a atribuição apropriada de assento. Se não, exiba a mensagem "Next flight leaves in 3 hours" [O próximo vôo parte em 3 horas].
import java.util.Scanner;

public class Exerc_7_19 
{
    static boolean[] aviao = new boolean[10];// cria um array de boolean (false por padrao)
    public static void main(String[] args) 
    {    
        Scanner input = new Scanner(System.in);
    
        int opcao = 3;// variavel inicializada com un numero diferente a 0, 1 e 2

        exibePoltronas(aviao);// exibe as poltronas no inicio do programa para ver as disponibilidades

        while (opcao != 0)// o numero 0 encerra o programa
        {
            disponibilidade(opcao);// verifica a disponiilidade na classe escolhida

            if (vagasNoAviao(aviao) == 0)// se acabarem as vagas no aviao
            {
                System.out.println("Aviao lotado, sem poltronas disponiveis!\n");
                break;// encerra o programa 
            }

            System.out.print("Por favor digite\n1 para Primeira Classe\n2 para Classe Economica\n0 para sair\n");// mensagem para escolher uma opcao de classe
            opcao = input.nextInt();// dado inserido pelo usuario
        }

        if (vagasNoAviao(aviao) != 0)// se existen vagas ainda disponiveis
            exibePoltronas(aviao);// exibe as poltronas no final do programa para ver as disponibilidades

        System.out.println("O proximo voo parte em 3 horas");// mensagem mostrada antes de encerrar o programa
    }

    public static int vagasNoAviao(boolean[] aviao)// Verifica se ainda tem vagas no aviao todo
    {
        int vagas = 0;// acumulador de poltronas disponiveis

        for (int i = 0; i < aviao.length; i++)
        {
            if (aviao[i] == false)
                vagas++;
        }
        return vagas;// retorna a quantidade de poltronas disponiveis
    }
       
    public static boolean disponibilidade(int opcao)// verifica a disponibilidade das poltronas no aviao dependendo do tipo de classe
    {
        // variaveis inicializadas
        boolean resposta = false;
        int i = 0;// contador 
        int j = 0;// .length
        String mensagem = "";

        if (opcao == 1)// se a opcao e primeira classe
        {
            i = 0;
            j = aviao.length / 2;
            mensagem = "Primeira classe sem poltronas disponiveis,\naceita ficar na classe economica?\n";
        }

        if (opcao == 2)// ou se e classe economica
        {
            i = 5; 
            j = aviao.length;
            mensagem = "Classe economica sem poltronas disponiveis,\naceita ficar em primeira classe?\n";
        }

        for (;i < j; i++)// faz o loop pelo array dependendo da opcao
        {   
            if (aviao[i] == false)// se estiver disponivel
            {
                resposta = true;
                aviao[i] = true;// reserva a poltrona
                cartaoDeEmbarque(i);
                break;           
            }
            else
                if (i == j - 1)
                System.out.println(mensagem);
        }
        return resposta;        
    }

    public static void cartaoDeEmbarque(int passagem)// imprime as informacoes de numero de poltrona e tipo de classe
    {
        System.out.printf("%-30s%n%-30s%n%s%02d%n", "------------------------------","Reserva feita com sucesso!", "Numero da poltrona: ", (passagem + 1));

        if (passagem < aviao.length / 2)
            System.out.println("Primeira classe");
        else
            System.out.println("Classe Economica");
        
        System.out.printf("%30s%n", "------------------------------");
    }
    
    public static void exibePoltronas(boolean[] aviao)// metodo para exibir as poltronas do aviao
    {
        for (int assento = 0; assento < aviao.length; assento++)
        {
            if (assento == 0)
            System.out.println("Primeira classe");
            if (assento == aviao.length / 2)
            System.out.println("\nClasse Economica");

            System.out.printf("Poltrona %02d: ", (assento + 1));
            if (aviao[assento] == true)
                System.out.println("RESERVADO");
            else
                System.out.println("Disponivel");
        }
        System.out.println();
    }
}
