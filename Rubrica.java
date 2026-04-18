public interface Rubrica {
    String aggiungiContatto(String nome, String num);
    String aggiornaContatto(String nome, String num);
    String trovaContatto(String nome);
    String rimuoviContatto(String nome);
    String stampaRubrica();
}
