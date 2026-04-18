package ES5;

import ES2.Palestra;

import java.util.List;
import java.io.PrintWriter;

public class PalestraUtil {
    public static void StampaReportAttivita(List<? extends Palestra> palestre, PrintWriter pw){
        int countPalestra = 1;
        for(Palestra p : palestre){
            pw.println("Palestra " + countPalestra);
            pw.println(p.toString());
            pw.println("Fine informazioni palestra" + countPalestra);
            countPalestra++;
        }
    }
}
