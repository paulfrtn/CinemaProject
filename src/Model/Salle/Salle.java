package Model.Salle;

public class Salle {
    private int salle_id;
    private int salle_number;
    private int salle_capa_max;
    private boolean salle_dispo;

    public Salle(int salle_id, int salle_number, int salle_capa_max, boolean salle_dispo) {
        this.salle_id = salle_id;
        this.salle_number = salle_number;
        this.salle_capa_max = salle_capa_max;
        this.salle_dispo = salle_dispo;
    }

    public Salle( int salle_number, int salle_capa_max, boolean salle_dispo) {
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
