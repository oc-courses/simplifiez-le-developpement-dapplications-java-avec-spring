package org.example.demo.ticket.consumer.impl.dao;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.consumer.rowmapper.ProjetRM;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component("ProjetDao")
public class ProjetDaoImpl extends AbstractDao implements ProjetDao {
	
	private final static String vSELECT_ALL_PROJECTS = "SELECT p.id, p.nom, p.date_creation, p.cloture, u.id as \"resp_id\", u.nom as \"responsable\"\r\n" + 
													   "FROM public.projet p, public.utilisateur u\r\n" + 
													   "WHERE p.id = u.id";
	
	/** Logger pour la classe */
    private final static Log LOGGER = LogFactory.getLog(ProjetDaoImpl.class);	
	
	
	@Override
	public List<Projet> getListProjets() {
		List<Projet> vListProjet = getJdbcTemplate().query(vSELECT_ALL_PROJECTS, ProjetRM.ROWMAPPERPROJ);
		return vListProjet;		
	}

	@Override
	public Projet getProjet(Integer pId) {
		
		StringBuilder vSQLBuilder = new StringBuilder(vSELECT_ALL_PROJECTS);
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vSQLBuilder.append(" AND p.id = :id ");
		vParams.addValue("id", pId);
		
	
		List<Projet> vProjets = getNamedParamJdbcTemplate()
				.query(vSQLBuilder.toString(), vParams, ProjetRM.ROWMAPPERPROJ);
		
		Optional<Projet> optProjet = vProjets.stream().findFirst();
		if (optProjet.isPresent()) {
			return optProjet.get();
		}
		
		LOGGER.info("Projet inexistant");
		return null;
	}

}
