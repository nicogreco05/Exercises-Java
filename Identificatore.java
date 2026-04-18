package ES1;

public record Identificatore(String val) {
    public Identificatore{
        if(val == null) throw new NullPointerException("Valore nullo!");
        if(val.isBlank()) throw new IllegalArgumentException("Composto solo da spazi");
        if(!val.matches("^[a-zA-Z]{3}[0-9]{8}$")) throw new IllegalArgumentException("Stringa non valida!");
    }
}
