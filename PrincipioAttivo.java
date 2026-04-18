package ES1;

public record PrincipioAttivo(String val) {
    public PrincipioAttivo{
        if(val == null){
            throw new NullPointerException("Stringa nulla");
        }
        if(!val.matches("[a-zA-Z]")){
            throw new IllegalArgumentException("Principio attivo non valido");
        }
    }
}
