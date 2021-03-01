package fr.diginamic.offi.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.offi.entity.Allergene;

/**
 * Classe qui propose des services de traitement des allergènes
 * 
 * @author RichardBONNAMY
 *
 */
public class AllergeneDao {

	/** EntityManager */
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public AllergeneDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionEntite(Allergene entite) {

		Allergene entiteBase = find(entite.getNom());
		if (entiteBase == null) {
			em.persist(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}

	/**
	 * Retrouve un allergène en base à partir de son nom
	 * 
	 * @param Allergene
	 */
	public Allergene find(String nom) {

		TypedQuery<Allergene> query = em.createQuery("FROM Allergene WHERE nom=:nom", Allergene.class);
		query.setParameter("nom", nom);

		List<Allergene> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}
}
