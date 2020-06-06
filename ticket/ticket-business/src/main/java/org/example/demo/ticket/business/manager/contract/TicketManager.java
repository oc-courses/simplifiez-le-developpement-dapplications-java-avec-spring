package org.example.demo.ticket.business.manager.contract;

import java.util.List;

import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;

public interface TicketManager {

	/**
	 * Renvoie le nombre de {@link Ticket} correspondants aux critères de recherche.
	 *
	 * @param pRechercheTicket -
	 * @return int
	 */
	int getCountTicket(RechercheTicket pRechercheTicket);

	/**
	 * Renvoie la liste des {@link Ticket} correspondants aux critères de recherche.
	 *
	 * @param pRechercheTicket -
	 * @return List
	 */
	List<Ticket> getListTicket(RechercheTicket pRechercheTicket);

	/**
	 * Cherche et renvoie le {@link Ticket} numéro {@code pNumero}
	 *
	 * @param pNumero le numéro du Ticket
	 * @return Le {@link Ticket}
	 * @throws NotFoundException Si le Ticket n'est pas trouvé
	 */
	Ticket getTicket(Long pNumero) throws NotFoundException;

}
