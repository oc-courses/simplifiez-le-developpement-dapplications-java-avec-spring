package org.example.demo.ticket.consumer.rowmapper;

import java.sql.ResultSet;

import org.example.demo.ticket.model.bean.ticket.Evolution;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.springframework.jdbc.core.RowMapper;

public class TicketRM {
   public final static RowMapper<Ticket> ROWMAPPERTICKET = (ResultSet rs, int rowNum) -> {
    	Ticket vTicket = new Evolution(rs.getLong("numero"));
    	vTicket.setTitre(rs.getString("titre"));
    	vTicket.setDate(rs.getDate("date"));
    	vTicket.setDescription(rs.getString("description"));
    	return vTicket;
    };        
    
}
