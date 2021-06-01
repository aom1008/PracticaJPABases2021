package es.ubu.lsi.dao.asociacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import es.ubu.lsi.dao.*;
import es.ubu.lsi.model.asociacion.Conductor;


public class ConductorDAO extends JpaDAO<Conductor, String>{

	public ConductorDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<Conductor> findAll() {
		try {
			TypedQuery<Conductor> query = getEntityManager().createNamedQuery("Conductor.findAll", Conductor.class);
			
			return query.getResultList();
			} catch (Exception e) {
				//El logger
				throw new RuntimeException(e);
			}
	}
	

}
