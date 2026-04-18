package ES1;

public record Fabbricante(String val) {
    public Fabbricante{
        if(val == null) throw new NullPointerException("Fabbricante vuoto");
        if(val.isBlank()) throw new IllegalArgumentException("Stringa composta solo da spazi");
        if(val.matches("[a-zA-Z\\s]+"));
    }
}
