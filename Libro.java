package ES1;

public abstract class Libro extends SupportoAbstr{
    private final Genere<Libro> genere;
    public Libro(Titolo getTitolo, Anno annoEdizione, Anno annoAcquisto, Nominativo getAutore, Genere<Libro> genere){
        super(getTitolo, annoEdizione, annoAcquisto, getAutore);
        if(genere == null){
            throw new NullPointerException("Genere nullo!");
        }
        this.genere = genere;
    }

    @Override
    public Genere<Libro> getGenere(){
        return genere;
    }

    @Override
    public String toString(){
        return super.toString() + ", Tipo supporto: Libro";
    }
}
