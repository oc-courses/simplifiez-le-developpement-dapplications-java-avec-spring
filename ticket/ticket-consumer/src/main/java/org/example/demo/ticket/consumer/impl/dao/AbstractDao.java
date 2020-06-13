package org.example.demo.ticket.consumer.impl.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractDao {

	@Autowired
	@Qualifier("dataSourceTicket")
	private DataSource dataSource;

	protected void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	protected DataSource getDataSource() {
		return dataSource;
	}

}
