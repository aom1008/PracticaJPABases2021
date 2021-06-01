package es.ubu.lsi.dao.asociacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import es.ubu.lsi.dao.*;
import es.ubu.lsi.model.asociacion.Incidencia;

import es.ubu.lsi.model.asociacion.IncidenciaId;


public class IncidenciaDAO extends JpaDAO<Incidencia, IncidenciaId>{

	public IncidenciaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Incidencia> findAll() {
		try {
			TypedQuery<Incidencia> query = getEntityManager().createNamedQuery("Factura.findAll", Incidencia.class);
			
			return query.getResultList();
			} catch (Exception e) {
				//El logger
				throw new RuntimeException(e);
			}
	}

}
