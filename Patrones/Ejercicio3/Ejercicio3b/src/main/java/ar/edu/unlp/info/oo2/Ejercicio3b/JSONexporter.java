package ar.edu.unlp.info.oo2.Ejercicio3b;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONexporter extends VoorheesExporter{
	private JSONObject exporter = new JSONObject();
	private JSONArray listGenerator = new JSONArray();
	
	private String exportar(Socio socio) {
		this.exporter.put("nombre", socio.getNombre());
		this.exporter.put("email", socio.getEmail());
		this.exporter.put("legajo", socio.getLegajo());
		return this.exporter.toString();
	}
	
	public String exportar(List<Socio> socios) {
		socios.stream().forEach(s -> this.listGenerator.add(this.exportar(s)));
		return listGenerator.toJSONString();
	}
	
	
}
