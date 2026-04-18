package ES2;

import ES1.AbstrStrumento;
import ES1.Categoria;
import ES1.Espositore;
import ES1.Strumento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public abstract class AbstrEspositore<S extends Strumento> implements Espositore<S> {
    private final String codice; // AAA12
    private final int numEspositori;
    private final int capEspositore;
    private final Categoria<S> categoria;
    public AbstrEspositore(String codice, int numEspositori, int capEspositore, Categoria<S> categoria){
        if(codice == null) throw new NullPointerException("Codice vuoto");
        if(codice.isBlank()) throw new IllegalArgumentException("Codice composto solo da spazi");
        if(codice.matches("^[a-zA-Z]\\d{2}$")) throw new IllegalArgumentException("Codice non valido");
        if(numEspositori < 0 || capEspositore < 0) throw new IllegalArgumentException("Numero espositori/cap per espositore < 0");
        this.codice = codice;
        this.numEspositori = numEspositori;
        this.capEspositore = capEspositore;
        this.categoria = categoria;
    }

    public String getCodice() {return codice;}
    public int getNumEspositori() {return numEspositori;}
    public int getCapEspositore() {return capEspositore;}
    public Categoria<S> getCategoria() {return categoria;}

    @Override
    public List<S> livello(int index){
        if(index < 0 || index > this.getCapEspositore()) throw new IllegalArgumentException("Indice non valido");
        List<S> ret = new ArrayList<>();
        int start = index * capEspositore;
        int end = start + capEspositore;
        int i = 0;
        Iterator<S> it = iterator();
        while(i < end && it.hasNext()){
            if(i >= start){
                ret.add(it.next());
            }
            i++;
        }
        return ret;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Lista degli espositori con i propri strumenti").append("\n");
        sb.append("Espositore con codice: ").append(codice).append(", Numero espositori: ").append(numEspositori).append(", Capacita per espositore: ").append(numEspositori).append(", Categoria").append(categoria).append("\n").append(", con strumenti: ").append("\n");
        for(S s : this){
            sb.append(s);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o){
        if(o == null) throw new IllegalArgumentException();
        if(o == this) {return true;}
        if(!(o instanceof AbstrEspositore<?> that)) {return false;}
        return Objects.equals(codice, that.codice);
    }

    @Override
    public int hashCode(){
        return  Objects.hash(codice);
    }
}
