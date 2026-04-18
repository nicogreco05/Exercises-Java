package ES1;

public class CD extends SupportoAbstr{
    private final Genere<CD> genere;
    public CD(Titolo getTitolo, Anno annoEdizione, Anno annoAcquisto, Nominativo getAutore, Genere<CD> genere){
        super(getTitolo, annoEdizione, annoAcquisto, getAutore);
        if(genere == null){
            throw new NullPointerException("Genere nullo!");
        }
        this.genere = genere;
    }

    @Override
    public Genere<CD> getGenere(){
        return genere;
    }

    @Override
    public String toString(){
        return super.toString() + ", Tipo supporto: CD";
    }
}
