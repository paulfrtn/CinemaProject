package Model.Salle;

/**
 * Représente une salle dans un cinéma.
 */
public class Salle {
    private int salle_id; // Identifiant de la salle
    private int salle_number; // Numéro de la salle
    private int salle_capa_max; // Capacité maximale de la salle
    private boolean salle_dispo; // Disponibilité de la salle

    /**
     * Constructeur avec tous les attributs.
     * @param salle_id L'identifiant de la salle.
     * @param salle_number Le numéro de la salle.
     * @param salle_capa_max La capacité maximale de la salle.
     * @param salle_dispo La disponibilité de la salle.
     */
    public Salle(int salle_id, int salle_number, int salle_capa_max, boolean salle_dispo) {
        this.salle_id = salle_id;
        this.salle_number = salle_number;
        this.salle_capa_max = salle_capa_max;
        this.salle_dispo = salle_dispo;
    }

    /**
     * Constructeur sans l'identifiant de la salle.
     * @param salle_number Le numéro de la salle.
     * @param salle_capa_max La capacité maximale de la salle.
     * @param salle_dispo La disponibilité de la salle.
     */
    public Salle(int salle_number, int salle_capa_max, boolean salle_dispo) {
        this.salle_number = salle_number;
        this.salle_capa_max = salle_capa_max;
        this.salle_dispo = salle_dispo;
    }

    // Getters
    public int getSalle_id() {
        return salle_id;
    }

    public int getSalle_number() {
        return salle_number;
    }

    public int getSalle_capa_max() {
        return salle_capa_max;
    }

    public boolean getSalle_dispo() {
        return salle_dispo;
    }

    // Setters

    public void setSalle_id(int salle_id) {
        this.salle_id = salle_id;
    }

    public void setSalle_number(int salle_number) {
        this.salle_number = salle_number;
    }

    public void setSalle_capa_max(int salle_capa_max) {
        this.salle_capa_max = salle_capa_max;
    }

    public void setSalle_dispo(boolean salle_dispo) {
        this.salle_dispo = salle_dispo;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "salle_id=" + salle_id +
                ", salle_number=" + salle_number +
                ", salle_capa_max=" + salle_capa_max +
                ", salle_dispo=" + salle_dispo +
                '}';
    }

}