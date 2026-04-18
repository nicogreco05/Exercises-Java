package ES4;

import ES1.Espositore;
import ES1.Strumento;

import java.io.PrintWriter;
import java.util.List;

public class EspositoreUtil {
    public static void stampaReport(List<? extends Espositore<? extends Strumento>> espositori, PrintWriter pw){
        pw.write("Report degli espositori");
        int count = 1;
        for(Espositore<?> e : espositori){
            pw.println(e);
        }
    }

    // metodo che dato un file con all'interno liste di sturmenti ritorna una lista con quegli strumenti
}
