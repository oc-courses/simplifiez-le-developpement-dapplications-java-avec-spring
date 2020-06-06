package org.example.demo.ticket.business.manager.contract;

import java.util.List;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.exception.NotFoundException;

public interface ProjetManager {

	/**
	 * Renvoie la liste des {@link Projet}
	 *
	 * @return List
	 */
	List<Projet> getListProjet();

	/**
	 * Renvoie le projet demandé
	 *
	 * @param pId l'identifiant du projet
	 * @return Le {@link Projet}
	 * @throws NotFoundException Si le projet n'est pas trouvé
	 */
	Projet getProjet(Integer pId) throws NotFoundException;

}
