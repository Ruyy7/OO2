package ar.edu.unlp.info.oo2.Ejercicio5;

public class VideoStreamAdapter extends Media {
	VideoStream adaptado;
	
	public String play() {
		return this.adaptado.reproduce();
	}

}
