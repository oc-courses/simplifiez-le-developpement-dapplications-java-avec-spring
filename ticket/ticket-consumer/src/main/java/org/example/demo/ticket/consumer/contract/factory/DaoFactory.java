package org.example.demo.ticket.consumer.contract.factory;

import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.consumer.contract.dao.TicketDao;

public interface DaoFactory {

	void setProjetDao(ProjetDao projetDao);

	ProjetDao getProjetDao();

	void setTicketDao(TicketDao ticketDao);

	TicketDao getTicketDao();

}
