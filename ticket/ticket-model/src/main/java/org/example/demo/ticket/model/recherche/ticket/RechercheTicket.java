package org.example.demo.ticket.model.recherche.ticket;

/**
 * Classe de critères de recherche de Ticket.
 *
 * @author lgu
 */
public class RechercheTicket {

    // ==================== Attributs ====================
    private Integer projetId;
    private Integer auteurId;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public RechercheTicket() {

    }


    // ==================== Getters/Setters ====================
    public Integer getAuteurId() {
        return auteurId;
    }

    /**
     * Assigne le critère de recherche : id de l'auteur.
     *
     * @param pAuteurId -
     * @return {@code this}
     */
    public RechercheTicket setAuteurId(Integer pAuteurId) {
        auteurId = pAuteurId;
        return this;
    }

    public Integer getProjetId() {
        return projetId;
    }

    /**
     * Assigne le critère de recherche : id du projet.
     *
     * @param pProjetId -
     * @return {@code this}
     */
    public RechercheTicket setProjetId(Integer pProjetId) {
        projetId = pProjetId;
        return this;
    }
}
