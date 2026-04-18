package ES1;


public interface Strumento extends Comparable<Strumento>{
    Nome getNome();
    Anno annoCostruzione();
    Anno annoArrivo();
    Fabbricante getFabbricante();
    Categoria<? extends Strumento> getCategoria();

    @Override
    default int compareTo(Strumento s){
        if(s == null) throw new NullPointerException();
        return this.getFabbricante().val().compareToIgnoreCase(s.getFabbricante().val());
    }
}
