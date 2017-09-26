package org.example.demo.ticket.model.bean.ticket;

/**
 * Bean représentant un Ticket de type "Évolution".
 *
 * @author lgu
 */
public class Evolution extends Ticket {

    // ==================== Attributs ====================
    private Integer priorite;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Evolution() {
    }

    /**
     * Constructeur.
     *
     * @param pNumero -
     */
    public Evolution(Long pNumero) {
        super(pNumero);
    }


    // ==================== Getters/Setters ====================
    public Integer getPriorite() {
        return priorite;
    }
    public void setPriorite(Integer pPriorite) {
        priorite = pPriorite;
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

            .append("priorite=").append(priorite)
            .append("}");
        return vStB.toString();
    }
}
