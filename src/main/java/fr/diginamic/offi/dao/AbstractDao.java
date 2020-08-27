package fr.diginamic.offi.dao;

import javax.persistence.EntityManager;

/**
 * Classe mère de toutes les DAO qui fournit quelques attributs de base
 * 
 * @author RichardBONNAMY
 *
 */
public class AbstractDao {

	/** entityManager */
	protected EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public AbstractDao(EntityManager em) {
		super();
		this.em = em;
	}

	/**
	 * Getter
	 * 
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}
}
