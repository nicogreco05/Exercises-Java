package ES2;

import ES1.Categoria;
import ES1.Strumento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EspositoreImpl<S extends Strumento> extends AbstrEspositore<S>{
    private final List<S> strumenti = new ArrayList<>();
    public EspositoreImpl(String codice, int numEspositori, int capEspositore, Categoria<S> categoria){
        super(codice, numEspositori, capEspositore, categoria);
    }

    @Override
    public void add(S item){
        if(item == null) throw new NullPointerException("Item da aggiungere vuoto!");
        if(strumenti.size() >= this.getNumEspositori() * this.getCapEspositore()) throw new IllegalArgumentException("Spazio insufficente");
        if(!(item.getCategoria().equals(this.getCategoria()))) throw new IllegalArgumentException("Categoria item diversa dalla categoria dell'espositore");
        strumenti.add(item);
        Collections.sort(strumenti);
    }

    @Override
    public Iterator<S> iterator(){
        return strumenti.iterator();
    }
}
