// 10.14 - Modificação do sistema de folha de pagamento
// Modifique o sistema de folha de pagamento das figuras 10.4 a 10.9 para incluir uma subclasse PieceWorker adicional de Employee que representa um funcionário cujo pagamento está baseado no número de peças de mercadorias produzido. A classe PieceWorker deve conter variáveis de instância wage private (para armazenar o salário do funcionário por peça) e pieces (para armazenar o número de peças produzido). Forneça uma implementação concreta do método earnings na classe PieceWorker que calcula os vencimentos do funcionário multiplicando o número de peças produzido pelo salário por peças. Crie um array de variáveis Employee para armazenar referências a objetos de cada classe concreta na nova hierarquia Employee. Para cada Employee, exiba sua representação de String e vencimentos.

public class PieceWorker extends Employee 
{
    // Variáveis de instância para armazenar o salário por peça e o número de peças produzidas
    private double wage;   // Salário por peça
    private int pieces;    // Número de peças produzidas

    // Construtor da classe PieceWorker que inicializa as variáveis de instância
    public PieceWorker(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double wage, int pieces) 
    {
        // Chama o construtor da superclasse Employee para inicializar informações básicas
        super(firstName, lastName, socialSecurityNumber, birthDate);
        
        // Inicializa as variáveis de instância wage e pieces
        this.wage = wage;
        this.pieces = pieces;
    }

    // Método para obter o salário por peça
    private double getWage() 
    {
        return wage;
    }

    // Método para obter o número de peças produzidas
    private int getPieces() 
    {
        return pieces;
    }

    // Implementação do método earnings que calcula os vencimentos com base no número de peças e no salário por peça
    @Override
    public double earnings() 
    {
        return wage * pieces;  // Vencimentos são calculados multiplicando o salário por peça pelo número de peças produzidas
    }

    // Método toString que retorna uma descrição detalhada do PieceWorker
    @Override
    public String toString() 
    {
        // Formata e retorna uma string com informações sobre o PieceWorker, incluindo o salário por peça e o número de peças
        return String.format("piece worker: %s%nwage per piece: $%,.2f%npieces produced: %d", 
            super.toString(), getWage(), getPieces());
    }
}
