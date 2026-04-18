package ES2;

import ES1.Vagone;

import java.util.Iterator;
import java.util.Objects;

public abstract class ConvoglioAbstr implements Convoglio{

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Dettagli dei vagoni per ogni convoglio: ").append("\n");
        for(Vagone v : this){
            sb.append(v);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o){
        if(o == null) throw new IllegalArgumentException();
        if(o == this) {return true;}
        if(!(o instanceof ConvoglioAbstr that)){return false;}
        Iterator<Vagone> it1 = this.iterator();
        Iterator<Vagone> it2 = that.iterator();
        while(it1.hasNext() && it2.hasNext()){
            Vagone v1 = it1.next();
            Vagone v2 = it2.next();
            if(!(Objects.equals(v1, v2))) {return false;}
        }
        return !it1.hasNext() && !it2.hasNext();
    }

    @Override
    public int hashCode(){
        int h = 1;
        for(Vagone v : this){
            h = 31 * h + v.hashCode();
        }
        return h;
    }

}
