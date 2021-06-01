package es.ubu.lsi.model.asociacion;

import java.io.Serializable;


import javax.persistence.*;


@Entity
@Table(name="Incidencia")

@NamedQueries({
	@NamedQuery(name = "Incidencia.findAll",
			query = "SELECT i FROM Incidencia i"),
	
})
public class Incidencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId private IncidenciaId id;
	
	
	@ManyToOne
	@JoinColumn(name="nif")
	@MapsId("nif")
	private Conductor conductor;
	

	


	
	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	@Column(name="anotacion")
	private String anotacion;
	
	@ManyToOne
	@JoinColumn(name="idtipo")
	private TipoIncidencia idtipo;



	public IncidenciaId getId() {
		return id;
	}

	public void setId(IncidenciaId id) {
		
		this.id = id;
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
	
	
	@Override
	public String toString() {
		return "Incidencia [ id = " + id.toString() + ", anotacion = " + anotacion + ", conductor = " + conductor.toString() +  ", tipoIncidencia = "+ idtipo.toString() +" ]";
	}
	

}
