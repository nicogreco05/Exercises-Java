package ES1;

public interface Supporto extends Comparable<Supporto>{
    Titolo getTitolo();
    Anno annoEdizione();
    Anno annoAcquisto();
    Nominativo getAutore();
    Genere getGenere();

    default int compareTo(Supporto o){
        if(o == null){
            return 1;
        }
        int c = this.getAutore().val().compareToIgnoreCase(o.getAutore().val());
        if(c != 0){
            return c;
        }
        return this.getTitolo().val().compareToIgnoreCase(o.getTitolo().val()); // se hanno lo stesso nome ordino in base al titolo
    }
}
