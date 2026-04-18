package ES1;

public class Cardio extends CorsoAbstr{
    private final String attrezzatura;
    public Cardio(CodiceCorso codice, String nome, int capacitaMassima, int numeroIstruttori, Orario orario, int durataMinuti, Intensita intensita, String attrezzatura){
        super(codice, nome, capacitaMassima, numeroIstruttori, orario, durataMinuti, intensita);
        if(durataMinuti < 45){
            throw new IllegalArgumentException("Durata minuti non valida!");
        }
        this.attrezzatura = attrezzatura;
    }

    public String getAttrezzatura(){
        return attrezzatura;
    }

    public String toString(){
        return super.toString() + "Tipo: Cardio";
    }
}
