// Figura 8.10 - Book.java
// Declarando um tipo enum com um construtor e campos de instancia explicitos 
// e metodos de acesso para esses campos

public enum Fig_8_10 
{
    // declara constantes do tipo enum 
    JHTP("Java How to Program", "2015"),
    CHTP("C How to Program", "2013"),
    IW3HTP("Internet & World Wide Web How to Program", "2012"),
    CPPHTP("C++ How to Program", "2014"),
    VBHTP("Visual Basic How to Program", "2014"),
    CSHARPHTP("Visual C# How to Program", "2014");

    // campos de instancia
    private final String title;// titulo del livro
    private final String copyrightYear;// ano dos direitos autorais

    // construtor enum
    Fig_8_10(String title, String copyrightYear)
    {
        this.title = title;
        this.copyrightYear = copyrightYear;
    }

    // acessor para titulo de campo 
    public String getTitle()
    {
        return title;
    }

    // acessor para o campo copyrightYear
    public String getCopyrightYear()
    {
        return copyrightYear;
    }
}// fim do enum Book
