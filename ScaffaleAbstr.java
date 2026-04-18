package ES2;

import ES1.Genere;
import ES1.Scaffale;
import ES1.Supporto;

import java.util.Objects;

public abstract class ScaffaleAbstr<S extends Supporto> implements Scaffale<S> {
    private final int numMensole;
    private final int capPerMensola;
    private final String codice;
    private final Genere<S> genere;
    public ScaffaleAbstr(int numMensole, int capPerMensola, String codice, Genere<S> genere){
        if(numMensole < 0 || capPerMensola <= 0){
            throw new IllegalArgumentException("Numero mensole non valido o capacità per mensola non valida");
        }
        if(!codice.matches("^$[a-zA-Z]{1}\\d{3}")){
            throw new IllegalArgumentException("Il codice ident. dello scaffale non rispetta il formato richiesto");
        }
        this.numMensole = numMensole;
        this.capPerMensola = capPerMensola;
        this.codice = codice;
        this.genere = genere;
    }

    public int getNumMensole(){
        return numMensole;
    }

    public int getCapPerMensola(){
        return capPerMensola;
    }

    public Genere<S> getGenere(){
        return genere;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Scaffale: ").append(codice).append("Numero di mensole: ").append(numMensole).append(", Capacità per mensola: ").append(capPerMensola).append("\n");
        sb.append("Informazioni dei supporti presenti:\n");
        for(S supporto : this){
            sb.append(supporto).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o == null || !(o instanceof Scaffale<?>)){
            return false;
        }
        ScaffaleAbstr<?> that = (ScaffaleAbstr<?>) o;
        return Objects.equals(codice, that.codice);
    }

    @Override
    public int hashCode(){
        return Objects.hash(codice);
    }

	/*
	   E se non avessi avuto un codice univoco?

	    public boolean equals(Object o) {
		if(o == this) return true;
		if(o == null || !(o instanceof Scaffale<?>) ) return false;
		AbstractScaffale<?> that = (AbstractScaffale<?>) o;
		if(!Objects.equals(numMensole, that.numMensole || !Objects.equals(capacitaMaxPerMensola, that.capacitaMaxPerMensola) || !Objects.equals(genere, that.genere)) return false;
		Iterator<S> it1 = this.iterator();
		Iterator<?> it2 = other.iterator();

		while(it1.hasNext() && it2.hasNext() ) {
			if(!it1.next().equals(it2.next()) ) return false;
		}

		return it1.hasNext() == it2.hasNext();
	*/

    /*
    public int hashCode(){
        int h = 1;
        for(S s : this){
             h = 31 * h + (s == null ? 0 : s.hashCode())
             }
             return Objects.hash(h, numMensole, capPerMensola, codice);
        }
     */
}
