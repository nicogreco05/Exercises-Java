package ES4;

import ES1.Scaffale;
import ES1.Supporto;

import java.io.PrintWriter;
import java.util.List;

public class MediaUtil {
    public static void stampaReport(List<? extends Scaffale<? extends Supporto>> scaffali, PrintWriter pw){
        pw.append("Lista di supporti presenti nella lista passata come parametro");
        for(Scaffale<? extends Supporto> scaffale : scaffali){
            for(Supporto supporto : scaffale){
                pw.println(supporto);
            }
        }
        pw.flush();
    }
}
