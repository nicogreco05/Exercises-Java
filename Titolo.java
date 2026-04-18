package ES1;

public record Titolo(String val) {
    public Titolo{
        if(val == null){
            throw new NullPointerException("Titolo nullo!");
        }
        if(val.isBlank()){
            throw new IllegalArgumentException("Titolo composto solo da spazi!");
        }
        if(!val.matches("^[a-zA-Z\s]{2,20}$")){
            throw new IllegalArgumentException("Titolo non valido!");
        }
    }
}
