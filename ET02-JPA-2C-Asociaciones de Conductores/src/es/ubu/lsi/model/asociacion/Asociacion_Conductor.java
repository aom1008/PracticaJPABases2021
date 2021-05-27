package es.ubu.lsi.model.asociacion;

import java.io.Serializable;
import javax.persistence.*;

@Entity


@NamedQueries({
	@NamedQuery(name = "Asociacion_Conductor.findAll",
			query = "SELECT a FROM Asociacion_Conductor a"),
})
public class Asociacion_Conductor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Asociacion_ConductorId id;

	public Asociacion_ConductorId getId() {
		return id;
	}

	public void setIdasoc(Asociacion_ConductorId idasoc) {
		this.id = idasoc;
	}



}
