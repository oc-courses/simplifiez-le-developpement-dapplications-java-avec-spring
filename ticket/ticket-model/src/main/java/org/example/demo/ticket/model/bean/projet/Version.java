package org.example.demo.ticket.model.bean.projet;

/**
 * Objet métier représentant une Version de Projet
 *
 * @author lgu
 */
public class Version {

    // ==================== Attributs ====================
    private Projet projet;
    private String numero;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Version() {
    }


    // ==================== Getters/Setters ====================
    public Projet getProjet() {
        return projet;
    }
    public void setProjet(Projet pProjet) {
        projet = pProjet;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String pNumero) {
        numero = pNumero;
    }


    // ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
            .append("projet=").append(projet)
            .append(vSEP).append("numero=\"").append(numero).append('"')
            .append("}");
        return vStB.toString();
    }
}
