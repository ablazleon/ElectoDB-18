package es.upm.dit.isst.webLab.dao;

import java.util.ArrayList;
import java.util.List;

import es.upm.dit.isst.webLab.model.TFG;

import org.hibernate.Session;

public class TFGDAOImplementation implements TFGDAO {
	
	
	// Singleton pattern
	private static TFGDAOImplementation instance = null;
	private TFGDAOImplementation() {};

	public static TFGDAOImplementation getInstance() {
		if(null == instance) {
			instance = new TFGDAOImplementation();
		}
		return instance;
	};
	
	
	//Para cada operación CRUD se sigue el siguiente patrón:
	// 1. Se abre una sesión de hibernate
	// 2. Hacerlas operaciones protegidas con try catch
	// 3. Se incluyen las operaciones dentro de las transacciones
	// 4. Se cierra la sesión.
	
	
	@Override
	public void createTFG(TFG tfg) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(tfg);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
		} finally {
			session.close();
		}
		
	}

	@Override
	public TFG readTFG(String email) {
		TFG tfg = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			tfg = session.get(TFG.class, email);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void updateTFG(TFG tfg) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(tfg);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
		} finally {
			session.close();
		}
		
	}

	@Override
	public void deleteTFG(TFG tfg) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(tfg);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<TFG> readAllTFG() {
		List<TFG> tfgs = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			tfgs.addAll(
					session.createQuery("from TFG").list()
					);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
		} finally {
			session.close();
		}
		return tfgs;
	}

}
