package ES1;

public class VagoneMerci extends VagoneAbstr{
    public VagoneMerci(Identificatore identificatore, Lunghezza lunghezza, Massa massa, Massa massaFrenata, Velocita velocitaMax){
        super(identificatore, lunghezza, massa, massaFrenata, velocitaMax);
    }

    @Override
    public String toString(){return super.toString() + ", Tipo vagone: Vagone merci";}
}
