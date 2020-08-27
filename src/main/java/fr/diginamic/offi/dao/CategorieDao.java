package fr.diginamic.offi.dao;

import javax.persistence.EntityManager;

import fr.diginamic.offi.entity.Categorie;

/**
 * Gère la persistance des catégories
 * 
 * @author RichardBONNAMY
 *
 */
public class CategorieDao extends EntiteDao<Categorie> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public CategorieDao(EntityManager em) {
		super(em, Categorie.class);
	}
}
