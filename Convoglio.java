package ES2;

import ES1.Motrice;
import ES1.Vagone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface Convoglio extends Iterable<Vagone> {
    void add(Vagone v);

    default boolean remove(Vagone v){
        if(v == null) throw new NullPointerException("Vagone da aggiungere inesistente!");
        Iterator<Vagone> it = iterator();
        while(it.hasNext()){
            Vagone vag = it.next();
            if(vag.equals(v)){
                it.remove();
                return true;
            }
        }
        return false;
    }

    default Vagone getVagone(int index){
        int i = 0;
        for(Vagone v : this){
            if(i == index){
                return v;
            }
            i++;
        }
        throw new IllegalArgumentException("Indice non valido!");
    }

    default double calcolaRappFren(){
        double massaTot = 0.0;
        double massaFenanteTotale = 0.0;
        for(Vagone v : this){
            massaTot += v.massa().val();
            massaFenanteTotale += v.massaFrenata().val();
        }
        return massaTot / massaFenanteTotale;
    }

    default boolean controllo() {
        // Rapporto frenante > 0.60
        if (this.calcolaRappFren() <= 0.60) {
            return false;
        }
        // Copio in lista per accedere a primo/ultimo
        List<Vagone> copy = new ArrayList<>();
        Iterator<Vagone> it = this.iterator();
        while (it.hasNext()) {
            copy.add(it.next());
        }
        if (copy.size() == 0) return false;
        int countMotrici = 0;
        int massaTrainata = 0;      // solo vagoni NON motrici
        int trazioneTot = 0;        // somma capacità di trazione delle motrici
        for (Vagone v : copy) {
            if (v instanceof Motrice) {
                countMotrici++;
                Motrice m = (Motrice) v;
                trazioneTot += m.massaFrenata().val(); // <-- CAMBIA qui col tuo metodo
            } else {
                massaTrainata += v.massa().val();
            }
        }
        // Al più due motrici
        if (countMotrici > 2) return false;
        // Motrici agli estremi (1: a uno dei due estremi; 2: entrambe agli estremi opposti)
        Vagone iniziale = copy.getFirst();
        Vagone finale = copy.getLast();
        boolean estremiOk = true;
        if (countMotrici == 1) {
            estremiOk = (iniziale instanceof Motrice) || (finale instanceof Motrice);
        } else if (countMotrici == 2) {
            estremiOk = (iniziale instanceof Motrice) && (finale instanceof Motrice);
        }
        // Massa trainata < trazione motrici e comunque < 1800
        if (!(massaTrainata < trazioneTot)) return false;
        if (!(massaTrainata < 1800)) return false;
        return estremiOk;
    }

}
