package ES1;

public record Anno(int val) {
    public Anno{
        if(val < 1700 || val > 2100) throw new IllegalArgumentException("Anno non valido");
    }
}
