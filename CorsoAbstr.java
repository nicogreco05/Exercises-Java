package ES1;

import java.util.Objects;

public abstract class CorsoAbstr implements Corso{
    private final CodiceCorso codice;
    private final String nome;
    private final int capacitaMassima;
    private final int numeroIstruttori;
    private final Orario orario;
    private final int durataMinuti;
    private final Intensita intensita;
    public CorsoAbstr(CodiceCorso codice, String nome, int capacitaMassima, int numeroIstruttori, Orario orario, int durataMinuti, Intensita intensita){
        if(!nome.matches("^[a-zA-z]{1}[a-zA-z0-9]{4,19}$")){
            throw new IllegalArgumentException("Nome corso non valido!");
        }
        if(capacitaMassima < 5 || capacitaMassima > 25){
            throw new IllegalArgumentException("Capacità non valida!");
        }
        if(numeroIstruttori < 1 || numeroIstruttori > 5){
            throw new IllegalArgumentException("Numero di istruttori non valido!");
        }
        if(durataMinuti < 30 || durataMinuti > 120){
            throw new IllegalArgumentException("Durata minuti non valida!");
        }
        this.codice = codice;
        this.nome = nome;
        this.capacitaMassima = capacitaMassima;
        this.numeroIstruttori = numeroIstruttori;
        this.orario = orario;
        this.durataMinuti = durataMinuti;
        this.intensita = intensita;
    }

    @Override
    public CodiceCorso codice(){
        return codice;
    }

    @Override
    public String nome(){
        return nome;
    }

    @Override
    public int capacitaMassima(){
        return capacitaMassima;
    }

    @Override
    public int numeroIstruttori(){
        return numeroIstruttori;
    }

    @Override
    public Orario orario(){
        return orario;
    }

    @Override
    public int durataMinuti(){
        return durataMinuti;
    }

    @Override
    public Intensita intensita(){
        return intensita;
    }

    @Override
    public String toString(){
        return "Codice corso: " + codice().val() + ", Nome corso: " + nome() + ", Capacità massima: " + capacitaMassima() + ", Numero istruttori: " + numeroIstruttori() + ", Orario: " + orario().toString() + ", Durata minuti: " + durataMinuti() + ", Intensita: " + intensita().toString();
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(codice);

    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o == null || this.getClass() != o.getClass()){
            return false;
        }
        CorsoAbstr that = (CorsoAbstr) o;
        return Objects.equals(codice, that.codice);
    }

}
