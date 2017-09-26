package org.example.demo.ticket.business.manager;


import java.util.ArrayList;
import java.util.List;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.ticket.Bug;
import org.example.demo.ticket.model.bean.ticket.Evolution;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;


/**
 * Manager des beans du package Ticket.
 *
 * @author lgu
 */
public class TicketManager {

    /**
     * Cherche et renvoie le {@link Ticket} numéro {@code pNumero}
     *
     * @param pNumero le numéro du Ticket
     * @return Le {@link Ticket}
     * @throws NotFoundException Si le Ticket n'est pas trouvé
     */
    public Ticket getTicket(Long pNumero) throws NotFoundException {
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        if (pNumero < 1L) {
            throw new NotFoundException("Ticket non trouvé : numero=" + pNumero);
        }
        Evolution vEvolution = new Evolution(pNumero);
        vEvolution.setPriorite(10);
        return vEvolution;
    }


    /**
     * Renvoie la liste des {@link Ticket} correspondants aux critères de recherche.
     *
     * @param pRechercheTicket -
     * @return List
     */
    public List<Ticket> getListTicket(RechercheTicket pRechercheTicket) {
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        List<Ticket> vList = new ArrayList<>();
        if (pRechercheTicket.getProjetId() != null) {
            Projet vProjet = new Projet(pRechercheTicket.getProjetId());
            for (int vI = 0; vI < 4; vI++) {
                Ticket vTicket = new Bug((long) pRechercheTicket.getProjetId() * 10 + vI);
                vTicket.setProjet(vProjet);
                vList.add(vTicket);
            }
        } else {
            for (int vI = 0; vI < 9; vI++) {
                Ticket vTicket = new Evolution((long) vI);
                vList.add(vTicket);
            }
        }
        return vList;
    }


    /**
     * Renvoie le nombre de {@link Ticket} correspondants aux critères de recherche.
     *
     * @param pRechercheTicket -
     * @return int
     */
    public int getCountTicket(RechercheTicket pRechercheTicket) {
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        return 42;
    }
}
