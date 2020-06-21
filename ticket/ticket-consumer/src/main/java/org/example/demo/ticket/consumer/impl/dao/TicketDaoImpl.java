package org.example.demo.ticket.consumer.impl.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.consumer.contract.dao.TicketDao;
import org.example.demo.ticket.model.bean.ticket.Evolution;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;
import org.springframework.jdbc.core.RowMapper;
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
        
        RowMapper<Ticket> rowMapper = (ResultSet rs, int rowNum) -> {
        	Ticket vTicket = new Evolution(rs.getLong("numero"));
        	vTicket.setTitre(rs.getString("titre"));
        	vTicket.setDate(rs.getDate("date"));
        	vTicket.setDescription(rs.getString("description"));
        	return vTicket;
        };        
        
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        List<Ticket> ticketList = vJdbcTemplate.query(vSQLBuilder.toString(), vParams, rowMapper);
        return ticketList;
        
    }

	@Override
	public Ticket getTicket(Long pNumero) {
		
		final String vSQL= "SELECT * FROM public.ticket WHERE 1=1";
		StringBuilder vSQLBuilder = new StringBuilder(vSQL);
		MapSqlParameterSource vParams = new MapSqlParameterSource();       
//		LOGGER.info("################################ the Select- Command: "+vSQL);
		
		vSQLBuilder.append(" AND numero = :numero");
        vParams.addValue("numero", pNumero); 
        
        RowMapper<Ticket> rowMapper = (ResultSet rs, int rowNum) -> {
        	Ticket vTicket = new Evolution(rs.getLong("numero"));
        	vTicket.setTitre(rs.getString("titre"));
        	vTicket.setDate(rs.getDate("date"));
        	vTicket.setDescription(rs.getString("description"));
        	return vTicket;
        };
        
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        
// Pose Problème si pas de resultats!!
// pringframework.dao.EmptyResultDataAccessException: Incorrect result size: expected 1, actual 0
//        Ticket vTicket = vJdbcTemplate.queryForObject(vSQLBuilder.toString(), vParams, Ticket.class);
        List<Ticket> vTickets = vJdbcTemplate.query(vSQLBuilder.toString(), vParams, rowMapper);
        Optional<Ticket> optTicket = vTickets.stream().findFirst();
        if (optTicket.isPresent()) {
			return optTicket.get();
		}
		return null;
	}

}
