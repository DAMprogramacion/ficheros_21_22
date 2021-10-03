package ficherosCSV;

public class Sitio {
	
	//atributos
	private String ciudad;
	private String pais;
	private float latitud;
	private float longitud;
	
	//getters y setters
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return String.format("Ciudad=%s, pais=%s, latitud=%.2f, longitud=%.2f",
				ciudad, pais, latitud, longitud);
	}
	
	

	


}
