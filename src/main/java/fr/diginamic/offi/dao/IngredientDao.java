package fr.diginamic.offi.dao;

import javax.persistence.EntityManager;

import fr.diginamic.offi.entity.Ingredient;

/**
 * Gère la persistance des ingrédients
 * 
 * @author RichardBONNAMY
 *
 */
public class IngredientDao extends EntiteDao<Ingredient> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public IngredientDao(EntityManager em) {
		super(em, Ingredient.class);
	}
}
