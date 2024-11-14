// Figura 14.21 - Validate.java
// Insere e valida os dados do usuario usando a classe ValidateInput
import java.util.Scanner;

public class Fig_14_21 
{
    public static void main(String[] args) 
    {
        // obtem a entrada de usuario
        Scanner scanner = new Scanner(System.in);    
        System.out.println("Please enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Please enter last name:");
        String lastName = scanner.nextLine();        
        System.out.println("Please enter address:");
        String address = scanner.nextLine();        
        System.out.println("Please enter city:");
        String city = scanner.nextLine();        
        System.out.println("Please enter state:");
        String state = scanner.nextLine();        
        System.out.println("Please enter zip:");
        String zip = scanner.nextLine();        
        System.out.println("Please enter phone:");
        String phone = scanner.nextLine();

        // valida a entrada de usuario e exibe mensagem de erro
        System.out.println("\nValidate Result:");

        if (!Fig_14_20.validateFirstName(firstName))
            System.out.println("Invalid first name");
        else if (!Fig_14_20.validateLastName(lastName))
            System.out.println("Invalid last name");
        else if (!Fig_14_20.validateAddress(address))
            System.out.println("Invalid address");
        else if (!Fig_14_20.validateCity(city))
            System.out.println("Invalid city");
        else if (!Fig_14_20.validateState(state))
            System.out.println("Invalid state");        
        else if (!Fig_14_20.validateZip(zip))
            System.out.println("Invalid zip code");        
        else if (!Fig_14_20.validatePhone(phone))
            System.out.println("Invalid phone number");
        else 
            System.out.println("Valid input.    Thank you");
    }
}
