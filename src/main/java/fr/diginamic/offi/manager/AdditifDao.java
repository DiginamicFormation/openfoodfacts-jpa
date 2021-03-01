package fr.diginamic.offi.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.offi.entity.Additif;

/**
 * Classe qui propose des services de traitement des additifs
 * 
 * @author RichardBONNAMY
 *
 */
public class AdditifDao {

	/** EntityManager */
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public AdditifDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionEntite(Additif entite) {

		Additif entiteBase = find(entite.getNom());
		if (entiteBase == null) {
			em.persist(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}

	/**
	 * Retrouve un additif en base à partir de son nom
	 * 
	 * @param Additif
	 */
	public Additif find(String nom) {

		TypedQuery<Additif> query = em.createQuery("FROM Additif WHERE nom=:nom", Additif.class);
		query.setParameter("nom", nom);

		List<Additif> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}
}
