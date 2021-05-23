package es.ubu.lsi.model.asociacion;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="TipoIncidencia")
public class TipoIncidencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private String descripcion;
	
	private int valor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	

}
