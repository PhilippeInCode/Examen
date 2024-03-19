package clases;

import interfaces.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ListaReproduccionImpl implements ListaReproduccion {
	// Propiedades
	private String nombre;
	private List<Cancion> canciones;

	// Constructores
	public ListaReproduccionImpl(String nombre) {
		this.nombre = nombre;
		this.canciones = new ArrayList<>();
	}

	// Métodos consultables
	public String getNombre() {
		return nombre;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public Integer getNumeroCanciones() {
		return canciones.size();
	}

	// Métodos modificables
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Representación como cadena
	@Override
	public String toString() {
		return nombre + " (" + canciones.size() + " canciones)";
	}

	// Criterio de igualdad
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ListaReproduccionImpl))
			return false;
		ListaReproduccionImpl that = (ListaReproduccionImpl) o;
		return canciones.equals(that.canciones);
	}

	@Override
	public int hashCode() {
		return Objects.hash(canciones);
	}

	public List<Cancion> getSublistaArtista(String artista) {
		List<Cancion> lista = new ArrayList<>();

		for (Cancion c : canciones) {
			for (Artista a : c.getArtistas()) {
				if (a.getId().equals(artista)) {
					lista.add(c);
				}
			}

		}
		return lista;
	}

	public void muestraFotosArtistas() {
		List<Artista> listaArtistas = new ArrayList<>();
		for (Artista a : listaArtistas) {
			List<String> listaImagenes = a.getUrlImagenes();
			if (!listaImagenes.isEmpty()) {
				String idArtista = a.getId();
				for (String urlImagen : listaImagenes) {
					Imagenes.show(idArtista, urlImagen);
				}
			}
		}
	}

	public List<Cancion> getCancionesPorArtista(String idArtista) {
		List<Cancion> cancionesPorArtista = new ArrayList<>();

		for (Cancion c : canciones) {
			for (Artista a : c.getArtistas()) {
				if (a.getId().equals(idArtista)) {
					cancionesPorArtista.add(c);
					break;
				}
			}
		}

		return cancionesPorArtista;
	}

	public Map<String, List<Artista>> artistasPorGenero() {
		Map<String, List<Artista>> artistasPorGenero = new Hashtable<>();
		List<Artista> listaArtistas = new ArrayList<>();
		for (Cancion c : canciones) {
			for (Artista a : c.getArtistas()) {
				for (String g : a.getGeneros()) {
					if (!(artistasPorGenero.containsKey(g))) {
						listaArtistas = new ArrayList<Artista>();
						listaArtistas.add(a);
						artistasPorGenero.put(g, listaArtistas);
					} else {
						artistasPorGenero.get(g).add(a);
					}
				}
			}
		}
		return artistasPorGenero;

	}

}
