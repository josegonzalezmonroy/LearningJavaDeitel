// Figura 14.20 - ValidateInput.java
// Valida informacoes de usuario utilizando expressoes regulares

public class Fig_14_20 
{
    // valida nome
    public static boolean validateFirstName(String firstName)
    {
        return firstName.matches("[A-Z][a-zA-Z]*");
    }

    // valida sobrenome
    public static boolean validateLastName(String lastName)
    {
        return lastName.matches("[a-zA-Z]+(['-][a-zA-Z]+)*");
    }

    // valida endereço
    public static boolean validateAddress(String address)
    {
        return address.matches(
            "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    // valida cidade
    public static boolean validateCity(String city)
    {
        return city.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    // valida estado
    public static boolean validateState(String state)
    {
        return state.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    // valida CEP
    public static boolean validateZip(String zip)
    {
        return zip.matches("\\d{5}");
    }

    // valida telefone
    public static boolean validatePhone(String phone)
    {
        return phone.matches("[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}");
    }
}
