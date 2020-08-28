package fr.diginamic.offi.manager;

import javax.persistence.EntityManager;

import fr.diginamic.offi.dao.ProduitDao;
import fr.diginamic.offi.entity.Produit;

/**
 * Classe qui propose des services de traitement des produits
 * 
 * @author RichardBONNAMY
 *
 */
public class ProduitService extends EntiteService<Produit> {

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public ProduitService(EntityManager em) {
		super(Produit.class, new ProduitDao(em));
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionEntite(Produit entite) {
		Produit entiteBase = entiteDao.find(entite.getNom());
		if (entiteBase != null) {
			return;
		}

		entiteDao.insert(entite);

		entiteBase = entiteDao.find(entite.getNom());
		entite.setId(entiteBase.getId());
	}

}
