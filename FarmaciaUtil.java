package ES4;

import ES1.Armadio;
import ES1.Farmaco;

import java.io.PrintWriter;
import java.util.List;

public class FarmaciaUtil {
    public static void stampaScadenziario(List<? extends Armadio<? extends Farmaco>> reparto, PrintWriter pw){
        pw.write("Report dei reparti");
        for(Armadio<? extends Farmaco> r : reparto){
            for(Farmaco f : r){
                pw.println(f.toString());
            }
        }
    }

    // da fare metodo con il file aggiuntivo (creato da noi)
}

