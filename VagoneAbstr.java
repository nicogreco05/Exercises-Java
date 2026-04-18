package ES1;

import java.util.Objects;

public abstract class VagoneAbstr implements Vagone{
    private final Identificatore identificatore;
    private final Lunghezza lunghezza;
    private final Massa massa;
    private final Massa massaFrenata;
    private final Velocita velocitaMax;

    public VagoneAbstr(Identificatore identificatore, Lunghezza lunghezza, Massa massa, Massa massaFrenata, Velocita velocitaMax) {
        if(!(massa.val() < 1 || massa.val() > 125)) throw new IllegalArgumentException("Massa non valida");
        if(massaFrenata.val() > massa.val()) throw new IllegalArgumentException("Massa frenata non valida!");
        this.identificatore = identificatore;
        this.lunghezza = lunghezza;
        this.massa = massa;
        this.massaFrenata = massaFrenata;
        this.velocitaMax = velocitaMax;
    }

    @Override
    public Identificatore identificatore(){return identificatore;}
    @Override
    public Lunghezza lunghezza(){return lunghezza;}
    @Override
    public Massa massa(){return massa;}
    @Override
    public Massa massaFrenata(){return massaFrenata;}
    @Override
    public Velocita velocitaMax(){return velocitaMax;}

    @Override
    public String toString() {return "Vagone con identificatore: " + identificatore.val() + ", Lunghezza: " + lunghezza.val() + ", Massa totale: " + massa.val() + ", Massa frenata: " + massaFrenata.val() + ", Velocita max : " + velocitaMax.getVelocita();}

    @Override
    public boolean equals(Object o){
        if(o == null) throw new IllegalArgumentException();
        if(o == this) {return true;}
        if(!(o instanceof VagoneAbstr that)){return false;}
        return Objects.equals(identificatore, that.identificatore);
    }

    @Override
    public int hashCode(){
        return Objects.hash(identificatore);
    }
}
