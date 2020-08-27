package fr.diginamic.offi.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.diginamic.offi.db.DbMgr;
import fr.diginamic.offi.entity.Additif;
import fr.diginamic.offi.entity.Allergene;
import fr.diginamic.offi.entity.Ingredient;
import fr.diginamic.offi.entity.Produit;

/**
 * Classe qui prend en charge la totalité du traitement d'un produit
 * 
 * @author RichardBONNAMY
 *
 */
public class ProduitManager {

	/** EntityManager Hibernate */
	private EntityManager em;
	/** categorieService */
	private CategorieService categorieService;
	/** marqueService */
	private MarqueService marqueService;
	/** produitService */
	private ProduitService produitService;

	/** additifService */
	private AdditifService additifService;
	/** allergeneService */
	private AllergeneService allergeneService;
	/** ingredientService */
	private IngredientService ingredientService;

	/**
	 * Constructeur
	 * 
	 */
	public ProduitManager() {
		em = DbMgr.getEntityManager();

		categorieService = new CategorieService(em);
		marqueService = new MarqueService(em);
		produitService = new ProduitService(em);

		additifService = new AdditifService(em);
		allergeneService = new AllergeneService(em);
		ingredientService = new IngredientService(em);
	}

	/**
	 * Traite un produit: gère la totalité de la persistance du produit et de toutes
	 * ses données associées
	 * 
	 * @param produit produit à insérer en base de données.
	 */
	public void traiteProduit(Produit produit) {

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		categorieService.insertionEntite(produit.getCategorie());
		marqueService.insertionEntite(produit.getMarque());

		for (Additif additif : produit.getAdditifs()) {
			additifService.insertionEntite(additif);
		}

		for (Allergene allergene : produit.getAllergenes()) {
			allergeneService.insertionEntite(allergene);
		}

		for (Ingredient ingredient : produit.getIngredients()) {
			ingredientService.insertionEntite(ingredient);
		}

		produitService.insertionEntite(produit);

		transaction.commit();
	}

	/**
	 * Fermeture des ressources ouvertes par la classe
	 */
	public void close() {
		em.close();
	}
}
