package ES1;

public record Lunghezza(double val) {
    public Lunghezza{
        if(val < 5.0 || val > 35.0) throw new IllegalArgumentException("Lunghezza non valida");
    }
}
