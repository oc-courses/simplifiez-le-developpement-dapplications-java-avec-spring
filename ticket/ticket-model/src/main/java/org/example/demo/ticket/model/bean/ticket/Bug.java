package org.example.demo.ticket.model.bean.ticket;

import java.util.ArrayList;
import java.util.List;

import org.example.demo.ticket.model.bean.projet.Version;


/**
 * Bean représentant un Ticket de type "Bug".
 *
 * @author lgu
 */
public class Bug extends Ticket {

    // ==================== Attributs ====================
    private BugNiveau niveau;
    private final List<Version> listVersionAffectee = new ArrayList<>();


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Bug() {
    }

    /**
     * Constructeur.
     *
     * @param pNumero -
     */
    public Bug(Long pNumero) {
        super(pNumero);
    }


    // ==================== Getters/Setters ====================
    public BugNiveau getNiveau() {
        return niveau;
    }
    public void setNiveau(BugNiveau pNiveau) {
        niveau = pNiveau;
    }
    public List<Version> getListVersionAffectee() {
        return listVersionAffectee;
    }


    // ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")

            .append('(')
            .append(Ticket.class.getSimpleName())
            .append(") ")
            .append(super.toString())
            .append(" + {")

            .append("niveau=").append(niveau)
            .append("}");
        return vStB.toString();
    }
}
