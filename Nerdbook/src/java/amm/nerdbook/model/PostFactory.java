package amm.nerdbook.model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Chiara
 */
public class PostFactory {
   
    //Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {
        
        UtenteFactory utenteFactory = UtenteFactory.getInstance();
        GruppoFactory gruppoFactory = GruppoFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setContenuto("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        post1.setId(0);
        post1.setUtente(utenteFactory.getUtenteById(0));
        

        Post post2 = new Post();
        post2.setContenuto("Cosa ne pensate amici? mi starebbe bene?");
        post2.setId(1);
        post2.setUtente(utenteFactory.getUtenteById(1));
        post2.setTipoPost(Post.Tipo.IMAGE);
        post2.setContenutoTipo("img/naso1.jpg");

        Post post3 = new Post();
        post3.setContenuto("Miao aMici, sono famoso!");
        post3.setId(2);
        post3.setUtente(utenteFactory.getUtenteById(2));
        post3.setTipoPost(Post.Tipo.URL);
        post3.setContenutoTipo("http://it.harrypotter.wikia.com/wiki/Grattastinchi");

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostList(Utente utente) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUtente().equals(utente)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }

        
    public List getPostList(Gruppo gruppo){
        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getGruppo().equals(gruppo)) {
                   listaPost.add(post);
            }
        }
        return listaPost;
    }
}

