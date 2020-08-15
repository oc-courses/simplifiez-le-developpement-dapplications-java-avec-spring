package org.example.demo.ticket.consumer.rowmapper;

import java.sql.ResultSet;

import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.springframework.jdbc.core.RowMapper;

public class TicketStatusRM {
	public final static RowMapper<TicketStatut> ROWMAPPERSTATUT = (ResultSet rs, int rowNum) -> {
    	TicketStatut vStatut = new TicketStatut(rs.getInt("id"));
    	vStatut.setLibelle(rs.getString("libelle"));
    	return vStatut;
    };
    
    
}
