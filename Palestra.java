package ES2;

import ES1.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface Palestra extends Iterable<Corso>{
    void aggiungiCorso(Corso c);

    default boolean rimuoviCorso(Corso c){
        if(c == null){
            return false;
        }
        Iterator<Corso> it = iterator();
        while(it.hasNext()){
            if(it.next().equals(c)){
                it.remove();
                return true;
            }
        }
        return false;
    }

    default Corso getCorso(int index){
        int i = 0;
        for(Corso c : this){
            if(index == i){
                return c;
            }
            i++;
        }
        throw new IllegalArgumentException("Corso non trovato");
    }

    default double rapportoPartecipanti(){
        double numeroTotIstr = 0.0;
        double capTotCorsi = 0.0;
        for(Corso c : this){
            numeroTotIstr += c.numeroIstruttori();
            capTotCorsi += c.capacitaMassima();
        }
        if(capTotCorsi == 0){
            throw  new ArithmeticException("Non posso dividere per 0");
        }
        return numeroTotIstr / capTotCorsi;
    }

    default boolean verificaStandardQualita(){
        if(rapportoPartecipanti() < 0.1){
            return false;
        }
        int capTot = 0;
        int countCardio = 0;
        int countForza = 0;
        int countBenesssere = 0;
        List<Giorno> giorniDeiCorsi = new ArrayList<Giorno>();
        List<Giorno> giorniDellaSett = List.of(Giorno.values());
        for(Corso c : this){
            capTot += c.capacitaMassima();
            if(c.intensita() == Intensita.ALTISSIMA && c.numeroIstruttori() < 2){
                return false;
            }
            giorniDellaSett.add(c.orario().gg());
            if(c instanceof Forza){
                countForza++;
            }
            else if(c instanceof Cardio){
                countCardio++;
            }
            else{
                countBenesssere++;
            }
        }
        if(countCardio == 0 || countForza == 0 || countBenesssere == 0){
            return false;
        }
        if(!giorniDeiCorsi.containsAll(giorniDellaSett)){
            return false;
        }
        if(capTot < 100){
            return false;
        }
        return true;
    }


}
