package ES1;

public record Data(int val) {
    public Data{
        if(val < 0){
            throw new IllegalArgumentException("Data non valida!");
        }
    }
}
