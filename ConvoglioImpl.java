package ES3;

import ES1.Vagone;
import ES2.ConvoglioAbstr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvoglioImpl extends ConvoglioAbstr {
    private final List<Vagone> treno = new ArrayList<>();

    @Override
    public void add(Vagone v){
        if(v == null) throw new IllegalArgumentException("Vagone nullo");
        treno.add(v);
    }

    @Override
    public Iterator<Vagone> iterator(){
        return treno.iterator();
    }
}
