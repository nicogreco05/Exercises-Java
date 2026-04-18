package ES1;

public interface Corso extends Comparable<Corso>{
    CodiceCorso codice();
    String nome();
    int capacitaMassima();
    int numeroIstruttori();
    Orario orario();
    int durataMinuti();
    Intensita intensita();

    @Override
    default int compareTo(Corso o){
        if(o == null) {
            return 1;
        }
        return this.codice().val().compareTo(o.codice().val());
    }

}


