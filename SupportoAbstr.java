package ES1;

import java.util.Objects;

public abstract class SupportoAbstr implements Supporto{
    private final Titolo getTitolo;
    private final Anno annoEdizione;
    private final Anno annoAcquisto;
    private final Nominativo getAutore;
    protected SupportoAbstr(Titolo getTitolo, Anno annoEdizione, Anno annoAcquisto, Nominativo getAutore){
        this.getTitolo = getTitolo;
        this.annoEdizione = annoEdizione;
        this.annoAcquisto = annoAcquisto;
        this.getAutore = getAutore;
    }

    @Override
    public Titolo getTitolo(){
        return getTitolo;
    }
    @Override
    public Anno annoEdizione(){
        return annoEdizione;
    }
    @Override
    public Anno annoAcquisto(){
        return annoEdizione;
    }
    @Override
    public Nominativo getAutore(){
        return getAutore;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o == null || o.getClass() != this.getClass()){
            return false;
        }
        SupportoAbstr that = (SupportoAbstr) o;
        return Objects.equals(getTitolo, that.getTitolo()) && Objects.equals(annoEdizione, that.annoEdizione) && Objects.equals(annoAcquisto, that.annoAcquisto) && Objects.equals(getAutore, that.getAutore);
    }

    @Override
    public int hashCode(){
        return Objects.hash(getTitolo, annoEdizione, annoAcquisto, getAutore);
    }

    @Override
    public String toString(){
        return "Supporto - Titolo: " + getTitolo().val() + ", Anno edizione: " + annoEdizione().val() + ", Anno acquisto: " + annoAcquisto().val() + ", Autore: " + getAutore().val();
    }


}
