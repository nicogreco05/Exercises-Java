package ES1;

public record Nominativo(String val) {
    public Nominativo{
        if(val == null){
            throw new NullPointerException("Elemento nullo!");
        }
        if(val.isBlank()){
            throw new IllegalArgumentException("Stringa vuota!");
        }
        if(val.length() < 3 || val.length() > 25){
            throw new IllegalArgumentException("Lungheza del nome non valida!");
        }
        if(!val.matches("^[a-zA-Z]{3,25}$")){
            throw new IllegalArgumentException("Nome non valido!");
        }
    }
}
