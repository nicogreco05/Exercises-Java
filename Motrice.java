package ES1;

public class Motrice extends VagoneAbstr{
    private final Massa trazione;
    public Motrice(Identificatore identificatore, Lunghezza lunghezza, Massa massa, Massa massaFrenata, Velocita velocitaMax, Massa trazione){
        super(identificatore, lunghezza, massa, massaFrenata, velocitaMax);
        if(trazione.val() < 0) throw new IllegalArgumentException("Trazione minore di 0");
        this.trazione = trazione;
    }

    @Override
    public String toString(){return super.toString() + ", Trazione: " + trazione.val();}

}
