package fr.diginamic.offi.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.offi.entity.Ingredient;

/**
 * Classe qui propose des services de traitement des ingrédients
 * 
 * @author RichardBONNAMY
 *
 */
public class IngredientService {

	/** EntityManager */
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public IngredientService(EntityManager em) {
		this.em = em;
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionEntite(Ingredient entite) {

		Ingredient entiteBase = find(entite.getNom());
		if (entiteBase == null) {
			em.persist(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}

	/**
	 * Retrouve un ingrédient en base à partir de son nom
	 * 
	 * @param Ingredient
	 */
	public Ingredient find(String nom) {

		TypedQuery<Ingredient> query = em.createQuery("FROM Ingredient WHERE nom=:nom", Ingredient.class);
		query.setParameter("nom", nom);

		List<Ingredient> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}

}
