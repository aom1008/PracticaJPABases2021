package es.ubu.lsi.model.asociacion;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="Asociacion")

@NamedQueries({
	@NamedQuery(name = "Asociacion.findAll",
			query = "SELECT a FROM Asociacion a ORDER BY a.idasoc"),
})
public class Asociacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idasoc;
	
	@Column(name="nombre")
	private String nombre;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="calle", column = @Column(name="direccion")),
		@AttributeOverride(name="codigoPostal", column = @Column(name="CP")),
		@AttributeOverride(name="ciudad", column = @Column(name="ciudad")),
	})
	private Direccion direccion;
	
	@ManyToMany(mappedBy="asociaciones")
	private Set<Conductor> conductores;

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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Set<Conductor> getConductores() {
		return conductores;
	}

	public void setConductores(Set<Conductor> conductores) {
		this.conductores = conductores;
	}
	public void addConductor(Conductor conductor) {
		if (conductor != null && !getConductores().contains(conductor)) {
			getConductores().add(conductor);
			conductor.addAsociacion(this);
		}
	}
	public void removeConductor(Conductor conductor) {
		if (conductor != null && getConductores().contains(conductor)) {
			getConductores().remove(conductor);
			conductor.addAsociacion(this);
		}
	}

}
