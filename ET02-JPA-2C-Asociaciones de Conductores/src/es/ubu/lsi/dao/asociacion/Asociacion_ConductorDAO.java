package es.ubu.lsi.dao.asociacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import es.ubu.lsi.dao.*;
import es.ubu.lsi.model.asociacion.Asociacion_Conductor;
import es.ubu.lsi.model.asociacion.Asociacion_ConductorId;


public class Asociacion_ConductorDAO extends JpaDAO<Asociacion_Conductor, Asociacion_ConductorId>{

	public Asociacion_ConductorDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Asociacion_Conductor> findAll() {
		try {
		TypedQuery<Asociacion_Conductor> query = getEntityManager().createNamedQuery("Factura.findAll", Asociacion_Conductor.class);
		
		return query.getResultList();
		} catch (Exception e) {
			//El logger
			throw new RuntimeException(e);
		}
	}

}
