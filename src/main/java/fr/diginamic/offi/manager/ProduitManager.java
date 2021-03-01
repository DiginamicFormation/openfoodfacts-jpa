package fr.diginamic.offi.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProduitManager.class);

	/** EntityManager Hibernate */
	private EntityManager em;
	/** categorieService */
	private CategorieDao categorieService;
	/** marqueService */
	private MarqueDao marqueService;
	/** produitService */
	private ProduitDao produitService;

	/** additifService */
	private AdditifDao additifService;
	/** allergeneService */
	private AllergeneDao allergeneService;
	/** ingredientService */
	private IngredientDao ingredientService;

	/**
	 * Constructeur
	 * 
	 */
	public ProduitManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("openfoodfacts");
		em = entityManagerFactory.createEntityManager();

		categorieService = new CategorieDao(em);
		marqueService = new MarqueDao(em);
		produitService = new ProduitDao(em);

		additifService = new AdditifDao(em);
		allergeneService = new AllergeneDao(em);
		ingredientService = new IngredientDao(em);
	}

	/**
	 * Traite un produit: gère la totalité de la persistance du produit et de toutes
	 * ses données associées
	 * 
	 * @param produit produit à insérer en base de données.
	 */
	public void traiteProduit(Produit produit) {

		LOGGER.debug("Produit" + produit.getNom());

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
