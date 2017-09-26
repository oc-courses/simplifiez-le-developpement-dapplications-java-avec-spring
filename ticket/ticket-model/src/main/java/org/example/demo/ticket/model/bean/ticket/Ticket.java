package org.example.demo.ticket.model.bean.ticket;

import java.util.Date;

import org.example.demo.ticket.model.bean.projet.Projet;


/**
 * Bean représentant un Ticket.
 *
 * @author lgu
 */
public abstract class Ticket {

    // ==================== Attributs ====================
    private Long numero;
    private String titre;
    private Date date;
    private String description;
    private Projet projet;
    private TicketStatut statut;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    protected Ticket() {
    }


    /**
     * Constructeur.
     *
     * @param pNumero -
     */
    protected Ticket(Long pNumero) {
        numero = pNumero;
    }


    // ==================== Getters/Setters ====================
    public Long getNumero() {
        return numero;
    }
    public void setNumero(Long pNumero) {
        numero = pNumero;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String pTitre) {
        titre = pTitre;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date pDate) {
        date = pDate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String pDescription) {
        description = pDescription;
    }
    public Projet getProjet() {
        return projet;
    }
    public void setProjet(Projet pProjet) {
        projet = pProjet;
    }
    public TicketStatut getStatut() {
        return statut;
    }
    public void setStatut(TicketStatut pStatut) {
        statut = pStatut;
    }


    // ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
            .append("numero=").append(numero)
            .append(vSEP).append("titre=\"").append(titre).append('"')
            .append(vSEP).append("date=").append(date)
            .append(vSEP).append("description=\"").append(description).append('"')
            .append(vSEP).append("projet=").append(projet)
            .append(vSEP).append("statut=").append(statut)
            .append("}");
        return vStB.toString();
    }
}
