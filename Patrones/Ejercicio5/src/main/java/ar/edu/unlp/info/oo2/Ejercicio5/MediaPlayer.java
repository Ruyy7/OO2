package ar.edu.unlp.info.oo2.Ejercicio5;

import java.util.List;

public class MediaPlayer {
	private List<Media> archivos;
	
	public String play() {
		String titulosArchivos = "";
		for (Media media : archivos) {
			titulosArchivos += media + " ";
		}
		return titulosArchivos;
	}
}
