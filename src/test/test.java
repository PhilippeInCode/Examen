package test;
import interfaces.*;
import java.util.Arrays;
import java.util.List;

import clases.*;
public class test {

	public static void main(String[] args) {
		
        //Comparando artistas

		ArtistaImpl artista1 = new ArtistaImpl("Pepe", "1", 80, Arrays.asList("Pop", "Rock"),
                Arrays.asList("Grammy al Mejor Álbum", "MTV Music Award"),
                Arrays.asList("https://url_imagen1.com", "https://url_imagen2.com"));

        ArtistaImpl artista2 = new ArtistaImpl("Pepe", "2", 80, Arrays.asList("Pop", "Rock"),
                Arrays.asList("Grammy al Mejor Álbum", "MTV Music Award"),
                Arrays.asList("https://url_imagen1.com", "https://url_imagen2.com"));

        System.out.println(artista1.compareTo(artista2));

        //Comparando canciones
        
        ComparadorNombreYNumPista cmp = new ComparadorNombreYNumPista();
        
        CancionImpl cancion1 = new CancionImpl("Cancion 1", "18Y8", 2.0, 2, 3, "https://dle.rae.es/de");

        CancionImpl cancion2 = new CancionImpl("Cancion 2", "U2HE", 3.0, 3, 4, "https://sede.agenciatributaria.gob.es");

        System.out.println(cmp.compare(cancion1, cancion2));
        
		
	}

}




























                                                                 