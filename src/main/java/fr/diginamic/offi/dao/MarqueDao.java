package fr.diginamic.offi.dao;

import javax.persistence.EntityManager;

import fr.diginamic.offi.entity.Marque;

/**
 * Gère la persistance des marques
 * 
 * @author RichardBONNAMY
 *
 */
public class MarqueDao extends EntiteDao<Marque> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public MarqueDao(EntityManager em) {
		super(em, Marque.class);
	}
}
