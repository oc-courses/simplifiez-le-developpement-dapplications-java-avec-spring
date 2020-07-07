package org.example.demo.ticket.consumer.impl.dao;

import java.util.List;
import java.util.Optional;

import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.consumer.rowmapper.ProjetRM;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component("ProjetDao")
public class ProjetDaoImpl extends AbstractDao implements ProjetDao {
	@Override
	public List<Projet> getListProjets() {
		final String vSQL = "SELECT * FROM public.projet";

		List<Projet> vListProjet = getJdbcTemplate().query(vSQL, ProjetRM.ROWMAPPERPROJ);
		return vListProjet;		
	}

	@Override
	public Projet getProjet(Integer pId) {
		
		final String vSQL = "SELECT * FROM public.projet WHERE 1=1";
		final String vSQLalt = "SELECT p.id, p.nom, p.date_creation, p.cloture, u.id, u.nom as \"responsable\"\r\n" + 
				"FROM public.projet p, public.utilisateur u\r\n" + 
				"WHERE p.id = u.id";
		
		StringBuilder vSQLBuilder = new StringBuilder(vSQL);
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		
		vSQLBuilder.append(" AND id = :id ");
		vParams.addValue("id", pId);
		
	
		List<Projet> vProjets = getNamedParamJdbcTemplate()
				.query(vSQLBuilder.toString(), vParams, ProjetRM.ROWMAPPERPROJ);
		
		Optional<Projet> optProjet = vProjets.stream().findFirst();
		if (optProjet.isPresent()) {
			return optProjet.get();
		}
		return new Projet();
	}

}
