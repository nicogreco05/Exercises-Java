package ES1;

import ES2.AbstrEspositore;

import java.util.Objects;

public abstract class AbstrStrumento implements Strumento{
    private final Nome nome;
    private final Anno annoCostruzione;
    private final Anno annoArrivo;
    private final Fabbricante fabbricante;
    public AbstrStrumento(Nome nome, Anno annoCostruzione, Anno annoArrivo, Fabbricante fabbricante){
        this.nome = nome;
        this.annoCostruzione = annoCostruzione;
        this.annoArrivo = annoArrivo;
        this.fabbricante = fabbricante;
    }

    @Override
    public Nome getNome() {return nome;}
    @Override
    public Anno annoCostruzione() {return annoCostruzione;}
    @Override
    public Anno annoArrivo() {return annoArrivo;}
    @Override
    public Fabbricante getFabbricante() {return fabbricante;}

    @Override
    public String toString(){return "Nome: " + nome.val() + ", Anno costruzione: " + annoCostruzione.val() + ", Anno arrivo: " + annoArrivo.val() + ", Fabbricante:" + fabbricante.val();}

    @Override
    public boolean equals(Object o){
        if(o == this) {return true;}
        if(o == null) {return false;}
        if(!(o instanceof AbstrStrumento that)) {return false;}
        return Objects.equals(nome, that.nome) && Objects.equals(annoCostruzione, that.annoCostruzione) && Objects.equals(annoArrivo, that.annoArrivo) && Objects.equals(fabbricante, that.fabbricante);
    }

    @Override
    public int hashCode(){return Objects.hash(nome, annoCostruzione, annoArrivo, fabbricante);}

}
