package org.example.demo.ticket.business.manager.factory.impl;

import org.example.demo.ticket.business.manager.contract.ProjetManager;
import org.example.demo.ticket.business.manager.contract.TicketManager;
import org.example.demo.ticket.business.manager.factory.contract.ManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {
	
	@Autowired
	private ProjetManager projetManager;
	
	@Autowired
	private TicketManager ticketManager;

	@Override
	public ProjetManager getProjetManager() {
		return projetManager;
	}

	@Override
	public void setProjetManager(ProjetManager projetManager) {
		this.projetManager = projetManager;
	}

	@Override
	public TicketManager getTicketManager() {
		return ticketManager;
	}

	@Override
	public void setTicketManager(TicketManager ticketManager) {
		this.ticketManager = ticketManager;
	}
	
	

}
