package ES1;

import java.util.List;

public record Orario(Giorno gg, int ora, int min) {
    // creo una lista di minuti validi
    private static List<Integer> minValidi = List.of(00,15,30,45);
    public Orario{
        if(gg == null){
            throw new NullPointerException("Giorno non valido!");
        }
        if(ora <= 0 || ora > 23){
            throw new IllegalArgumentException("Orario non valido!");
        }
        if(!minValidi.contains(min)){
            throw new IllegalArgumentException("Minuti non validi!");
        }
    }
}
