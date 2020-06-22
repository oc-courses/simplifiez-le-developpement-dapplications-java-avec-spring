package org.example.demo.ticket.consumer.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("ProjetDao")
public class ProjetDaoImpl extends AbstractDao implements ProjetDao {
	@Override
	public List<Projet> getListProjets() {
		final String vSQL = "SELECT * FROM public.projet";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		RowMapper<Projet> vRowMapper = new RowMapper<Projet>() {

			@Override
			public Projet mapRow(ResultSet rs, int rowNum) throws SQLException {

				Utilisateur user = new Utilisateur();

				Projet vProj = new Projet(rs.getInt("id"));
				vProj.setNom(rs.getString("nom"));
				vProj.setDateCreation(rs.getDate("date_creation"));
				vProj.setCloture(rs.getBoolean("cloture"));
				user.setId(rs.getInt("responsable_id"));
				vProj.setResponsable(user);
				return vProj;
			}
		};

		List<Projet> vListProjet = vJdbcTemplate.query(vSQL, vRowMapper);
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
		Utilisateur user = new Utilisateur();
		
		vSQLBuilder.append(" AND id = :id ");
		vParams.addValue("id", pId);
		
		RowMapper<Projet> rowMapper = (ResultSet rs, int rowNummer) -> {
			Projet pProj = new Projet(rs.getInt("id"));
			pProj.setNom(rs.getString("nom"));
			pProj.setDateCreation(rs.getDate("date_creation"));
			pProj.setCloture(rs.getBoolean("cloture"));
			user.setId(rs.getInt("responsable_id"));
			pProj.setResponsable(user);
			return pProj;
		};
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		List<Projet> vProjets = vJdbcTemplate.query(vSQLBuilder.toString(), vParams, rowMapper);
		
		Optional<Projet> optProjet = vProjets.stream().findFirst();
		if (optProjet.isPresent()) {
			return optProjet.get();
		}
		return new Projet();
	}

}
