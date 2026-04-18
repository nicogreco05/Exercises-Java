package ES2;

import ES1.Armadio;
import ES1.ClasseTerapeutica;
import ES1.Farmaco;

import java.util.Objects;

public abstract class AbstractArmadio<F extends Farmaco> implements Armadio<F> {
    private final String id;
    private final int numRipiani;
    private final int capRipiani;
    private final ClasseTerapeutica<F> classe;
    protected AbstractArmadio(String id, int numRipiani, int capRipiani, ClasseTerapeutica<F> classe){
        if(id == null || id.isBlank()) throw new NullPointerException("Id non valido!");
        if(numRipiani < 0 || capRipiani < 0) throw new IllegalArgumentException("Ripiani non validi");
        if(classe == null) throw new IllegalArgumentException("Classe non valida!");
        this.id = id;
        this.numRipiani = numRipiani;
        this.capRipiani = capRipiani;
        this.classe = classe;
    }

    public String getId(){
        return id;
    }

    public int getNumRipiani(){
        return numRipiani;
    }

    public int getCapRipiani(){
        return capRipiani;
    }

    public ClasseTerapeutica<F> getClasse(){
        return classe;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != this.getClass()){
            return false;
        }
        if(o == this){
            return true;
        }
        AbstractArmadio<?> that = (AbstractArmadio<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Armadio con id").append(id).append(", Numero ripiani: ").append(numRipiani).append(", Capacità ripiani: ").append(capRipiani).append(", Classe").append(classe).append("\n");
        sb.append("Dettagli per ogni farmaco presenti nell'armadio").append("\n");
        for(F f : this){
            sb.append(f.toString());
        }
        return sb.toString();
    }
}
