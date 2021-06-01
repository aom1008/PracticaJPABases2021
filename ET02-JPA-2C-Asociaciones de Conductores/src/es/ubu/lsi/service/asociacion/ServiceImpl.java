package es.ubu.lsi.service.asociacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import es.ubu.lsi.dao.asociacion.*;
import es.ubu.lsi.model.asociacion.Asociacion;
import es.ubu.lsi.model.asociacion.*;
import es.ubu.lsi.model.asociacion.TipoIncidenciaRanking;
import es.ubu.lsi.service.PersistenceException;
import es.ubu.lsi.service.PersistenceService;

public class ServiceImpl extends PersistenceService implements Service{
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

	@Override
	public void insertarIncidencia(Date fecha, String nif, long tipo) throws PersistenceException {
		EntityManager em = this.createSession();
		
		try {
			beginTransaction(em);
			
			//DAO
			ConductorDAO conductorDAO = new ConductorDAO(em);
			TipoIncidenciaDAO tipoIncidenciaDAO = new TipoIncidenciaDAO(em);
			
			Conductor conductor = conductorDAO.findById(nif);
			
			if (conductor == null) {
				throw new IncidentException(IncidentError.NOT_EXIST_DRIVER);
			}
			
			TipoIncidencia tipoIncidencia = tipoIncidenciaDAO.findById(tipo);
			
			if (tipoIncidencia == null) {
				throw new IncidentException(IncidentError.NOT_EXIST_INCIDENT_TYPE);
			}
			
			int puntosConductor = conductor.getPuntos();
			int puntosIncidencia = tipoIncidencia.getValor();

			int puntosRestantes = puntosConductor - puntosIncidencia;
			
			if (puntosRestantes < 0) {
				throw new IncidentException(IncidentError.NOT_AVAILABLE_POINTS);
			}
			
			//Actualizamos los puntos del conductor
			conductor.setPuntos(puntosRestantes);

			
			//Creamos la nueva Incidencia
			IncidenciaId id = new IncidenciaId(fecha, nif);
			Incidencia incidencia = new Incidencia();
			incidencia.setId(id);
			incidencia.setIdtipo(tipoIncidencia);
			conductor.addIncidencia(incidencia);
			em.persist(incidencia);
			
			

			commitTransaction(em);
			
			
			
		} catch(Exception e) {
			rollbackTransaction(em);
			if (e instanceof IncidentException) {
				throw e;
			}
			else {
				logger.debug(e.getMessage());
			}
			
		}
		
		finally {
			em.close();
		}
		
		
		
	}

	@Override
	public void indultar(String nif) throws PersistenceException {
		EntityManager em = this.createSession();
		
		try {
			beginTransaction(em);
			
			//DAO
			ConductorDAO conductorDAO = new ConductorDAO(em);
			Conductor conductor = conductorDAO.findById(nif);
			
			if (conductor == null) {
				throw new IncidentException(IncidentError.NOT_EXIST_DRIVER);
			}
			
			conductor.setPuntos(12);
			
			Set<Incidencia> incidencias = conductor.getIncidencias();

			
			for (Incidencia incidencia : incidencias) {
				//conductor.removeIncidencia(incidencia);
				em.remove(incidencia);
			}
			

			commitTransaction(em);
			
			
			
		} catch(Exception e) {
			
			rollbackTransaction(em);
			if (e instanceof IncidentException) {
				throw e;
			}
			else {
				logger.debug(e.getMessage());
			}
			
		}
		
		finally {
			em.close();
		}
		
		
		
	}

	@Override
	public void insertarTipoIncidencia(String descripcion, int valor) throws PersistenceException {
		EntityManager em = this.createSession();
		
		try {
			beginTransaction(em);
			
			TipoIncidencia nuevoTipoIncidencia = new TipoIncidencia();
			
			nuevoTipoIncidencia.setValor(valor);
			nuevoTipoIncidencia.setDescripcion(descripcion);
			
			em.persist(nuevoTipoIncidencia);

			commitTransaction(em);
			
			
			
		} catch(Exception e) {
			
			rollbackTransaction(em);
			if (e instanceof IncidentException) {
				throw e;
			}
			else {
				logger.debug(e.getMessage());
			}
			
		}
		
		finally {
			em.close();
		}
		
		
	}

	@Override
	public int consultarNumeroConductoresConIncidenciasEnAsoc(String idasoc) throws PersistenceException {
		EntityManager em = this.createSession();
		int devolver = 0;
		
		try {
			beginTransaction(em);
			
			AsociacionDAO asociacionDAO = new AsociacionDAO(em);
			Asociacion asociacion = asociacionDAO.findById(idasoc);
			
			if (asociacion == null) {
				throw new IncidentException(IncidentError.NOT_EXIST_ASSOCIATION);
			}
			
			Set<Conductor> conductores = asociacion.getConductores();
			
			for(Conductor conductor : conductores) {
				if(conductor.getIncidencias()!= null && conductor.getIncidencias().size()>0) {
					devolver++;
				}
			}
			commitTransaction(em);
			
			
			
		} catch(Exception e) {
			
			rollbackTransaction(em);
			if (e instanceof IncidentException) {
				throw e;
			}
			else {
				logger.debug(e.getMessage());
			}
			
		}
		
		finally {
			em.close();
			
		}
		return devolver;
		

	}
	
	
	@Override
	public List<TipoIncidenciaRanking> consultarRanking() throws PersistenceException {
		EntityManager em = this.createSession();
		
		List<TipoIncidenciaRanking> devolver = new ArrayList<TipoIncidenciaRanking>();
		try {
			
			devolver = em.createQuery("SELECT NEW es.ubu.lsi.model.asociacion.TipoIncidenciaRanking ( t.descripcion, COUNT(i)) FROM TipoIncidencia t LEFT JOIN t.incidencias i GROUP BY t.descripcion ORDER BY count(i)",TipoIncidenciaRanking.class).getResultList();
			
			
		

;
		} catch(Exception e) {
			rollbackTransaction(em);
			if (e instanceof IncidentException) {
				throw e;
			}
			else {
				logger.error(e.getMessage());
			}
			
		}
		
		finally {
			em.close();
			
		}
		return devolver;
	}
	
	
	@SuppressWarnings("unchecked")
	//Problema de genearcidad
	@Override
	public List<Asociacion> consultarAsociaciones() throws PersistenceException {
		EntityManager em = this.createSession();
		List<Asociacion> asociaciones = null;
		
		try {
			asociaciones = em.createNamedQuery("Asociacion.findAll").setHint("javax.persistence.fetchgraph", em.getEntityGraph("asociacionesConConductoresIncidencias")).getResultList();
			
			} catch(Exception e) {
			
			rollbackTransaction(em);
			if (e instanceof IncidentException) {
				throw e;
			}
			else {
				logger.error(e.getMessage());
			}
			
		}
		
		finally {
			em.close();
			
		}
		return asociaciones;
	}




	


}
