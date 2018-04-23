import java.util.LinkedList;
import java.util.List;

public class FilmeList {

    List<Filme> filmes = new LinkedList<Filme>();
    Connection connection = new Connection();

    public void getFilmes(){
        try {
            filmes = connection.sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> returnFilmes(){
        List<String> filme = new LinkedList<String>();
        for(Filme cort : filmes){
            filme.add(cort.getFilme());
        }
        return filme;
    }

    public List<String> returnURL(){
        List<String> links = new LinkedList<String>();
        for(Filme cort : filmes){
            links.add(cort.getUrls());
        }
        return links;
    }

    public String returnU(String nome) {
        for (Filme cort : filmes) {
            if (cort.getFilme().equals(nome)) {
                return cort.getUrls();
            }
        }
        return "Not found link";
    }

    public String returnNOTA(String nome) {
        for (Filme cort : filmes) {
            if (cort.getFilme().equals(nome)) {
                return cort.getNota();
            }
        }
        return "Not found Nota";
    }

    }
