package es.ubu.lsi.model.asociacion;


public class TipoIncidenciaRanking {
	
	private long numeroApariciones;
	private String tipoIncidencia;
	
	
	public TipoIncidenciaRanking(String tipoIncidencia, long numeroApariciones) {
		this.setNumeroApariciones(numeroApariciones);
		this.setTipoIncidencia(tipoIncidencia);
	}
	
	
	public long getNumeroApariciones() {
		return numeroApariciones;
	}
	public void setNumeroApariciones(long numeroApariciones) {
		this.numeroApariciones = numeroApariciones;
	}
	public String getTipoIncidencia() {
		return tipoIncidencia;
	}
	public void setTipoIncidencia(String tipoIncidencia) {
		this.tipoIncidencia = tipoIncidencia;
	}

	@Override
	public String toString() {
		return "TipoIncidenciaRanking [tipoIncidencia = " + tipoIncidencia + ", apariciones = " + numeroApariciones + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (numeroApariciones ^ (numeroApariciones >>> 32));
		result = prime * result + ((tipoIncidencia == null) ? 0 : tipoIncidencia.hashCode());
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
		TipoIncidenciaRanking other = (TipoIncidenciaRanking) obj;
		if (numeroApariciones != other.numeroApariciones)
			return false;
		if (tipoIncidencia == null) {
			if (other.tipoIncidencia != null)
				return false;
		} else if (!tipoIncidencia.equals(other.tipoIncidencia))
			return false;
		return true;
	}

	

}
