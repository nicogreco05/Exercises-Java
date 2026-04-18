package ES2;

import ES1.Genere;
import ES1.Supporto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ScaffaleImpl<S extends Supporto> extends ScaffaleAbstr<S>{
    private final List<List<S>> scaffale;
    public ScaffaleImpl(int numMensole, int capPerMensola, String codice, Genere<S> genere){
        super(numMensole, capPerMensola, codice, genere);
        scaffale = new ArrayList<List<S>>(numMensole);
        for(int i = 0; i < numMensole; i++){
            scaffale.add(new ArrayList<S>());
        }
    }

    @Override
    public void add(S item){
        if(item == null){
            throw new IllegalArgumentException("Item nullo");
        }
        if(!item.getGenere().equals(this.getGenere())){
            throw new IllegalArgumentException("Questo scaffale ammette solo item di tipo: " + this.getGenere());
        }
        for(List<S> mensola : scaffale){
            if(mensola.size() < this.getCapPerMensola()){
                mensola.add(item);
                Collections.sort(mensola);
                return;
            }
        }
        throw new RuntimeException("Spazio non disponibile");
    }

    @Override
    public boolean remove(S item){
        if(item == null){
            return false;
        }
        for(List<S> mensola : scaffale){
            if(mensola.remove(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<S> mensola(int index){
        if(index < 0 || index > this.getNumMensole()){
            throw new IllegalArgumentException("Indice non valido");
        }
        return new ArrayList<S>(scaffale.get(index));
    }

    @Override
    public Iterator<S> iterator(){
        List<S> listaTotale = new ArrayList<S>();
        for(List<S> mensola : scaffale){
            listaTotale.addAll(mensola);
        }
        return listaTotale.iterator();
    }

}
