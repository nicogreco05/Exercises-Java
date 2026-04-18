package ES2;

import ES1.ClasseTerapeutica;
import ES1.Farmaco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArmadioImpl<F extends Farmaco> extends AbstractArmadio<F> {
    private final List<List<F>> amradio;
    public ArmadioImpl(String id, int numRipiani, int capRipiani, ClasseTerapeutica<F> classe){
        super(id, numRipiani, capRipiani, classe);
        amradio = new ArrayList<List<F>>(numRipiani);
        for(int i = 0; i < numRipiani; i++){
            amradio.add(new ArrayList<F>());
        }
    }

    @Override
    public void add(F item){
        if(item == null) throw new NullPointerException("Item vuoto");
        if(!item.getClasse().equals(this.getClasse())) throw new IllegalArgumentException("Questo armadio ammette solo farmaci di tipo: " + this.getClasse());
        for(List<F> ripiano : amradio){
            if(ripiano.size() < this.getCapRipiani()){
                ripiano.add(item);
                Collections.sort(ripiano);
                return;
            }
        }
        throw new IllegalArgumentException("Indice non valido!");
    }

    @Override
    public boolean remove(F item){
        if(item == null) throw new NullPointerException("Item vuoto");
        for(List<F> ripiano : amradio){
            for(F f : ripiano){
                if(f.equals(item)) {
                    ripiano.remove(item);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<F> ripiano(int index){
        if(index < 0 || index > this.getNumRipiani()){
            throw new IllegalArgumentException("Indice non valido!");
        }
        return new ArrayList<F>(amradio.get(index));
    }

    @Override
    public Iterator<F> iterator(){
        List<F> listaTotale = new ArrayList<F>();
        for(List<F> ripiano : amradio){
            listaTotale.addAll(ripiano);
        }
        return listaTotale.iterator();
    }
}
