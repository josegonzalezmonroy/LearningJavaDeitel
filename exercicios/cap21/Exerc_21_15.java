// 21.15 - Simulação de Supermercado
/* Escreva um programa que simula uma fila de caixa em um supermercado. A fila é um objeto fila. Os clientes (isto é, os objetos cliente) chegam em intervalos aleatórios inteiros de 1 a 4 minutos. Além disso, cada cliente é atendido em intervalos aleatórios inteiros de 1 a 4 minutos. Obviamente, as taxas precisam ser equilibradas. Se a taxa média de chegada for maior que a taxa média de atendimento, a fila crescerá infinitamente. Mesmo com taxas "equilibradas", a aleatoriedade ainda pode provocar filas longas.

Execute a simulação de supermercado para um dia de 12 horas (720 minutos) utilizando o seguinte algoritmo:

a) Escolha um inteiro aleatório entre 1 e 4 para determinar o minuto em que o primeiro cliente chega.
b) Na hora da chegada do primeiro cliente, faça o seguinte:
    Determine o tempo de atendimento do serviço ao cliente (inteiro aleatório de 1 a 4).
    Comece atendendo o cliente.
    Agende a hora de chegada do próximo cliente (inteiro aleatório de 1 a 4 adicionado à hora atual).
c) Para cada minuto simulado do dia, considere o seguinte:
    Se o próximo cliente chegar, prosseguir da seguinte maneira:
        Expresse isso.
        Enfileire o cliente.
        Agende a hora de chegada do próximo cliente.
    Se o atendimento do último cliente tiver sido concluído, faça o seguinte:
        Expresse isso.
        Desenfileire o próximo cliente a ser atendido.
        Determine o tempo de atendimento do cliente (inteiro aleatório de 1 a 4 adicionado à hora atual).

Agora execute sua simulação para 720 minutos e responda a cada um dos seguintes itens:

a) Qual é o número máximo de clientes na fila a qualquer hora?
b) Qual é a espera mais longa que qualquer cliente experimenta?
c) O que acontece se o intervalo de chegada é alterado de 1 a 4 minutos para 1 a 3 minutos?
*/
import java.security.SecureRandom;
import com.deitel.datastructures.Queue;

public class Exerc_21_15 
{
    public static void main(String[] args) 
    {
        final int DURACAO = 720; // Duração da simulação em minutos (12 horas)
        final int INTERVALO = 4; // Intervalo máximo entre chegadas de clientes em minutos
        
        Queue<Cliente> fila = new Queue<>(); // Cria uma fila para armazenar os clientes
        SecureRandom random = new SecureRandom(); // Cria um gerador de números aleatórios
        
        int proximoClienteChegada = 1 + random.nextInt(INTERVALO); // Define o minuto em que o próximo cliente chega
        int maxClientesEmFila = 0; // Variável para rastrear o número máximo de clientes na fila
        int maiorTempoDeEspera = 0; // Variável para rastrear o maior tempo de espera de qualquer cliente
        int clientesAtendidos = 0; // Contador para o número total de clientes atendidos
        int tempoDeAtendimentoAtual = 0;  // Acompanhamento do tempo de atendimento atual do cliente sendo atendido
        
        for (int minutoAtual = 0; minutoAtual < DURACAO; minutoAtual++)
        {
            // Verificar se um novo cliente chega
            if (minutoAtual == proximoClienteChegada)
            {
                int tempoDeAtendimento = 1 + random.nextInt(INTERVALO);
                Cliente novoCliente = new Cliente(minutoAtual, tempoDeAtendimento);
                fila.enqueue(novoCliente);

                System.out.println("Cliente chegou no minuto " + minutoAtual + " com tempo de atendimento de " + tempoDeAtendimento + (tempoDeAtendimento == 1 ? " minuto" : " minutos"));

                // Agendar o próximo cliente
                proximoClienteChegada = minutoAtual + 1 + random.nextInt(INTERVALO);
            }

            // Verificar se um cliente está sendo atendido
            if (tempoDeAtendimentoAtual > 0)  // Se há um cliente em atendimento
            {
                tempoDeAtendimentoAtual--;  // Diminuir o tempo de atendimento restante

                // Se terminou o tempo de atendimento do cliente
                if (tempoDeAtendimentoAtual == 0 && !fila.isEmpty())
                {
                    Cliente clienteAtendido = fila.dequeue();
                    int tempoDeEspera = minutoAtual - clienteAtendido.tempoDeChegada;

                    // Atualizar o tempo de espera máximo
                    maiorTempoDeEspera = Math.max(maiorTempoDeEspera, tempoDeEspera);
                    System.out.println("Cliente atendido no minuto " + minutoAtual + " apos esperar " + tempoDeEspera + " minutos.");

                    // Iniciar atendimento do próximo cliente
                    if (!fila.isEmpty())  // Somente iniciar se houver mais clientes na fila
                    {
                        Cliente proximoCliente = fila.peek();  // Ver o próximo cliente sem removê-lo
                        tempoDeAtendimentoAtual = proximoCliente.tempoDeAtendimento;  // Estabelecer o tempo de atendimento
                    }
                    clientesAtendidos++;
                }
            }
            else if (!fila.isEmpty())  // Se não há cliente em atendimento e há clientes na fila
            {
                Cliente proximoCliente = fila.dequeue();  // Atender o próximo cliente
                tempoDeAtendimentoAtual = proximoCliente.tempoDeAtendimento;  // Estabelecer o tempo de atendimento
                int tempoDeEspera = minutoAtual - proximoCliente.tempoDeChegada;

                // Atualizar o tempo de espera máximo
                maiorTempoDeEspera = Math.max(maiorTempoDeEspera, tempoDeEspera);
                System.out.println("Cliente atendido no minuto " + minutoAtual + " apos esperar " + tempoDeEspera + " minutos.");
            }

            // Atualizar o número máximo de clientes na fila
            maxClientesEmFila = Math.max(maxClientesEmFila, fila.size());
        }

        // Resultados da simulação
        System.out.println("\n--- Resultados da Simulacao ---");
        System.out.println("Numero maximo de clientes na fila: " + maxClientesEmFila);
        System.out.println("Maior tempo de espera: " + maiorTempoDeEspera + " minutos");
        System.out.println("Numero total de clientes atendidos: " + clientesAtendidos);
    }      
}

class Cliente
{
    int tempoDeChegada;
    int tempoDeAtendimento;

    public Cliente(int tempoDeChegada, int tempoDeAtendimento)
    {
        this.tempoDeChegada = tempoDeChegada;
        this.tempoDeAtendimento = tempoDeAtendimento;
    }
}
