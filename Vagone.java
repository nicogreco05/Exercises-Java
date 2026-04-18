package ES1;

public interface Vagone extends Comparable<Vagone>{
    Identificatore identificatore();
    Lunghezza lunghezza();
    Massa massa();
    Massa massaFrenata();
    Velocita velocitaMax();

    @Override
    default int compareTo(Vagone o){
        if(o == null) throw new IllegalArgumentException();
        return this.identificatore().val().compareToIgnoreCase(o.identificatore().val());
    }
}
