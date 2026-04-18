package ES5;

import ES1.*;
import ES2.Palestra;
import ES3.PalestraImpl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PalestraApp {
    public static void main(String[] args){
        Forza f1 = new Forza(new CodiceCorso("AB-123A"), "CodiceForza", 5, 2, new Orario(Giorno.LUN, 2, 15), 40, Intensita.ALTA);
        Palestra p1 = new PalestraImpl();
        p1.aggiungiCorso(f1);
        PrintWriter pw = new PrintWriter(System.out);
        List<Palestra> listaPalestre = new ArrayList<>(List.of(p1));
        PalestraUtil.StampaReportAttivita(listaPalestre, pw);
        pw.flush();


    }
}
