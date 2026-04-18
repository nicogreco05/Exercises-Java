package ES1;

import java.util.ArrayList;
import java.util.List;

public interface Armadio<F extends Farmaco> extends Iterable<F>{
    void add(F item);
    boolean remove(F item);
    List<F> ripiano(int index);
    default List<F> cerca(String keyword){
        if(keyword == null){
            throw new NullPointerException("Keyword nulla!");
        }
        if(!keyword.matches("[a-zA-Z0-9]{1,10}")){
            throw new IllegalArgumentException("Keyword non valida!");
        }
        List<F> ret = new ArrayList<F>();
        for(F f : this){
            if(f.getNome().val().contains(keyword)){
                ret.add(f);
            }
        }
        return ret;
    }
}
