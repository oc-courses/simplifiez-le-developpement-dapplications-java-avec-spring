package org.example.demo.ticket.consumer.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

}
