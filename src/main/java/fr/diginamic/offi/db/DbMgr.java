package fr.diginamic.offi.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe qui fournit une connexion à la base de données.
 * 
 * @author RichardBONNAMY
 *
 */
public class DbMgr {

	/** entityManagerFactory */
	private static EntityManagerFactory entityManagerFactory;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("openfoodfacts");
	}

	/**
	 * Retourne un {@link EntityManager}
	 * 
	 * @return EntityManager
	 */
	public static EntityManager getEntityManager() {

		EntityManager em = entityManagerFactory.createEntityManager();
		return em;
	}

}
