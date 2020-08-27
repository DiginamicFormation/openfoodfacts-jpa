package fr.diginamic.offi.dao;

import javax.persistence.EntityManager;

import fr.diginamic.offi.entity.Produit;

/**
 * Gère la persistance des produits
 * 
 * @author RichardBONNAMY
 *
 */
public class ProduitDao extends EntiteDao<Produit> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion
	 */
	public ProduitDao(EntityManager em) {
		super(em, Produit.class);
	}
}
