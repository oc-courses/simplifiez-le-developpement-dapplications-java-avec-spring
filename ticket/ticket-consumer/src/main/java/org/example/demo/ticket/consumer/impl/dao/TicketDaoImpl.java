package org.example.demo.ticket.consumer.impl.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.consumer.contract.dao.TicketDao;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("ticketDao")
public class TicketDaoImpl  extends AbstractDao implements TicketDao {
	
	   /** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(TicketDaoImpl.class);
	
	@Override
	public List<Ticket> search(RechercheTicket pRechercheTicket) {
        
		final String vSQL= "SELECT * FROM public.ticket WHERE 1=1";
		StringBuilder vSQLBuilder = new StringBuilder(vSQL);
		MapSqlParameterSource vParams = new MapSqlParameterSource();       
		LOGGER.info("################################ the Select- Command: "+vSQL);		
        if (pRechercheTicket != null) {
            if (pRechercheTicket.getAuteurId() != null) {
            	vSQLBuilder.append(" AND auteur_id = :auteur_id");
                vParams.addValue("auteur_id", pRechercheTicket.getAuteurId());
            }
            if (pRechercheTicket.getProjetId() != null) {
            	vSQLBuilder.append(" AND projet_id = :projet_id");
                vParams.addValue("projet_id", pRechercheTicket.getProjetId());
            }
        }
		
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        List<Ticket> ticketList = vJdbcTemplate.queryForList(vSQLBuilder.toString(), vParams, Ticket.class);
        return ticketList;
        
    }

}
