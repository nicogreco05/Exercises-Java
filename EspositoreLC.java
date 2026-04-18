package ES3;

import ES1.Categoria;
import ES1.Espositore;
import ES1.Strumento;
import ES2.AbstrEspositore;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EspositoreLC<S extends Strumento> extends AbstrEspositore<S> {
    public EspositoreLC(String codice, int numEspositori, int capEspositore, Categoria<S> categoria) {
        super(codice, numEspositori, capEspositore, categoria);
    }

    private final class Nodo{
        S info;
        Nodo next;
        Nodo(S info){
            this.info = info;
        }
    }

    private Nodo head = null;
    private Nodo tail = null;
    private int size = 0;

    @Override
    public void add(S item){
        if(item == null) throw new NullPointerException("Item da aggiungere vuoto!");
        if(size >= this.getNumEspositori() * this.getCapEspositore()) throw new IllegalArgumentException("Spazio insufficente");
        if(!(item.getCategoria().equals(this.getCategoria()))) throw new IllegalArgumentException("Categoria item diversa dalla categoria dell'espositore");
        Nodo daInserire = new Nodo(item);
        if(head == null || head.info.compareTo(item) > 0){
            daInserire.next = head;
            head = daInserire;
        }
        else{
            Nodo corr = head;
            while(corr.next != null && corr.next.info.compareTo(item) < 0){
                corr = corr.next;
            }
            daInserire.next = corr.next;
            corr.next = daInserire;

        }
        size++;
    }

    @Override
    public Iterator<S> iterator(){
        return new Iterator<S>() {
            Nodo prec = null;
            Nodo corr = null;
            boolean removable = false;
            @Override
            public boolean hasNext() {
                if(corr == null){
                    return head != null;
                }
                return corr.next != null;
            }
            @Override
            public S next() {
                if(!hasNext()) throw new NoSuchElementException();
                removable = true;
                if(corr == null) corr = head;
                else{
                    prec = head;
                    corr = corr.next;
                }
                return corr.info;
            }

            @Override
            public void remove(){
                if(!removable) throw new NoSuchElementException();
                // rimozione in testa
                if(prec == null){
                    head = corr.next;
                    if(head == null) tail = null;
                }
                // rimozione in coda
                else if(corr == tail){
                    tail = prec;
                    prec.next = null;
                }
                // rimozione in mezzo
                else{
                    prec.next = corr.next;
                }
                removable = false;
                corr = prec;
                size--;
            }
        };
    }
}

