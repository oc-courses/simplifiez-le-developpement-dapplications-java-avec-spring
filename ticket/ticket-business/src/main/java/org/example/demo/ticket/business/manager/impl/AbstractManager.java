package org.example.demo.ticket.business.manager.impl;

import org.example.demo.ticket.consumer.contract.factory.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractManager {

	@Autowired
	private DaoFactory daoFact;

	public void setDaoFact(DaoFactory daoFact) {
		this.daoFact = daoFact;
	}

	protected DaoFactory getDaoFact() {
		return daoFact;
	}

}
