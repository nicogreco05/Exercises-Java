package ES1;

import java.util.ArrayList;
import java.util.List;

public interface Scaffale<S extends Supporto> extends Iterable<S>{
    void add(S item); // non lo posso fare

    boolean remove(S item); // non ha senso farlo, rimuoverei in una copia e non nell'originale

    List<S> mensola(int index); // non lo posso fare perche io ho liste di liste, l'index passato è l'indice di una mensola ma io ho una lista di supporti, quindi con il solito metodo restituirei un supporto e non una mensola

    default public List<S> cerca(String keyword){
        if(!keyword.matches("^[a-zA-z]{1,10}$")){
            throw new IllegalArgumentException("Keyword non valida!");
        }
        List<S> ret = new ArrayList<S>();
        for(S s : this){
            if(s.getTitolo().val().contains(keyword)){
                ret.add(s);
            }
        }
        return ret;
    }

}
