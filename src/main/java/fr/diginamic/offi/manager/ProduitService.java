package fr.diginamic.offi.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.offi.entity.Produit;

/**
 * Classe qui propose des services de traitement des produits
 * 
 * @author RichardBONNAMY
 *
 */
public class ProduitService {

	/** EntityManager */
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public ProduitService(EntityManager em) {
		this.em = em;
	}

	/**
	 * Insère l'entité en base de données**
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionEntite(Produit entite) {
		Produit entiteBase = find(entite.getNom());
		if (entiteBase != null) {
			return;
		}

		em.persist(entite);
	}

	/**
	 * Retrouve un produit en base à partir de son nom
	 * 
	 * @param Produit
	 */
	public Produit find(String nom) {

		TypedQuery<Produit> query = em.createQuery("FROM Produit WHERE nom=:nom", Produit.class);
		query.setParameter("nom", nom);

		List<Produit> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}

}
