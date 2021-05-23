package es.ubu.lsi.model.asociacion;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="Conductor")
public class Conductor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	private int idasoc;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="puntos")
	private int puntos;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="calle", column = @Column(name="direccion")),
		@AttributeOverride(name="codigoPostal", column = @Column(name="CP")),
		@AttributeOverride(name="ciudad", column = @Column(name="ciudad")),
	})
	private Direccion direccion;
	
	@OneToMany(mappedBy="nif")
	private Set<Incidencia> incidencias;
	
	@ManyToMany
	@JoinTable(name="Asociacion_Conductor", joinColumns=@JoinColumn(name="nif"), inverseJoinColumns=@JoinColumn(name="idasoc"))
	private Set<Asociacion> asociaciones;

	public int getIdasoc() {
		return idasoc;
	}

	public void setIdasoc(int idasoc) {
		this.idasoc = idasoc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Set<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(Set<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	public Set<Asociacion> getAsociaciones() {
		return asociaciones;
	}

	public void setAsociaciones(Set<Asociacion> asociaciones) {
		this.asociaciones = asociaciones;
	}


}
