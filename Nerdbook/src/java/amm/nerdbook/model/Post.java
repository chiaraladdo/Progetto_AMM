package amm.nerdbook.model;

/**
 *
 * @author Chiara
 */
public class Post{
    
    public enum Tipo{
        NONE, IMAGE, URL
    };

    protected int id;
    protected Utente utente;
    protected Utente bachecaUtente;
    protected Gruppo gruppo;
    private String contenuto;
    private Tipo tipoPost;
    private String contenutoTipo;
    
    /*Costruttore*/
    public Post(){
        id = 0;
        utente = null;
        contenuto = "";
        tipoPost = Tipo.NONE;
        contenutoTipo = null;
    }
    
    /*Getter e Setter*/
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Utente getUtente(){
        return utente;
    }

    public void setUtente(Utente utente){
        this.utente = utente;
    }

    public Utente getBachecaUtente() {
        return bachecaUtente;
    }

    public void setBachecaUtente(Utente bachecaUtente) {
        this.bachecaUtente = bachecaUtente;
    }

    public Gruppo getGruppo() {
        return gruppo;
    }

    public void setGruppo(Gruppo gruppo) {
        this.gruppo = gruppo;
    }
    
    public String getContenuto(){
        return contenuto;
    }

    public void setContenuto(String contenuto){
        this.contenuto = contenuto;
    }

    public Tipo getTipoPost(){
        return tipoPost;
    }

    public void setTipoPost(Tipo tipoPost){
        this.tipoPost = tipoPost;
    }
    
    public String getContenutoTipo() {
        return contenutoTipo;
    }

    public void setContenutoTipo(String contenutoTipo) {
        this.contenutoTipo = contenutoTipo;
    }

}
