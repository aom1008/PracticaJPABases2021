package es.ubu.lsi.model.asociacion;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@IdClass(Asociacion_ConductorId.class)

@NamedQueries({
	@NamedQuery(name = "Asociacion_Conductor.findAll",
			query = "SELECT a FROM Asociacion_Conductor a"),
})
public class Asociacion_Conductor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int idasoc;
	
	@Id
	private int nif;

	public int getIdasoc() {
		return idasoc;
	}

	public void setIdasoc(int idasoc) {
		this.idasoc = idasoc;
	}

	public int getNif() {
		return nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
	}

}
