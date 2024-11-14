// 8.16 - Classe Huge Integer 
// Crie uma classe HugeInteger que utiliza um array de 40 elementos de digitos para armazenar inteiros com ate 40 digitos. Forneca os metodos parse, toString, add e subtract. O metodo parse deve receber uma String, extrair cada digito usando o metodo charAt e colocar o valor inteiro equivalente de cada digito no array de inteiros. Para comparar objetos HugeInteger, forneca os metodos a seguir: isEqualTo, isNotEqualTo, isGreaterThan, isLessThan, isGreaterThanOrEqualTo e isLessThanOrEqualTo. Cada um destes e um metodo predicado que retorna true se o relacionamento estiver contido entre os dois objetos HugeInteger e retorna false se o relacionamento nao estiver contido. Forneca um metodo predicado isZero. Se voce se sentir ambicioso, forneca tambem os metodos multiply, divide e remainder. [Observacao: valores boolean primitivos podem ser gerados como as palavras "true" ou "false" com o especificador de formato %b.]

import java.util.Arrays;

public class Exerc_8_16 
{
    public static void main(String[] args) 
    {
        HugeInteger number1 = new HugeInteger();
        HugeInteger number2 = new HugeInteger();

        // Teste 0: Suma de um número positivo menor com um número negativo maior
        number1.parse("12345");// Número positivo menor
        number2.parse("-67890");// Número negativo maior

        // Teste 1: Soma de números pequenos
        number1.parse("123");
        number2.parse("456");
        number1.add(number2);
        System.out.println("Teste 1 - Soma: " + number1); // Esperado: 579
        
        // Teste 2: Subtração de números pequenos
        number1.parse("456");
        number2.parse("123");
        number1.subtract(number2);
        System.out.println("Teste 2 - Subtração: " + number1); // Esperado: 333
        
        // Teste 3: Subtração onde o resultado é negativo
        number1.parse("123");
        number2.parse("456");
        number1.subtract(number2);
        System.out.println("Teste 3 - Subtração Negativa: " + number1); // Esperado: -333
        
        // Teste 4: Soma com carry
        number1.parse("999");
        number2.parse("1");
        number1.add(number2);
        System.out.println("Teste 4 - Soma com Carry: " + number1); // Esperado: 1000

        // Teste 5: Subtração de zero
        number1.parse("0");
        number2.parse("123");
        number1.subtract(number2);
        System.out.println("Teste 5 - Subtração de Zero: " + number1); // Esperado: -123

        // Teste 6: Subtração com resultado zero
        number1.parse("123");
        number2.parse("123");
        number1.subtract(number2);
        System.out.println("Teste 6 - Subtração com Resultado Zero: " + number1); // Esperado: 0

        // Teste 7: Comparações
        number1.parse("123");
        number2.parse("456");
        System.out.println("Teste 7 - number1 igual a number2: " + number1.isEqualTo(number2)); // Esperado: false
        System.out.println("Teste 7 - number1 não igual a number2: " + number1.isNotEqualTo(number2)); // Esperado: true
        System.out.println("Teste 7 - number1 maior que number2: " + number1.isGreaterThan(number2)); // Esperado: false
        System.out.println("Teste 7 - number1 menor que number2: " + number1.isLessThan(number2)); // Esperado: true
        System.out.println("Teste 7 - number1 maior ou igual a number2: " + number1.isGreaterThanOrEqualTo(number2)); // Esperado: false
        System.out.println("Teste 7 - number1 menor ou igual a number2: " + number1.isLessThanOrEqualTo(number2)); // Esperado: true

        // Teste 8: number3 e number4 iguais
        HugeInteger number3 = new HugeInteger();
        HugeInteger number4 = new HugeInteger();

        number3.parse("999");
        number4.parse("999");
        System.out.println("Teste 8 - number3 igual a number4: " + number3.isEqualTo(number4)); // Esperado: true
        System.out.println("Teste 8 - number3 não igual a number4: " + number3.isNotEqualTo(number4)); // Esperado: false
        System.out.println("Teste 8 - number3 maior que number4: " + number3.isGreaterThan(number4)); // Esperado: false
        System.out.println("Teste 8 - number3 menor que number4: " + number3.isLessThan(number4)); // Esperado: false
        System.out.println("Teste 8 - number3 maior ou igual a number4: " + number3.isGreaterThanOrEqualTo(number4)); // Esperado: true
        System.out.println("Teste 8 - number3 menor ou igual a number4: " + number3.isLessThanOrEqualTo(number4)); // Esperado: true
    }
}

class HugeInteger
{
    // Array para armazenar os dígitos do número, com um tamanho máximo de 40 dígitos
    private final int[] digits = new int[40];
    // Flag para indicar se o número é negativo
    private boolean isNegative;

    // Construtor da classe HugeInteger
    public HugeInteger() 
    {
        // Inicializa todos os elementos do array digits com -1 para indicar posições vazias
        Arrays.fill(digits, -1);
    }

    public void parse(String bigNumber) 
    {
        // Inicializa todos os elementos do array digits com -1 para indicar posições vazias
        Arrays.fill(digits, -1);
        // Inicializa a flag isNegative como falsa
        isNegative = false;

        // Verifica se o número é negativo e ajusta a flag isNegative
        if (bigNumber.charAt(0) == '-') 
            isNegative = true;
    
        // Define o limite com base na flag isNegative
        int limit = isNegative ? digits.length + 1 : digits.length;
    
        // Verifica se o comprimento do número excede o limite permitido
        if (bigNumber.length() > limit) 
            throw new IllegalArgumentException("Error: The number has " + (isNegative ? bigNumber.length() - 1 : bigNumber.length()) + " digits. It must not exceed " + digits.length + " digits.");
    
        // Itera sobre os dígitos do número da direita para a esquerda
        for (int i = bigNumber.length() - 1; i >= (isNegative ? 1 : 0); i--) {
            // Calcula a diferença entre o comprimento do array de dígitos e o comprimento do número
            int diferenca = digits.length - bigNumber.length();  
            // Converte o caractere para um dígito inteiro e armazena no array
            char zero = '0';
            digits[i + diferenca] = bigNumber.charAt(i) - zero;   
        }
    }

    public boolean isEqualTo(HugeInteger otherBigNumber) 
    {
        // Verifica se os sinais dos números são diferentes
        if (isNegative != otherBigNumber.isNegative) 
            return false; // Se os sinais forem diferentes, os números não são iguais
    
        // Itera sobre cada dígito dos arrays de dígitos, começando do final
        for (int i = digits.length - 1; i >= 0; i--) 
            // Compara os dígitos correspondentes dos dois números
            if (digits[i] != otherBigNumber.digits[i]) 
                return false; // Se encontrar dígitos diferentes, os números não são iguais

        return true; // Se todos os dígitos forem iguais, os números são iguais
    }
    
    public boolean isNotEqualTo(HugeInteger otherBignumber) 
    {
        // Reutiliza o método isEqualTo para verificar se os dois números não são iguais
        return !isEqualTo(otherBignumber);
    }

    public boolean isGreaterThan(HugeInteger otherBigNumber) 
    {
        // Verifica se os números são iguais
        if (isEqualTo(otherBigNumber))
            return false;
    
        // Verifica se o número atual é negativo e o outro é positivo
        if (isNegative && !otherBigNumber.isNegative)
            return false;
    
        // Ambos números são positivos
        if (!isNegative && !otherBigNumber.isNegative) 
            // Itera sobre cada dígito dos arrays de dígitos, começando do mais significativo
            for (int i = 0; i < digits.length; i++) 
                // Compara os dígitos correspondentes dos dois números
                if (digits[i] != otherBigNumber.digits[i]) 
                    if (digits[i] < otherBigNumber.digits[i])
                        return false; // Se o dígito atual for menor, o número atual não é maior
                    else
                        return true; // Se o dígito atual for maior, o número atual é maior
    
        // Ambos números são negativos
        if (isNegative && otherBigNumber.isNegative) 
            // Itera sobre cada dígito dos arrays de dígitos, começando do mais significativo
            for (int i = 0; i < digits.length; i++) 
                // Compara os dígitos correspondentes dos dois números
                if (digits[i] != otherBigNumber.digits[i]) 
                    if (digits[i] > otherBigNumber.digits[i])
                        return false; // Se o dígito atual for maior, o número atual não é maior (em valor absoluto)
                    else
                        return true; // Se o dígito atual for menor, o número atual é maior (em valor real)

        return true; // Se todos os dígitos forem iguais, o número atual é maior
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger otherBigNumber) 
    {
        // Verifica se o número atual é igual ao outro número
        if (isEqualTo(otherBigNumber) || isGreaterThan(otherBigNumber))
            return true; // Se for igual ou maior, retorna verdadeiro
    
        return false; // Caso contrário, retorna falso
    }
    
    public boolean isLessThan(HugeInteger otherBigNumber) 
    {
        // Verifica se os números são iguais
        if (isEqualTo(otherBigNumber))
            return false; // Se forem iguais, o número atual não é menor
    
        // Verifica se o número atual não é igual e se não é maior que o outro número
        return isNotEqualTo(otherBigNumber) && !isGreaterThan(otherBigNumber);
    }

    public boolean isLessThanOrEqualTo(HugeInteger otherBigNumber) 
    {
        // Verifica se o número atual é igual ao outro número
        // ou se é menor que o outro número
        if (isEqualTo(otherBigNumber) || isLessThan(otherBigNumber))
            return true; // Se for igual ou menor, retorna verdadeiro
        
        return false; // Caso contrário, retorna falso
    }    
    
    public boolean isZero() 
    {
        // Itera sobre cada dígito no array de dígitos
        for (int digit : digits) 
            // Verifica se o dígito não é -1 e não é 0
            if (digit != -1 && digit != 0) 
                return false; // Se encontrar um dígito que não é -1 nem 0, o número não é zero
        return true; // Se todos os dígitos forem -1 ou 0, então o número é zero
    }

    public void subtract(HugeInteger otherBigNumber)
    {
        // Se o número atual for zero e o outro número não for zero,
        // copia os dígitos do outro número e ajusta o sinal
        if (isZero() && !otherBigNumber.isZero())
        {
            for (int i = 0; i < digits.length; i++)
                digits[i] = otherBigNumber.digits[i];
            
            // Define o sinal como negativo se o outro número não for negativo
            if (!otherBigNumber.isNegative)
                isNegative = true;
        }
    
        // Se ambos números têm o mesmo sinal
        else if (isNegative == otherBigNumber.isNegative)
        {
            // Verifica se o número atual é menor que o outro número
            boolean less = isLessThan(otherBigNumber);

            int borrow = 0; // Variável para armazenar o empréstimo (borrow)
            
            // Itera de trás para frente
            for (int i = digits.length - 1; i >= 0; i--) 
            {                    
                int maior = digits[i];
                int menor = otherBigNumber.digits[i];
    
                // Ajusta maior e menor com base nos sinais dos números
                if (!isNegative && isLessThan(otherBigNumber) || (isNegative && isGreaterThan(otherBigNumber)))
                {
                    maior = otherBigNumber.digits[i];
                    menor = digits[i];
                }
    
                // Calcula a diferença subtraindo o empréstimo
                int diff = (maior == -1 ? 0 : maior) - (menor == -1 ? 0 : menor) - borrow;
    
                // Ajusta a diferença e o empréstimo se a diferença for negativa
                if (diff < 0) 
                {
                    diff += 10;
                    borrow = 1;
                } 
                else 
                    borrow = 0;
    
                digits[i] = diff;
            }
    
            // Define o sinal como negativo se o número atual for menor que o outro
            if (!isNegative && less)
                isNegative = true;
    
            cleanZeros(); // Limpa os zeros à esquerda
        }
        // Se os números têm sinais diferentes
        else
            if (isNegative)
                add(otherBigNumber); // Se o número atual for negativo, adiciona
            else
            {
                isNegative = false;
                add(otherBigNumber); // Caso contrário, muda o sinal e adiciona
            }
    }
    
    public void add(HugeInteger otherBigNumber) 
    {
        int carry = 0; // Variável para armazenar o carry (acarreo)
    
        // Itera desde o final do array em direção ao início
        for (int i = digits.length - 1; i >= 0; i--) 
        {
            // Soma os dígitos atuais e o carry
            int sum = (digits[i] == -1 ? 0 : digits[i]) + (otherBigNumber.digits[i] == -1 ? 0 : otherBigNumber.digits[i]) + carry;
    
            // Atualiza o dígito atual com o valor da soma sem o carry
            digits[i] = sum % 10;
    
            // Calcula o novo carry
            carry = sum / 10;
        }

        // Verifica se o carry excede o limite de 40 dígitos
        if (carry > 0) 
        {
            throw new Error("Erro: A soma dos dois números excede o limite de " + digits.length + " dígitos.");
        }
        cleanZeros();
    }

    private void cleanZeros()
    {
        for (int i = 0; i < digits.length; i++)
        {
            if (digits[i] > 0)
                break;
            digits[i] = -1;
        }
    }
    
    public String toString() 
    {
        String numberString = "";
    
        // Itera sobre cada dígito no array de dígitos
        for (int i = 0; i < digits.length; i++) 
            // Verifica se o dígito é diferente de -1
            if (digits[i] != -1) 
                // Adiciona o dígito à string
                numberString += String.valueOf(digits[i]) + (i % 3 == 0 ? " " : "");
    
        // Retorna "0" se o número é zero, caso contrário, adiciona o sinal negativo se necessário
        return isZero() ? "0" : !isNegative ? numberString : "-" + numberString;
    }
    
}


