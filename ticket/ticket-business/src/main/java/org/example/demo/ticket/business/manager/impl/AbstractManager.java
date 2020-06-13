package org.example.demo.ticket.business.manager.impl;

import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.consumer.contract.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractManager {
	
	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private ProjetDao projetDao;

	protected TicketDao getTicketDao() {
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	protected ProjetDao getProjetDao() {
		return projetDao;
	}

	public void setProjetDao(ProjetDao projetDao) {
		this.projetDao = projetDao;
	}
	
	

}
