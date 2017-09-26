package org.example.demo.ticket.model.bean.ticket;

/**
 * Bean représentant le Niveau d'un Bug.
 *
 * @author lgu
 */
public class BugNiveau {

    // ==================== Attributs ====================
    private Integer id;
    private Integer ordre;
    private String libelle;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public BugNiveau() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public BugNiveau(Integer pId) {
        id = pId;
    }


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public Integer getOrdre() {
        return ordre;
    }
    public void setOrdre(Integer pOrdre) {
        ordre = pOrdre;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String pLibelle) {
        libelle = pLibelle;
    }


    // ==================== Méthodes ====================
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
            .append("id=").append(id)
            .append(vSEP).append("ordre=").append(ordre)
            .append(vSEP).append("libelle=\"").append(libelle).append('"')
            .append("}");
        return vStB.toString();
    }
}
