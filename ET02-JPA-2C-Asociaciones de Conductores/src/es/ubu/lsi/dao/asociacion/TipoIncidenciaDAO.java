package es.ubu.lsi.dao.asociacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import es.ubu.lsi.dao.*;
import es.ubu.lsi.model.asociacion.TipoIncidencia;



public class TipoIncidenciaDAO extends JpaDAO<TipoIncidencia, Long>{

	public TipoIncidenciaDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TipoIncidencia> findAll() {
		try {
		TypedQuery<TipoIncidencia> query = getEntityManager().createNamedQuery("Factura.findAll", TipoIncidencia.class);
		
		return query.getResultList();
		} catch (Exception e) {
			//El logger
			throw new RuntimeException(e);
		}
	}

}
