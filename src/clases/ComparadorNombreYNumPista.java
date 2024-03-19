package clases;

import java.util.Comparator;
public class ComparadorNombreYNumPista implements Comparator<CancionImpl> {
   
	public int compare(CancionImpl c1, CancionImpl c2) {
        int cmp = c1.getNombre().compareToIgnoreCase(c2.getNombre());
        if (cmp == 0) {
            cmp = c1.getNumeroPista() - c2.getNumeroPista();
        }
        return cmp;
    }
}