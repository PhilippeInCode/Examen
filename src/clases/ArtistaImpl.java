package clases;
import interfaces.*;
import java.util.Collections;
import java.util.List;

public class ArtistaImpl implements Artista, Comparable<Object> {
	// Propiedades
	private String nombre;
	private String id;
	private Integer popularidad;
	private List<String> generos;
	private List<String> premios;
	private List<String> urlImagenes;

	// Constructores
	public ArtistaImpl(String nombre, String id, Integer popularidad, List<String> generos, List<String> premios,
			List<String> urlImagenes) {
		this.nombre = nombre;
		this.id = id;
		this.popularidad = popularidad;
		this.generos = generos;
		this.premios = premios;
		this.urlImagenes = urlImagenes;
	}

	// Métodos consultables
	public String getNombre() {
		return nombre;
	}

	public String getId() {
		return id;
	}

	public Integer getPopularidad() {
		return popularidad;
	}

	public List<String> getGeneros() {
		return generos;
	}

	public List<String> getPremios() {
		return premios;
	}

	public List<String> getUrlImagenes() {
		return urlImagenes;
	}

	// Métodos modificables
	public void setPopularidad(Integer popularidad) {
		this.popularidad = popularidad;
	}

	public void setPremios(List<String> premios) {
		this.premios = premios;
	}

	public void setUrlImagenes(List<String> urlImagenes) {
		this.urlImagenes = urlImagenes;
	}

	// Restricciones
	public void verificarRestricciones() throws IllegalArgumentException {
		// R1: El id debe contener 22 caracteres
		if (id.length() != 22) {
			throw new IllegalArgumentException("El ID debe contener exactamente 22 caracteres.");
		}

		// R2: La popularidad debe estar comprendida entre 0 y 100, ambos inclusive
		if (popularidad < 0 || popularidad > 100) {
			throw new IllegalArgumentException("La popularidad debe estar comprendida entre 0 y 100.");
		}

		// R3: La URL de todas las imágenes del artista deben comenzar por "http"
		for (String url : urlImagenes) {
			if (!url.startsWith("http")) {
				throw new IllegalArgumentException("La URL de las imágenes debe comenzar por 'http'.");
			}
		}
	}

	public int compareTo(Object o) {
        int cmp = -1;
        if (o instanceof Artista && o != null) {
            Artista a = (Artista) o;
            cmp = this.getNombre().compareTo(a.getNombre());
            if (cmp == 0) {
                Collections.sort(this.getPremios());
                Collections.sort(a.getPremios());

                String lista = null;
                for (String elemento : this.getPremios()) {

                    lista += elemento + "-";
                }

                String lista2 = null;
                for (String elemento : a.getPremios()) {

                    lista2 += elemento + "-";
                }
                cmp = lista.compareTo(lista2);
            }
            if (cmp == 0) {
                cmp = 0;
            } else if (cmp > 0) {
                cmp = 1;
            } else {
                cmp = -1;
            }
        }
        return cmp;
    }
}
