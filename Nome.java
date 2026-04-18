package ES1;

public record Nome(String val) {
    public Nome{
        if(val == null) throw new NullPointerException("String nulla");
        if(val.isBlank()) throw new IllegalArgumentException("Stringa composta solo da spazi");
        if(!val.matches("[a-zA-Z\\s]+")) throw new IllegalArgumentException("Nome non valido");
    }
}
