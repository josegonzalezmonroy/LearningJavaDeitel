// 7.38 - Simulador de computador
import java.util.Scanner;

public class Exerc_7_37 
{
    public static void main(String[] args) 
    {
        
        Scanner input = new Scanner(System.in);
        int[] memory = new int[100];
        
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

                memory[counter++] = valorUsuario;
            }
            else
            {
                sentinela = true;
                System.out.printf("*** Program loading completed ***%n*** Program execution begins  ***%n");
            }
        }

        int accumulator = 0;
        for (int instructionCounter = 0; instructionCounter < memory.length; instructionCounter++)
        {
            int instructionRegister = memory[instructionCounter];
            int operationCode = instructionRegister / 100;// determina a operacao a realizar

            int operand = instructionRegister % 100;// determina a posicao destino da operacao

            switch (operationCode) 
            {
                case READ:
                System.out.print("Enter an integer ");
                    valorUsuario = input.nextInt();

                while (!validaInteiro(valorUsuario, true)) 
                    valorUsuario = input.nextInt();
                
                memory[operand] = valorUsuario;
                break;

                case WRITE:
                System.out.println(memory[operand]);
                break;

                case LOAD:
                accumulator = memory[operand];
                break;
                
                case STORE:
                memory[operand] = accumulator;
                if (!validaInteiro(accumulator, false))
                {
                    System.out.println("*** Accumulator out of range ***\n*** Simpletron execution abnormally terminated ***");
                    imprimeDump(memory, accumulator, instructionCounter, instructionRegister, operationCode, operand);
                    return;
                }
                break;

                case ADD:
                accumulator += memory[operand];
                break;
                
                case SUBTRACT:
                accumulator -= memory[operand];
                break;

                case DIVIDE:
                if (memory[operand] == 0)
                {
                    System.out.println("*** Attempt to divide by zero ***\n*** Simpletron execution abnormally terminated ***");
                    imprimeDump(memory, accumulator, instructionCounter, instructionRegister, operationCode, operand);
                    return;
                }
                else
                    accumulator /= memory[operand];
                break;

                case MULTIPLY:
                accumulator *= memory[operand];
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
    
    public static void imprimeDump(int[] memory, int accumulator, int instructionCounter, int instructionRegister, int operationCode, int operand)
    {
        // imprime o dump
        System.out.println("\nREGISTERS:");
        if (accumulator < 0)
           System.out.printf("%-20s-%04d%n","accumulator", -(accumulator));
        else
            System.out.printf("%-20s+%04d%n","accumulator", accumulator);

        System.out.printf("%-23s%02d%n%-20s+%04d%n%-23s%02d%n%-23s%02d%nMEMORY:%n", "instructionCounter", instructionCounter, "instructionRegister", instructionRegister, "operationCode", operationCode, "operand", operand);

        System.out.print("   ");
        for (int j = 0; j < memory.length / 10; j++)
            System.out.printf("    %d ", j % (memory.length / 10));

        for (int i = 0; i < memory.length; i++)
        {
            if (i % 10 == 0)
            {
                System.out.println();
                if (i / 10 * 10 == 0)
                    System.out.print(" 0 ");
                else 
                    System.out.printf("%02d ", i / 10 * 10);
            }
            if (memory[i] < 0)
            System.out.printf("-%04d ", -(memory[i]));  
            else
            System.out.printf("+%04d ", memory[i]);  
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
    final static int MEDIA = 34;

    final static int BRANCH = 40;
    final static int BRANCHNEG = 41;
    final static int BRANCHZERO = 42;
    final static int HALT = 43;

}   
