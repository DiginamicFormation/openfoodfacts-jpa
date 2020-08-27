package fr.diginamic.offi.manager;

import javax.persistence.EntityManager;

import fr.diginamic.offi.dao.CategorieDao;
import fr.diginamic.offi.entity.Categorie;

/**
 * Classe qui propose des services de traitement des catégories
 * 
 * @author RichardBONNAMY
 *
 */
public class CategorieService extends EntiteService<Categorie> {

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public CategorieService(EntityManager em) {
		super(Categorie.class, new CategorieDao(em));
	}

}
