package ES3;

import ES1.Genere;
import ES1.Supporto;
import ES2.ScaffaleAbstr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ScaffaleLC<S extends Supporto> extends ScaffaleAbstr<S> {

    private class Nodo {
        S info;
        Nodo next;

        public Nodo(S info, Nodo next) {
            this.info = info;
            this.next = next;
        }
    }
        private Nodo head;
        private int cout = 0; // num elementi

        public ScaffaleLC(int numMensola, int capPerMensola, String codice, Genere<S> genere){
            super(numMensola, capPerMensola, codice, genere);
            head = null;
        }

    @Override
    public void add(S item) {
        if (item == null) {
            throw new NullPointerException("Elemento da aggiungere nullo");
        }
        if (!item.getGenere().equals(this.getGenere())) {
            throw new IllegalArgumentException("Questo scaffale ammette solo item di tipo: " + this.getGenere());
        }
        if (cout >= this.getNumMensole() * this.getCapPerMensola()) {
            throw new IllegalArgumentException("Spazio non disponibile");
        }
        if(head == null || head.info.compareTo(item) > 0){
            head = new Nodo(item, head);
        }
        else{
            var corr = head;
            while(corr.next != null && corr.next.info.compareTo(item) < 0){
                corr = corr.next;
            }
            corr.next = new Nodo(item, corr.next);
        }
        cout++;
    }

    @Override
    public boolean remove(S item){
            if(item == null){
                return false;
            }
            if(head.info.equals(item)){
                head = head.next;
                cout--;
                return true;
            }
            else{
                var corr = head;
                while(corr.next != null && !corr.next.info.equals(item)){
                    corr = corr.next;
                }
                if(corr.next == null){
                    return false;
                }
                corr.next = corr.next.next;
            }
            cout--;
            return true;
    }

    @Override
    public List<S> mensola(int index){
            if(index < 0 || index > this.getNumMensole()){
                throw new IllegalArgumentException("Indice errato!");
            }
            int start = index * this.getCapPerMensola();
            int end = start + this.getCapPerMensola();
            List<S> ret = new ArrayList<S>();
            int i = 0;
            var curr = head;
            while(i < start){
                curr = curr.next;
                i++;
            }
            while(i < end){
                ret.add(curr.info);
                curr = curr.next;
                i++;
            }
            return ret;
    }

    @Override
    public Iterator<S> iterator(){
        return new Iterator<S>() {
            Nodo corr = head;
            @Override
            public boolean hasNext() {
                return corr != null;
            }

            @Override
            public S next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                S dato = corr.info;
                corr = corr.next;
                return dato;
            }
        };
    }



}

