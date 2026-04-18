import java.util.HashMap;
import java.util.Map;

public class RubricaImpl implements Rubrica{
    private String nome;
    private String num;

    private HashMap<String, String> rubrica = new HashMap<>();

    @Override
    public String aggiungiContatto(String nome, String num){
        if(nome == null){
            throw new IllegalArgumentException("Nome non valido!");
        }
        if(num == null || num.length() != 10){
            throw new IllegalArgumentException("Numero non valido!");
        }
        rubrica.put(nome, num);
        return "Contatto inserito";
    }

    @Override
    public String aggiornaContatto(String nome, String numero){
        if(rubrica.containsKey(nome) == false){
            throw new IllegalArgumentException("Contatto inesistente");
        }
        else{
            rubrica.put(nome, numero);
            return "Contatto aggiornato, il nuovo numero è: " + rubrica.get(nome);
        }
    }

    @Override
    public String trovaContatto(String nome){
        if(rubrica.containsKey(nome) == false){
            throw new IllegalArgumentException("Contatto inesistente");
        }
        return ("Nome: " + nome + ", Numero: " + rubrica.get(nome));
    }

    @Override
    public String rimuoviContatto(String nome){
        if(rubrica.containsKey(nome) == false){
            throw new IllegalArgumentException("Contatto inesistente");
        }
        else{
            rubrica.remove(nome);
        }
        return "Contatto rimosso";
    }

    @Override
    public String stampaRubrica(){
        // metodo che mi consente di iterare sull'hashmap e restituisce ogni oggetto (chiave, valore) dell'hash map
        for(Map.Entry<String, String> entry : rubrica.entrySet()){
            System.out.println("Nome: " + entry.getKey() + ", Numero: " + entry.getValue());
        }
        return "Fine rubrica";
    }
}
