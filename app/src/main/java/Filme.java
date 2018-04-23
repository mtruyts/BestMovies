public class Filme {
    private String filme;
    private String urls;
    private String nota;

    public Filme(String filme, String urls, String nota){
        this.filme = filme;
        this.urls=urls;
        this.nota=nota;
        this.location=location;
    }

    public String getFilme(){
        return this.filme;
    }

    public String getUrls(){
        return this.urls;
    }

    public String getNota(){ return this.nota;}

}
