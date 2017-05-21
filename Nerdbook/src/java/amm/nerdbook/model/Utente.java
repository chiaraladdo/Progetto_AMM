package amm.nerdbook.model;

/**
 *
 * @author Chiara
 */
public class Utente{
    
    private int id;
    private String nome;
    private String cognome;
    private String password;
    private String urlFotoProfilo;
    private String frase;
    private String data;
    private String email;
    
    
    /*Costruttore*/
    public Utente(){
        this.id = 0;
        this.nome = "";
        this.cognome = "";
        this.frase = "";
        this.data = "";
        this.password = "";
    }

    /*Getter e Setter*/
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCognome(){
        return cognome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUrlFotoProfilo(){
        return urlFotoProfilo;
    }

    public void setUrlFotoProfilo(String urlFotoProfilo){
        this.urlFotoProfilo = urlFotoProfilo;
    }

    public String getFrase(){
        return frase;
    }

    public void setFrase(String frase){
        this.frase = frase;
    }

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
