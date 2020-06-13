package org.example.demo.ticket.consumer.impl.factory;

import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.consumer.contract.dao.TicketDao;
import org.example.demo.ticket.consumer.contract.factory.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("daoFactory")
public class DaoFactoryImpl implements DaoFactory {
	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private ProjetDao projetDao;

	@Override
	public TicketDao getTicketDao() {
		return ticketDao;
	}

	@Override
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	@Override
	public ProjetDao getProjetDao() {
		return projetDao;
	}

	@Override
	public void setProjetDao(ProjetDao projetDao) {
		this.projetDao = projetDao;
	}
}
