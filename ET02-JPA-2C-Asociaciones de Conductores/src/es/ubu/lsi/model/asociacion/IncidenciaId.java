package es.ubu.lsi.model.asociacion;

import java.io.Serializable;
import java.util.Date;



public class IncidenciaId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncidenciaId() {}
	
	public IncidenciaId(Date fecha, int nif) {
		this.fecha=fecha;
		this.nif=nif;
		
	}

	private Date fecha;
	
	private int nif;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + nif;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncidenciaId other = (IncidenciaId) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (nif != other.nif)
			return false;
		return true;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getNif() {
		return nif;
	}

}
