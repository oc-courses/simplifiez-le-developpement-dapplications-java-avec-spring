package org.example.demo.ticket.consumer.impl.dao;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.consumer.contract.dao.TicketDao;
import org.example.demo.ticket.consumer.rowmapper.TicketRM;
import org.example.demo.ticket.consumer.rowmapper.TicketStatusRM;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component("ticketDao")
public class TicketDaoImpl  extends AbstractDao implements TicketDao {
	private final static String vSQL_ALL_TICKETS = "SELECT t.numero, t.titre, t.description, t.date, p.id as \"proj_id\", p.nom as \"proj_nom\"\r\n" + 
			                                       "FROM public.ticket t, public.projet p\r\n" +
			                                       "WHERE t.projet_id = p.id ";
	
	private final static String vSQL_ALL_STATUTS = "SELECT * FROM public.statut";

	
	/** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(TicketDaoImpl.class);
	
	@Override
	public List<Ticket> search(RechercheTicket pRechercheTicket) {
        
		StringBuilder vSQLBuilder = new StringBuilder(vSQL_ALL_TICKETS);
		MapSqlParameterSource vParams = new MapSqlParameterSource();       
		LOGGER.info("################################ the Select- Command: "+vSQL_ALL_TICKETS);		
        if (pRechercheTicket != null) {
            if (pRechercheTicket.getAuteurId() != null) {
            	vSQLBuilder.append(" AND t.auteur_id = :auteur_id");
                vParams.addValue("auteur_id", pRechercheTicket.getAuteurId());
            }
            if (pRechercheTicket.getProjetId() != null) {
            	vSQLBuilder.append(" AND t.projet_id = :projet_id");
                vParams.addValue("projet_id", pRechercheTicket.getProjetId());
            }
        }        

        List<Ticket> ticketList = getNamedParamJdbcTemplate()
        		.query(vSQLBuilder.toString(), vParams, TicketRM.ROWMAPPERTICKET);
        
        if (ticketList.isEmpty()) {
			LOGGER.info("Tickets inexistants");
		}
        return ticketList;
        
    }

	@Override
	public Ticket getTicket(Long pNumero) {
		
		StringBuilder vSQLBuilder = new StringBuilder(vSQL_ALL_TICKETS);
		MapSqlParameterSource vParams = new MapSqlParameterSource();       
		
		vSQLBuilder.append(" AND numero = :numero");
        vParams.addValue("numero", pNumero);         
            
// Pose Problème si pas de resultats!!
// pringframework.dao.EmptyResultDataAccessException: Incorrect result size: expected 1, actual 0
//        Ticket vTicket = vJdbcTemplate.queryForObject(vSQLBuilder.toString(), vParams, Ticket.class);
        List<Ticket> vTickets = getNamedParamJdbcTemplate()
        		.query(vSQLBuilder.toString(), vParams, TicketRM.ROWMAPPERTICKET);
        Optional<Ticket> optTicket = vTickets.stream().findFirst();
        if (optTicket.isPresent()) {
			return optTicket.get();
		}
		return null;
	}

	@Override
	public List<TicketStatut> getTicketStatut() {		
		
        List<TicketStatut> vStatuts = getJdbcTemplate()
        		.query(vSQL_ALL_STATUTS, TicketStatusRM.ROWMAPPERSTATUT);
        return vStatuts;
	}

}
