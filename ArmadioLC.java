package ES3;

import ES1.ClasseTerapeutica;
import ES1.Farmaco;
import ES2.AbstractArmadio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ArmadioLC<F extends Farmaco> extends AbstractArmadio<F> {
    private class Nodo{
        F info;
        Nodo next;
        public Nodo(F info, Nodo next){
            this.info = info;
            this.next = next;
        }
    }

    private Nodo head;
    private int count = 0;

    public ArmadioLC(String id, int numRipiani, int capRipiani, ClasseTerapeutica<F> classe){
        super(id, numRipiani, capRipiani, classe);
        head = null;
    }

    @Override
    public void add(F item){
        if(item == null) throw new NullPointerException("Item nullo");
        if (!item.getClasse().equals(this.getClasse())) {
            throw new IllegalArgumentException("Questo scaffale ammette solo item di tipo: " + this.getClasse());
        }
        if (count >= this.getNumRipiani() * this.getCapRipiani()) {
            throw new IllegalArgumentException("Spazio non disponibile");
        }
        if(head == null || head.info.compareTo(item) > 0){
            head = new Nodo(item, head);
        }
        else{
            var corr = head;
            while(head.next != null && head.info.compareTo(item) < 0){
                corr = corr.next;
            }
            corr.next = new Nodo(item, corr.next);
        }
        count++;
    }

    @Override
    public boolean remove(F item){
        if(item == null) throw new NullPointerException("Item nullo");
        if(head.info.equals(item)){
            head = head.next;
        }
        else{
            var corr = head;
            while(corr.next != null && !corr.next.info.equals(item)){
                corr = corr.next;
            }
            if(corr.next == null) return false;
            corr.next = corr.next.next;
        }
        count--;
        return true;
    }

    @Override
    public List<F> ripiano(int index){
        if(index < 0 || index > this.getNumRipiani()) throw new IllegalArgumentException("Indice non valido!");
        List<F> ret = new ArrayList<F>();
        int start = index * this.getNumRipiani();
        int end = start + this.getCapRipiani();
        int i = 0;
        var corr = head;
        while(i < end && corr != null){
            if(i >= start){
                ret.add(corr.info);
            }
            corr = corr.next;
            i++;
        }
        return ret;
    }

    @Override
    public Iterator<F> iterator(){
        return new Iterator<F>() {
            Nodo corr = null;
            Nodo prec = null;
            @Override
            public boolean hasNext() {
                if(corr == null) return head != null;
                return corr.next != null;
            }

            @Override
            public F next() {
                if(!hasNext()) throw new NoSuchElementException();
                if(corr != null) corr = head;
                else{
                    prec = corr;
                    corr = corr.next;
                }
                return corr.info;
            }
        };
    }
}
