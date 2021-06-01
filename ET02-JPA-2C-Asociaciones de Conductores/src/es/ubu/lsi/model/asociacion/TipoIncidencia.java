package es.ubu.lsi.model.asociacion;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="TipoIncidencia")

@NamedQueries({
	@NamedQuery(name = "TipoIncidencia.findAll",
			query = "SELECT t FROM TipoIncidencia t ORDER BY t.id"),
})
public class TipoIncidencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@SequenceGenerator(name="Sec_TipoInc", allocationSize=1, initialValue=1 , sequenceName="TIPOINCIDENCIA_SEQ")
	@Id @GeneratedValue(generator="Sec_TipoInc")
	private long id;
	
	private String descripcion;
	
	private int valor;

	@OneToMany(mappedBy="idtipo")
	private Set<Incidencia> incidencias;
	
	public Set<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(Set<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	@Override
	public String toString() {
		return "TipoIncidencia [ id = " + id + ", descripcion = " + descripcion + ", valor = " + valor +" ]";
	}

}
