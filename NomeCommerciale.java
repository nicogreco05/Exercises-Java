package ES1;

public record NomeCommerciale(String val) {
    public NomeCommerciale{
        if(val == null){
            throw new IllegalArgumentException("Stringa nulla!");
        }
        if(!val.matches("[a-zA-Z]{1,20}")){
            throw new IllegalArgumentException("Nome commerciale non valido!");
        }
    }
}
