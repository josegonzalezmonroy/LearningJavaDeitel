import java.util.Scanner;

public class Exerc_7_38 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String[] memory = new String[1000];
        
        System.out.printf("*** Welcome to Simpletron! ***%n*** Please enter your program one instruction    ***%n*** (or data word) at a time. I will display     ***%n*** the location number and a question mark (?). ***%n*** You then type the word for that location.    ***%n*** Type -99999 to stop entering your program    ***%n");
        
        boolean sentinela = false;
        int counter = 0;
        int valorUsuario = 0;
        
        while (!sentinela) 
        {
            System.out.printf("%02d ? ", counter);
            valorUsuario = input.nextInt();
            
            if (valorUsuario != -99999)
            {
                while (!validaInteiro(valorUsuario, true))
                    valorUsuario = input.nextInt();

                memory[counter++] = decimalToHexa(valorUsuario);
            }
            else
            {
                sentinela = true;
                System.out.printf("*** Program loading completed ***%n*** Program execution begins  ***%n");
            }
        }
        int instructionCounter = 0;
        simpletron(memory, instructionCounter, input, valorUsuario);

        // calculos adicionais
        boolean additionalInstruction = true;

        while (additionalInstruction) 
        {
            System.out.println("*** Additional instruction ***\n*** Enter the memory location number where    ***\n*** you want to start the calculations        ***\n*** Type -99999 to stop entering your program ***");
            int additionalInstructionCounter = input.nextInt();// o usuario deve digitar uma posicao da memoria
            int start = additionalInstructionCounter;// o valor sera a posicao inicial pela qual o simpletron iniciara a leitura do sml

            boolean inserirDados = true;// sentinela

            if (additionalInstructionCounter != -99999)// se o valor inserido nao for o sentinela
            {
                while (inserirDados)// enquanto o sentinela for true
                {
                    System.out.printf("%02d ? ", additionalInstructionCounter);// mostra a posicao da memoria
                    valorUsuario = input.nextInt();// valor inserido pelo usuario
                    
                    if (valorUsuario != -99999)// se o resultado for diferente ao sentinela
                    {
                        while (!validaInteiro(valorUsuario, true))// valida
                        valorUsuario = input.nextInt();

                        // se for validado faz a atribuicao
                        memory[additionalInstructionCounter++] = decimalToHexa(valorUsuario);
                    }                    
                    else
                    {
                        inserirDados = false;// aciona o sentinela para sair do bucle
                        System.out.printf("*** Program loading completed ***%n*** Program execution begins  ***%n");// imprime a mensagem 
                    }  
                }
            simpletron(memory, start, input, valorUsuario);// executa o simpletron
            }
            else
            {
                additionalInstruction = false;// aciona o sentinela
                System.out.println("*** Simpletron execution terminated ***");// imprime a mensagem de saida do programa
            }
        }
    }

    public static void simpletron(String[] memory, int counter, Scanner input, int valorUsuario)
    {
        int accumulator = 0;
        
        for (int instructionCounter = counter; instructionCounter < memory.length; instructionCounter++)
        {
            int instructionRegister = hexaToDecimal(memory[instructionCounter]);
            int operationCode = instructionRegister / 100;// determina a operacao a realizar

            int operand = instructionRegister % 100;// determina a posicao destino da operacao

            switch (operationCode) 
            {
                case READ:
                System.out.print("Enter an integer ");
                    valorUsuario = input.nextInt();

                while (!validaInteiro(valorUsuario, true)) 
                    valorUsuario = input.nextInt();
                
                memory[operand] = decimalToHexa(valorUsuario);
                break;

                case WRITE:
                System.out.println(hexaToDecimal(memory[operand]));
                break;

                case LOAD:
                accumulator = hexaToDecimal(memory[operand]);
                if (estouroAcumulador(accumulator))
                {
                    imprimeDump(memory, accumulator, instructionCounter, instructionRegister, operationCode, operand);
                    return;
                }
                break;
                
                case STORE:
                memory[operand] = decimalToHexa(accumulator);
                break;

                case ADD:
                accumulator += hexaToDecimal(memory[operand]);
                if (estouroAcumulador(accumulator))
                {
                    imprimeDump(memory, accumulator, instructionCounter, instructionRegister, operationCode, operand);
                    return;
                }
                break;
                
                case SUBTRACT:
                accumulator -= hexaToDecimal(memory[operand]);
                if (estouroAcumulador(accumulator))
                {
                    imprimeDump(memory, accumulator, instructionCounter, instructionRegister, operationCode, operand);
                    return;
                }
                break;

                case DIVIDE:
                if (hexaToDecimal(memory[operand]) == 0)
                {
                    System.out.println("*** Attempt to divide by zero ***\n*** Simpletron execution abnormally terminated ***");
                    imprimeDump(memory, accumulator, instructionCounter, instructionRegister, operationCode, operand);
                    return;
                }
                if (estouroAcumulador(accumulator))
                {
                    imprimeDump(memory, accumulator, instructionCounter, instructionRegister, operationCode, operand);
                    return;
                }
                else
                    accumulator /= hexaToDecimal(memory[operand]);
                break;

                case MULTIPLY:
                accumulator *= hexaToDecimal(memory[operand]);
                if (estouroAcumulador(accumulator))
                {
                    imprimeDump(memory, accumulator, instructionCounter, instructionRegister, operationCode, operand);
                    return;
                }
                break;

                case EXPONENTIATION:
                int exp = accumulator;
                int vezes = hexaToDecimal(memory[operand]);

                if (vezes == 0)
                    accumulator = 1;
                else  
                {
                    for (int i = 1; i < vezes; i++)
                    {
                        accumulator *= exp;
                        
                        if (estouroAcumulador(accumulator))
                        {
                            imprimeDump(memory, accumulator, instructionCounter, instructionRegister, operationCode, operand);
                            return;
                        }
                    }
                }  
                break;

                case BRANCH:
                instructionCounter = operand - 1;
                break;

                case BRANCHNEG:
                if (accumulator < 0) 
                    instructionCounter = operand - 1;
                break;

                case BRANCHZERO:
                if (accumulator == 0)
                    instructionCounter = operand - 1;
                break;

                case HALT:
                System.out.println("*** Simpletron execution terminated ***");
                imprimeDump(memory, accumulator, instructionCounter, instructionRegister, operationCode, operand);
                return;

                default:
                if (operationCode != 0)
                {
                    System.out.println("*** Invalid operation code ***\n*** Simpletron execution abnormally terminated ***");
                    imprimeDump(memory, accumulator, instructionCounter, instructionRegister, operationCode, operand);
                    return;
                }
                break;
            }
        }
    }

    public static boolean estouroAcumulador(int accumulator)
    {
        if (!validaInteiro(accumulator, false))
        {
            System.out.println("*** Accumulator out of range ***\n*** Simpletron execution abnormally terminated ***");
            return true;
        }
        else 
            return false;
    }

    public static boolean validaInteiro(int valor, boolean imprime)
    {
        if (!(valor >= -9999 && valor <= 9999)) 
        {
            if (imprime)
                System.out.println("Please enter a valid integer between -9999 and 9999");
                
            return false;
        }
        return true;
    }
    
    public static void imprimeDump(String[] memory, int accumulator, int instructionCounter, int instructionRegister, int operationCode, int operand)
    {
        // imprime o dump
        System.out.println("\nREGISTERS:");
        if (accumulator < 0)
           System.out.printf("%-20s-%04d%n","accumulator", -(accumulator));
        else
            System.out.printf("%-20s+%04d%n","accumulator", accumulator);

        System.out.printf("%-23s%02d%n%-20s+%04d%n%-23s%02d%n%-23s%02d%nMEMORY:%n", "instructionCounter", instructionCounter, "instructionRegister", instructionRegister, "operationCode", operationCode, "operand", operand);

        System.out.print("    ");
        for (int j = 0; j < memory.length / 100; j++)
            System.out.printf("    %d ", j % (memory.length / 10));

        for (int i = 0; i < memory.length; i++)
        {
            if (i % 10 == 0)
            {
                System.out.println();
                if (i / 10 * 10 == 0)
                    System.out.print("  0 ");
                else if (i / 10 * 10 >= 10 && i / 10 * 10 <= 90)
                System.out.printf(" %02d ", i / 10 * 10);
                else 
                System.out.printf("%03d ", i / 10 * 10);
            }
            if (memory[i] != null)
            {
                System.out.printf("%-6s", memory[i]);  
            }
            else
                System.out.printf("%-6s" ,"+0000");
        }
        System.out.println("\n");
    }
    
    final static int READ = 10;
    final static int WRITE = 11;

    final static int LOAD = 20;
    final static int STORE = 21;

    final static int ADD = 30;
    final static int SUBTRACT = 31;
    final static int DIVIDE = 32;
    final static int MULTIPLY = 33;
    final static int EXPONENTIATION = 34;

    final static int BRANCH = 40;
    final static int BRANCHNEG = 41;
    final static int BRANCHZERO = 42;
    final static int HALT = 43;

    static final String[] caracterHexa = 
    {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
    };

    public static int hexaToDecimal(String hexadecimal)
    {
        String[] hexaStrings = hexadecimal.split("");
        int valorDecimal = 0;

        for (int i = 1; i < hexaStrings.length; i++)
        {
            for (int j = 1; j < caracterHexa.length; j++)
            {
                if (hexaStrings[i].equals(caracterHexa[j]))
                {   
                    int exp = (int) Math.pow(16, hexaStrings.length - i - 1);
                    valorDecimal += j * exp;
                }
            }
        }

        if (hexaStrings[0].equals("-"))
            return -(valorDecimal);
        else
            return valorDecimal;
    }

    public static String decimalToHexa(int valorDecimal)
    {
        String valorHexadecimal = "";
        String sinal = valorDecimal < 0 ? "-" : "+";

        if (valorDecimal < 0)
            valorDecimal = -(valorDecimal);
        
        while (valorDecimal > 0) 
        {
            valorHexadecimal = caracterHexa[valorDecimal % 16] + valorHexadecimal;
            valorDecimal = valorDecimal / 16;     
        }
        return sinal + valorHexadecimal;
    }  
}
