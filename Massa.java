package ES1;

public record Massa(int val) {
    public Massa{
        if(val < 0) throw new IllegalArgumentException("Massa < 0");
    }
}
