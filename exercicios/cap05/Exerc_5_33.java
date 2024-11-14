// 5.33 - Crescimento da base de usuarios do Facebook
// De acordo com o CNNMoney.com, o Facebook alcançou um bilhão de usuários em outubro de 2012. Usando a técnica de crescimento composto que você aprendeu na figura 5.6 e supondo que a base de usuarios cresça a uma taxa de 4% ao mês, quantos meses levarão pra que o Facebook aumente sua base de usuários para 1.5 bilhão? Quantos meses serão necessários para que o Facebook expanda sua base de usuários para dois bilhões?  
public class Exerc_5_33 
{
    public static void main(String[] args) 
    {
        double usuarios = 1;
        
        for (int mes = 1; usuarios < 2; mes++)
        {
            usuarios *= 1.04;
            if (usuarios > 1.5 && usuarios < 1.6)
                System.out.printf("O Facebook vai precisar de %d meses para ultrapassar os 1.5 bilhões de usuários ", mes);
            if (usuarios > 2)
                System.out.printf("e de %d meses para ultrapassar os 2 bilhões de usuários", mes);
        }
    }    
}
