package es.ubu.lsi.model.asociacion;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@IdClass(IncidenciaId.class)
@Table(name="Incidencia")

@NamedQueries({
	@NamedQuery(name = "Incidencia.findAll",
			query = "SELECT i FROM Incidencia i ORDER BY i.fecha"),
	
})
public class Incidencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	
	@ManyToOne
	@JoinColumn(name="nif")
	private Conductor conductor;
	
	@Id
	private String nif = conductor.getNif();
	
	@Column(name="anotacion")
	private String anotacion;
	
	@ManyToOne
	@JoinColumn(name="idtipo")
	private TipoIncidencia idtipo;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		
		this.nif = nif;
	}

	public String getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

	public TipoIncidencia getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(TipoIncidencia idtipo) {
		this.idtipo = idtipo;
	}
	
	
	
	

}
