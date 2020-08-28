package fr.diginamic.offi.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.offi.entity.Marque;

/**
 * Classe qui propose des services de traitement des marques
 * 
 * @author RichardBONNAMY
 *
 */
public class MarqueService {

	/** EntityManager */
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public MarqueService(EntityManager em) {
		this.em = em;
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionEntite(Marque entite) {

		Marque entiteBase = find(entite.getNom());
		if (entiteBase == null) {
			em.persist(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}

	/**
	 * Retrouve une marque en base à partir de son nom
	 * 
	 * @param Marque
	 */
	public Marque find(String nom) {

		TypedQuery<Marque> query = em.createQuery("FROM Marque WHERE nom=:nom", Marque.class);
		query.setParameter("nom", nom);

		List<Marque> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}

}
