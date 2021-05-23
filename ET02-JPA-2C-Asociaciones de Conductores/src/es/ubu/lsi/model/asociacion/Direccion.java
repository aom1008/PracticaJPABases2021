package es.ubu.lsi.model.asociacion;
import java.io.Serializable;

//import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Direccion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//@Column(name="direccion")
	private String calle;
	
	//@Column(name="CP")
	private String codigoPostal;
	
	//@Column(name="ciudad")
	private String ciudad;

	
	
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
