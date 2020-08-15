package org.example.demo.ticket.business.manager.impl;


import java.util.List;

import org.example.demo.ticket.business.manager.contract.ProjetManager;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.springframework.stereotype.Component;


/**
 * Manager des beans du package Projet.
 *
 * @author lgu
 */

@Component
public class ProjetManagerImpl extends AbstractManager implements ProjetManager{

    /**
     * Renvoie le projet demandé
     *
     * @param pId l'identifiant du projet
     * @return Le {@link Projet}
     * @throws NotFoundException Si le projet n'est pas trouvé
     */
    @Override
	public Projet getProjet(Integer pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Projet non trouvé : ID=" + pId);
        }
        
        Projet vProjet = getDaoFact().getProjetDao().getProjet(pId);
        return vProjet;
    }


    /**
     * Renvoie la liste des {@link Projet}
     *
     * @return List
     */
    @Override
	public List<Projet> getListProjet() {
        List<Projet> vList = getDaoFact().getProjetDao().getListProjets();
        
        return vList;
    }
}
