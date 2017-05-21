package amm.nerdbook.model;
import java.util.ArrayList;

/**
 *
 * @author Chiara
 */

public class UtenteFactory{

    //Pattern Design Singleton
    private static UtenteFactory singleton;

    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }

    private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();

    private UtenteFactory() {
        
        //Creazione utenti

        //Harry Potter
        Utente utente1 = new Utente();
        utente1.setId(0);
        utente1.setNome("Harry");
        utente1.setCognome("Potter");
        utente1.setPassword("miao");
        utente1.setUrlFotoProfilo("../web/M2/img/HarryPotter1.jpg");
        utente1.setFrase("Miaomiao");
        utente1.setData("31/07/1980");
        utente1.setEmail("harrypotter80@miao.it");
        

        //Lord Voldemort
        Utente utente2 = new Utente();
        utente2.setId(1);
        utente2.setNome("Lord");
        utente2.setCognome("Voldemort");
        utente2.setPassword("miao");
        utente2.setUrlFotoProfilo("../web/M2/img/LordVoldemort1.jpg");
        utente2.setFrase("Miaomiao");
        utente2.setData("31/12/1926");
        utente2.setEmail("lordvoldy@miao.it");

        //Grattastinchi
        Utente utente3 = new Utente();
        utente3.setId(2);
        utente3.setNome("Grattastinchi");
        utente3.setCognome("Miao");
        utente3.setPassword("miao");
        utente3.setUrlFotoProfilo("../web/M2/img/Grattastinchi1.jpg");
        utente3.setFrase("Miaomiao");
        utente3.setData("01/01/2000");
        utente3.setEmail("gattino@miao.it");


        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
    }

    public Utente getUtenteById(int id) {
        for (Utente utente : this.listaUtenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password){
        for(Utente utente : this.listaUtenti){
            
            if(utente.getEmail().equals(user) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        
        return -1;
    }
    
}

