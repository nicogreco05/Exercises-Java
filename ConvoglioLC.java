package ES4;

import ES1.Vagone;
import ES2.ConvoglioAbstr;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConvoglioLC extends ConvoglioAbstr {

    private class Nodo {
        Vagone dato;
        Nodo next;

        Nodo(Vagone dato) {
            this.dato = dato;
        }
    }

    private Nodo head = null;
    private Nodo tail = null;
    private int size = 0;

    @Override
    public void add(Vagone v) {
        if (v == null) throw new IllegalArgumentException();
        Nodo daInserire = new Nodo(v);
        if(head == null) {
            head = daInserire = tail;
            size++;
           }
        else{
            tail.next = daInserire;
            daInserire = tail;
            size++;
        }
    }

    @Override
    public Iterator<Vagone> iterator(){
        return new Iterator<Vagone>() {
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
            public Vagone next() {
                if(!hasNext()) throw new NoSuchElementException();
                removable = true;
                if(corr == null) corr = head;
                else{
                    prec = head;
                    corr = corr.next;
                }
                return corr.dato;
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
