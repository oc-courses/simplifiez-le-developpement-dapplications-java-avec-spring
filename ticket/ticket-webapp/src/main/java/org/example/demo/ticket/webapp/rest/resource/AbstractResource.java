package org.example.demo.ticket.webapp.rest.resource;

import org.example.demo.ticket.business.manager.factory.contract.ManagerFactory;

public class AbstractResource {
	
	private static ManagerFactory managerFactory;

	protected ManagerFactory getManagerFactory() {
		return managerFactory;
	}

	public static void setManagerFactory(ManagerFactory mgrFactory) {
		managerFactory = mgrFactory;
	}

}
