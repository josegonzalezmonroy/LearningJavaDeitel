// Figura 15.7 - MenuOption.java
// tipo enum para as opcoes do programa de consulta de credito

public enum Fig_15_7 
{
    // declara o conteudo do tipo enum
    ZERO_BALANCE(1),
    CREDIT_BALANCE(2),
    DEBIT_BALANCE(3),
    END(4);

    private final int value; // opcao final de menu

    // construtor
    private Fig_15_7(int value)
    {
        this.value = value;
    }
}// fim do menu de MenuOption
