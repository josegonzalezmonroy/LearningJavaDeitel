// 7.10 - Comissões de vendas
// Utilize um array unidimensional para resolver o seguinte problema: uma empresa paga seu pessoal de vendas por comissão. O pessoal de vendas recebe $ 200 por semana mais 9% de suas vendas brutas durante essa semana. Por exemplo, um vendedor que vende $ 5.000 brutos em uma semana recebe $ 200 mais 9% de $ 5000 ou um total de $ 650. Escreva um aplicativo (utilizando um array de contadores) que determina quanto o pessoal de vendas ganhou em cada um dos seguintes intervalos (assuma que o salário de cada vendedor foi truncado para uma quantia inteira): a) $ 200-299 b) $ 300-399 c) $ 400-499 d) $ 500-599 e) $ 600-699 f) $ 700-799 g) $ 800-899 h) $ 900-999 i) $ 1000 e acima. Resuma os resulatados em formato tabular.
public class Exerc_7_10 
{
    public static void main(String[] args) 
    {
        int[] vendas = {10000, 8879, 9, 1550, 3046, 4054, 5065, 7080, 350, 2000, 7009, 0, 6500, 8500};// array con as vendas de cada funcionario

        int[] salarios = new int[9];// array para armazenar os intervalos dos salarios

        for (int venda : vendas)// armazena cada salario em um indice especifico do array vendas
        {
            if (salario(venda) >= 1000)// se for maior a 1000
                salarios[8]++;
            else
                salarios[salario(venda)/100 - 2]++;
        }
        
        System.out.printf("Salarios do setor de vendas%n%n");// titulo

        System.out.printf("%s%14s%n", "Intervalo", "Funcionarios");
        for (int grupo = 0; grupo < salarios.length; grupo++)
        {
            if (grupo == 8)
                System.out.printf(">= $1000%15d", salarios[grupo]);
            else
                System.out.printf("$%d00-%d99%15d%n", (grupo+2), (grupo+2), salarios[grupo]);
        }
    }

    public static int salario(int venda)// calcula o salario do funcionario dependendo do total de vendas
    {
        int valorfixo = 200;// valor fixo
        double comisao = 0.09;// comisão do 9% das vendas

        return (int)(venda * comisao + valorfixo);
    }
}
