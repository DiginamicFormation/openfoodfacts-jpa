package fr.diginamic.offi.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.offi.entity.Categorie;

/**
 * Classe qui propose des services de traitement des catégories
 * 
 * @author RichardBONNAMY
 *
 */
public class CategorieDao {

	/** EntityManager */
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public CategorieDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionEntite(Categorie entite) {

		Categorie entiteBase = find(entite.getNom());
		if (entiteBase == null) {
			em.persist(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}

	/**
	 * Retrouve une catégorie en base à partir de son nom
	 * 
	 * @param Categorie
	 */
	public Categorie find(String nom) {

		TypedQuery<Categorie> query = em.createQuery("FROM Categorie WHERE nom=:nom", Categorie.class);
		query.setParameter("nom", nom);

		List<Categorie> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}
}
