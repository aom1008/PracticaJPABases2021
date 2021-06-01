package es.ubu.lsi.dao.asociacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import es.ubu.lsi.dao.*;
import es.ubu.lsi.model.asociacion.Asociacion;


public class AsociacionDAO extends JpaDAO<Asociacion, String> {

	public AsociacionDAO(EntityManager em) {
		super(em);
		
	}

	@Override
	public List<Asociacion> findAll() {
		try {
		TypedQuery<Asociacion> query = getEntityManager().createNamedQuery("Factura.findAll", Asociacion.class);
		
		return query.getResultList();
		} catch (Exception e) {
			//El logger
			throw new RuntimeException(e);
		}
	}

}
