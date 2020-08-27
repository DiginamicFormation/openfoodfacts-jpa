package fr.diginamic.offi.manager;

import javax.persistence.EntityManager;

import fr.diginamic.offi.dao.AllergeneDao;
import fr.diginamic.offi.entity.Allergene;

/**
 * Classe qui propose des services de traitement des allergènes
 * 
 * @author RichardBONNAMY
 *
 */
public class AllergeneService extends EntiteService<Allergene> {

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public AllergeneService(EntityManager em) {
		super(Allergene.class, new AllergeneDao(em));
	}

}
