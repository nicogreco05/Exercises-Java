package ES1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface Espositore<S extends Strumento> extends Iterable<S>{
    void add(S item);

    default boolean remove(S item){
        if(item == null) throw new NullPointerException("Item da rimuovere nullo!");
        Iterator<S> it = iterator();
        while(it.hasNext()){
            S s = it.next();
            if(s.equals(item)){
                it.remove();
                return true;
            }
        }
        return false;
    }

    List<S> livello(int index);

    default List<S> contaPerDecennio(Anno decennio){
        List<S> ret = new ArrayList<>();
        for(S s : this){
            if(s.annoCostruzione().val() >= decennio.val() || s.annoCostruzione().val() <= (decennio.val() + 9)){
                ret.add(s);
            }
        }
        return ret;
    }
}
