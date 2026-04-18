package ES1;

public record CodiceCorso(String val) {
    public CodiceCorso{
        if(val == null){
            throw new NullPointerException("Codice corso non valido!");
        }
        if(!val.matches("^[a-zA-z]{2}-\\d{3}[a-zA-z]{1}$")){
            throw new IllegalArgumentException("Codice corso non valido!");
        }

    }
}
