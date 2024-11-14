// Classe Person representa uma entrada em uma agenda de enderecos
public class Person
{
   private int addressID;
   private String firstName;
   private String lastName;
   private String email;
   private String phoneNumber;

   // construtor padrao
   public Person()
   {
   } 

   // construtor com parametros
   public Person(int addressID, String firstName, String lastName, 
      String email, String phoneNumber)
   {
      setAddressID(addressID);
      setFirstName(firstName);
      setLastName(lastName);
      setEmail(email);
      setPhoneNumber(phoneNumber);
   } 

   // define o addressID
   public void setAddressID(int addressID)
   {
      this.addressID = addressID;
   }

   // retorna o addressID
   public int getAddressID()
   {
      return addressID;
   }
   
   // define o primeiro nome
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   } 

   // retorna o primeiro nome
   public String getFirstName()
   {
      return firstName;
   } 
   
   // define o ultimo nome
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   } 

   // retorna o ultimo nome
   public String getLastName()
   {
      return lastName;
   }
   
   // define o email
   public void setEmail(String email)
   {
      this.email = email;
   }

   // retorna o email
   public String getEmail()
   {
      return email;
   } 
   
   // define o numero de telefone
   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }

   // retorna o numero de telefone
   public String getPhoneNumber()
   {
      return phoneNumber;
   } 
} // fim da classe Person
