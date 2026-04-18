import java.util.HashMap;

public class Main {
    public void main(String[] args){
        RubricaImpl rub = new RubricaImpl();
        System.out.println(rub.aggiungiContatto("Silvio", "3335363210"));
        System.out.println(rub.aggiungiContatto("Mario", "3335363211"));
        System.out.println(rub.aggiungiContatto("Pino", "3335363212"));
        System.out.println(rub.aggiungiContatto("Matteo", "3335363213"));
        System.out.println(rub.aggiungiContatto("Nicolò", "3335363214"));

        System.out.println(rub.stampaRubrica());
    }
}