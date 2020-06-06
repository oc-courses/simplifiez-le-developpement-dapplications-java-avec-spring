package org.example.demo.ticket.business.manager.factory.contract;

import org.example.demo.ticket.business.manager.contract.ProjetManager;
import org.example.demo.ticket.business.manager.contract.TicketManager;

public interface ManagerFactory {

	void setTicketManager(TicketManager ticketManager);

	TicketManager getTicketManager();

	void setProjetManager(ProjetManager projetManager);

	ProjetManager getProjetManager();

}
