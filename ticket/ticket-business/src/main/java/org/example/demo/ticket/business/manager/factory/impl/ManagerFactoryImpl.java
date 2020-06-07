package org.example.demo.ticket.business.manager.factory.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.demo.ticket.business.manager.contract.ProjetManager;
import org.example.demo.ticket.business.manager.contract.TicketManager;
import org.example.demo.ticket.business.manager.factory.contract.ManagerFactory;

@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {
	
	@Inject
	private ProjetManager projetManager;
	
	@Inject
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
