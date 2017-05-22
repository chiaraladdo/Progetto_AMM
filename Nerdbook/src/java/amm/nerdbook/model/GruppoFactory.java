package amm.nerdbook.model;
import java.util.ArrayList;

/**
 *
 * @author Chiara
 */
public class GruppoFactory {
    
    //Pattern Design Singleton
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }
    
    private ArrayList<Gruppo> listaGruppo = new ArrayList<Gruppo>();
    
    private GruppoFactory() {
        
        UtenteFactory utenteFactory = UtenteFactory.getInstance();

        //Creazione Gruppo
        Gruppo gruppo1 = new Gruppo();
        gruppo1.setId(0);
        gruppo1.setNome("Grifondoro");
        gruppo1.setListaUtenti(null);
        gruppo1.setUrlFotoGruppo("img/grifondoro.jpg");
        listaGruppo.add(gruppo1);
        
        Gruppo gruppo2 = new Gruppo();
        gruppo2.setId(1);
        gruppo2.setNome("Tassorosso");
        gruppo2.setListaUtenti(null);
        gruppo2.setUrlFotoGruppo("img/tassorosso.GIF");
        listaGruppo.add(gruppo2);
        
        Gruppo gruppo3 = new Gruppo();
        gruppo3.setId(1);
        gruppo3.setNome("Corvonero");
        gruppo3.setListaUtenti(null);
        gruppo3.setUrlFotoGruppo("img/corvonero.GIF");
        listaGruppo.add(gruppo3);
        
        Gruppo gruppo4 = new Gruppo();
        gruppo4.setId(1);
        gruppo4.setNome("Serpeverde");
        gruppo4.setListaUtenti(null);
        gruppo4.setUrlFotoGruppo("img/serpeverde.jpg");
        listaGruppo.add(gruppo4);
    }

    
    public Gruppo getGruppoById(int id) {
        for (Gruppo gruppo : this.listaGruppo) {
            if (gruppo.getId() == id) {
                return gruppo;
            }
        }
        return null;
    }
    
     public Gruppo getGruppoByNome(String nome) {
        for (Gruppo gruppo : this.listaGruppo) {
            if ((gruppo.getNome()).equals(nome)) {
                return gruppo;
            }
        }
        return null;
    }
       
    public ArrayList<Gruppo> getListaGruppo() {
        return listaGruppo;
    }
    
}
