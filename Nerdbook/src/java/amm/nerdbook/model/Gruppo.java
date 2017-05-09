package amm.nerdbook.model;
import java.util.ArrayList;

/**
 *
 * @author Chiara
 */

public class Gruppo{

    protected int id;
    private String nome;
    private ArrayList <Utente> listaUtenti = new ArrayList <>();
    
    /*Costruttore*/
    public Gruppo(){
        this.id = 0;
        this.nome = "";
    }
    
    /*Getter e Setter*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public ArrayList<Utente> getListaUtenti() {
        return listaUtenti;
    }

    public void setListaUtenti(ArrayList<Utente> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }
}