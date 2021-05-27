package es.ubu.lsi.model.asociacion;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Asociacion_ConductorId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Asociacion_ConductorId() {}
	
	public Asociacion_ConductorId(String idasoc, String nif) {
		
		this.idasoc=idasoc;
		this.nif=nif;
	}
	
	private String idasoc;
	
	
	private String nif;
	
	public String getIdasoc() {
		return idasoc;
	}
	public String getNif() {
		return nif;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idasoc.hashCode();
		result = prime * result + nif.hashCode();
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
		Asociacion_ConductorId other = (Asociacion_ConductorId) obj;
		if (idasoc != other.idasoc)
			return false;
		if (nif != other.nif)
			return false;
		return true;
	}


}
