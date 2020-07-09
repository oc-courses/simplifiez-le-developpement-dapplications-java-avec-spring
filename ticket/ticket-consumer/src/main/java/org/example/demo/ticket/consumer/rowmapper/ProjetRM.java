package org.example.demo.ticket.consumer.rowmapper;

import java.sql.ResultSet;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

public class ProjetRM {
	public final static RowMapper<Projet> ROWMAPPERPROJ = (ResultSet rs, int rowNum) -> {

			Utilisateur user = new Utilisateur();

			Projet vProj = new Projet(rs.getInt("id"));
			vProj.setNom(rs.getString("nom"));
			vProj.setDateCreation(rs.getDate("date_creation"));
			vProj.setCloture(rs.getBoolean("cloture"));
			user.setId(rs.getInt("resp_id"));
			user.setNom(rs.getString("responsable"));
			vProj.setResponsable(user);
			return vProj;
		};

}
