package ES1;

public class Forza extends  CorsoAbstr{
    public Forza(CodiceCorso codice, String nome, int capacitaMassima, int numeroIstruttori, Orario orario, int durataMinuti, Intensita intensita){
        super(codice, nome, capacitaMassima, numeroIstruttori, orario, durataMinuti, intensita);
    }

    public String toString(){
        return super.toString() + "Tipo: Forza";
    }
}
