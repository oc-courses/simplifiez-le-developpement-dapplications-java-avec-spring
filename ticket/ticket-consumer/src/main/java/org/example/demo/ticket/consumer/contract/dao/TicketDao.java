package org.example.demo.ticket.consumer.contract.dao;

import java.util.List;

import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;

public interface TicketDao {

	List<Ticket> search(RechercheTicket pRechercheTicket);

	Ticket getTicket(Long pNumero);

	List<TicketStatut> getTicketStatut();

}
